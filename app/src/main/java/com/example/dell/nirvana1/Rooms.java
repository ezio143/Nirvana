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
import com.example.dell.nirvana1.data.SContract.RoomsEntry;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rooms extends Fragment {

    private TextView rdetails;

    public Rooms() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rooms, container, false);

        showRooms(rootView);

        return rootView;
    }

    private void showRooms(View rootView) {

        rdetails = (TextView) rootView.findViewById(R.id.text_rdetails);
        String[] Projection = {"*"};
        Cursor cursor = null;
        try {
            cursor = getActivity().getContentResolver().query(RoomsEntry.CONTENT_URI, Projection, null, null, null);

            if (cursor.getCount() == 0) {
                Toast.makeText(getContext(), "error fetching rooms", Toast.LENGTH_SHORT).show();
                return;
            }
            cursor.moveToFirst();
            rdetails.setText(cursor.getInt(cursor.getColumnIndexOrThrow(RoomsEntry._ID))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(RoomsEntry.COLUMN_RNO))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(RoomsEntry.COLUMN_FLOOR))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(RoomsEntry.COLUMN_DNO))+"--"
            +cursor.getInt(cursor.getColumnIndexOrThrow(RoomsEntry.COLUMN_BENCHES))+"--"
            +cursor.getInt(cursor.getColumnIndexOrThrow(RoomsEntry.COLUMN_CAPACITY)));


        }
        finally {
            if(cursor != null)
                cursor.close();
        }

    }

}
