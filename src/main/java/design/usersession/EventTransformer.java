package design.usersession;

import java.util.*;

public class EventTransformer implements Transformer<List<PageEvent>, Map<String, List<Session>>>{
    public Map<String, List<Session>> transform(List<PageEvent> events) {
        Map<String, List<Session>> sessionByUser = new HashMap<>();
        Map<String, List<PageEvent>> eventsByUser = new HashMap<>();
        for (PageEvent event : events) {
            eventsByUser.computeIfAbsent(event.visitorId, k -> new ArrayList<>()).add(event);
        }

        for (Map.Entry<String, List<PageEvent>> entry : eventsByUser.entrySet()) {
            List<PageEvent> userEvents = entry.getValue();
            Collections.sort(userEvents, Comparator.comparingLong(event -> event.timestamp));

            List<Session> sessions = new ArrayList<>();
            List<String> currentPages = new ArrayList<>();
            long startTime = -1;
            for (PageEvent event : userEvents) {
                if (startTime == -1) {
                    startTime = event.timestamp;
                }
                if (!currentPages.contains(event.url)) {
                    currentPages.add(event.url);
                }
                if (event.timestamp - startTime > 600000) { // Session timeout: 10 minutes (600000 milliseconds)
                    sessions.add(new Session(event.timestamp - startTime, currentPages, startTime));
                    startTime = event.timestamp;
                    currentPages = new ArrayList<>();
                }
            }
            sessions.add(new Session(userEvents.get(userEvents.size() - 1).timestamp - startTime, currentPages, startTime));
            sessionByUser.put(entry.getKey(), sessions);
        }
        return sessionByUser;
    }
}
