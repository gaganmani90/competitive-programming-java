package design.usersession.transformers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import design.usersession.model.PageEvent;

import java.io.IOException;
import java.util.List;

public class JsonToPageEventTransformer implements Transformer<String, List<PageEvent>> {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<PageEvent> transform(String source) {
        List<PageEvent> pageEvents = null;
        try {
            pageEvents = objectMapper.readValue(source, new TypeReference<List<PageEvent>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Failed to transform JSON to PageEvent: "+e);
        }
        return pageEvents;
    }
}
