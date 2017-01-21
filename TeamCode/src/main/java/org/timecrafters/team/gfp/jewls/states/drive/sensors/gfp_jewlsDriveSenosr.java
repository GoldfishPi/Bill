package org.timecrafters.team.gfp.jewls.states.drive.sensors;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/20/2017.
 */

public class gfp_jewlsDriveSenosr extends State {

    public int[] directions = new int[4];
    public boolean halt = false;
    private double haltTime;

    public double[] speeds = new double[4];
    private byte[] frontRangeCache;

    public gfp_jewlsDriveSenosr(Engine engine) {
        this.engine = engine;

    }

    @Override
    public void exec() {

        //if(engine.dsFront.getRawLightDetected());
        Log.i(TAG, Double.toString(engine.dsBack.getLightDetected()));

        if(engine.dsBack.getLightDetected() <= 0.03){

            engine.dcBackLeft.setPower(directions[0] * speeds[0]);
            engine.dcFrontLeft.setPower(directions[1] * speeds[1]);
            engine.dcFrontRight.setPower(directions[2] * speeds[2]);
            engine.dcBackRight.setPower(directions[3] * speeds[3]);

        }else{
            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);

            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);
            setFinished(true);
        }

        /*frontRangeCache = engine.dsFrontReader.read(engine.RANGE1_REG_START, engine.RANGE1_READ_LENGTH);

        engine.telemetry.addData("Ultra Sonic", frontRangeCache[0] & 0xFF);
        engine.telemetry.addData("ODS", frontRangeCache[1] & 0xFF);
        engine.telemetry.update();*/
        /*frontRangeCache = engine.dsFrontReader.read(0x04, 2);
        Log.i(TAG + ":FRONT", Double.toString((engine.dsFront.rawUltrasonic())));*/

    }
}