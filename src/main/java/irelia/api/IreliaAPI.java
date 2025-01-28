package irelia.api;

import java.util.Locale;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.service.impl.AccountService;
import irelia.service.impl.CommunityService;
import irelia.service.impl.DDragonService;
import irelia.service.impl.LeagueService;
import irelia.service.impl.MatchServices;
import irelia.service.impl.SpectatorService;
import irelia.service.impl.StatusService;
import irelia.service.impl.SummonerService;

public interface IreliaAPI {

    public AccountService account();

    public DDragonService ddragon();

    public LeagueService league();

    public SpectatorService spectator();

    public SummonerService summoner();

    public MatchServices match();

    public StatusService status();

    public CommunityService community();

    public static IreliaAPI create(String key, Platform platform, Locale locale){
        Irelia irelia = new Irelia(key, platform, locale);
        return irelia.start().join();
    }

}
