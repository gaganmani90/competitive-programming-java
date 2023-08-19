package design.usersession;

import design.usersession.http.AnalyticsAPIOperations;
import design.usersession.model.PageEvent;
import design.usersession.model.Session;
import design.usersession.transformers.JsonToPageEventTransformer;
import design.usersession.transformers.PageEventToSessionTransformer;
import design.usersession.transformers.SessionToJsonTransformer;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class UserSessionGenerator {
    String getUrl, postUrl;
    public UserSessionGenerator(String getUrl, String postUrl) {
        this.getUrl = getUrl;
        this.postUrl = postUrl;
    }
    private List<PageEvent> processRawWebViews() {
        String webViewPayload = new AnalyticsAPIOperations().get(getUrl);
        return new JsonToPageEventTransformer().transform(webViewPayload);
    }

    public void postUserSessions() {
        Map<String, List<Session>> map = new PageEventToSessionTransformer().transform(processRawWebViews());
        new AnalyticsAPIOperations().post(postUrl, new SessionToJsonTransformer().transform(map));
    }
}
