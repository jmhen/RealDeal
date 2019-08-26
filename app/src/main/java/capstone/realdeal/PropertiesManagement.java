package capstone.realdeal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import capstone.realdeal.recycler.PropertyCard;
import capstone.realdeal.recycler.PropertyCardAdapter;

public class PropertiesManagement extends BaseActivity {

    private ArrayList<PropertyCard> cardList = new ArrayList<>();
    private RecyclerView iRecyclerView;
    private PropertyCardAdapter pAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
}
