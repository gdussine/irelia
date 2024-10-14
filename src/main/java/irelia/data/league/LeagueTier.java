package irelia.data.league;

public enum LeagueTier {

    IRON, BRONZE, SILVER, GOLD, PLATINUM, EMERALD, DIAMOND, MASTER, GRANDMASTER, CHALLENGER;

    public int getEloOffset(){
        return Math.min(7, this.ordinal()) * 400;
    }
}
