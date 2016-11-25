package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/10/2016.
 */

public class gfp_LeoColorSensor extends State {

   private ColorSensor sensor;

    public gfp_LeoColorSensor(Engine engine, int sensitivity){
        this.engine = engine;
        this.sensor = sensor;
    }

    @Override
    public void init(){
        //engine.colorSensorRight.enableLed(true);
        engine.colorSensorLeft.enableLed(false);
    }
    @Override
    public void exec(){
        engine.telemetry.addData(TAG+"color",engine.colorSensorLeft.blue());
        engine.telemetry.update();
        /*if(engine.colorSensorRight.red() > sensitivity || engine.colorSensorRight.blue() > sensitivity){
            setFinished(true);
        }*/
    }
}
