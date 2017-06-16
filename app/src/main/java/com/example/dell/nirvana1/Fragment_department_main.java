package com.example.dell.nirvana1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_department_main extends Fragment  implements View.OnClickListener {

    private Button faculty, course, rooms, labs;

    public Fragment_department_main() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_department_main, container, false);

        faculty = (Button) rootView.findViewById(R.id.imgbutton_faculty);
        course = (Button) rootView.findViewById(R.id.imgbutton_courses);
        rooms = (Button) rootView.findViewById(R.id.imgbutton_Rooms);
        labs = (Button) rootView.findViewById(R.id.imgbutton_labs);

        faculty.setOnClickListener(this);
        course.setOnClickListener(this);
        rooms.setOnClickListener(this);
        labs.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imgbutton_faculty:
                Faculty ff = new Faculty();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.department_main_view,ff).commit();
                break;
            case R.id.imgbutton_courses:
                Courses cf = new Courses();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.department_main_view,cf).commit();
                break;
            case R.id.imgbutton_Rooms:
                Rooms rf = new Rooms();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.department_main_view,rf).commit();
                break;
            case R.id.imgbutton_labs:
                Labs lf = new Labs();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.department_main_view,lf).commit();
                break;
        }
    }

}
