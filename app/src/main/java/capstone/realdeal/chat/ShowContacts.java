package capstone.realdeal.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import capstone.realdeal.R;
import capstone.realdeal.TabActivity;
import capstone.realdeal.payment.PayActivity;
import capstone.realdeal.payment.ReceiptActivity;
import capstone.realdeal.payment.RequestActivity;
import capstone.realdeal.recycler.ContactCardAdapter;
import capstone.realdeal.recycler.ContactCard;
import capstone.realdeal.recycler.PaymentCard;
import capstone.realdeal.recycler.PaymentCardAdapter;

public class ShowContacts extends TabActivity {

    private String TAG = "=====ShowContacts=====";
    private ArrayList<PaymentCard> cardList = new ArrayList<>();
    private ArrayList<ContactCard> contact_list = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView pRecyclerView;
    private PaymentCardAdapter pAdapter;
    private ContactCardAdapter cAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, " OnCreate " );
        setContentView(R.layout.chat_all_contacts);
        getSupportActionBar().setTitle(R.string.title_chat);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //getJSON(server,statusCollect);
        mRecyclerView = findViewById(R.id.cards_recycler);
        LinearLayoutManager hManager = new LinearLayoutManager(ShowContacts.this);
        hManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(hManager);


        pRecyclerView = findViewById(R.id.contact_recycler);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(ShowContacts.this));
//        pRecyclerView.setHasFixedSize(true);
//        pRecyclerView.setNestedScrollingEnabled(false)


        getList();
        showPaymentCards();
        showContactList();

        menu_tab = findViewById(R.id.menu_tab);
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

    private void getList() {

        cardList.clear();

        PaymentCard card1 = new PaymentCard("Property A", "4 participants");
        PaymentCard card2 = new PaymentCard("Property B", "3 participants");
        PaymentCard card3 = new PaymentCard("Property C", "4 participants");

        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        contact_list.clear();
        ContactCard msg1 = new ContactCard("Tenant C","Property A", "most recent msg");
        ContactCard msg2 = new ContactCard("Tenant D","Property A", "most recent msg");
        ContactCard msg3 = new ContactCard("Tenant E","Property A", "most recent msg");

        contact_list.add(msg1);
        contact_list.add(msg2);
        contact_list.add(msg3);



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
        Intent gotoFavourate  =  new Intent(this, ReceiptActivity.class);
        startActivity(gotoFavourate);
    }

    private void showPaymentCards(){
        mRecyclerView.removeAllViews();
        pAdapter = new PaymentCardAdapter(cardList); //here we assume the history items equals the collect items
        mRecyclerView.setAdapter(pAdapter);
        Log.d("adapter: " , "cAdapter");
    }

    private void showContactList(){
        pRecyclerView.removeAllViews();
        cAdapter = new ContactCardAdapter(contact_list); //here we assume the history items equals the collect items
        pRecyclerView.setAdapter(cAdapter);
        Log.d("adapter: " , "cAdapter");
    }
}
