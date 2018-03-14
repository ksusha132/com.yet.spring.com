package application;


import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    public Event(Date date, DateFormat dateFormatter) {
        this.dateFormatter = dateFormatter;
        this.date = date;
        this.id = random.nextLong();
    }

    private Long id;
    private String msg;
    private Date date;
    private DateFormat dateFormatter;

    private final Random random = new Random();

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = random.nextLong();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateFormat getDateFormatter() {
        return dateFormatter;
    }

    public void setDateFormatter(DateFormat dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                ", random=" + random +
                '}' + dateFormatter.format(date) + "\n";
    }
}
