package com.example.dell.nirvana1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.nsd.NsdManager;

import com.example.dell.nirvana1.Attendance;
import com.example.dell.nirvana1.Labs;
import com.example.dell.nirvana1.Notes;
import com.example.dell.nirvana1.Result;
import com.example.dell.nirvana1.Rooms;

import static com.example.dell.nirvana1.R.id.email;
import static com.example.dell.nirvana1.R.id.img_rooms;
import static com.example.dell.nirvana1.data.SContract.CONTENT_AUTHORITY;
import static com.example.dell.nirvana1.data.SContract.StudentsEntry;
import static com.example.dell.nirvana1.data.SContract.AttendanceEntry;
import static com.example.dell.nirvana1.data.SContract.FacultyEntry;
import static com.example.dell.nirvana1.data.SContract.CourseEntry;
import static com.example.dell.nirvana1.data.SContract.RoomsEntry;
import static com.example.dell.nirvana1.data.SContract.LabsEntry;
import static com.example.dell.nirvana1.data.SContract.NotesEntry;
import static com.example.dell.nirvana1.data.SContract.ResultEntry;
import static com.example.dell.nirvana1.data.SContract.TTEntry;

/**
 * Created by DELL on 06-03-2017.
 */

public class SdbHelper extends SQLiteOpenHelper {

    // public static final String LOG_TAG = SdbHelper.class.getSimpleName();
    private static final String DB_NAME = "student.db";
    private static final int DB_VERSION = 1;
    String SQL_CREATE_STUDENT_TABLE ;
    private ContentValues values,values2,values3,coursevals,roomvals,labvals,notesvals,resultvals,ttvals;
    String SQL_CREATE_ATTENDANCE_TABLE;
    String SQL_CREATE_FACULTY_TABLE;
    String SQL_CREATE_COURSE_TABLE;
    String SQL_CREATE_ROOMS_TABLE;
    String SQL_CREATE_LABS_TABLE;
    String SQL_CREATE_NOTES_TABLE;
    String SQL_CREATE_RESULT_TABLE;
    String SQL_CREATE_TIME_TABLE;




    public SdbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

         SQL_CREATE_STUDENT_TABLE = "CREATE TABLE "+ StudentsEntry.TABLE_NAME + " ("
                +StudentsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +StudentsEntry.COLUMN_NAME + " TEXT ,"
                +StudentsEntry.COLUMN_USN+ " TEXT  unique not null ,"
                +StudentsEntry.COLUMN_DOB+ " NUMERIC,"
                +StudentsEntry.COLUMN_MNO+ " TEXT ,"
                +StudentsEntry.COLUMN_EMAIL+ " TEXT ,"
                +StudentsEntry.COLUMN_PASSWORD + " TEXT ,"
                +StudentsEntry.COLUMN_ANSWER+" TEXT ,"
                +StudentsEntry.COLUMN_BRANCH+" TEXT ,"
                +StudentsEntry.COLUMN_SECTION+" TEXT ,"
                +StudentsEntry.COLUMN_ADDRESS +" TEXT ,"
                +StudentsEntry.COLUMN_SEMESTER+" TEXT );";

         values = new ContentValues();
        values.put(StudentsEntry.COLUMN_USN,"root");
        values.put(StudentsEntry.COLUMN_NAME,"Ezio");
        values.put(StudentsEntry.COLUMN_DOB,"dec-13-1996");
        values.put(StudentsEntry.COLUMN_MNO,"9742961957");
        values.put(StudentsEntry.COLUMN_EMAIL,"ezio@suvarna");
        values.put(StudentsEntry.COLUMN_PASSWORD,"pass777");
        values.put(StudentsEntry.COLUMN_BRANCH,"CSE");
        values.put(StudentsEntry.COLUMN_SECTION,"A");
        values.put(StudentsEntry.COLUMN_ADDRESS,"Banglore");
        values.put(StudentsEntry.COLUMN_SEMESTER,"6th");
        values.put(StudentsEntry.COLUMN_ANSWER,"Dharwad");

        SQL_CREATE_FACULTY_TABLE = "CREATE TABLE "+ FacultyEntry.TABLE_NAME + " ("
                +FacultyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +FacultyEntry.COLUMN_NAME + " TEXT ,"
                +FacultyEntry.COLUMN_FID+ " TEXT  unique not null ,"
                +FacultyEntry.COLUMN_DOB+ " NUMERIC,"
                +FacultyEntry.COLUMN_MNO+ " TEXT ,"
                +FacultyEntry.COLUMN_EMAIL+ " TEXT ,"
                +FacultyEntry.COLUMN_PASSWORD + " TEXT ,"
                +FacultyEntry.COLUMN_ANSWER+" TEXT ,"
                +FacultyEntry.COLUMN_DNUM+" TEXT ,"
                +FacultyEntry.COLUMN_ADDRESS +" TEXT );";

        values2 = new ContentValues();
        values2.put(FacultyEntry.COLUMN_FID,"root");
        values2.put(FacultyEntry.COLUMN_NAME,"Ezio");
        values2.put(FacultyEntry.COLUMN_DOB,"dec-13-1996");
        values2.put(FacultyEntry.COLUMN_MNO,"9742961957");
        values2.put(FacultyEntry.COLUMN_EMAIL,"ezio@suvarna");
        values2.put(FacultyEntry.COLUMN_PASSWORD,"pass777");
        values2.put(FacultyEntry.COLUMN_DNUM,"CSE");
        values2.put(FacultyEntry.COLUMN_ADDRESS,"Banglore");
        values2.put(FacultyEntry.COLUMN_ANSWER,"Dharwad");


        SQL_CREATE_ATTENDANCE_TABLE = "CREATE TABLE "+ AttendanceEntry.TABLE_NAME + " ("
                +AttendanceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +AttendanceEntry.COLUMN_USN + "  TEXT UNIQUE ,"
                +AttendanceEntry.COLUMN_DNO + " TEXT ,"
                +AttendanceEntry.COLUMN_SEM + " INTEGER ,"
                +AttendanceEntry.COLUMN_1 + " INTEGER ,"
                +AttendanceEntry.COLUMN_11 + " INTEGER ,"
                +AttendanceEntry.COLUMN_2 + " INTEGER ,"
                +AttendanceEntry.COLUMN_22 + " INTEGER ,"
                +AttendanceEntry.COLUMN_3 + " INTEGER ,"
                +AttendanceEntry.COLUMN_33 + " INTEGER ,"
                +AttendanceEntry.COLUMN_4 + " INTEGER ,"
                +AttendanceEntry.COLUMN_44 + " INTEGER ,"
                +AttendanceEntry.COLUMN_5 + " INTEGER ,"
                +AttendanceEntry.COLUMN_55 + " INTEGER ,"
                +AttendanceEntry.COLUMN_6 + " INTEGER ,"
                +AttendanceEntry.COLUMN_66 + " INTEGER ,"
                +AttendanceEntry.COLUMN_7 + " INTEGER ,"
                +AttendanceEntry.COLUMN_77 + " INTEGER ,"
                +AttendanceEntry.COLUMN_8 + " INTEGER ,"
                +AttendanceEntry.COLUMN_88 + " INTEGER ,"
                +AttendanceEntry.COLUMN_9 + " INTEGER ,"
                +AttendanceEntry.COLUMN_99 + " INTEGER );";


        values3 = new ContentValues();
        values3.put(AttendanceEntry.COLUMN_USN,"1da14cs056");
        values3.put(AttendanceEntry.COLUMN_DNO,"d1");
        values3.put(AttendanceEntry.COLUMN_SEM,6);
        values3.put(AttendanceEntry.COLUMN_1,12);
        values3.put(AttendanceEntry.COLUMN_11,12);
        values3.put(AttendanceEntry.COLUMN_2,12);
        values3.put(AttendanceEntry.COLUMN_22,10);
        values3.put(AttendanceEntry.COLUMN_3,12);
        values3.put(AttendanceEntry.COLUMN_33,11);
        values3.put(AttendanceEntry.COLUMN_4,12);
        values3.put(AttendanceEntry.COLUMN_44,12);
        values3.put(AttendanceEntry.COLUMN_5,12);
        values3.put(AttendanceEntry.COLUMN_55,4);
        values3.put(AttendanceEntry.COLUMN_6,12);
        values3.put(AttendanceEntry.COLUMN_66,8);
        values3.put(AttendanceEntry.COLUMN_7,12);
        values3.put(AttendanceEntry.COLUMN_77,8);
        values3.put(AttendanceEntry.COLUMN_8,12);
        values3.put(AttendanceEntry.COLUMN_88,8);
        values3.put(AttendanceEntry.COLUMN_9,12);
        values3.put(AttendanceEntry.COLUMN_99,8);


        SQL_CREATE_COURSE_TABLE = "CREATE TABLE "+ CourseEntry.TABLE_NAME + " ("
                +CourseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CourseEntry.COLUMN_SNAME + " TEXT ,"
                +CourseEntry.COLUMN_SCODE+ " TEXT  unique not null ,"
                +CourseEntry.COLUMN_CREDITS+ " NUMERIC,"
                +CourseEntry.COLUMN_SEM+ " NUMERIC ,"
                +CourseEntry.COLUMN_DNO+ " TEXT );";


            coursevals = new ContentValues();
            coursevals.put(CourseEntry.COLUMN_SNAME,"Compiler Design");
            coursevals.put(CourseEntry.COLUMN_SCODE,"CS63");
            coursevals.put(CourseEntry.COLUMN_CREDITS,4);
            coursevals.put(CourseEntry.COLUMN_DNO,"d1");
            coursevals.put(CourseEntry.COLUMN_SEM,6);

        SQL_CREATE_ROOMS_TABLE = "CREATE TABLE "+ RoomsEntry.TABLE_NAME + " ("
                +RoomsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +RoomsEntry.COLUMN_RNO + " TEXT unique not null,"
                +RoomsEntry.COLUMN_FLOOR+ " TEXT   ,"
                +RoomsEntry.COLUMN_DNO+ " TEXT,"
                +RoomsEntry.COLUMN_BENCHES+ " NUMERIC ,"
                +RoomsEntry.COLUMN_CAPACITY+ " NUMERIC );";

        SQL_CREATE_LABS_TABLE = "CREATE TABLE "+ LabsEntry.TABLE_NAME + " ("
                +LabsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +LabsEntry.COLUMN_RNO + " TEXT unique not null,"
                +LabsEntry.COLUMN_FLOOR+ " TEXT   ,"
                +LabsEntry.COLUMN_DNO+ " TEXT,"
                +LabsEntry.COLUMN_LNAME+ " TEXT ,"
                +LabsEntry.COLUMN_SUB+ " TEXT );";

        roomvals = new ContentValues();
        roomvals.put(RoomsEntry.COLUMN_RNO,"C01");
        roomvals.put(RoomsEntry.COLUMN_DNO,"d1");
        roomvals.put(RoomsEntry.COLUMN_FLOOR,"Ground");
        roomvals.put(RoomsEntry.COLUMN_BENCHES,20);
        roomvals.put(RoomsEntry.COLUMN_CAPACITY,62);

        labvals = new ContentValues();
        labvals.put(LabsEntry.COLUMN_LNAME,"MH JPN");
        labvals.put(LabsEntry.COLUMN_RNO,"L01");
        labvals.put(LabsEntry.COLUMN_DNO,"d1");
        labvals.put(LabsEntry.COLUMN_FLOOR,"Ground");
        labvals.put(LabsEntry.COLUMN_SUB,"WT");


        SQL_CREATE_NOTES_TABLE = "CREATE TABLE "+ NotesEntry.TABLE_NAME + " ("
                +NotesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NotesEntry.COLUMN_FID + " TEXT  not null,"
                +NotesEntry.COLUMN_DES+ " TEXT   ,"
                +NotesEntry.COLUMN_DNO+ " TEXT,"
                +NotesEntry.COLUMN_SEM+ " NUMERIC ,"
                +NotesEntry.COLUMN_SUB+ " TEXT );";

        SQL_CREATE_RESULT_TABLE = "CREATE TABLE "+ ResultEntry.TABLE_NAME + " ("
                +ResultEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +ResultEntry.COLUMN_USN + " TEXT unique not null,"
                +ResultEntry.COLUMN_ANN+ " NUMERIC   ,"
                +ResultEntry.COLUMN_DNO+ " TEXT,"
                +ResultEntry.COLUMN_SEM+ " NUMERIC ,"
                +ResultEntry.COLUMN_SGPA+" NUMERIC ,"
                + ResultEntry.COLUMN_S1+" TEXT  ,"
                + ResultEntry.COLUMN_S2+" TEXT  ,"
                + ResultEntry.COLUMN_S3+" TEXT  ,"
                + ResultEntry.COLUMN_S4+" TEXT  ,"
                + ResultEntry.COLUMN_S5+" TEXT  ,"
                + ResultEntry.COLUMN_S6+" TEXT  ,"
                + ResultEntry.COLUMN_S7+" TEXT  ,"
                + ResultEntry.COLUMN_S8+" TEXT  ,"
                + ResultEntry.COLUMN_S9+" TEXT  ,"
                + ResultEntry.COLUMN_DATE+" TEXT  ,"
                +ResultEntry.COLUMN_EXAM+ " TEXT );";

        notesvals = new ContentValues();
        notesvals.put(NotesEntry.COLUMN_FID,"cs01");
        notesvals.put(NotesEntry.COLUMN_DES,"troops near Delnice. When fifth column supporters of the Croatian nationalist Ustaše movement arrested the headquarters staff of the 7th Army later that day, the formation effectively ceased to exist. On 12 April, the Germans linked up with the Italians near the Adriatic coast, encircling the remnants of the 7th Army, which offered no further resistance. Ceasefires were implemented on 15");
        notesvals.put(NotesEntry.COLUMN_DNO,"d1");
        notesvals.put(NotesEntry.COLUMN_SEM,"6");
        notesvals.put(NotesEntry.COLUMN_SUB,"M&E");

        resultvals = new ContentValues();
        resultvals.put(ResultEntry.COLUMN_USN,"1da14cs056");
        resultvals.put(ResultEntry.COLUMN_ANN,1);
        resultvals.put(ResultEntry.COLUMN_DNO,"d1");
        resultvals.put(ResultEntry.COLUMN_SEM,6);
        resultvals.put(ResultEntry.COLUMN_SGPA,9);
        resultvals.put(ResultEntry.COLUMN_DATE,"15-6-2016");
        resultvals.put(ResultEntry.COLUMN_EXAM,"Session End Exams");
        resultvals.put(ResultEntry.COLUMN_S1,"A");
        resultvals.put(ResultEntry.COLUMN_S2,"A");
        resultvals.put(ResultEntry.COLUMN_S3,"A");
        resultvals.put(ResultEntry.COLUMN_S4,"A");
        resultvals.put(ResultEntry.COLUMN_S5,"A");
        resultvals.put(ResultEntry.COLUMN_S6,"A");
        resultvals.put(ResultEntry.COLUMN_S7,"A");
        resultvals.put(ResultEntry.COLUMN_S8,"A");
        resultvals.put(ResultEntry.COLUMN_S9,"A");


        //attendance table
        SQL_CREATE_TIME_TABLE = "CREATE TABLE "+ TTEntry.TABLE_NAME + " ("
                +TTEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TTEntry.COLUMN_DAY + "  TEXT ,"
                +TTEntry.COLUMN_DNO + " TEXT ,"
                +TTEntry.COLUMN_SEM + " NUMERIC ,"
                +TTEntry.COLUMN_ONE + " TEXT ,"
                +TTEntry.COLUMN_TWO + " TEXT ,"
                +TTEntry.COLUMN_THREE + " TEXT ,"
                +TTEntry.COLUMN_FOUR + " TEXT ,"
                +TTEntry.COLUMN_FIVE + " TEXT ,"
                +TTEntry.COLUMN_SIX + " TEXT ,"
                +TTEntry.COLUMN_SEVEN + " TEXT );";


        ttvals = new ContentValues();
        ttvals.put(TTEntry.COLUMN_DAY,"monday");
        ttvals.put(TTEntry.COLUMN_DNO,"d1");
        ttvals.put(TTEntry.COLUMN_SEM,"sixth");
        ttvals.put(TTEntry.COLUMN_ONE,"WT");
        ttvals.put(TTEntry.COLUMN_ONE,"MAN");
        ttvals.put(TTEntry.COLUMN_ONE,"PT");
        ttvals.put(TTEntry.COLUMN_ONE,"PT");
        ttvals.put(TTEntry.COLUMN_ONE,"CD");
        ttvals.put(TTEntry.COLUMN_ONE,"ME");
        ttvals.put(TTEntry.COLUMN_ONE,"ME");


    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //string that is used to create the pets table
        db.execSQL(SQL_CREATE_STUDENT_TABLE);
        db.execSQL(SQL_CREATE_FACULTY_TABLE);
        db.execSQL(SQL_CREATE_ATTENDANCE_TABLE);
        db.execSQL(SQL_CREATE_COURSE_TABLE);
        db.execSQL(SQL_CREATE_ROOMS_TABLE);
        db.execSQL(SQL_CREATE_LABS_TABLE);
        db.execSQL(SQL_CREATE_NOTES_TABLE);
        db.execSQL(SQL_CREATE_RESULT_TABLE);
        db.execSQL(SQL_CREATE_TIME_TABLE);
        db.insert(StudentsEntry.TABLE_NAME,null,values);
        db.insert(FacultyEntry.TABLE_NAME,null,values2);
        db.insert(AttendanceEntry.TABLE_NAME,null,values3);
        db.insert(CourseEntry.TABLE_NAME,null,coursevals);
        db.insert(RoomsEntry.TABLE_NAME,null,roomvals);
        db.insert(LabsEntry.TABLE_NAME,null,labvals);
        db.insert(NotesEntry.TABLE_NAME,null,notesvals);
        db.insert(ResultEntry.TABLE_NAME,null,resultvals);
        db.insert(TTEntry.TABLE_NAME,null,ttvals);

    }

    //this method is called when database is updated


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //the database is still at version 1,t
        db.execSQL("DROP TABLE IF EXISTS "+StudentsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+FacultyEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+AttendanceEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+CourseEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+RoomsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+LabsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+NotesEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ResultEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TTEntry.TABLE_NAME);
        onCreate(db);


    }
}
