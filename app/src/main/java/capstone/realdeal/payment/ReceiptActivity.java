package capstone.realdeal.payment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.R;

public class ReceiptActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_invoice);
        getSupportActionBar().setTitle(R.string.title_create_invoice);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



    public void generateBtnOnclick(View view){
        setContentView(R.layout.send_receipt);
        getSupportActionBar().setTitle(R.string.title_issue_receipt);
    }
    public void confirmBtnOnclick(View view){
        setContentView(R.layout.send_receipt_done);
        getSupportActionBar().setTitle(R.string.title_send_receipt);
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
