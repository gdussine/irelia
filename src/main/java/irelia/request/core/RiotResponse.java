package irelia.request.core;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.request.exceptions.RiotResponseException;
import irelia.request.exceptions.RiotResponseStatus;

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

    public T toAPIData() throws RiotResponseException {
        if (statusCode() / 100 != 2) {
            throw new RiotResponseException(this);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(httpResponse.body(), request.getType());
        } catch (IOException e) {
            throw new RiotResponseException(this);
        }
    }

    public byte[] toData() throws RiotResponseException {
        if (statusCode() / 100 != 2) {
            throw new RiotResponseException(this);
        }
        return httpResponse.body();

    }

    public RiotResponseStatus status() {
        return RiotResponseStatus.byCode(statusCode());
    }

}
