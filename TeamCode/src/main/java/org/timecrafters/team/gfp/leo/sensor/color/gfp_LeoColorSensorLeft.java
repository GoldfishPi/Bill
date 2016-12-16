package org.timecrafters.team.gfp.leo.sensor.color;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 12/8/2016.
 */

public class gfp_LeoColorSensorLeft extends gfp_LeoColorSensor {
    public gfp_LeoColorSensorLeft(Engine engine, double sensitivity){
        this.sensitivity = sensitivity;
        this.engine = engine;
    }

    @Override
    public void init(){
        this.sensor = this.engine.colorSensorLeft;
    }

}
