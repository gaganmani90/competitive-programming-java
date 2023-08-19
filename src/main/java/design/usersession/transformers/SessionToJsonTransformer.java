package design.usersession.transformers;

import com.fasterxml.jackson.databind.ObjectMapper;
import design.usersession.model.Session;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SessionToJsonTransformer implements Transformer<Map<String, List<Session>>, String> {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String transform(Map<String, List<Session>> source) {
        String jsonPayload = "";
        try {
            jsonPayload = objectMapper.writeValueAsString(source);
        } catch (IOException e) {
            throw new RuntimeException("Failed to transform JSON to PageEvent: "+e);
        }
        return jsonPayload;
    }
}
