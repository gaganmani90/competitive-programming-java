package design.usersession.http;

public interface APIOperations {
    String get(String url);
    String post(String url, String payload);
}
