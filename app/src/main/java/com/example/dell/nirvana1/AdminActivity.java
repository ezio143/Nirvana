package com.example.dell.nirvana1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    private Button adduser;
    private Button showuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setTitle(R.string.title_activity_settings);

        adduser = (Button) findViewById(R.id.button_add);
        showuser = (Button) findViewById(R.id.button_enrolledusers);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this,AddUserActivity.class));
            }
        });

        showuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this,ShowAllUsersActivity.class));
            }
        });

    }
}
