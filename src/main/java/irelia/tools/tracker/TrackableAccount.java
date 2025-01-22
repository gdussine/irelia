package irelia.tools.tracker;

import java.util.Set;

import irelia.data.account.Account;
import irelia.data.league.LeagueEntry;
import irelia.data.spectator.CurrentGameInfo;
import irelia.data.summoner.Summoner;

public class TrackableAccount {

    private Account account;
    private Summoner summoner;
    private CurrentGameInfo currentGame;
    private Set<LeagueEntry> currentLeagues;

    public TrackableAccount(Account account, Summoner summoner, Set<LeagueEntry> leagues) {
        this.account = account;
        this.summoner = summoner;
        this.currentGame = null;
        this.currentLeagues = leagues;
    }

    public Account getAccount() {
        return account;
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public CurrentGameInfo getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(CurrentGameInfo currentGame) {
        this.currentGame = currentGame;
    }

    public Set<LeagueEntry> getCurrentLeagues() {
        return currentLeagues;
    }

    @Override
    public String toString() {
        return account.toString();
    }

}
