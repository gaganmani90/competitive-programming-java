package design.usersession.http;

import design.usersession.http.APIOperations;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Data
public class AnalyticsAPIOperations implements APIOperations {
    CloseableHttpClient httpClient;
    public AnalyticsAPIOperations() {
        httpClient = HttpClients.createDefault();
    }
    public String get(String url) {
        String payload = "";
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if(entity != null) {
                payload = EntityUtils.toString(entity);
            } else {
                throw new RuntimeException("No response is received from endpoint: "+url);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return payload;
    }

    public String post(String url, String payload) {
        HttpPost httpPost = new HttpPost(url);
        String postPayload = "";
        try {
            httpPost.setEntity(new StringEntity(payload));
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("X-User-Name", "Gagan Mani");
            CloseableHttpResponse postResponse = httpClient.execute(httpPost);
            int statusCode = postResponse.getStatusLine().getStatusCode();
            postPayload = EntityUtils.toString(postResponse.getEntity());
            if(statusCode != 200) {
                throw new RuntimeException("Post request failed at URL: %s"+url+" with status code: "+statusCode);
            }
            return postPayload;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
