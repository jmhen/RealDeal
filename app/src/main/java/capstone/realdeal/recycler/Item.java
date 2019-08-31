package capstone.realdeal.recycler;

public class Item {
    public String name,status;

    public Item(){
        this.name = "name";
        this.status = "status";
    }
    public Item(String m_str1,String m_str2){
        this.name = m_str1;
        this.name = m_str2;
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
