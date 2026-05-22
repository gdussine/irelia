package irelia.request.core;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

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
}
