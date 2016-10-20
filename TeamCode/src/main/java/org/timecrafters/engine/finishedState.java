package org.timecrafters.engine;

import android.util.Log;

/**
 * Created by t420 on 10/18/2016.
 */

public class finishedState extends caseBase {

    boolean isFinished = false;
    @Override
    public void init(){

    }

    @Override
    public void run(){
        if(!isFinished){
            isFinished = true;
            Log.i(TAG,"test FINISHED");
        }
    }
}
