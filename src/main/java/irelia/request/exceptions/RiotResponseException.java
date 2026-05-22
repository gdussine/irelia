package irelia.request.exceptions;

import irelia.request.core.RiotResponse;

public class RiotResponseException extends RuntimeException {

    protected RiotResponse<?> response;
    protected RiotResponseStatus status;

    public <T> RiotResponseException(RiotResponse<T> response) {
        this.response = response;
        this.status =  RiotResponseStatus.byCode(response.statusCode());
    }

    @Override
    public String getMessage() {
        return status.toString();
    }

    public RiotResponse<?> getResponse() {
        return response;
    }

    public int getCode() {
        return status.getCode();
    }

}
