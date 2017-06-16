package com.example.dell.nirvana1.customObject;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 30-04-2017.
 */

public class NfLoader extends AsyncTaskLoader<List<Notification>> {

    private static String mUrl ;

    public NfLoader(Context context,String url) {
        super(context);
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Notification> loadInBackground() {
        if(mUrl == null)
            return null;

        ArrayList<Notification> nfs = QueryUtils.ExtractNfData(mUrl);

        return nfs;
    }
}
