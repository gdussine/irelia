package irelia.data.league;

import irelia.data.community.QueueTypes;

public enum LeagueQueueType {

    RANKED_SOLO_5x5(QueueTypes.QUEUE_RANKED_SOLODUO_420),
    RANKED_FLEX_SR(QueueTypes.QUEUE_RANKED_FLEX_440);

    private QueueTypes type;

    private LeagueQueueType(QueueTypes type) {
        this.type = type;
    }

    public QueueTypes getType() {
        return type;
    }

}
