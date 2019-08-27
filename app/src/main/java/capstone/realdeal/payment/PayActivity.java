package capstone.realdeal.payment;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.TextInputEditText;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import capstone.realdeal.R;

public class PayActivity extends PaymentActivity {

    private String i_amt,i_description,i_to;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.payment_tab1);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_pay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Button nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText amtText = findViewById(R.id.input_amt);
                TextInputEditText desText = findViewById(R.id.input_des);
                TextInputEditText toText = findViewById(R.id.input_to);
                i_amt = amtText.getText().toString();
                i_description = desText.getText().toString();
                i_to = toText.getText().toString();
                setContentView(R.layout.payment_methods);

            }
        });
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
