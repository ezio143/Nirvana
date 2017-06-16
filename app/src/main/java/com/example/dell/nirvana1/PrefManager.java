package com.example.dell.nirvana1;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DELL on 16-04-2017.
 */

public class PrefManager {
    Context context;
    PrefManager(Context context){
        this.context = context;
    }

    public void saveLoginDetails(String username,String password,long id){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor  = sharedPreferences.edit();

        editor.putString("Username",username);
        editor.putString("Password",password);
        editor.putLong("Id",id);
        editor.commit();

    }

    public void clearLoginDetails(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);

        return sharedPreferences.getString("Username","");
    }
    public long getUserId(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        return sharedPreferences.getLong("Id",0);
    }

    public boolean isUserLoggedOut(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        boolean isUsernameEmpty = sharedPreferences.getString("Username","").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password","").isEmpty();
        return isUsernameEmpty || isPasswordEmpty ;

    }
}
