package capstone.realdeal.payment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.R;

public class RequestActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        getSupportActionBar().setTitle(R.string.payment_tab2);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
