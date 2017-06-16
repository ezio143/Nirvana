package com.example.dell.nirvana1.customObject;

import android.widget.TextView;

/**
 * Created by DELL on 29-04-2017.
 */

public class Notification {

    private String name,branch,content;


    public Notification(){}

    public Notification(String name,String branch,String content){
        this.name = name;
        this.branch = branch;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
