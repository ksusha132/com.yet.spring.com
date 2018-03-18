package application;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

//    private EventLogger eventLogger;
//    private EventLogger fileEventLogger;
//    private EventLogger cacheFileLogger;
//
//    public CombinedEventLogger(EventLogger eventLogger, EventLogger fileEventLogger, EventLogger cacheFileLogger) {
//        this.eventLogger = eventLogger;
//        this.fileEventLogger = fileEventLogger;
//        this.cacheFileLogger = cacheFileLogger;
//    }

    private List<EventLogger> loggerList;

    public CombinedEventLogger(List<EventLogger> loggerList) {
        this.loggerList = loggerList;
    }

    public void logEvent(Event event) {

        for (EventLogger eventLogger : loggerList) {
            eventLogger.logEvent(event);
        }
    }
}
