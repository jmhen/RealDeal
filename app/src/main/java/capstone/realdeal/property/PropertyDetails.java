package capstone.realdeal.property;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.R;
import capstone.realdeal.chat.ShowContacts;
import capstone.realdeal.recycler.ShowImageAdapter;
import capstone.realdeal.calendar.CalendarActivity;

public class PropertyDetails extends BaseActivity {

    private String property_name;
    List<String> url_list = new ArrayList<>();
    ShowImageAdapter imageAdapter;
    RecyclerView mRecyclerView;
    LinearLayout details_sec,manage_sec,room_list;
    TabLayout tabs;
    TextView property_name_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        property_name = getIntent().getStringExtra("property_name");
        setContentView(R.layout.property_details);
        getSupportActionBar().setTitle(property_name);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        property_name_text = findViewById(R.id.property_name);
        property_name_text.setText(property_name);


        mRecyclerView = findViewById(R.id.pic_recycler);
        LinearLayoutManager hManager = new LinearLayoutManager(PropertyDetails.this);
        hManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(hManager);

        createImageList();
        showImg();

        details_sec = findViewById(R.id.details_sec);
        manage_sec = findViewById(R.id.manage_sec);
        room_list = findViewById(R.id.room_list);

        details_sec.setVisibility(View.VISIBLE);
        manage_sec.setVisibility(View.INVISIBLE);

        tabs = findViewById(R.id.ppt_tab);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int idx = tab.getPosition();
                switch (idx) {
                    case 0:
                        details_sec.setVisibility(View.VISIBLE);
                        manage_sec.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        details_sec.setVisibility(View.INVISIBLE);
                        manage_sec.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        for(int i=0;i<room_list.getChildCount();i++){
            View t = room_list.getChildAt(i);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToRoom = new Intent(PropertyDetails.this, RoomDetails.class);
                    TextView t = findViewById(view.getId());
                    goToRoom.putExtra("room_name", t.getText());
                    view.getContext().startActivity(goToRoom);
                }
            });


        }



    }


    public void createImageList(){
        url_list.add("https://f10.baidu.com/it/u=1754964157,2742717649&fm=72");
        url_list.add("https://f11.baidu.com/it/u=101053314,1184308983&fm=72");
        url_list.add("https://f12.baidu.com/it/u=2532863132,623801812&fm=72");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void showImg(){
        mRecyclerView.removeAllViews();
        imageAdapter = new ShowImageAdapter(PropertyDetails.this); //here we assume the history items equals the collect items
        imageAdapter.setImageUrlList(url_list);
        mRecyclerView.setAdapter(imageAdapter);
        Log.d("adapter: " , "paymentAdapter");
    }


    public void goToCalendar(View view) {
        Intent go = new Intent(this, CalendarActivity.class);
        go.putExtra("property_name",property_name);
        this.startActivity(go);
    }

    public void goToPropertyDocument(View view) {
        Intent go = new Intent(this, PropertyDocuments.class);
        go.putExtra("property_name",property_name);
        this.startActivity(go);
    }

    public void goToContacts(View view) {
        Intent go = new Intent(this, ShowContacts.class);
        go.putExtra("property_name",property_name);
        this.startActivity(go);
    }

}
