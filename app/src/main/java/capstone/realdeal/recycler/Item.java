package capstone.realdeal.recycler;

public class Item {
    public String name,status;
    public Item(String m_name,String m_status){
        this.name = m_name;
        this.status = m_status;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }
}
