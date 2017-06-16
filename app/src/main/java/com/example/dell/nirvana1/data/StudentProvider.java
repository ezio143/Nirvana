package com.example.dell.nirvana1.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.dell.nirvana1.Labs;
import com.example.dell.nirvana1.R;
import com.example.dell.nirvana1.data.SContract.StudentsEntry;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by DELL on 07-03-2017.
 */

public class StudentProvider extends ContentProvider {

    //setting the uri'
    private static final int STUDENT = 100;
    private static final int STUDENT_ID = 101;
    private static final int FACULTY = 200;
    private static final int FACULTY_ID = 201;

    private static final int ATTENDANCE = 300;
    private static final int ATTENDANCE_ID = 301;

    private static final int COURSE = 400;
    private static final int COURSE_ID = 401;

    private static final int ROOMS = 450;
    private static final int ROOMS_ID = 451;

    private static final int LABS = 460;
    private static final int LABS_ID = 461;

    private static final int NOTES = 470;
    private static final int NOTES_ID = 471;

    private static final int RESULT = 500;
    private static final int RESULT_ID = 501;



    private SQLiteDatabase db;
    private SdbHelper mdbHelper;
    //static urimatcher which is used to match the uri's  from the content resolver's
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    @Override
    public boolean onCreate() {
        mdbHelper = new SdbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionargs, String sortorder) {
        Cursor cursor = null;
        db = mdbHelper.getReadableDatabase();

        int match = sUriMatcher.match(uri);
        switch (match) {

            case STUDENT:
                cursor = db.query(StudentsEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case STUDENT_ID:
                selection = StudentsEntry._ID + "=?";
                selectionargs = new String[] { String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(StudentsEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case ATTENDANCE:
                cursor = db.query(SContract.AttendanceEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case ATTENDANCE_ID:
                selection = SContract.AttendanceEntry._ID + "=?";
                selectionargs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(SContract.AttendanceEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case FACULTY:
                cursor = db.query(SContract.FacultyEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case FACULTY_ID:
                break;
            case COURSE:
                cursor = db.query(SContract.CourseEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case COURSE_ID:
                break;
            case ROOMS:
                cursor = db.query(SContract.RoomsEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case ROOMS_ID:
                break;
            case LABS:
                cursor = db.query(SContract.LabsEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case LABS_ID:
                break;
            case NOTES:
                cursor = db.query(SContract.NotesEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case NOTES_ID:
                break;
            case RESULT:
                cursor = db.query(SContract.ResultEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            case RESULT_ID:
                break;
            default:
                throw new IllegalArgumentException("cannot query unknown URI" + uri);

        }


        return cursor;

    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int match = sUriMatcher.match(uri);
        switch (match) {
            case STUDENT:
                return insertStudent(uri, values,StudentsEntry.TABLE_NAME);
            case ATTENDANCE:
                return insertStudent(uri,values, SContract.AttendanceEntry.TABLE_NAME);
            default:
                throw new IllegalArgumentException("insertion cannot be performed for " + uri);
        }


    }

    private Uri insertStudent(Uri uri, ContentValues values, String tableName) {

        db = mdbHelper.getWritableDatabase();


            long newrowid = db.insert(tableName, null, values);
            if (newrowid == -1) {
                Toast.makeText(getContext(), "error in inserting values", Toast.LENGTH_SHORT).show();
            }
        else{
                Toast.makeText(getContext(), " add successful", Toast.LENGTH_SHORT).show();
            }

            //return the new uri with the id appeded at the end
            return ContentUris.withAppendedId(uri, newrowid);

        }

    @Override
    public int delete(Uri uri, String selection, String[] selectionargs) {
        db = mdbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        switch(match){
            case STUDENT:
                //notify all listeners that the data has changed for the pet content uri
                getContext().getContentResolver().notifyChange(uri,null);
                return db.delete(StudentsEntry.TABLE_NAME,selection,selectionargs);
            case STUDENT_ID:
                selection = StudentsEntry._ID + " =?";
                selectionargs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                //notify all listeners that the data has changed for the pet content uri
                getContext().getContentResolver().notifyChange(uri,null);
                return  db.delete(StudentsEntry.TABLE_NAME,selection,selectionargs);
            case ATTENDANCE:
                return db.delete(SContract.AttendanceEntry.TABLE_NAME,selection,selectionargs);
            default:
                throw new IllegalArgumentException("deletion failed"+uri);
        }
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionargs) {
        final int match = sUriMatcher.match(uri);
        switch(match){
            case STUDENT:
                return updateStudent(uri,contentValues,selection,selectionargs);
            case STUDENT_ID:
                //for the pet_id code, extract out the id from the uri
                selection = StudentsEntry._ID + "=?";
                selectionargs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateStudent(uri,contentValues,selection,selectionargs);
            default:
                throw new IllegalArgumentException("Update is not supported for "+uri);

        }
    }

    //returns num of rows updated
    private int updateStudent(Uri uri, ContentValues values, String selection, String[] selectionargs) {

        //now if no values to update then
        if(values.size() == 0){
            return 0;
        }
        db = mdbHelper.getWritableDatabase();
        return db.update(StudentsEntry.TABLE_NAME,values,selection,selectionargs);

    }

    static {
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY, "student", STUDENT);//matches entire  table
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY, "student/#", STUDENT_ID);//matches the particular id
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"attendance",ATTENDANCE);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"attendance/#",ATTENDANCE_ID);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"faculty",FACULTY);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"faculty/#",FACULTY_ID);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"course",COURSE);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"course/#",COURSE_ID);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"rooms/#",ROOMS_ID);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"rooms",ROOMS);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"labs", LABS);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"labs/#",LABS_ID);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"notes", NOTES);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"notes/#",NOTES_ID);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"result", RESULT);
        sUriMatcher.addURI(SContract.CONTENT_AUTHORITY,"result/#",RESULT_ID);

    }
}
