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


/**
 * A simple {@link Fragment} subclass.
 */
public class Result extends Fragment {

    private TextView resdetails;

    public Result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_result, container, false);

        showResult(rootView);
        return rootView;
    }

    private void showResult(View rootView) {

        resdetails = (TextView) rootView.findViewById(R.id.text_resdetails);
        String[] Projection = {"*"};
        Cursor cursor = null;
        try {
            cursor = getActivity().getContentResolver().query(SContract.ResultEntry.CONTENT_URI, Projection, null, null, null);

            if (cursor.getCount() == 0) {
                Toast.makeText(getContext(), "error fetching student result", Toast.LENGTH_SHORT).show();
                return;
            }

            cursor.moveToFirst();
            resdetails.setText(cursor.getInt(cursor.getColumnIndexOrThrow(SContract.ResultEntry._ID))+"\n"
                    +cursor.getString(cursor.getColumnIndexOrThrow(SContract.ResultEntry.COLUMN_SGPA)));

        }
        finally {
            if(cursor!=null){
                cursor.close();
            }
        }
    }

}
