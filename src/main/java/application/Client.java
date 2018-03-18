package application;

public class Client {
    public Client() {
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;

    private String name;

    private String greeting;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
