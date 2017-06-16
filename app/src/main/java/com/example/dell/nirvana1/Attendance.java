package com.example.dell.nirvana1;


import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.nirvana1.data.SContract;
import com.example.dell.nirvana1.data.SContract.AttendanceEntry;
import com.example.dell.nirvana1.syncdb.SyncDatabase;

import java.sql.SQLException;


import static com.example.dell.nirvana1.syncdb.SyncDatabase.syncattendance;


/**
 * A simple {@link Fragment} subclass.
 */
public class Attendance extends Fragment {


    //PrefManager pref = new PrefManager(getContext());

    private static final String REQUEST_URL = "http://192.168.173.1/attendence.php";

    String[] Projection = {"*"};
    View rootView;
    private   String usn,dno;
    private int sem,c1,c11,c2,c22,c3,c33,c4,c44,c5,c55,c6,c66,c7,c77,c8,c88,c9,c99;
double p1,p2,p3,p4,p5,p6,p7,p8,p9;
ProgressBar progress;
    SyncAttendance sa;
    public Attendance() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootView =  inflater.inflate(R.layout.fragment_attendance, container, false);
        progress = (ProgressBar) rootView.findViewById(R.id.att_progress);
        sa = new SyncAttendance();
        sa.execute(REQUEST_URL);

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sa.cancel(true);
    }

    private void showAttendance(View view, String[] Projection) {

        Cursor cursor = null;
        try{
            cursor = this.getActivity().getContentResolver().query(AttendanceEntry.CONTENT_URI,Projection,null,null,null);

            if(cursor.getCount() == 0){
                Toast.makeText(getContext(),"error fetching student attendance",Toast.LENGTH_SHORT).show();
                return ;
            }
            cursor.moveToFirst();


            sem = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_SEM));
            ((TextView)view.findViewById(R.id.text_dno)).setText(sem+"");
            usn = cursor.getString(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_USN));
            ((TextView)view.findViewById(R.id.text_usn)).setText(usn);
            c1 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_1));
            ((TextView)view.findViewById(R.id.c1)).setText(c1+"");
            c11 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_11));
            ((TextView)view.findViewById(R.id.c11)).setText(c11+"");
            c2 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_2));
            ((TextView)view.findViewById(R.id.c2)).setText(c2+"");
            c22 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_22));
            c3 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_3));
            c33 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_33));
            c4 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_4));
            c44 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_44));
            c5 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_5));
            c55 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_55));
            c6 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_6));
            c66 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_66));
            c7 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_7));
            c77 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_77));
            c8 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_8));
            c88 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_88));
            c9 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_9));
            c99 = cursor.getInt(cursor.getColumnIndexOrThrow(AttendanceEntry.COLUMN_99));

            p1 = 100*c11/c1;
            p2 = 100*c22/c2;
            p3 = 100*c33/c3;
            p4 = 100*c44/c4;
            p5 = 100*c55/c5;
            p6 = 100*c66/c6;
            p7 = 100*c77/c7;
            p8 = 100*c88/c8;
            p9 = 100*c99/c9;

            ((TextView)view.findViewById(R.id.c22)).setText(c22+"");
            ((TextView)view.findViewById(R.id.c3)).setText(c3+"");
            ((TextView)view.findViewById(R.id.c33)).setText(c33+"");
            ((TextView)view.findViewById(R.id.c4)).setText(c4+"");
            ((TextView)view.findViewById(R.id.c44)).setText(c44+"");
            ((TextView)view.findViewById(R.id.c5)).setText(c5+"");
            ((TextView)view.findViewById(R.id.c55)).setText(c55+"");
            ((TextView)view.findViewById(R.id.c6)).setText(c6+"");
            ((TextView)view.findViewById(R.id.c66)).setText(c66+"");
            ((TextView)view.findViewById(R.id.c7)).setText(c7+"");
            ((TextView)view.findViewById(R.id.c77)).setText(c77+"");
            ((TextView)view.findViewById(R.id.c8)).setText(c8+"");
            ((TextView)view.findViewById(R.id.c88)).setText(c88+"");
            ((TextView)view.findViewById(R.id.c9)).setText(c9+"");
            ((TextView)view.findViewById(R.id.c99)).setText(c99+"");
            ((TextView)view.findViewById(R.id.per1)).setText(p1+"");
            ((TextView)view.findViewById(R.id.per2)).setText(p2+"");
            ((TextView)view.findViewById(R.id.per3)).setText(p3+"");
            ((TextView)view.findViewById(R.id.per4)).setText(p4+"");
            ((TextView)view.findViewById(R.id.per5)).setText(p5+"");
            ((TextView)view.findViewById(R.id.per6)).setText(p6+"");
            ((TextView)view.findViewById(R.id.per7)).setText(p7+"");
            ((TextView)view.findViewById(R.id.per8)).setText(p8+"");
            ((TextView)view.findViewById(R.id.per9)).setText(p9+"");

        }
        finally{
            if(cursor !=null)
                cursor.close();
        }


    }


    private class SyncAttendance extends AsyncTask<String,Void,ContentValues>{



        @Override
        protected ContentValues doInBackground(String... urls) {
         ContentValues  result = syncattendance(urls[0],getContext());
            if(result == null)
            return null;
            else
                return result;
        }

        @Override
        protected void onPostExecute(ContentValues result) {
            if(result != null) {
                getActivity().getContentResolver().delete(AttendanceEntry.CONTENT_URI,null,null);
                getActivity().getContentResolver().insert(AttendanceEntry.CONTENT_URI, result);
                Toast.makeText(getActivity(), "database sync : success", Toast.LENGTH_SHORT).show();
                progress.setVisibility(View.GONE);
                showAttendance(rootView, Projection);
            }
            else{
                Toast.makeText(getActivity(), "database sync : failure", Toast.LENGTH_SHORT).show();
                progress.setVisibility(View.GONE);
                showAttendance(rootView, Projection);

            }
        }
    }


}
