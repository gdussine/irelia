package irelia.service;

import java.lang.reflect.Field;

import irelia.api.MasteryAPI;
import irelia.api.RiotAPI;
import irelia.core.Irelia;
import irelia.service.impl.AccountService;
import irelia.service.impl.ChampionService;
import irelia.service.impl.CommunityService;
import irelia.service.impl.DDragonService;
import irelia.service.impl.LeagueService;
import irelia.service.impl.MasteryService;
import irelia.service.impl.MatchServices;
import irelia.service.impl.SpectatorService;
import irelia.service.impl.StatusService;
import irelia.service.impl.SummonerService;;

public class RiotServices implements RiotAPI {

    private AccountService account;
    private DDragonService ddragon;
    private LeagueService league;
    private SpectatorService spectator;
    private SummonerService summoner;
    private MatchServices match;
    private StatusService status;
    private CommunityService community;
    private ChampionService champion;
    private MasteryService mastery;

    public RiotServices(Irelia irelia) {

        for (Field f : getClass().getDeclaredFields())
            try {
                RiotService service = (RiotService) f.getType().getConstructor().newInstance();
                service.setIrelia(irelia);
                f.set(this, service);
            } catch (Exception e) {
            }
    }

    public void start() {
        for (Field f : getClass().getDeclaredFields())
            try {
                ((RiotService) f.get(this)).start();
            } catch (Exception e) {
            }
    }

    public void stop() {
        for (Field f : getClass().getDeclaredFields())
            try {
                ((RiotService) f.get(this)).stop();
            } catch (Exception e) {
            }

    }

    public AccountService account() {
        return account;
    }

    public DDragonService ddragon() {
        return ddragon;
    }

    public LeagueService league() {
        return league;
    }

    public SpectatorService spectator() {
        return spectator;
    }

    public SummonerService summoner() {
        return summoner;
    }

    public MatchServices match() {
        return match;
    }

    public StatusService status() {
        return status;
    }

    public CommunityService community() {
        return community;
    }

    @Override
    public ChampionService champion() {
        return champion;
    }

    @Override
    public MasteryAPI mastery() {
        return mastery;
    }

}
