package org.timecrafters.engine.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 10/31/2016.
 */

public class TouchSensorTest extends State {


    public TouchSensorTest(Engine engine){

        this.engine = engine;
    }

    @Override
    public void init(){
        //engine.touchSensor = engine.hardwareMap.touchSensor.get("touchSensor");
        engine.telemetry.addData(TAG+".touchSensor", engine.touchSensor.isPressed());
    }

    @Override
    public void exec(){

        engine.telemetry.update();
        if(engine.touchSensor.isPressed()){
            setFinished(true);
        }
    }
}
