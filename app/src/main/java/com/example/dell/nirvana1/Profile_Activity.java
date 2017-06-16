package com.example.dell.nirvana1;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.nirvana1.data.SContract;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static java.security.AccessController.getContext;

public class Profile_Activity extends AppCompatActivity {

private Uri currentStudentUri;
    private TextView name,usn,dob,mno,email,sem,address,branch,section;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_activity_profile);
         currentStudentUri = getIntent().getData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         name = (TextView) findViewById(R.id.profile_name);
         usn = (TextView) findViewById(R.id.profile_usn);
         dob = (TextView) findViewById(R.id.profile_dob);
         mno = (TextView) findViewById(R.id.profile_mno);
         email = (TextView) findViewById(R.id.profile_email);
         sem = (TextView) findViewById(R.id.profile_semester);
         address = (TextView) findViewById(R.id.profile_adress);
         branch = (TextView) findViewById(R.id.profile_branch);
         section = (TextView) findViewById(R.id.profile_section);

        showProfile();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void showProfile() {

        String[] Projection =  {
                SContract.StudentsEntry._ID,
                SContract.StudentsEntry.COLUMN_NAME,
                SContract.StudentsEntry.COLUMN_USN,
                SContract.StudentsEntry.COLUMN_DOB,
                SContract.StudentsEntry.COLUMN_MNO,
                SContract.StudentsEntry.COLUMN_EMAIL,
                SContract.StudentsEntry.COLUMN_PASSWORD,
                SContract.StudentsEntry.COLUMN_ANSWER,
                SContract.StudentsEntry.COLUMN_SEMESTER,
                SContract.StudentsEntry.COLUMN_ADDRESS,
                SContract.StudentsEntry.COLUMN_BRANCH,
                SContract.StudentsEntry.COLUMN_SECTION

        };


Cursor cursor = null;
        try{

             cursor = getContentResolver().query(currentStudentUri,Projection,null,null,null);
            if(cursor.getCount() == 0){
                Toast.makeText(Profile_Activity.this,"error fetching student details",Toast.LENGTH_SHORT).show();
                return ;
            }

            cursor.moveToFirst();

            sem.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_SEMESTER)));
            name.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_NAME)));
            usn.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_USN)));
            dob.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_DOB)));
            mno.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_MNO)));
            email.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_EMAIL)));
            branch.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_BRANCH)));
            address.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_ADDRESS)));
            section.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_SECTION)));

        }
        finally {
            if(cursor != null)
            cursor.close();
        }

    }
}
