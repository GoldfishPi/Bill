package org.timecrafters.engine.tests;

import android.text.format.DateFormat;
import android.util.Log;

import org.timecrafters.engine.caseBase;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Created by t420 on 9/29/2016.
 */

public class inheratencetTest extends caseBase {

    @Override
    public void init() {
        System.out.println("PROGRAM : WORKING");
        Log.i("PROGRAM", "WORKING");
    }

    @Override
    public void run(){
        Log.i(TAG,"Test Finished");
        setFinished(true);

    }

}

