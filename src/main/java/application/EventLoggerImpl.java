package application;


public class EventLoggerImpl implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
