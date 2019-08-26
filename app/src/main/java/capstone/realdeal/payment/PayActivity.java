package capstone.realdeal.payment;

import android.os.Bundle;

import capstone.realdeal.R;

public class PayActivity extends PaymentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.payment_tab1);
        getSupportActionBar().setElevation(0);
    }
}
