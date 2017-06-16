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
public class Faculty extends Fragment {

     private TextView fdetails;

    public Faculty() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_faculty, container, false);


        showAllFaculty(rootView);


        return rootView;
    }

    private void showAllFaculty(View root) {

        fdetails = (TextView) root.findViewById(R.id.text_fdetails);
        String[] Projection = {"*"};
        Cursor cursor = null;
        try{
            cursor = getActivity().getContentResolver().query(SContract.FacultyEntry.CONTENT_URI,Projection,null,null,null);

            if(cursor.getCount() == 0){
                Toast.makeText(getContext(),"error fetching student attendance",Toast.LENGTH_SHORT).show();
                return ;
            }
            cursor.moveToFirst();
            fdetails.setText(cursor.getString(cursor.getColumnIndexOrThrow(SContract.FacultyEntry._ID))+"-"
            +cursor.getString(cursor.getColumnIndexOrThrow(SContract.FacultyEntry.COLUMN_NAME))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(SContract.FacultyEntry.COLUMN_FID))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(SContract.FacultyEntry.COLUMN_DNUM)));


        }

        finally {
            if(cursor !=null)
                cursor.close();
        }

    }

}
