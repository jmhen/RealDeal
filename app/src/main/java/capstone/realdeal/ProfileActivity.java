package capstone.realdeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import capstone.realdeal.payment.PaymentActivity;
import capstone.realdeal.property.PropertiesManagement;
import capstone.realdeal.recycler.Item;
import capstone.realdeal.recycler.NormalAdapter;


public class ProfileActivity extends TabActivity {
    private ArrayList<Item> pList = new ArrayList<>();
    private RecyclerView nRecyclerView;
    private NormalAdapter nAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_profile_page);
        getSupportActionBar().setTitle(R.string.title_profile);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        //getJSON(server,statusCollect);
        nRecyclerView = findViewById(R.id.n_recycler);
        nRecyclerView.setLayoutManager(new LinearLayoutManager(ProfileActivity.this));
        getList();
        showList();

        menu_tab = findViewById(R.id.menu_tab);
        tabIni();
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);


    }
    public void goSetting(View view) {
//        Intent gotoFavourate  =  new Intent(this, DocumentsManagement.class);
//        gotoFavourate.putExtra("storeName", "SampleStore");
//        startActivity(gotoFavourate);
    }


    private void showList(){
        nRecyclerView.removeAllViews();
        nAdapter = new NormalAdapter(pList);
        nRecyclerView.setAdapter(nAdapter);
        Log.d("adapter: " , "normalAdapter" );

    }


    private void getList() {

        pList.clear();
        Item i1 = new Item("Property A","Leased");
        Item i2 = new Item("Property B","Leased");
        Item i3 = new Item("Property C","Vacant");

        pList.add(i1);
        pList.add(i2);
        pList.add(i3);

    }

    public void goToSetting(View view) {
        Intent go_setting = new Intent(this, Setting.class);
        this.startActivity(go_setting);
    }
}
