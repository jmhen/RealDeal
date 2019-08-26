package capstone.realdeal.recycler;

public class PaymentCard {
    private String property_name;
    private String payment_date;
    private String tenants;

    public PaymentCard(String property_name, String payment_date){
        this.property_name = property_name;
        this.payment_date = payment_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getProperty_name() {
        return property_name;
    }

    public String getTenants() {
        return tenants;
    }
}
