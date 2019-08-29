package capstone.realdeal.property;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.R;
import capstone.realdeal.TabActivity;
import capstone.realdeal.recycler.PropertyCard;
import capstone.realdeal.recycler.PropertyCardAdapter;

public class PropertiesManagement extends TabActivity {

    private ArrayList<PropertyCard> cardList = new ArrayList<>();
    private RecyclerView iRecyclerView;
    private PropertyCardAdapter pAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_properties);
        getSupportActionBar().setTitle(R.string.title_properties);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //getJSON(server,statusCollect);
        iRecyclerView = findViewById(R.id.infographic_recycler);
        iRecyclerView.setLayoutManager(new LinearLayoutManager(PropertiesManagement.this));

        getList();
        showPropertyCards();
        menu_tab = findViewById(R.id.menu_tab);
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);


    }

    private void getList() {

        cardList.clear();

        PropertyCard card1 = new PropertyCard("Property A", "some notifications abt tasks","Lease expiry/status");
        PropertyCard card2 = new PropertyCard("Property B", "some notifications abt tasks","Lease expiry/status");
        PropertyCard card3 = new PropertyCard("Property C", "some notifications abt tasks","Lease expiry/status");

        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);


    }
    private void showPropertyCards(){
        iRecyclerView.removeAllViews();
        pAdapter = new PropertyCardAdapter(cardList); //here we assume the history items equals the collect items
        iRecyclerView.setAdapter(pAdapter);
        Log.d("adapter: " , "paymentAdapter");
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
}
