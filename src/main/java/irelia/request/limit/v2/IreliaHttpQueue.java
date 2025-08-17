package irelia.request.limit.v2;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;

public class IreliaHttpQueue extends IreliaQueue {

    public IreliaHttpQueue(Irelia irelia) {
        super(irelia);
    }

    @Override
    public void onResponseReceived(HttpResponse<byte[]> response) {
    }

    @Override
    public void onRequestSend(RiotRequest<?> request) throws InterruptedException {
        try {
            HttpResponse<byte[]> respons = irelia.getHttp().send(request.getRequest(), BodyHandlers.ofByteArray());
            request.getPayload().complete(respons);
        } catch (IOException e) {
            request.getPayload().completeExceptionally(e);
        }
    }

}
