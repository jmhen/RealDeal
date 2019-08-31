package capstone.realdeal.property;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import capstone.realdeal.R;
import capstone.realdeal.TabActivity;
import capstone.realdeal.recycler.FolderAdapter;


public class PropertyDocuments extends TabActivity {
    private ArrayList<String> folder_list = new ArrayList<>();
    private RecyclerView fRecycler;
    private FolderAdapter fAdapter;
    private String property_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        property_name = getIntent().getStringExtra("property_name");
        setContentView(R.layout.property_documents);
        getSupportActionBar().setTitle(property_name);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //getJSON(server,statusCollect);
        fRecycler = findViewById(R.id.infographic_recycler);
        fRecycler.setLayoutManager(new LinearLayoutManager(PropertyDocuments.this));

        getList();
        showPropertyCards();
        menu_tab = findViewById(R.id.menu_tab);
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);


    }

    private void getList() {

        folder_list.clear();

        folder_list.add("Contracts");
        folder_list.add("Expenses");
        folder_list.add("Tax Claims");
        folder_list.add("Tenant");


    }
    private void showPropertyCards(){
        fRecycler.removeAllViews();
        fAdapter = new FolderAdapter(folder_list); //here we assume the history items equals the collect items
        fRecycler.setAdapter(fAdapter);
        Log.d("adapter: " , "folderAdapter");
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
