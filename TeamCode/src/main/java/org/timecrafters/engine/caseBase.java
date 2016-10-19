package org.timecrafters.engine;

import static java.lang.reflect.Modifier.STATIC;

/**
 * Created by t420 on 9/29/2016.
 */


public abstract class caseBase extends robotPrefs implements Runnable  {
    public volatile boolean isFinished = false;
    public byte layer = 0;
    public static String TAG = "PROGRAM.STATE";

    public abstract void init();

    public void setFinished(boolean value){
        isFinished = value;
    }
}
