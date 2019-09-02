package capstone.realdeal.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import capstone.realdeal.BaseActivity;
import capstone.realdeal.R;

import static android.view.View.GONE;
import android.support.v7.widget.GridLayout;

public class ChatActivity extends BaseActivity {
    private String TAG = "=====Chat Activity=====";
    private String chat_id;
    private GridLayout functions;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chat_id = getIntent().getStringExtra("chat_id");
        Log.d(TAG, " OnCreate " );
        setContentView(R.layout.chat_room);
        getSupportActionBar().setTitle(chat_id);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        functions = findViewById(R.id.functions);
        functions.setVisibility(GONE);
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

    public void showFunctions(View view){
        if(functions.getVisibility() == GONE)
        functions.setVisibility(View.VISIBLE);
        else functions.setVisibility(GONE);
    }

}
