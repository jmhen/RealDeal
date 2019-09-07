package capstone.realdeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;


public class TabActivity extends BaseActivity {
    protected TabLayout menu_tab;
    protected Activity mActivity;
    protected TabLayout.OnTabSelectedListener onMenuTabSelectedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        onMenuTabSelectedListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int idx = tab.getPosition();
                Intent proceed = new Intent();
                switch (idx) {
                    case 0:
                        proceed.setClass(mActivity, DashboardActivity.class);
                        startActivity(proceed);
                        break;
                    case 1:
                        //proceed.setClass(mActivity, NotificationActivity.class);
                        //startActivity(proceed);
                        break;
                    case 2:
                        //proceed.setClass(mActivity, ProfileActivity.class);
                        //startActivity(proceed);
                        break;
                    case 3:
                        proceed.setClass(mActivity, ProfileActivity.class);
                        startActivity(proceed);
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }


    protected void tabIni(){
        if(mActivity.getClass().equals(ProfileActivity.class)) {
            menu_tab.getTabAt(3).select();
           // fqTab.getTabAt(0).setIcon(R.drawable.feed);

        }
        else if(mActivity.getClass().equals(DashboardActivity.class)) {
            menu_tab.getTabAt(0).select();
            // fqTab.getTabAt(0).setIcon(R.drawable.feed);

        }


    }


//    public void tabClick(View view) {
//        int id = view.getId();
//        Intent proceed = new Intent();
//        switch (id){
//            case R.id.feed:
//                proceed.setClass(this, FeedActivity.class);
//                startActivity(proceed);
//                break;
//            case R.id.notification:
//                proceed.setClass(this, NotificationActivity.class);
//                startActivity(proceed);
//                break;
//            case R.id.profile:
//                proceed.setClass(this, ProfileActivity.class);
//                startActivity(proceed);
//                break;
//            default: break;
//
//        }
//
//    }
}
