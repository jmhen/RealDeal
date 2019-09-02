package capstone.realdeal.recycler;

public class ContactCard {
    private String contact_name,property_name, msg;

    public ContactCard(String contact_name, String property_name, String msg){
        this.property_name = property_name;
        this.contact_name = contact_name;
        this.msg = msg;
    }

    public String getProperty_name() {
        return property_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getMsg() {
        return msg;
    }
}
