package irelia.request.core;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RiotDataMapper {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T asRiotObject(RiotResponse<T> response) {
        try {
            return mapper.readValue(response.body(), response.getRequest().getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] asData(RiotResponse<byte[]> response) {
        return response.body();
    }

}
