package application;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {
//    Client client;
//
//    EventLoggerImpl eventLogger;

    private EventLogger cacheFileLogger;

    //private EventLogger fileEventLogger;
    //private EventLogger cacheFileLogger;

    private Client client;
    private Map<EventType, EventLogger> loggerMap;

    public App(Client client, EventLogger cacheFileLogger , Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.loggerMap = loggerMap;
        this.cacheFileLogger = cacheFileLogger;
//        this.fileEventLogger = fileEventLogger;
//        this.cacheFileLogger = cacheFileLogger;
    }

    public App() {
    }

    public static void main(String[] args) {

//        App app = new App();
//        app.client = new Client((long) 1, "Ivan");
//        app.eventLogger = new EventLoggerImpl();
//        app.logEvent("Some message...");

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        App app = ctx.getBean("app", App.class);
//        app.client.setId(2L);
//        app.client.setName("Sergei");
//        app.logEvent(ctx.getBean("event", Event.class));

        Client client = ctx.getBean("client", Client.class);
        client.setId(1L);
        client.setName("Vasya");

        Client client1 = ctx.getBean("client", Client.class);
        client1.setId(2L);
        client1.setName("Vanya");

        Client client2 = ctx.getBean("client", Client.class);
        client2.setId(3L);
        client2.setName("Pasha");

        Client client3 = ctx.getBean("client", Client.class);
        client3.setId(3L);
        client3.setName("Sasha");

        Client client4 = ctx.getBean("client", Client.class);
        client4.setId(4L);
        client4.setName("Masha");

        Client client5 = ctx.getBean("client", Client.class);
        client5.setId(5L);
        client5.setName("Lyosha");

        app.logEvent1(EventType.ERROR, "Fun", ctx.getBean("event", Event.class));

//        app.logEvent(ctx.getBean("event", Event.class), client);
//        app.logEvent(ctx.getBean("event", Event.class), client1);
//        app.logEvent(ctx.getBean("event", Event.class), client2);
//        app.logEvent(ctx.getBean("event", Event.class), client3);
//        app.logEvent(ctx.getBean("event", Event.class), client4);
//        app.logEvent(ctx.getBean("event", Event.class), client5);

        ctx.close();
    }

//    private void logEvent(Event event, Client client) {
//        if (client.getId() == 1) {
//            // String message = smg + " This message contains: " + client.getName();
//            eventLogger.logEvent(event);
//        } else if (client.getId() == 2) {
//            //String message = smg + " This message contains:" + client.getId();
//            fileEventLogger.logEvent(event);
//        } else {
//            cacheFileLogger.logEvent(event);
//        }
//
//    }


    private void logEvent1(EventType type, String msg, Event event) {
        EventLogger el = loggerMap.get(type);

        if (el == null) {
            el = cacheFileLogger;
        }
        el.logEvent(event);
    }

    // if event type  == null ->  cacheFileEventLogger
    //info - eventLogger
    //error - log everywhere

}
