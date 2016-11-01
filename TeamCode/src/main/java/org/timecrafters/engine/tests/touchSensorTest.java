package org.timecrafters.engine.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 10/31/2016.
 */

public class TouchSensorTest extends State {


    public TouchSensorTest(OpMode opmode){

        this.opMode = opmode;
    }

    @Override
    public void init(){
        touchSensor = opMode.hardwareMap.touchSensor.get("touchSensor");
        opMode.telemetry.addData(TAG+".touchSensor", touchSensor.isPressed());
    }

    @Override
    public void exec(){

        opMode.telemetry.update();
        if(touchSensor.isPressed()){
            setFinished(true);
        }
    }
}
