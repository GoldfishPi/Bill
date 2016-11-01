package org.timecrafters.engine.tests;

import android.util.Log;

import org.timecrafters.engine.State;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by t420 on 9/29/2016.
 */

public class InheratencetTest extends State {

    public boolean csdata;
    public int num;

    public InheratencetTest(OpMode opmode){
        this.opMode = opmode;
    }

    @Override
    public void init() {

        colorSensor = opMode.hardwareMap.colorSensor.get("colorSensor");
        System.out.println("PROGRAM : WORKING");
        Log.i("PROGRAM", "WORKING");

        opMode.telemetry.addData(TAG+".colorSensor", colorSensor.blue());
    }

    @Override
    public void exec(){

        opMode.telemetry.update();
        if(colorSensor.blue() > 3){
            setFinished(true);
        }

    }

}

