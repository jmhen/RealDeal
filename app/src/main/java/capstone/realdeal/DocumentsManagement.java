package capstone.realdeal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import capstone.realdeal.property.PropertiesManagement;
import capstone.realdeal.recycler.OverLayLayoutManager;
import capstone.realdeal.recycler.PropertyCard;
import capstone.realdeal.recycler.PropertyCardAdapter;
import capstone.realdeal.recycler.SimpleAdapter;

public class DocumentsManagement extends TabActivity {

    private ArrayList<String> pList = new ArrayList<>();
    private RecyclerView iRecyclerView;
    private SimpleAdapter sAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.doc_main);
        getSupportActionBar().setTitle(R.string.title_document);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //getJSON(server,statusCollect);
        iRecyclerView = findViewById(R.id.recycler);
        iRecyclerView.setLayoutManager(new OverLayLayoutManager(DocumentsManagement.this));

        getList();
        showPropertyCards();
        menu_tab = findViewById(R.id.menu_tab);
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);


    }

    private void getList() {

        pList.clear();

        pList.add("Personal");
        pList.add("Property A");
        pList.add("Property B");
        pList.add("Property C");


    }
    private void showPropertyCards(){
        iRecyclerView.removeAllViews();
        sAdapter = new SimpleAdapter(pList); //here we assume the history items equals the collect items
        iRecyclerView.setAdapter(sAdapter);
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
