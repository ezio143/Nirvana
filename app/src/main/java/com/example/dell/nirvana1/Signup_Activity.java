package com.example.dell.nirvana1;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.nirvana1.data.SContract;
import com.example.dell.nirvana1.data.SContract.StudentsEntry;

import org.w3c.dom.Text;

import static android.R.attr.id;
import static com.example.dell.nirvana1.R.id.answer;
import static com.example.dell.nirvana1.R.id.start;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.FACULTY;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.Qbirthplace;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.Qnickname;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.Qpetname;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry.STUDENT;

public class Signup_Activity extends AppCompatActivity {

    private RadioGroup rg;
    private static int category ;
   private Button signupbtn ;
    private Spinner mQuestionSpinner;
    private EditText usernametext;
    private EditText answertext;
    private  int checkedid;
    private Uri currentStudentUri;

    private int curQuestion = Qnickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);

        mQuestionSpinner = (Spinner) findViewById(R.id.signup_spinner);
       rg = (RadioGroup) findViewById(R.id.radiogroup);




        signupbtn = (Button) findViewById(R.id.button_register);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup_user();
            }
        });
        setupSpinner();

        setTitle("Sign Up");

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


    }

    private void signup_user() {

        //check for the usn
        usernametext = (EditText) findViewById(R.id.edit_username);
        //check the answer
        answertext = (EditText) findViewById(R.id.answer);
        //check for the category
        checkedid = rg.getCheckedRadioButtonId();

        usernametext.setError(null);
        answertext.setError(null);

        if (checkedid == R.id.radiostudent) {
            category = STUDENT;
        } else if (checkedid == R.id.radiofaculty) {
            category = FACULTY;
        }

        final String usn = usernametext.getText().toString().trim();
        final String answer = answertext.getText().toString().trim();
        if (TextUtils.isEmpty(usn) && TextUtils.isEmpty(answer)) {
            usernametext.setError("required field");
            return;
        }





        String[] Projection = {StudentsEntry._ID,StudentsEntry.COLUMN_NAME, StudentsEntry.COLUMN_USN, StudentsEntry.COLUMN_ANSWER};
        String selection = "usn=?";
        String[] selectionargs = new String[]{usn};
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(StudentsEntry.CONTENT_URI, Projection, selection, selectionargs, null);
            if(cursor.getCount() == 0) {
                //check for the existance of the usn in database
                Toast.makeText(Signup_Activity.this, "username does not exist", Toast.LENGTH_SHORT).show();
                return;
            }
            cursor.moveToFirst();
            String storedname = cursor.getString(cursor.getColumnIndexOrThrow(StudentsEntry.COLUMN_NAME));
            String storedusn = cursor.getString(cursor.getColumnIndexOrThrow(StudentsEntry.COLUMN_USN));
            String storedanswer = cursor.getString(cursor.getColumnIndexOrThrow(StudentsEntry.COLUMN_ANSWER));

            if(!TextUtils.isEmpty(storedname)){

                Toast.makeText(Signup_Activity.this, storedname+" is already Registered!", Toast.LENGTH_SHORT).show();
                return;
            }


            if (usn.equals(storedusn) && answer.equals(storedanswer) && category == STUDENT) {

                long id = cursor.getInt(cursor.getColumnIndexOrThrow(StudentsEntry._ID));
                currentStudentUri = ContentUris.withAppendedId(StudentsEntry.CONTENT_URI, id);

                Toast.makeText(Signup_Activity.this, "Right Answer", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Signup_Activity.this, CompleteProfile.class);
                i.setData(currentStudentUri);
                startActivity(i);
                finish();

            } else
                answertext.setError("wrong answer");
        }
        finally {
            cursor.close();

        }
    }

}
