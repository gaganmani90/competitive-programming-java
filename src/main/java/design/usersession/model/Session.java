package design.usersession.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Session {
    long duration;
    List<String> pages;
    long startTime;

    public Session(long l, List<String> currentPages, long startTime) {
        this.duration = l;
        this.pages = currentPages;
        this.startTime = startTime;
    }
}
