package design.usersession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserSessionMain {
    static String json = "[\n" +
            "{\n" +
            "\"url\": \"/pages/a-big-river\",\n" +
            "\"visitorId\": \"d1177368-2310-11e8-9e2a-9b860a0d9039\",\n" +
            "\"timestamp\": 1512754583000\n" +
            "},\n" +
            "{\n" +
            "\"url\": \"/pages/a-small-dog\",\n" +
            "\"visitorId\": \"d1177368-2310-11e8-9e2a-9b860a0d9039\",\n" +
            "\"timestamp\": 1512754631000\n" +
            "},\n" +
            "{\n" +
            "\"url\": \"/pages/a-big-talk\",\n" +
            "\"visitorId\": \"f877b96c-9969-4abc-bbe2-54b17d030f8b\",\n" +
            "\"timestamp\": 1512709065294\n" +
            "},\n" +
            "{\n" +
            "\"url\": \"/pages/a-sad-story\",\n" +
            "\"visitorId\": \"f877b96c-9969-4abc-bbe2-54b17d030f8b\",\n" +
            "\"timestamp\": 1512711000000\n" +
            "},\n" +
            "{\n" +
            "\"url\": \"/pages/a-big-river\",\n" +
            "\"visitorId\": \"d1177368-2310-11e8-9e2a-9b860a0d9039\",\n" +
            "\"timestamp\": 1512754436000\n" +
            "},\n" +
            "{\n" +
            "\"url\": \"/pages/a-sad-story\",\n" +
            "\"visitorId\": \"f877b96c-9969-4abc-bbe2-54b17d030f8b\",\n" +
            "\"timestamp\": 1512709024000\n" +
            "}\n" +
            "]";
    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        Map<String, List<Session>> response = EventTransformer.transform(sessionManager.readEvent(json));
        System.out.println(response);

        FetchAndPostClient fetchAndPostClient = new FetchAndPostClient("https://httpbin.org/get");
        String payload = fetchAndPostClient.fetchData();
        System.out.println("GET response: "+payload);

        fetchAndPostClient = new FetchAndPostClient("https://httpbin.org/post");
        payload = fetchAndPostClient.postData(payload);
        System.out.println("POST response: "+payload);
    }
}
