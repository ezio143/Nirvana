package com.example.dell.nirvana1.syncdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.nirvana1.Attendance;
import com.example.dell.nirvana1.data.SContract;
import com.example.dell.nirvana1.data.SContract.AttendanceEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import static com.example.dell.nirvana1.NotificationsActivity.LOG_TAG;

/**
 * Created by DELL on 05-05-2017.
 */

public final class SyncDatabase {

private static  String usn,dno;
    private static int sem,c1,c11,c2,c22,c3,c33,c4,c44,c5,c55,c6,c66,c7,c77,c8,c88,c9,c99;




    private SyncDatabase() {
    }

    public static ContentValues syncattendance(String requestUrl,Context context){

if(requestUrl == "")
    return null;

        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        ContentValues result = extractData(jsonResponse,context);

        return result;
    }

    private static ContentValues extractData(String jsonResponse,Context context) {
        ContentValues result  = null;

        if (TextUtils.isEmpty(jsonResponse)) {
            return result;
        }

        try{
            JSONObject rootObject = new JSONObject(jsonResponse);
            JSONArray notifications = rootObject.getJSONArray("notifications");
                JSONObject cur = notifications.getJSONObject(0);
                usn = cur.getString("usn");
                dno = cur.getString("dno");
                sem = cur.getInt("sem");
                c1 = cur.getInt("11");
                c11 = cur.getInt("1");
                c2 = cur.getInt("22");
                c22 = cur.getInt("2");
                c3 = cur.getInt("33");
                c33 = cur.getInt("3");
                c4 = cur.getInt("44");
                c44 = cur.getInt("4");
                c5 = cur.getInt("55");
                c55 = cur.getInt("5");
                c6 = cur.getInt("66");
                c66 = cur.getInt("6");
                c7 = cur.getInt("77");
                c77 = cur.getInt("7");
                c8 = cur.getInt("88");
                c88 = cur.getInt("8");
                c9 = cur.getInt("99");
                c99 = cur.getInt("9");

            if(!TextUtils.isEmpty(dno)) {
               /* int numRows =   context.getContentResolver().delete(AttendanceEntry.CONTENT_URI,null,null);
                if(numRows == 0){
                  Toast.makeText(context,"error deleting the old value",Toast.LENGTH_SHORT).show();
                    return false;
                } */
                ContentValues values = new ContentValues();
                values.put(AttendanceEntry.COLUMN_USN,usn);
                values.put(AttendanceEntry.COLUMN_DNO,dno);
                values.put(AttendanceEntry.COLUMN_SEM,sem);
                values.put(AttendanceEntry.COLUMN_1,c1);
                values.put(AttendanceEntry.COLUMN_11,c11);
                values.put(AttendanceEntry.COLUMN_2,c2);
                values.put(AttendanceEntry.COLUMN_22,c22);
                values.put(AttendanceEntry.COLUMN_3,c3);
                values.put(AttendanceEntry.COLUMN_33,c33);
                values.put(AttendanceEntry.COLUMN_4,c4);
                values.put(AttendanceEntry.COLUMN_44,c44);
                values.put(AttendanceEntry.COLUMN_5,c5);
                values.put(AttendanceEntry.COLUMN_55,c55);
                values.put(AttendanceEntry.COLUMN_6,c6);
                values.put(AttendanceEntry.COLUMN_66,c66);
                values.put(AttendanceEntry.COLUMN_7,c7);
                values.put(AttendanceEntry.COLUMN_77,c77);
                values.put(AttendanceEntry.COLUMN_8,c8);
                values.put(AttendanceEntry.COLUMN_88,c88);
                values.put(AttendanceEntry.COLUMN_9,c9);
                values.put(AttendanceEntry.COLUMN_99,c99);
                //Uri rows = context.getContentResolver().insert(AttendanceEntry.CONTENT_URI,values);
            result = values;
            }

        }
        catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);

        }

        return result;
    }


    private static URL createUrl(String stringUrl) {

        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }



    private static String makeHttpRequest(URL url) throws  IOException{
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(20000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the notification JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }


    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
}
