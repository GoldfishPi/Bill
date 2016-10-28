package org.timecrafters.engine.tests;

import android.graphics.Path;
import android.text.format.DateFormat;
import android.util.Log;

import org.timecrafters.engine.caseBase;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Created by t420 on 9/29/2016.
 */

public class inheratencetTest extends caseBase {

    public boolean csdata;
    public int num;

    public inheratencetTest(OpMode opmode){
        this.opMode = opmode;
    }

    @Override
    public void init() {

        colorSensor = opMode.hardwareMap.colorSensor.get("colorSensor");
        System.out.println("PROGRAM : WORKING");
        Log.i("PROGRAM", "WORKING");
    }

    @Override
    public void exec(){
        //opMode.telemetry.addData(TAG, "this is working");
        opMode.telemetry.addData(TAG,colorSensor.argb());
        num++;
        opMode.telemetry.update();
        Log.i(TAG,Integer.toString(num));

    }

}

