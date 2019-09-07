package capstone.realdeal.calendar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import capstone.realdeal.R;
import capstone.realdeal.TabActivity;

public class EventDetails extends TabActivity {

    private TextView name, date, property, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Event Details");
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.event_details);

        name = findViewById(R.id.event_name);
        date = findViewById(R.id.dateday);
        property = findViewById(R.id.property);
        description = findViewById(R.id.description);

        name.setText(getIntent().getStringExtra("event_name"));

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
