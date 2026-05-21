package irelia.request.exceptions;

public enum RiotResponseStatus {

    REP_200(200, "OK"),
    ERR_400(400, "Bad request"),
    ERR_401(401, "Unauthorized"),
    ERR_403(403, "Forbidden"),
    ERR_404(404, "Data not found"),
    ERR_405(405, "Method not allowed"),
    ERR_415(415, "Unsupported media type"),
    ERR_429(429, "Rate limit exceeded"),
    ERR_500(500, "Internal server error"),
    ERR_502(502, "Bad gateway"),
    ERR_503(503, "Service unavailable"),
    ERR_504(504, "Gateway timeout");

    private int code;
    private String message;

    private RiotResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static RiotResponseStatus byCode(int code){
        for(RiotResponseStatus obj :values()){
            if(obj.code == code)
                return obj;
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "%d %s".formatted(code, message);
    }

}
