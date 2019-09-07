package capstone.realdeal.calendar;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import capstone.realdeal.R;
import capstone.realdeal.recycler.Event;
import capstone.realdeal.recycler.EventAdapter;


public class CalendarActivity extends CalendarBaseActivity implements
        CalendarView.OnCalendarSelectListener,CalendarView.OnYearChangeListener,
        CalendarView.OnMonthChangeListener,CalendarView.OnCalendarLongClickListener{


    TextView mTextMonthDay;

    TextView mTextYear;

    TextView mTextLunar;

    TextView mTextCurrentDay;
    ImageView mPrev,mNext;

    private ArrayList<Event> eventList = new ArrayList<>();
    private CalendarView mCalendarView;
    private RecyclerView mRecycler;
    private EventAdapter eAdapter;
    RelativeLayout mRelativeTool;
    private int mYear;
    CalendarLayout mCalendarLayout;



    @Override
    protected int getLayoutId() {
        return R.layout.calendar_view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        getSupportActionBar().setTitle("Calendar");
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTextMonthDay = findViewById(R.id.tv_month_day);
        mTextYear = findViewById(R.id.tv_year);
        mTextLunar = findViewById(R.id.tv_lunar);
        mPrev = findViewById(R.id.prev);
        mNext = findViewById(R.id.next);

        mRelativeTool = findViewById(R.id.rl_tool);
        mCalendarView = findViewById(R.id.calendarView);
        mCalendarView.setRange(2018, 7, 1, 2021, 4, 28);
        mTextCurrentDay = findViewById(R.id.tv_current_day);
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarLayout.expand();
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });


//        mPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCalendarView.scrollToPre();
//            }
//        });
//        mNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCalendarView.scrollToNext();;
//            }
//        });



        mCalendarLayout = findViewById(R.id.calendarLayout);

        mCalendarView.setOnCalendarSelectListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mCalendarView.setOnMonthChangeListener(this);
        mCalendarView.setOnCalendarLongClickListener(this, true);

        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));

        mRecycler = findViewById(R.id.recycler_view);
        mRecycler.setLayoutManager(new LinearLayoutManager(CalendarActivity.this));
        getList();
        showAllEvents();


    }

    @SuppressWarnings("unused")
    @Override
    protected void initData() {

        final int year = mCalendarView.getCurYear();
        final int month = mCalendarView.getCurMonth();

        Map<String, Calendar> map = new HashMap<>();
        for (int y = 1997; y < 2082; y++) {
            for (int m = 1; m <= 12; m++) {
                map.put(getSchemeCalendar(y, m, 1, 0xFF40db25, "假").toString(),
                        getSchemeCalendar(y, m, 1, 0xFF40db25, "假"));
                map.put(getSchemeCalendar(y, m, 2, 0xFFe69138, "游").toString(),
                        getSchemeCalendar(y, m, 2, 0xFFe69138, "游"));
                map.put(getSchemeCalendar(y, m, 3, 0xFFdf1356, "事").toString(),
                        getSchemeCalendar(y, m, 3, 0xFFdf1356, "事"));
                map.put(getSchemeCalendar(y, m, 4, 0xFFaacc44, "车").toString(),
                        getSchemeCalendar(y, m, 4, 0xFFaacc44, "车"));
                map.put(getSchemeCalendar(y, m, 5, 0xFFbc13f0, "驾").toString(),
                        getSchemeCalendar(y, m, 5, 0xFFbc13f0, "驾"));
                map.put(getSchemeCalendar(y, m, 6, 0xFF542261, "记").toString(),
                        getSchemeCalendar(y, m, 6, 0xFF542261, "记"));
                map.put(getSchemeCalendar(y, m, 7, 0xFF4a4bd2, "会").toString(),
                        getSchemeCalendar(y, m, 7, 0xFF4a4bd2, "会"));
                map.put(getSchemeCalendar(y, m, 8, 0xFFe69138, "车").toString(),
                        getSchemeCalendar(y, m, 8, 0xFFe69138, "车"));
                map.put(getSchemeCalendar(y, m, 9, 0xFF542261, "考").toString(),
                        getSchemeCalendar(y, m, 9, 0xFF542261, "考"));
                map.put(getSchemeCalendar(y, m, 10, 0xFF87af5a, "记").toString(),
                        getSchemeCalendar(y, m, 10, 0xFF87af5a, "记"));
                map.put(getSchemeCalendar(y, m, 11, 0xFF40db25, "会").toString(),
                        getSchemeCalendar(y, m, 11, 0xFF40db25, "会"));
                map.put(getSchemeCalendar(y, m, 12, 0xFFcda1af, "游").toString(),
                        getSchemeCalendar(y, m, 12, 0xFFcda1af, "游"));
                map.put(getSchemeCalendar(y, m, 13, 0xFF95af1a, "事").toString(),
                        getSchemeCalendar(y, m, 13, 0xFF95af1a, "事"));
                map.put(getSchemeCalendar(y, m, 14, 0xFF33aadd, "学").toString(),
                        getSchemeCalendar(y, m, 14, 0xFF33aadd, "学"));
                map.put(getSchemeCalendar(y, m, 15, 0xFF1aff1a, "码").toString(),
                        getSchemeCalendar(y, m, 15, 0xFF1aff1a, "码"));
                map.put(getSchemeCalendar(y, m, 16, 0xFF22acaf, "驾").toString(),
                        getSchemeCalendar(y, m, 16, 0xFF22acaf, "驾"));
                map.put(getSchemeCalendar(y, m, 17, 0xFF99a6fa, "校").toString(),
                        getSchemeCalendar(y, m, 17, 0xFF99a6fa, "校"));
                map.put(getSchemeCalendar(y, m, 18, 0xFFe69138, "车").toString(),
                        getSchemeCalendar(y, m, 18, 0xFFe69138, "车"));
                map.put(getSchemeCalendar(y, m, 19, 0xFF40db25, "码").toString(),
                        getSchemeCalendar(y, m, 19, 0xFF40db25, "码"));
                map.put(getSchemeCalendar(y, m, 20, 0xFFe69138, "火").toString(),
                        getSchemeCalendar(y, m, 20, 0xFFe69138, "火"));
                map.put(getSchemeCalendar(y, m, 21, 0xFF40db25, "假").toString(),
                        getSchemeCalendar(y, m, 21, 0xFF40db25, "假"));
                map.put(getSchemeCalendar(y, m, 22, 0xFF99a6fa, "记").toString(),
                        getSchemeCalendar(y, m, 22, 0xFF99a6fa, "记"));
                map.put(getSchemeCalendar(y, m, 23, 0xFF33aadd, "假").toString(),
                        getSchemeCalendar(y, m, 23, 0xFF33aadd, "假"));
                map.put(getSchemeCalendar(y, m, 24, 0xFF40db25, "校").toString(),
                        getSchemeCalendar(y, m, 24, 0xFF40db25, "校"));
                map.put(getSchemeCalendar(y, m, 25, 0xFF1aff1a, "假").toString(),
                        getSchemeCalendar(y, m, 25, 0xFF1aff1a, "假"));
                map.put(getSchemeCalendar(y, m, 26, 0xFF40db25, "议").toString(),
                        getSchemeCalendar(y, m, 26, 0xFF40db25, "议"));
                map.put(getSchemeCalendar(y, m, 27, 0xFF95af1a, "假").toString(),
                        getSchemeCalendar(y, m, 27, 0xFF95af1a, "假"));
                map.put(getSchemeCalendar(y, m, 28, 0xFF40db25, "码").toString(),
                        getSchemeCalendar(y, m, 28, 0xFF40db25, "码"));
            }
        }

        //28560 数据量增长不会影响UI响应速度，请使用这个API替换
        mCalendarView.setSchemeDate(map);

        //可自行测试性能差距
        //mCalendarView.setSchemeDate(schemes);

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


    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        return calendar;
    }



    private void getList() {

        eventList.clear();
        Event e1 = new Event("Event 1", "12:00","Property A","description");
        Event e2 = new Event("Event 2", "12:00","Property A","description");
        Event e3 = new Event("Event 3", "12:00","Property A","description");
        Event e4 = new Event("Event 4", "12:00","Property A","description");
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        eventList.add(e4);


    }

    private void showAllEvents(){
        mRecycler.removeAllViews();
        eAdapter = new EventAdapter(eventList);
        mRecycler.setAdapter(eAdapter);
        Log.d("adapter: " , "todayAdapter" );
    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
        if (isClick) {
            Toast.makeText(this, getCalendarText(calendar), Toast.LENGTH_SHORT).show();
            mCalendarLayout.shrink();

        }

        Log.e("onDateSelected", "  -- " + calendar.getYear() +
                "  --  " + calendar.getMonth() +
                "  -- " + calendar.getDay() +
                "  --  " + isClick + "  --   " + calendar.getScheme());
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }

    @Override
    public void onMonthChange(int year, int month) {
        Log.e("onMonthChange", "  -- " + year + "  --  " + month);
        Calendar calendar = mCalendarView.getSelectedCalendar();
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
    }


    @Override
    public void onCalendarLongClickOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarLongClick(Calendar calendar) {
        Toast.makeText(this, "长按不选择日期\n" + getCalendarText(calendar), Toast.LENGTH_SHORT).show();
    }

    private static String getCalendarText(Calendar calendar) {
        return String.format("新历%s \n 农历%s \n 公历节日：%s \n 农历节日：%s \n 节气：%s \n 是否闰月：%s",
                calendar.getMonth() + "月" + calendar.getDay() + "日",
                calendar.getLunarCalendar().getMonth() + "月" + calendar.getLunarCalendar().getDay() + "日",
                TextUtils.isEmpty(calendar.getGregorianFestival()) ? "无" : calendar.getGregorianFestival(),
                TextUtils.isEmpty(calendar.getTraditionFestival()) ? "无" : calendar.getTraditionFestival(),
                TextUtils.isEmpty(calendar.getSolarTerm()) ? "无" : calendar.getSolarTerm(),
                calendar.getLeapMonth() == 0 ? "否" : String.format("闰%s月", calendar.getLeapMonth()));
    }
}
