package capstone.realdeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import capstone.realdeal.payment.PaymentActivity;
import capstone.realdeal.property.PropertiesManagement;
import capstone.realdeal.recycler.MsgAdapter;
import capstone.realdeal.recycler.MsgPiece;


public class DashboardActivity extends TabActivity {
    private ArrayList<MsgPiece> msgList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MsgAdapter todayAdapter;
    private MsgAdapter paymentAdapter;
    private TabLayout msgTab;
    private String WEBSERVICE_NOTIFICATIONLIST ="";
    private String server = SERVER + WEBSERVICE_NOTIFICATIONLIST;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncActivity = this;
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle(R.string.title_dashboard);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        msgTab = findViewById(R.id.channel_tab);

        //getJSON(server,statusCollect);
        mRecyclerView = findViewById(R.id.msg_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));
        getList();
        showTodayMsg();
        msgTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int idx = tab.getPosition();
                switch (idx){
                    case 0:
                        //getJSON(server,statusCollect);
                        getList();
                        showTodayMsg();
                        break;
                    case 1:
                        //getJSON(server,statusCollected);
                        getList();
                        showTodayMsg();
                        break;
                    default: break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        menu_tab = findViewById(R.id.menu_tab);
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);

    }
    public void goToDocuments(View view) {
        Intent gotoFavourate  =  new Intent(this, DocumentsManagement.class);
        gotoFavourate.putExtra("storeName", "SampleStore");
        startActivity(gotoFavourate);
    }
    public void goToProperties(View view) {
        Intent gotoFavourate  =  new Intent(this, PropertiesManagement.class);
        gotoFavourate.putExtra("storeName", "SampleStore");
        startActivity(gotoFavourate);
    }
    public void goToPayments(View view) {
        Intent gotoFavourate  =  new Intent(this, PaymentActivity.class);
        gotoFavourate.putExtra("storeName", "SampleStore");
        startActivity(gotoFavourate);
    }

    private void showTodayMsg(){
        mRecyclerView.removeAllViews();
        todayAdapter = new MsgAdapter(msgList);
        mRecyclerView.setAdapter(todayAdapter);
        Log.d("adapter: " , "todayAdapter" );

    }

    private void showPaymentMsg(){
        mRecyclerView.removeAllViews();
        paymentAdapter = new MsgAdapter(msgList); //here we assume the history items equals the collect items
        mRecyclerView.setAdapter(paymentAdapter);
        Log.d("adapter: " , "paymentAdapter");
    }

    private void getList() {

        msgList.clear();
        MsgPiece msg1 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        MsgPiece msg2 = new MsgPiece("Hougang Rental Due","10AM - 12PM");
        MsgPiece msg3 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        MsgPiece msg4 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
        msgList.add(msg4);


    }
}
