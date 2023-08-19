package design.usersession;

import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Data
public class FetchAndPostClient {
    String url;
    CloseableHttpClient httpClient;
    public FetchAndPostClient(String url) {
        this.url = url;
        httpClient = HttpClients.createDefault();
    }
    public String fetchData() {
        String payload = "";
        HttpGet httpGet = new HttpGet(this.url);
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

    public String postData(String payload) {
        HttpPost httpPost = new HttpPost(this.url);
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
