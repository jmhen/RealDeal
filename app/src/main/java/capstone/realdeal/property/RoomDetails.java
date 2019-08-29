package capstone.realdeal.property;

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
import capstone.realdeal.recycler.ShowImageAdapter;

public class RoomDetails extends BaseActivity {

    private String room_name;
    List<String> url_list = new ArrayList<>();
    ShowImageAdapter imageAdapter;
    RecyclerView mRecyclerView;
    LinearLayout details_sec;
    LinearLayout manage_sec;
    TabLayout tabs;
    TextView room_name_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        room_name = getIntent().getStringExtra("room_name");
        setContentView(R.layout.room_details);
        getSupportActionBar().setTitle(room_name);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        room_name_text = findViewById(R.id.room_name);
        room_name_text.setText(room_name);

        mRecyclerView = findViewById(R.id.pic_recycler);
        LinearLayoutManager hManager = new LinearLayoutManager(RoomDetails.this);
        hManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(hManager);

        createImageList();
        showImg();

        details_sec = findViewById(R.id.details_sec);
        manage_sec = findViewById(R.id.manage_sec);

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




    }


    public void createImageList(){
        url_list.add("https://yun12.qfangimg.com/group2/800x600/M00/6D/E7/CvtcKl08M8iAVGOKAAssHRdSYzM870.jpg");
        url_list.add("https://yun4.qfangimg.com/group5/800x600/M00/06/F5/CvtcNV08Mk6APTbJAAhOhlQJhjk166.jpg");
        url_list.add("https://yun10.qfangimg.com/group2/800x600/M00/6F/7A/CvtcKV08M_qAI3kdAAtMFVTga0c759.jpg");
        url_list.add("https://yun12.qfangimg.com/group6/800x600/M00/06/DC/CvtcOl08MniAG8xSAApINBjUZns687.jpg");
        url_list.add("https://yun10.qfangimg.com/group4/800x600/M00/6E/96/CvtcMl08NAiAFPgLAA29u7QabzA282.jpg");
        url_list.add("https://yun4.qfangimg.com/group6/800x600/M00/06/DC/CvtcOl08MjWAW8otAAkXto2uQsA486.jpg");

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
        imageAdapter = new ShowImageAdapter(RoomDetails.this); //here we assume the history items equals the collect items
        imageAdapter.setImageUrlList(url_list);
        mRecyclerView.setAdapter(imageAdapter);
        Log.d("adapter: " , "paymentAdapter");
    }
}
