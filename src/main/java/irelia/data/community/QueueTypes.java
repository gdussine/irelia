package irelia.data.community;

public enum QueueTypes {


	QUEUE_RANKED_FLEX_440(440,"Ranked Flex"),
	QUEUE_NORMAL_400(400,"Normal"),
	QUEUE_INTERMEDIATE_890(890,"Intermediate"),
	QUEUE_CUSTOM_0(0,"Custom"),
	QUEUE_INTERMEDIATE_850(850,"Intermediate"),
	QUEUE_NORMAL_430(430,"Normal"),
	QUEUE_INTRO_830(830,"Intro"),
	QUEUE_INTRO_870(870,"Intro"),
	QUEUE_TEAMFIGHT_TACTICS_NORMAL_1090(1090,"Teamfight Tactics (Normal)"),
	QUEUE_2V0_RANKED_1102(1102,"2v0 (Ranked)"),
	QUEUE_BEGINNER_880(880,"Beginner"),
	QUEUE_TEAMFIGHT_TACTICS_HYPER_ROLL_1130(1130,"Teamfight Tactics (Hyper Roll)"),
	QUEUE_ARAM_450(450,"ARAM"),
	QUEUE_BEGINNER_840(840,"Beginner"),
	QUEUE_SWIFTPLAY_480(480,"Swiftplay"),
	QUEUE_1V0_RANKED_1101(1101,"1v0 (Ranked)"),
	QUEUE_TEAMFIGHT_TACTICS_RANKED_1100(1100,"Teamfight Tactics (Ranked)"),
	QUEUE_QUICKPLAY_490(490,"Quickplay"),
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

