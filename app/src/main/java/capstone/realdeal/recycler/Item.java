package capstone.realdeal.recycler;

public class Item {
    public String name,status;

    public Item(){
        this.name = "name";
        this.status = "status";
    }
    public Item(String name,String status){
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
