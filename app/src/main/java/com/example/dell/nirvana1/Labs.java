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
import com.example.dell.nirvana1.data.SContract.LabsEntry;


/**
 * A simple {@link Fragment} subclass.
 */
public class Labs extends Fragment {

    private TextView ldetails;

    public Labs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_labs, container, false);

        showLabs(rootView);

        return rootView;
    }

    private void showLabs(View rootView) {


        ldetails = (TextView) rootView.findViewById(R.id.text_ldetails);
        String[] Projection = {"*"};
        Cursor cursor = null;
        try {
            cursor = getActivity().getContentResolver().query(SContract.LabsEntry.CONTENT_URI, Projection, null, null, null);

            if (cursor.getCount() == 0) {
                Toast.makeText(getContext(), "error fetching labs", Toast.LENGTH_SHORT).show();
                return;
            }
            cursor.moveToFirst();
            ldetails.setText(cursor.getInt(cursor.getColumnIndexOrThrow(LabsEntry._ID))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(LabsEntry.COLUMN_LNAME))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(LabsEntry.COLUMN_RNO))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(LabsEntry.COLUMN_FLOOR))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(LabsEntry.COLUMN_SUB))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(LabsEntry.COLUMN_DNO)));

        }
        finally {
            if(cursor != null)
                cursor.close();
        }
    }

}
