package org.timecrafters.team.gfp.jewls.states.sensors.distance.optical.distance.ultraSonic;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/15/2017.
 */



public class jewls_gfpUltraSonicDistanceSensor extends State {

    public volatile boolean isFinished = false;
    private byte sensorNum = 0;
    public double distance;
    byte[] frontRangeCache;
    byte[] rightRangeCache;

    byte unused = -1;

    public jewls_gfpUltraSonicDistanceSensor(Engine engine, double distance) {
        this.engine = engine;
    }

    @Override
    public void exec() {

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
