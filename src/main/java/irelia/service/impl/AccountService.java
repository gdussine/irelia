package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class AccountService extends RateLimitedRiotService {


	private TypeReference<Account> type = new TypeReference<Account>() {};

	public AccountService(Irelia irelia) {
		super(irelia);
	}

	private final static String BY_RIOT_ID_URI = "riot/account/v1/accounts/by-riot-id/%s/%s";
	private final static String BY_ID = "riot/account/v1/accounts/by-puuid/%s";

	public CompletableFuture<Account> byRiotId(String gameName, String tagLine) {
		RiotRequest<Account> request = this.createAPIRequest(type, irelia.getRegion(), BY_RIOT_ID_URI, gameName,tagLine);
		return getAsync(request);
	}

	public CompletableFuture<Account> byRiotId(String riotId){
		Account temp = new Account();
		temp.setRiotId(riotId);
		return byRiotId(temp.getGameName(), temp.getTagLine());

	}

	public CompletableFuture<Account> byId(String puuid){
		RiotRequest<Account> request = this.createAPIRequest(type, irelia.getRegion(), BY_ID, puuid);
		return getAsync(request);
	}

}
