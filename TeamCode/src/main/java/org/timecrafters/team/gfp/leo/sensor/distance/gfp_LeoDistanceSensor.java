package org.timecrafters.team.gfp.leo.sensor.distance;

import android.util.Log;

import com.qualcomm.robotcore.hardware.I2cAddr;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoDistanceSensor extends State {

    public volatile boolean isFinished = false;
    private byte sensorNum;
    public double distance;
    byte[] frontRangeCache;
    byte[] rightRangeCache;

    byte unused = -1;

    public gfp_LeoDistanceSensor(Engine engine, double distance,byte sensornum){
        this.engine = engine;
        this.distance = distance;
        this.sensorNum = sensornum;
    }

    @Override
    public void init(){

    }

    public void exec(){
        if(sensorNum == 0) {
            frontRangeCache = engine.dsFrontReader.read(0x04, 2);
            //rightRangeCache = engine.dsRightReader.read(0x04,2);

            Log.i(TAG + ":FRONT", Byte.toString(frontRangeCache[0]));
            //Log.i(TAG+":RIGHT",Byte.toString(rightRangeCache[1]));

            if (frontRangeCache[0] > unused && frontRangeCache[0] <= distance) {
                setFinished(true);
            }
        }
        else if(sensorNum ==1){
            rightRangeCache = engine.dsRightReader.read(0x04,2);

            Log.i(TAG+":RIGHT",Byte.toString(rightRangeCache[0]));

            if(rightRangeCache[0] > unused && rightRangeCache[0] <=distance){
                setFinished(true);
            }
        }
    }
}
