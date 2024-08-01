package irelia.core.service;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;
import irelia.data.account.Account;

public class AccountService extends RiotService {

	public AccountService(Irelia irelia) {
		super(irelia);
	}

	private final static String BY_RIOT_ID_URI = "riot/account/v1/accounts/by-riot-id/%s/%s";

	public CompletableFuture<Account> byRiotId(String gameName, String tagLine) {
		RiotRequest request = this.createAPIRequest(irelia.getRegion(), BY_RIOT_ID_URI, gameName, tagLine);
		return getAsync(request, new TypeReference<Account>() {});
	}

}
