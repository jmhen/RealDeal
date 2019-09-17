package capstone.realdeal.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.R;

public class SearchActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.menu_search);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.search_view);
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

