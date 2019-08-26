package capstone.realdeal.recycler;

public class PropertyCard {
    private String property_name;
    private String notification;
    private String status;

    public PropertyCard(String property_name,String notification,String status){
        this.property_name = property_name;
        this.notification = notification;
        this.status = status;
    }

    public String getProperty_name() {
        return property_name;
    }

    public String getNotification() {
        return notification;
    }

    public String getStatus() {
        return status;
    }
}
