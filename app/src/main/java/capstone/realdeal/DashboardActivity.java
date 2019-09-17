package capstone.realdeal;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import capstone.realdeal.payment.PaymentActivity;
import capstone.realdeal.property.PropertiesManagement;
import capstone.realdeal.recycler.MsgAdapter;
import capstone.realdeal.recycler.MsgPiece;
import capstone.realdeal.util.CameraActivity;
import capstone.realdeal.util.SearchActivity;


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


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);


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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        //使用代码来动态控制MenuItem的显示状态 or XML定义MenuItem的显示状态
        //MenuItem share = menu.findItem(R.id.share);
        MenuItem search = menu.findItem(R.id.search);
        MenuItem camera = menu.findItem(R.id.camera);
       // MenuItem save = menu.findItem(R.id.save);
        search.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        camera.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        //redo.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        //save.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                showToast(R.string.menu_search);
                Intent search = new Intent(DashboardActivity.this, SearchActivity.class);
                startActivity(search);
                break;
            case R.id.camera:
                showToast(R.string.menu_camera);
                Intent shot = new Intent(DashboardActivity.this, CameraActivity.class);
                startActivity(shot);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
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
