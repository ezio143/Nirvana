package com.example.dell.nirvana1;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.nirvana1.data.SContract;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notes extends Fragment {

    private TextView ndetails;

    public Notes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_notes, container, false);

        showNotes(rootView);

        return rootView;
    }

    private void showNotes(View rootView) {
        ndetails = (TextView) rootView.findViewById(R.id.text_ndetails);
        String[] Projection = {"*"};
        Cursor cursor = null;
        try {
            cursor = getActivity().getContentResolver().query(SContract.NotesEntry.CONTENT_URI, Projection, null, null, null);

            if (cursor.getCount() == 0) {
                Toast.makeText(getContext(), "error fetching student notes", Toast.LENGTH_SHORT).show();
                return;
            }

            cursor.moveToFirst();
            ndetails.setText(cursor.getInt(cursor.getColumnIndexOrThrow(SContract.NotesEntry._ID))+"\n"
                    +cursor.getString(cursor.getColumnIndexOrThrow(SContract.NotesEntry.COLUMN_DES)));

        }
        finally {
            if(cursor!=null){
                cursor.close();
            }
        }

    }

}
