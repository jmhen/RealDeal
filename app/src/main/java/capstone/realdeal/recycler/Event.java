package capstone.realdeal.recycler;

public class Event {
    private String name, time, property, description;


    public Event(String name, String time, String property, String description){
        this.name = name;
        this.time = time;
        this.property = property;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getProperty() {
        return property;
    }

    public String getTime() {
        return time;
    }
}
