package org.timecrafters.engine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by t420 on 9/29/2016.
 */


public abstract class State implements Runnable  {

    public DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms");
    public Date date = new Date();
    public volatile boolean isFinished = false;
    public byte layer = 0;
    public static String TAG = "PROGRAM.STATE";
    public Engine engine;



    public void init(){}

    public abstract void exec();

    @Override
    public void run(){
        while(!isFinished){
            exec();
        }
    }

    public void stop(){
        /*
        * Override this and put your ending crap in here
        * */
    }

    public void setFinished(boolean value){
        isFinished = value;
    }
}