package com.example.dell.nirvana1;

import android.media.Image;
import android.widget.TextView;

import static android.R.attr.id;

/**
 * Created by DELL on 06-02-2017.
 */

public class Buzz {

    private String headtext;
    private String infotext;
    //private String quote;
    private static  final int NO_IMAGE_PROVIDED =-1;
    private int imageid = NO_IMAGE_PROVIDED;
    //private int photoid = NO_IMAGE_PROVIDED;


    public  Buzz(String headtext){
        this.headtext = headtext;

    }

    public  Buzz(String headtext,int imageid){
        this.headtext = headtext;
        this.imageid = imageid;
    }

/*    public  Buzz(String headtext,String infotext,String quote,int imageid){
        this.headtext = headtext;
        this.infotext = infotext;
        this.imageid = imageid;
        this.quote = quote;
    }


    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }



    public static int getNoImageProvided() {
        return NO_IMAGE_PROVIDED;
    }
*/

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getHeadtext() {
        return headtext;
    }

    public void setHeadtext(String headtext) {
        this.headtext = headtext;
    }

    public String getInfotext() {
        return infotext;
    }

    public void setInfotext(String infotext) {
        this.infotext = infotext;
    }

    /*public boolean hasImage(){
        return (imageid != NO_IMAGE_PROVIDED);
    }
    public boolean hasphoto(){
        return (photoid != NO_IMAGE_PROVIDED);
    }
*/
}
