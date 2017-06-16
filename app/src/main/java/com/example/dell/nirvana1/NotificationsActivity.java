package com.example.dell.nirvana1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class NotificationsActivity extends AppCompatActivity {

    public static final String LOG_TAG = NotificationsActivity.class.getName();

    College_Notifications cn;
    Class_Notifications cln;
    Activitys_Activity af;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    cn = new College_Notifications();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_activity,cn).commit();
                    mTextMessage.setText(R.string.title_college);
                    return true;
                case R.id.navigation_dashboard:
                    cln = new Class_Notifications();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_activity,cln).commit();
                    mTextMessage.setText(R.string.title_classroom);
                    return true;
                case R.id.navigation_notifications:
                    af = new Activitys_Activity();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_activity,af).commit();
                    mTextMessage.setText(R.string.activities);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
setTitle(R.string.title_notifications);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        cn = new College_Notifications();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_activity,cn).commit();
    }

}
