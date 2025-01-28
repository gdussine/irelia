package irelia.core;

public enum Platform {

	BR1(Region.AMERICAS), EUW1(Region.EUROPE), EUN1(Region.EUROPE), JP1(Region.ASIA), KR(Region.ASIA),
	LA1(Region.AMERICAS), LA2(Region.AMERICAS), NA1(Region.AMERICAS), OC1(Region.ASIA), TR1(Region.EUROPE),
	RU(Region.EUROPE), PH2(Region.ASIA), SG2(Region.ASIA), TH2(Region.ASIA), TW2(Region.ASIA), VN2(Region.ASIA);

	private Region region;

	private Platform(Region region) {
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}

	public String getMatchId(long gameId){
		return "%s_%d".formatted(name(), gameId);
	}

}
