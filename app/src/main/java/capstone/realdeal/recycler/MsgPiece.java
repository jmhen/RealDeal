package capstone.realdeal.recycler;

public class MsgPiece {

    private String activity;
    private String time;

    public MsgPiece(String m_activity,String m_time){
        this.activity = m_activity;
        this.time = m_time;
    }

    public String getActivity() {
        return activity;
    }

    public String getTime() {
        return time;
    }
}
