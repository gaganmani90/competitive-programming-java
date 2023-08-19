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
        //Fetch web views payload from URL
        String webViewPayload = new AnalyticsAPIOperations().get(getUrl);

        //transform and return
        return new JsonToPageEventTransformer().transform(webViewPayload);
    }

    public void postUserSessions() {
        List<PageEvent> pageEvents = processRawWebViews();
        //apply transformation logic
        Map<String, List<Session>> map = new PageEventToSessionTransformer().transform(pageEvents);
        //convert to json
        String sessionPayload = new SessionToJsonTransformer().transform(map);
        //Make a POST request
        new AnalyticsAPIOperations().post(postUrl, sessionPayload);
    }
}
