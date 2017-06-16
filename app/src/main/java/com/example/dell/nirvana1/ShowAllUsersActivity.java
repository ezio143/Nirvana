package com.example.dell.nirvana1;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.nirvana1.data.SContract;
import com.example.dell.nirvana1.data.SdbHelper;

/**
 * Created by DELL on 31-03-2017.
 */

public class ShowAllUsersActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

private ListView cursorlist;
    private SdbHelper sdbHelper;
StudCursorAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showalluser);
        setTitle(R.string.title_activity_usersenrolled);




        cursorlist = (ListView) findViewById(R.id.list);
        //set the empty view for the list
        View emptyView = findViewById(R.id.empty_view);
        cursorlist.setEmptyView(emptyView);

        Adapter = new StudCursorAdapter(this,null);
        cursorlist.setAdapter(Adapter);
        sdbHelper = new SdbHelper(this);

        //set the  pet click listener
        cursorlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

             Uri  currentpeturi = ContentUris.withAppendedId(SContract.StudentsEntry.CONTENT_URI,id);

                clickAction(currentpeturi);
            }
        });

//kick of the loader
        getSupportLoaderManager().initLoader(0,null,this);
    }

    private void clickAction(final Uri currentpeturi) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setNegativeButton(R.string.action_delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //delete user logic
                int rowsdeleted = getContentResolver().delete(currentpeturi,null,null);
                if(rowsdeleted == 0){
                    Toast.makeText(ShowAllUsersActivity.this,R.string.deletefail,Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(ShowAllUsersActivity.this,R.string.delete_success,Toast.LENGTH_SHORT).show();

                }
            }
        });

        builder.setPositiveButton(R.string.action_viewprofile, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent p = new Intent(ShowAllUsersActivity.this,Profile_Activity.class);
                p.setData(currentpeturi);
                startActivity(p);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {


        String[] Projection = {SContract.StudentsEntry._ID,
                SContract.StudentsEntry.COLUMN_NAME,
                SContract.StudentsEntry.COLUMN_USN,
                SContract.StudentsEntry.COLUMN_SECTION};


        return new CursorLoader(this, SContract.StudentsEntry.CONTENT_URI,
                Projection, null, null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
Adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
Adapter.swapCursor(null);

    }
}
