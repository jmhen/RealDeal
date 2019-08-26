package capstone.realdeal.payment;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.DocumentsManagement;
import capstone.realdeal.PropertiesManagement;
import capstone.realdeal.R;
import capstone.realdeal.recycler.MsgAdapter;
import capstone.realdeal.recycler.MsgPiece;
import capstone.realdeal.recycler.PaymentCard;
import capstone.realdeal.recycler.PaymentCardAdapter;

public class PaymentActivity extends BaseActivity {

    private ArrayList<PaymentCard> cardList = new ArrayList<>();
    private ArrayList<MsgPiece> msgList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView pRecyclerView;
    private PaymentCardAdapter pAdapter;
    private MsgAdapter paymentAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_payment);
        getSupportActionBar().setTitle(R.string.manage_tab1);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //getJSON(server,statusCollect);
        mRecyclerView = findViewById(R.id.cards_recycler);
        LinearLayoutManager hManager = new LinearLayoutManager(PaymentActivity.this);
        hManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(hManager);


        pRecyclerView = findViewById(R.id.msg_recycler);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(PaymentActivity.this));
//        pRecyclerView.setHasFixedSize(true);
//        pRecyclerView.setNestedScrollingEnabled(false)


        getList();
        showPaymentCards();
        showPaymentMsg();


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

    private void getList() {

        cardList.clear();

        PaymentCard card1 = new PaymentCard("Property A", "22/09");
        PaymentCard card2 = new PaymentCard("Property B", "22/09");
        PaymentCard card3 = new PaymentCard("Property C", "22/09");

        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        msgList.clear();
        MsgPiece msg1 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        MsgPiece msg2 = new MsgPiece("Hougang Rental Due","10AM - 12PM");
        MsgPiece msg3 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        MsgPiece msg4 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        MsgPiece msg5 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        MsgPiece msg6 = new MsgPiece("Call plumber for Hougang","10AM - 12PM");
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
        msgList.add(msg4);
        msgList.add(msg5);
        msgList.add(msg6);


    }

    public void goToPay(View view) {
        Intent gotoFavourate  =  new Intent(this, PayActivity.class);
        startActivity(gotoFavourate);
    }
    public void goToRequest(View view) {
        Intent gotoFavourate  =  new Intent(this, RequestActivity.class);
        startActivity(gotoFavourate);
    }
    public void goToReceipt(View view) {
        Intent gotoFavourate  =  new Intent(this, CreateInvoice.class);
        startActivity(gotoFavourate);
    }

    private void showPaymentCards(){
        mRecyclerView.removeAllViews();
        pAdapter = new PaymentCardAdapter(cardList); //here we assume the history items equals the collect items
        mRecyclerView.setAdapter(pAdapter);
        Log.d("adapter: " , "paymentAdapter");
    }

    private void showPaymentMsg(){
        pRecyclerView.removeAllViews();
        paymentAdapter = new MsgAdapter(msgList); //here we assume the history items equals the collect items
        pRecyclerView.setAdapter(paymentAdapter);
        Log.d("adapter: " , "paymentAdapter");
    }
}
