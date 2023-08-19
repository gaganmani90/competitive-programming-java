package design.usersession.transformers;

import design.usersession.model.PageEvent;
import design.usersession.model.Session;

import java.util.*;

public class PageEventToSessionTransformer implements Transformer<List<PageEvent>, Map<String, List<Session>>> {
    public Map<String, List<Session>> transform(List<PageEvent> events) {
        Map<String, List<Session>> sessionByUser = new HashMap<>();
        Map<String, List<PageEvent>> eventsByUser = new HashMap<>();
        for (PageEvent event : events) {
            eventsByUser.computeIfAbsent(event.getVisitorId(), k -> new ArrayList<>()).add(event);
        }

        for (Map.Entry<String, List<PageEvent>> entry : eventsByUser.entrySet()) {
            List<PageEvent> userEvents = entry.getValue();
            userEvents.sort(Comparator.comparingLong(PageEvent::getTimestamp));

            List<Session> sessions = new ArrayList<>();
            List<String> currentPages = new ArrayList<>();
            long startTime = -1;
            for (PageEvent event : userEvents) {
                if (startTime == -1) {
                    startTime = event.getTimestamp();
                }
                if (!currentPages.contains(event.getUrl())) {
                    currentPages.add(event.getUrl());
                }
                if (event.getTimestamp() - startTime > 600000) { // Session timeout: 10 minutes (600000 milliseconds)
                    sessions.add(new Session(event.getTimestamp() - startTime, currentPages, startTime));
                    startTime = event.getTimestamp();
                    currentPages = new ArrayList<>();
                }
            }
            sessions.add(new Session(userEvents.get(userEvents.size() - 1).getTimestamp() - startTime, currentPages, startTime));
            sessionByUser.put(entry.getKey(), sessions);
        }
        return sessionByUser;
    }
}
