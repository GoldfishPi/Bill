package org.timecrafters.engine;

import android.util.Log;

/**
 * Created by t420 on 10/18/2016.
 */

public class finishedState extends caseBase {

    boolean isFinished = false;
    @Override
    public void init(){
        colorSensor = opMode.hardwareMap.colorSensor.get("colorSensor");
    }

    @Override
    public void exec(){
        if(!isFinished){
            isFinished = true;
            Log.i(TAG,"test FINISHED");

        }
    }
}
