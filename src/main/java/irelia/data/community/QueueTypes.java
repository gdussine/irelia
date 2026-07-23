package irelia.data.community;

public enum QueueTypes {


	QUEUE_ARAM_MAYHEM_TOURNAMENT_2410(2410,"ARAM: Mayhem Tournament"),
	QUEUE__1601(1601,""),
	QUEUE_CUSTOM_0(0,"Custom"),
	QUEUE__1603(1603,""),
	QUEUE__1602(1602,""),
	QUEUE__1605(1605,""),
	QUEUE__1604(1604,""),
	QUEUE_INTRO_830(830,"Intro"),
	QUEUE__1607(1607,""),
	QUEUE_BRAWL_3V3_2303(2303,"Brawl 3v3"),
	QUEUE__1606(1606,""),
	QUEUE__1609(1609,""),
	QUEUE__1608(1608,""),
	QUEUE_INTRO_870(870,"Intro"),
	QUEUE_ARAM_MAYHEM_2401(2401,"ARAM: Mayhem"),
	QUEUE_ARAM_MAYHEM_2400(2400,"ARAM: Mayhem"),
	QUEUE_ARAM_MAYHEM_2403(2403,"ARAM: Mayhem"),
	QUEUE_ARAM_MAYHEM_2405(2405,"ARAM: Mayhem"),
	QUEUE_SWIFTPLAY_480(480,"Swiftplay"),
	QUEUE_1V0_RANKED_1101(1101,"1v0 (Ranked)"),
	QUEUE_BRAWL_2V2_2302(2302,"Brawl 2v2"),
	QUEUE_QUICKPLAY_490(490,"Quickplay"),
	QUEUE_RANKED_5S_710(710,"Ranked 5s"),
	QUEUE_RANKED_FLEX_440(440,"Ranked Flex"),
	QUEUE_BOTS_EASY_1V1_893(893,"Bots Easy 1v1"),
	QUEUE_2V0_RANKED_1102(1102,"2v0 (Ranked)"),
	QUEUE_BRAWL_1V1_2301(2301,"Brawl 1v1"),
	QUEUE_NORMAL_400(400,"Normal"),
	QUEUE_INTERMEDIATE_890(890,"Intermediate"),
	QUEUE_INTERMEDIATE_850(850,"Intermediate"),
	QUEUE_ARAM_450(450,"ARAM"),
	QUEUE_TEAMFIGHT_TACTICS_RANKED_1100(1100,"Teamfight Tactics (Ranked)"),
	QUEUE__1612(1612,""),
	QUEUE__1611(1611,""),
	QUEUE__1614(1614,""),
	QUEUE__1613(1613,""),
	QUEUE_NORMAL_430(430,"Normal"),
	QUEUE__1616(1616,""),
	QUEUE__1615(1615,""),
	QUEUE__1618(1618,""),
	QUEUE__1617(1617,""),
	QUEUE_TEAMFIGHT_TACTICS_NORMAL_1090(1090,"Teamfight Tactics (Normal)"),
	QUEUE_BEGINNER_880(880,"Beginner"),
	QUEUE_TEAMFIGHT_TACTICS_HYPER_ROLL_1130(1130,"Teamfight Tactics (Hyper Roll)"),
	QUEUE_BRAWL_4V4_2304(2304,"Brawl 4v4"),
	QUEUE_BEGINNER_840(840,"Beginner"),
	QUEUE_BRAWL_1V0_2305(2305,"Brawl 1v0"),
	QUEUE_BRAWL_2300(2300,"Brawl"),
	QUEUE_RANKED_SOLODUO_420(420,"Ranked Solo/Duo");

    private long id;
    private String name;

    private QueueTypes(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

	public static QueueTypes from(long id){
		for(QueueTypes value : values())
			if(value.getId() == id) return value;
		return values()[0];
	}
}

