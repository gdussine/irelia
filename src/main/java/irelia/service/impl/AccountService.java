package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.AccountAPI;
import irelia.data.account.Account;
import irelia.data.account.AccountDTO;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class AccountService extends RateLimitedRiotService implements AccountAPI {

	private TypeReference<AccountDTO> type = new TypeReference<AccountDTO>() {
	};

	private TypeReference<byte[]> b = new TypeReference<byte[]>() {
	};

	private final static String BY_RIOT_ID_URI = "riot/account/v1/accounts/by-riot-id/%s/%s";
	private final static String BY_ID = "riot/account/v1/accounts/by-puuid/%s";

	@Override
	public CompletableFuture<Account> byRiotId(String riotId) {
		Account temp = new Account();
		temp.setRiotId(riotId);
		return byRiotId(temp.getGameName(), temp.getTagLine());
	}

	public CompletableFuture<Account> byRiotId(String gameName, String tagLine) {
		Account temp = new Account(null, gameName, tagLine);
		RiotRequest<AccountDTO> request = this.createAPIRequest(type, irelia.getRegion(), BY_RIOT_ID_URI,
				temp.getGameName(), temp.getTagLine());
		RiotRequest<byte[]> request2 = this.createAPIRequest(b, irelia.getRegion(), BY_RIOT_ID_URI,
				temp.getGameName(), temp.getTagLine());
		return getRiotObject(request).thenApply(x -> x == null ? null : new Account(x));
	}

	@Override
	public CompletableFuture<Account> byPuuid(String puuid) {
		RiotRequest<AccountDTO> request = this.createAPIRequest(type, irelia.getRegion(), BY_ID, puuid);
		return getRiotObject(request).thenApply(x -> x == null ? null : new Account(x));
	}
}
