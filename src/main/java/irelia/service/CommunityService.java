package irelia.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.community.QueueInfo;
import irelia.request.core.RiotRequest;
import irelia.service.impl.RiotService;

public class CommunityService extends RiotService{

    private final static String QUEUE_JSON_URI = "plugins/rcp-be-lol-game-data/global/%s/v1/queues.json";

    public CommunityService(Irelia irelia){
        super(irelia);
    }

	public CompletableFuture<List<QueueInfo>> queue() {
		TypeReference<List<QueueInfo>> type = new TypeReference<List<QueueInfo>>() {};
		RiotRequest<List<QueueInfo>> request = this.createRawCommunityRequest(type, QUEUE_JSON_URI);
		return getAsync(request);
	}

}
