package org.timecrafters.engine;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.tests.inheratencetTest;

import java.lang.reflect.Array;

/**
 * Created by t420 on 9/29/2016.
 * First sucess ful test was 5:00 6 thur oct 2016
 */

public abstract class engine extends OpMode {

    public caseBase[] processes = new caseBase[100];

    public static String TAG = "PROGRAM.ENGINE: ";
    private int x = 0;
    private int y = 0;
    private Thread t;
    private caseBase currentProcess = null;

    public void init(){
        setProcesses();
    }
    public void loop(){

        if(currentProcess == processes[x]){
            //check to see if process is done

        }else{
            //set next state.
            t = new Thread(processes[x]);
            t.start();
            currentProcess = processes[x];
            Log.i(TAG,"Started State");
        }

    }

    public abstract void setProcesses();
}
