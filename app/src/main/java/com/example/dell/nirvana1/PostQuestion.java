package com.example.dell.nirvana1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.edit;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostQuestion extends Fragment {

private EditText editusername,edittopicname, editdiscussquestion;
    private String username,topicname, question;
    private Button postButton;

    public PostQuestion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_post_question, container, false);

        editusername = (EditText) rootView.findViewById(R.id.edit_discuss_username);
        edittopicname = (EditText) rootView.findViewById(R.id.edit_discuss_topicname);
        editdiscussquestion =(EditText) rootView.findViewById(R.id.edit_discuss_question);
        postButton = (Button) rootView.findViewById(R.id.post_discuss);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editusername.setError(null);
                edittopicname.setError(null);
                editdiscussquestion.setError(null);
                if(TextUtils.isEmpty(editusername.getText())){
                    editusername.setError("fill the fields ");
                    editusername.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(edittopicname.getText())){

                    edittopicname.setError("fill the fields ");
                    edittopicname.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(editdiscussquestion.getText())){

                    editdiscussquestion.setError("fill the fields ");
                    editdiscussquestion.requestFocus();
                    return;
                }
                postQuestion();

            }
        });
        return rootView;
        }

    private void postQuestion() {

        username = editusername.getText().toString().trim();
        topicname = edittopicname.getText().toString().trim();
        question = editdiscussquestion.getText().toString().trim();
    }

}
