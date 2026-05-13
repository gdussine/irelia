package irelia.request.limit.v3;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestStatus;
import irelia.request.core.RiotRequestStatusObject;

public class RiotResponse<T> {

    private RiotRequest<T> request;
    private long time;
    private HttpResponse<byte[]> httpResponse;

    public RiotResponse(RiotRequest<T> request, HttpResponse<byte[]> httpResponse) {
        this.request = request;
        this.time = System.currentTimeMillis();
        this.httpResponse = httpResponse;
    }

    public RiotRequest<T> getRequest() {
        return request;
    }

    public long getTime() {
        return time;
    }

    public HttpHeaders headers() {
        return httpResponse.headers();
    }

    public int statusCode() {
        return httpResponse.statusCode();
    }

    public byte[] body() {
        return httpResponse.body();
    }

    public T payload() throws RiotResponseException {
        if (statusCode() / 100 != 2) {
            throw new RiotResponseException(status());
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(httpResponse.body(), request.getType());
        } catch (IOException e) {
            throw new RiotResponseException(status());
        }
    }

    public RiotRequestStatusObject status() {
        if (statusCode() / 100 == 2)
            return new RiotRequestStatusObject(RiotRequestStatus.status200());
        if (request.getRequestType().isRiotAPI()) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(httpResponse.body(), RiotRequestStatusObject.class);
            } catch (IOException e) {
                return new RiotRequestStatusObject("Parsing message error", statusCode());
            }
        }
        return new RiotRequestStatusObject("No message", statusCode());

    }

}
