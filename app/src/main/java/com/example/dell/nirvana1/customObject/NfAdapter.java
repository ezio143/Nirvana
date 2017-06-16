package com.example.dell.nirvana1.customObject;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dell.nirvana1.R;

import java.util.List;

import static android.R.attr.resource;

/**
 * Created by DELL on 29-04-2017.
 */

public class NfAdapter extends ArrayAdapter<Notification> {


    private TextView nf_name,nf_branch,nf_content;

    public NfAdapter(@NonNull Context context, List<Notification> notifications) {
        super(context, 0,notifications);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null)
            listItemView =  LayoutInflater.from(getContext()).inflate(R.layout.single_notification,parent,false);

        Notification curnf = getItem(position);


        nf_name = (TextView)listItemView.findViewById(R.id.nf_name);
        nf_name.setText(curnf.getName());

        nf_branch = (TextView) listItemView.findViewById(R.id.nf_branch);
        nf_branch.setText(curnf.getBranch());

        nf_content = (TextView) listItemView.findViewById(R.id.nf_content_text);
        nf_content.setText(curnf.getContent());



        return listItemView;
    }
}
