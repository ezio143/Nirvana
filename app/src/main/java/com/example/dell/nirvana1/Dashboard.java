package com.example.dell.nirvana1;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.transition.Visibility;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.dell.nirvana1.R.id.answer;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {

    Button answer_button;
    static int answercount = 0;
    private String input_answer;
    private TextView answerview,answertitle;

    public Dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView =  inflater.inflate(R.layout.fragment_dashboard, container, false);
         answer_button = (Button) rootView.findViewById(R.id.button_answer_discuss);
        answerview = (TextView) rootView.findViewById(R.id.discuss_answer1);
        answertitle = (TextView) rootView.findViewById(R.id.text_answer_title);
        answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postAnswer(rootView);
            }
        });
            return rootView;
    }

    private void postAnswer(View rootView) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("your answer");

// Set up the input
        final EditText input = new EditText(getActivity());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                answer_button.setVisibility(View.INVISIBLE);
                input_answer = input.getText().toString().trim();
                answertitle.setText("Answers:");
                answerview.setText(input_answer);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

}
