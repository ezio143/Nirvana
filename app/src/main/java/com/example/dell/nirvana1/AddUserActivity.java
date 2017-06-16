package com.example.dell.nirvana1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.dell.nirvana1.data.SContract;
import com.example.dell.nirvana1.data.SdbHelper;

import static com.example.dell.nirvana1.data.SContract.StudentsEntry.Qbirthplace;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.Qnickname;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.Qpetname;

public class AddUserActivity extends AppCompatActivity {

    private Spinner mQuestionSpinner;
    private int curQuestion = Qnickname;
    SQLiteDatabase db;
    SdbHelper mdbHelper;
    private ImageButton adduserbutton;
    private String newUname;
    private String newAnswer;
    private AutoCompleteTextView newUserText;
    private AutoCompleteTextView newAnswerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        setTitle(R.string.title_activity_adduser);
        mQuestionSpinner = (Spinner) findViewById(R.id.dept_spinner);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupSpinner();
        mdbHelper = new SdbHelper(this);

        adduserbutton = (ImageButton) findViewById(R.id.button_adduser);
        adduserbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });

    }


    private void addUser() {



        newUserText = (AutoCompleteTextView) findViewById(R.id.new_username);
        newAnswerText = (AutoCompleteTextView)findViewById(R.id.new_answer);

        newUserText.setError(null);
        newAnswerText.setError(null);

        newUname = newUserText.getText().toString().trim();
        newAnswer = newAnswerText.getText().toString().trim();

        if(TextUtils.isEmpty(newUname) || TextUtils.isEmpty(newAnswer)){
            if(TextUtils.isEmpty(newUname)){
                newUserText.setError(getString(R.string.error_field_required));
                newUserText.requestFocus();
            }
            else {
                newAnswerText.setError(getString(R.string.error_field_required));
                newAnswerText.requestFocus();
            }
            return;
        }


        ContentValues values = new ContentValues();

        values.put(SContract.StudentsEntry.COLUMN_NAME,"");
        values.put(SContract.StudentsEntry.COLUMN_USN,newUname);
        values.put(SContract.StudentsEntry.COLUMN_DOB,"");
        values.put(SContract.StudentsEntry.COLUMN_MNO,"");
        values.put(SContract.StudentsEntry.COLUMN_EMAIL,"");
        values.put(SContract.StudentsEntry.COLUMN_PASSWORD,"");
        values.put(SContract.StudentsEntry.COLUMN_ANSWER,newAnswer);

        //long newid = db.insert(StudentsEntry.TABLE_NAME,null,values);
        Uri id = getContentResolver().insert(SContract.StudentsEntry.CONTENT_URI,values);
        finish();

    }


    //security questions spinner
    private void setupSpinner() {



        ArrayAdapter questionSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_question_options,
                android.R.layout.simple_spinner_item);

        questionSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mQuestionSpinner.setAdapter(questionSpinnerAdapter);

        mQuestionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals("NickName")) {
                        curQuestion = Qnickname;
                    } else if (selection.equals("BirthPlace")) {
                        curQuestion = Qbirthplace;
                    } else {
                        curQuestion = Qpetname;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                curQuestion = Qnickname;
            }
        });


    }//end of spinner




}//dept_activity close