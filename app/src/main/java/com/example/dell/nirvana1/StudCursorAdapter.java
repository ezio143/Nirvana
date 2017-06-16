package com.example.dell.nirvana1;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.nirvana1.data.SContract;

import org.w3c.dom.Text;

/**
 * Created by DELL on 31-03-2017.
 */

public class StudCursorAdapter extends CursorAdapter {
    public StudCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cursor_listview,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nametext  = (TextView) view.findViewById(R.id.text_name);
        String name = cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_NAME));

        if(!TextUtils.isEmpty(name))
            nametext.setText(name);
        else
            nametext.setText("UNKNOWN");


        TextView usntext = (TextView) view.findViewById(R.id.text_usn);
        String usn = cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_USN));
        usntext.setText(usn);

        TextView sectext = (TextView) view.findViewById(R.id.text_section);
        String section = cursor.getString(cursor.getColumnIndexOrThrow(SContract.StudentsEntry.COLUMN_SECTION));

        if(!TextUtils.isEmpty(section))
            sectext.setText(section);
        else
            sectext.setText("U");

    }
}
