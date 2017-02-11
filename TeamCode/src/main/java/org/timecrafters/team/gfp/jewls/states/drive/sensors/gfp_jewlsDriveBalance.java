package org.timecrafters.team.gfp.jewls.states.drive.sensors;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/20/2017.
 */

public class gfp_jewlsDriveBalance extends State {


    public volatile boolean isFinished = false;
    private byte sensorNum = 0;
    public double distance;
    byte[] frontRangeCache;
    byte[] backRangeCache;

    private double fluff;

    double speed;

    byte unused = -1;

    public gfp_jewlsDriveBalance(Engine engine,double speed,double fluff) {
        this.engine = engine;
        this.speed = speed;
        this.fluff = fluff;
    }

    @Override
    public void init() {

    }

    @Override
    public void exec() {

        frontRangeCache = engine.dsFrontReader.read(0x04, 2);
        backRangeCache = engine.dsBackReader.read(0x04,2);

        Log.i(TAG + "back", Double.toString(backRangeCache[0]));
        Log.i(TAG+"front", Double.toString(frontRangeCache[0]));
        engine.telemetry.update();

        if(frontRangeCache[0] + fluff > backRangeCache[0] && frontRangeCache[0] - fluff < backRangeCache[0]){


            //// STOPSHIP: 2/10/2017


            Log.i(TAG, "STATE SHOULD END");
            engine.dcFrontRight.setPower(0);
            engine.dcBackRight.setPower(0);

            engine.dcFrontLeft.setPower(0);
            engine.dcBackLeft.setPower(0);

            setFinished(true);


        }

        else if (backRangeCache[0] > frontRangeCache[0]){

            Log.i(TAG,"BACK > FRONT");

            engine.dcFrontRight.setPower(-speed);
            engine.dcBackRight.setPower(-speed);

            engine.dcFrontLeft.setPower(speed);
            engine.dcBackLeft.setPower(speed);

        }
        else if(frontRangeCache[0] > backRangeCache[0]){

            Log.i(TAG, "FRONT > BACK");

            engine.dcFrontRight.setPower(speed);
            engine.dcBackRight.setPower(speed);

            engine.dcFrontLeft.setPower(-speed);
            engine.dcBackLeft.setPower(-speed);

        }else{
            Log.i(TAG, "YOU'VE GOT BIGGER PROBLEMS DUDE");
        }

    }
}
