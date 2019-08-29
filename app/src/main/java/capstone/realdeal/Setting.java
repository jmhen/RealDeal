package capstone.realdeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import capstone.realdeal.recycler.Item;
import capstone.realdeal.recycler.NormalAdapter;

public class Setting extends TabActivity {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting_page);
        getSupportActionBar().setTitle(R.string.title_setting);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        menu_tab = findViewById(R.id.menu_tab);
        tabIni();
        menu_tab.addOnTabSelectedListener(onMenuTabSelectedListener);


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
