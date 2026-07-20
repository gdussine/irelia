package irelia.api;

import irelia.service.impl.DDragonService;
import irelia.service.impl.MatchServices;

public interface RiotAPI {

    public AccountAPI account();

    public SummonerAPI summoner();

    public ChampionAPI champion();

    public LeagueAPI league();

    public StatusAPI status();

    public MasteryAPI mastery();

    public SpectatorAPI spectator();

    public MatchServices match();

    public DDragonService ddragon();





}
