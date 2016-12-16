package org.timecrafters.team.gfp.leo.sensor.color;

import android.util.Log;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/10/2016.
 */

public class gfp_LeoColorSensor extends State {

    public double sensitivity;
    public ColorSensor sensor;

    @Override
    public void init(){
        Log.i(TAG,"sen: "+Double.toString(sensitivity));
    }
    @Override
    public void exec(){
        engine.telemetry.addData("kappa",sensor.blue());

        if(sensor.blue() > sensitivity){
            Log.i(TAG,"FINISHED");
            setFinished(true);
        }
    }

}
