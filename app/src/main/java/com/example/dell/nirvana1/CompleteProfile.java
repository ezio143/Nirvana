package com.example.dell.nirvana1;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.nirvana1.data.SContract.StudentsEntry;

public  class CompleteProfile extends AppCompatActivity {

    private Button submit ;
    private  EditText
            nametext,
            dobtext,
            mobtext,
            emailtext,
            passwordtext,
            confpasstext,
            branchtext,
            sectiontext,
            adresstext,
            semestertext;

    private Uri currentStudentUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_profile_activity);

        setTitle("Complete Profile");


            currentStudentUri = getIntent().getData();

        submit = (Button) findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate_User();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void validate_User() {

        nametext = (EditText) findViewById(R.id.first_name);
        dobtext = (EditText) findViewById(R.id.edit_dob);
        mobtext = (EditText) findViewById(R.id.edit_mob);
        emailtext = (EditText) findViewById(R.id.edit_email);
        passwordtext = (EditText) findViewById(R.id.edit_password);
        confpasstext = (EditText) findViewById(R.id.edit_confirm_password);
        branchtext = (EditText) findViewById(R.id.edit_branch);
        sectiontext = (EditText) findViewById(R.id.edit_section);
        adresstext =(EditText) findViewById(R.id.edit_address);
        semestertext = (EditText) findViewById(R.id.edit_semester);


      final String  fname = nametext.getText().toString().trim();
        final  String dob  = dobtext.getText().toString().trim();
        final String mob = mobtext.getText().toString().trim();

        final String email = emailtext.getText().toString().trim();
        final String password = passwordtext.getText().toString().trim();
        final String confpass = confpasstext.getText().toString().trim();
        final String branch = branchtext.getText().toString().trim();
        final String section = sectiontext.getText().toString().trim();
        final String address = adresstext.getText().toString().trim();
        final String semester = semestertext.getText().toString().trim();



        if(TextUtils.isEmpty(fname) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(mob)
                || TextUtils.isEmpty(email)
                || TextUtils.isEmpty(password) || TextUtils.isEmpty(confpass) || TextUtils.isEmpty(address)){

            Toast.makeText(CompleteProfile.this,"empty fields!",Toast.LENGTH_SHORT).show();
        }

        else {

             if(!(password.equals(confpass))){
                Toast.makeText(CompleteProfile.this,"passwords does not match",Toast.LENGTH_SHORT).show();
                return;
             }

            ContentValues values = new ContentValues();
            values.put(StudentsEntry.COLUMN_NAME,fname);
            values.put(StudentsEntry.COLUMN_DOB,dob);
            values.put(StudentsEntry.COLUMN_MNO,mob);
            values.put(StudentsEntry.COLUMN_EMAIL,email);
            values.put(StudentsEntry.COLUMN_PASSWORD,password);
            values.put(StudentsEntry.COLUMN_BRANCH,branch);
            values.put(StudentsEntry.COLUMN_SECTION,section);
            values.put(StudentsEntry.COLUMN_ADDRESS,address);
            values.put(StudentsEntry.COLUMN_SEMESTER,semester);


            int rowsupdated = getContentResolver().update(currentStudentUri,values,null,null);
            if(rowsupdated == 0){
                Toast.makeText(CompleteProfile.this,"update failed",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(CompleteProfile.this, "profile update success", Toast.LENGTH_SHORT).show();
            }


            values.clear();
            finish();
        }//close else




    }



}
