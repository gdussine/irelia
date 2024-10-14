package irelia.data.league;

public enum LeagueRank {

     IV, III, II, I; 

    public int getEloOffset(){
        return this.ordinal() * 100;
    }
}
