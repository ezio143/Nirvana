package com.example.dell.nirvana1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;

/**
 * Created by DELL on 11-04-2017.
 */

public class Fragment_academics_main extends Fragment implements View.OnClickListener {


    private Button register,timetable,notes,attendence,result;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_academics_main,container,false);


        register = (Button) rootView.findViewById(R.id.imgbutton_register);
        timetable = (Button) rootView.findViewById(R.id.imgbutton_timetable);
        notes = (Button) rootView.findViewById(R.id.imgbutton_notes);
        attendence = (Button) rootView.findViewById(R.id.imgbutton_attendance);
        result = (Button) rootView.findViewById(R.id.imgbutton_result);

        attendence.setOnClickListener(this);
        timetable.setOnClickListener(this);
        notes.setOnClickListener(this);
        register.setOnClickListener(this);
        result.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbutton_attendance:
                        Attendance newattendance = new Attendance();
                        FragmentManager manager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.academics_main_view, newattendance, "2");
                        transaction.commit();break;
            case R.id.imgbutton_register:
                Register newreg = new Register();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.academics_main_view, newreg).commit();
                break;
            case R.id.imgbutton_timetable:
                TimeTable tb = new TimeTable();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.academics_main_view,tb).commit();
                break;
            case R.id.imgbutton_notes:
                Notes nf = new Notes();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.academics_main_view,nf).commit();
                break;
            case R.id.imgbutton_result:
                Result rf = new Result();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.academics_main_view,rf).commit();
                break;
        }
    }
}
