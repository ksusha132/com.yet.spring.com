package application;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<Event> events = new ArrayList<Event>();

    public void addToCache(Event event) {
        if (event != null) {
            events.add(event);
        }
    }

    public Integer size() {
        return events.size();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void clearCache() {
        events.clear();
    }
}
