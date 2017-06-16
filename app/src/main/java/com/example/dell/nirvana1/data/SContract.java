package com.example.dell.nirvana1.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.util.StringBuilderPrinter;

/**
 * Created by DELL on 06-03-2017.
 */

public final class SContract {

    private SContract(){}

    public static final String CONTENT_AUTHORITY = "com.example.dell.nirvana1";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);
    public static final String PATH_STUDENT = "student";
    public static final String PATH_ATTENDANCE = "attendance";
    public static final String PATH_FACULTY = "faculty";
    public static final String PATH_COURSE = "course";
    public static final String PATH_ROOMS = "rooms";
    public static final String PATH_LABS = "labs";
    public static final String PATH_NOTES = "notes";
    public static final String PATH_RESULT = "result";
    public static final String PATH_TIMETABLE = "timetable";

    public static final class StudentsEntry implements BaseColumns{

        public static final String TABLE_NAME = "student";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USN = "usn";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_MNO = "mno";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_ANSWER = "answer";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_BRANCH = "branch";
        public static final String COLUMN_SECTION = "section";
        public static final String COLUMN_SEMESTER = "semester";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_STUDENT);

        public static final int Qnickname = 0;
        public static final int Qbirthplace = 1;
        public static final int Qpetname = 2;

        public static final int STUDENT = 2;
        public static final int FACULTY = 5;



    }

    public static final class FacultyEntry implements BaseColumns{

        public static final String TABLE_NAME = "faculty";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_FID = "fid";
        public static final String COLUMN_DNUM = "dnum";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_MNO = "mno";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_ANSWER = "answer";
        public static final String COLUMN_ADDRESS = "address";



        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_FACULTY);

        public static final int Qnickname = 0;
        public static final int Qbirthplace = 1;
        public static final int Qpetname = 2;

        public static final int STUDENT = 2;
        public static final int FACULTY = 5;


    }


    public static final class AttendanceEntry implements  BaseColumns {

        public static final String TABLE_NAME = "attendance";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_USN = "usn";
        public static final String COLUMN_DNO = "dno";
        public static final String COLUMN_SEM = "sem";
        public static final String COLUMN_11 = "oneta";
        public static final String COLUMN_1 = "onetc";
        public static final String COLUMN_2 = "twotc";
        public static final String COLUMN_3 = "threetc";
        public static final String COLUMN_4 = "fourtc";
        public static final String COLUMN_5 = "fivetc";
        public static final String COLUMN_6 = "sixtc";
        public static final String COLUMN_22 = "twota";
        public static final String COLUMN_33 = "threeta";
        public static final String COLUMN_44 = "fourta";
        public static final String COLUMN_55 = "fiveta";
        public static final String COLUMN_66 = "sixta";
        public static final String COLUMN_7 = "seventc";
        public static final String COLUMN_77 = "seventa";
        public static final String COLUMN_8 = "eighttc";
        public static final String COLUMN_88 = "eightta";
        public static final String COLUMN_9 = "ninetc";
        public static final String COLUMN_99 = "nineta";


        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_ATTENDANCE);


    }

    public static final class CourseEntry implements BaseColumns {

        public static final String TABLE_NAME = "course";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SNAME = "sname";
        public static final String COLUMN_SCODE = "scode";
        public static final String COLUMN_CREDITS = "credits";
        public static final String COLUMN_SEM = "sem";
        public static final String COLUMN_DNO = "dno"; //foreign

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_COURSE);

    }


    public static final class RoomsEntry implements BaseColumns {

        public static final String TABLE_NAME = "rooms";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_RNO = "rno";
        public static final String COLUMN_FLOOR = "floor";
        public static final String COLUMN_BENCHES = "benches";
        public static final String COLUMN_CAPACITY = "capacity";
        public static final String COLUMN_DNO = "dno"; //foreign

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_ROOMS);

    }

    public static final class LabsEntry implements BaseColumns {

        public static final String TABLE_NAME = "labs";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_LNAME = "lname";
        public static final String COLUMN_RNO = "rno";
        public static final String COLUMN_FLOOR = "floor";
        public static final String COLUMN_SUB = "sub";
        public static final String COLUMN_DNO = "dno"; //foreign

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_LABS);

    }

    public static final class NotesEntry implements  BaseColumns {

        public static final String TABLE_NAME = "notes";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_FID = "fid";
        public static final String COLUMN_SUB = "sub";
        public static final String COLUMN_DES = "des";
        public static final String COLUMN_SEM =  "sem";
        public static final String COLUMN_DNO = "dno";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_NOTES);

    }

    public static final class ResultEntry implements  BaseColumns {
        public static final String TABLE_NAME = "result";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_USN = "usn";
        public static final String COLUMN_DNO = "dno";
        public static final String COLUMN_SEM = "sem";
        public static final String COLUMN_ANN = "ann";
        public static final String COLUMN_EXAM = "exam";
        public static final String COLUMN_S1 = "one";
        public static final String COLUMN_S2 = "two";
        public static final String COLUMN_S3 = "three";
        public static final String COLUMN_S4 = "four";
        public static final String COLUMN_S5 = "five";
        public static final String COLUMN_S6 = "six";
        public static final String COLUMN_S7 = "seven";
        public static final String COLUMN_S8 = "eight";
        public static final String COLUMN_S9 = "nine";
        public static final String COLUMN_SGPA = "sgpa";
        public static final String COLUMN_DATE = "date";



        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_RESULT);
    }

    public static final class TTEntry implements  BaseColumns {

        public static final String TABLE_NAME = "timetable";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DAY = "day";
        public static final String COLUMN_ONE = "one";
        public static final String COLUMN_TWO = "two";
        public static final String COLUMN_THREE = "three";
        public static final String COLUMN_FOUR = "four";
        public static final String COLUMN_FIVE = "five";
        public static final String COLUMN_SIX = "six";
        public static final String COLUMN_SEVEN = "seven";
        public static final String COLUMN_SEM =  "sem";
        public static final String COLUMN_DNO = "dno";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_TIMETABLE);

    }





}
