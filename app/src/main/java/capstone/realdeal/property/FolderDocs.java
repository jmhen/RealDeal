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
import capstone.realdeal.recycler.DocCardAdapter;
import capstone.realdeal.recycler.FolderAdapter;
import capstone.realdeal.recycler.Item;


public class FolderDocs extends TabActivity {
    private ArrayList<Item> doc_list = new ArrayList<>();
    private RecyclerView dRecycler;
    private DocCardAdapter dAdapter;
    private String folder_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        folder_name = getIntent().getStringExtra("folder_name");
        setContentView(R.layout.docs_folder);
        getSupportActionBar().setTitle(folder_name);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //getJSON(server,statusCollect);
        dRecycler = findViewById(R.id.infographic_recycler);
        dRecycler.setLayoutManager(new LinearLayoutManager(FolderDocs.this));


        getList();
        showPropertyCards();
        menu_tab = findViewById(R.id.menu_tab);
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);


    }

    private void getList() {

        doc_list.clear();

        doc_list.add(new Item("Contract A", "Date Created | Size"));
        doc_list.add(new Item("Contract B", "Date Created | Size"));
        doc_list.add(new Item("Contract C", "Date Created | Size"));
        doc_list.add(new Item("Contract D", "Date Created | Size"));


    }
    private void showPropertyCards(){
        dRecycler.removeAllViews();
        dAdapter = new DocCardAdapter(doc_list); //here we assume the history items equals the collect items
        dRecycler.setAdapter(dAdapter);
        Log.d("adapter: " , "docAdapter");
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
