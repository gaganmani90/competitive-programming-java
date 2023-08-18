package design.usersession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    ObjectMapper objectMapper = new ObjectMapper();
    List<PageEvent> sessionEventList;
    public SessionManager() {
        sessionEventList = new ArrayList<>();
    }

    public List<PageEvent> readEvent(String jsonEvents) throws IOException {
        return objectMapper.readValue(jsonEvents, new TypeReference<List<PageEvent>>(){});
    }
}


@Data
@ToString
class PageEvent {
    String url;
    String visitorId;
    long timestamp;
}

@Data
@ToString
class Session {
    long duration;
    List<String> pages;
    long startTime;

    public Session(long l, List<String> currentPages, long startTime) {
        this.duration = l;
        this.pages = currentPages;
        this.startTime = startTime;
    }
}