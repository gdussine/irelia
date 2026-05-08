package irelia.request.limit.v2;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;
import irelia.request.limit.v3.RiotResponse;

public class IreliaHttpQueue extends IreliaQueue {

    public IreliaHttpQueue(Irelia irelia) {
        super(irelia);
    }

    @Override
    public <X> void onResponseReceived(RiotResponse<X> response) {
    }

    @Override
    public <X> void onRequestSend(RiotRequest<X> request) throws InterruptedException {
        try {
            HttpResponse<byte[]> httpResponse = irelia.getHttp().send(request.getRequest(), BodyHandlers.ofByteArray());
            RiotResponse<X> response = new RiotResponse<>(request, httpResponse);
            request.getFuture().complete(response);
        } catch (IOException e) {
            throw new RuntimeException("Fail to contact endpoint", e);
        } 
    }

}
