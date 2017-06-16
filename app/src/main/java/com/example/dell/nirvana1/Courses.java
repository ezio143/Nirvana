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
public class Courses extends Fragment {

    private TextView cdetails;



    public Courses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_courses, container, false);

        showCourses(rootView);

        return rootView;
    }

    private void showCourses(View rootView) {

        cdetails = (TextView) rootView.findViewById(R.id.text_cdetails);
        String[] Projection = {"*"};
        Cursor cursor = null;
        try{
            cursor = getActivity().getContentResolver().query(SContract.CourseEntry.CONTENT_URI,Projection,null,null,null);

            if(cursor.getCount() == 0){
                Toast.makeText(getContext(),"error fetching student attendance",Toast.LENGTH_SHORT).show();
                return ;
            }

            cursor.moveToFirst();
            cdetails.setText(cursor.getInt(cursor.getColumnIndexOrThrow(SContract.CourseEntry._ID))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(SContract.CourseEntry.COLUMN_SNAME))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(SContract.CourseEntry.COLUMN_SCODE))+"--"
            +cursor.getInt(cursor.getColumnIndexOrThrow(SContract.CourseEntry.COLUMN_CREDITS))+"--"
            +cursor.getInt(cursor.getColumnIndexOrThrow(SContract.CourseEntry.COLUMN_SEM))+"--"
            +cursor.getString(cursor.getColumnIndexOrThrow(SContract.CourseEntry.COLUMN_DNO)));

    }
    finally {
            if(cursor!=null)
                cursor.close();
        }

}
}
