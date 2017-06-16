package com.example.dell.nirvana1;


import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.dell.nirvana1.customObject.NfAdapter;
import com.example.dell.nirvana1.customObject.NfLoader;
import com.example.dell.nirvana1.customObject.Notification;

import java.util.ArrayList;
import java.util.List;

import static com.example.dell.nirvana1.NotificationsActivity.LOG_TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Activitys_Activity extends Fragment implements  LoaderManager.LoaderCallbacks<List<Notification>> {


    private static final String NF_REQUEST_URL = "http://192.168.43.215/json/new.php";
    private static final int NOTIFICATION_LOADER_ID = 3;

    public Activitys_Activity() {
        // Required empty public constructor
    }



    private ListView nf_listView;
    NfAdapter adapter;
    View emptyView;
    ProgressBar progress ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_activitys_activity, container, false);

        emptyView = rootView.findViewById(R.id.aempty_view);
        nf_listView = (ListView) rootView.findViewById(R.id.alist_notification);
        progress = (ProgressBar) rootView.findViewById(R.id.aprogress);

        nf_listView.setEmptyView(emptyView);
        //ArrayList<Notification> curnf = new ArrayList<>();
        //curnf.add(new Notification("jitu","cse","hello nirvana app, this is the first notification"));

        adapter = new NfAdapter(getActivity(),new ArrayList<Notification>());

        nf_listView.setAdapter(adapter);

        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = connMgr.getActiveNetworkInfo();

        //if(networkinfo != null && networkinfo.isConnected()) {

        LoaderManager loaderManager = getActivity().getLoaderManager();
        Log.i(LOG_TAG, "TEST: calling initLoader()...");
        loaderManager.initLoader(NOTIFICATION_LOADER_ID, null, this);
        //}
       /* else{
            progress.setVisibility(View.GONE);
            TextView nonet = (TextView) rootView.findViewById(R.id.nfempty_title_text);
            rootView.findViewById(R.id.nfempty_subtitle_text).setVisibility(View.GONE);
            nonet.setText(R.string.noInternetConnection);

        }
*/
        return rootView;
    }

    @Override
    public Loader<List<Notification>> onCreateLoader(int i, Bundle bundle) {
        return new NfLoader(getContext(),NF_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Notification>> loader, List<Notification> notifications) {
        progress.setVisibility(View.GONE);
        adapter.clear();


        if(notifications != null && !notifications.isEmpty()) {
            adapter.addAll(notifications);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Notification>> loader) {
        adapter.clear();
    }
}