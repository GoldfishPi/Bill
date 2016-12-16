package org.timecrafters.team.gfp.leo.sensor.color;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 12/8/2016.
 */

public class gfp_LeoColorSensorRight extends gfp_LeoColorSensor {
    public gfp_LeoColorSensorRight(Engine engine,double sensetivity){
        this.engine = engine;
        this.sensitivity = sensetivity;
    }

    @Override
    public void init(){
        this.sensor = this.engine.colorSensorRight;
    }
}
