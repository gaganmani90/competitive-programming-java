package design.usersession.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsAPIOperationsTest {
    @Test
    void get() {
        AnalyticsAPIOperations fetchAndPostClient = new AnalyticsAPIOperations();
        String payload = fetchAndPostClient.get("https://httpbin.org/get");
        assertNotNull(payload, payload);
    }

    @Test
    void post() {
        AnalyticsAPIOperations fetchAndPostClient = new AnalyticsAPIOperations();
        String payload = fetchAndPostClient.get("https://httpbin.org/get");
        payload = fetchAndPostClient.post("https://httpbin.org/post", payload);
        assertNotNull(payload, payload);
    }
}