package capstone.realdeal;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    protected static final String SERVER = "placeholder";
    protected Activity asyncActivity;

    protected void showToast(int msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
