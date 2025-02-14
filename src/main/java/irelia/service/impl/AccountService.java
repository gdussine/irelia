package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.AccountAPI;
import irelia.data.account.Account;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class AccountService extends RateLimitedRiotService implements AccountAPI {

	private TypeReference<Account> type = new TypeReference<Account>() {
	};
	private final static String BY_RIOT_ID_URI = "riot/account/v1/accounts/by-riot-id/%s/%s";
	private final static String BY_ID = "riot/account/v1/accounts/by-puuid/%s";

	@Override
	public CompletableFuture<Account> byRiotId(String gameName, String tagLine) {
		Account temp = new Account();
		temp.setGameName(gameName);
		temp.setTagLine(tagLine);
		return byRiotId(temp);
	}

	@Override
	public CompletableFuture<Account> byRiotId(String riotId) {
		Account temp = new Account();
		temp.setRiotId(riotId);
		return byRiotId(temp);
	}

	public CompletableFuture<Account> byRiotId(Account account) {
		RiotRequest<Account> request = this.createAPIRequest(type, irelia.getRegion(), BY_RIOT_ID_URI,
				account.getGameName(), account.getTagLine());
		return getAsync(request);
	}

	@Deprecated
	public CompletableFuture<Account> byId(String puuid) {
		RiotRequest<Account> request = this.createAPIRequest(type, irelia.getRegion(), BY_ID, puuid);
		return getAsync(request);
	}

	@Override
	public CompletableFuture<Account> byPuuid(String puuid) {
		RiotRequest<Account> request = this.createAPIRequest(type, irelia.getRegion(), BY_ID, puuid);
		return getAsync(request);
	}

}
