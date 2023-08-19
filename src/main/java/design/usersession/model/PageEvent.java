package design.usersession.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageEvent {
    String url;
    String visitorId;
    long timestamp;
}
