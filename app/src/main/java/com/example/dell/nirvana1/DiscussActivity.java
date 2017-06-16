package com.example.dell.nirvana1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class DiscussActivity extends AppCompatActivity {

        Dashboard db;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    PostQuestion pq = new PostQuestion();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,pq).commit();
                    mTextMessage.setText(R.string.title_post);
                    return true;
                case R.id.navigation_dashboard:
                     db = new Dashboard();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,db).commit();
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    Mychats mc = new Mychats();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,mc).commit();
                    mTextMessage.setText(R.string.title_chat);
                    return true;


            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        setTitle(R.string.app_name);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Dashboard dbo = new Dashboard();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,dbo).commit();
        mTextMessage.setText(R.string.title_dashboard);
    }
}
