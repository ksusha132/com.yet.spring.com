package application;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.List;


public class CacheFileLogger extends FileEventLogger {

    private Integer cacheSize;

    private Cache cache;

    public CacheFileLogger(String name, Integer cacheSize, Cache cache) {
        super(name);
        this.cacheSize = cacheSize;
        this.cache = cache;
    }

    @Override
    public void logEvent(Event event) {
        cache.addToCache(event);

        if (cache.size() == cacheSize) {
            writeEventToFile(cache.getEvents());

            cache.clearCache();
        }


    }

    @Override
    public void init() throws IOException {
        super.init();
    }

    //@PreDestroy
    public void destroy() {

        if (cache.getEvents() != null) {
            for (Event event : cache.getEvents()) {
                logEvent(event);
            }
        }
    }

    private void writeEventToFile(List<Event> events) {
        for (Event event : events) {
            super.logEvent(event); // insert into file
        }
    }
}
