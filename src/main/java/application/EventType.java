package application;

public enum EventType {
    INFO("INFO"),
    ERROR("ERROR");

    private String code;

    EventType(String code) {
        this.code = code;
    }
}
