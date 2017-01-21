package org.timecrafters.team.gfp.jewls.states.drive.sensors;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/21/2017.
 */

public class gfp_jewlsDriveWall extends State {

    private byte[] frontRangeCache;

    public int[] directions = new int[4];
    public double[] speeds = new double[4];

    public int balanceHigh;
    public int balanceLow;

    public gfp_jewlsDriveWall(Engine engine, int balanceHigh, int balanceLow) {
        this.engine = engine;
        this.balanceHigh = balanceHigh;
        this.balanceLow = balanceLow;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void exec() {
        frontRangeCache = engine.dsFrontReader.read(engine.RANGE1_REG_START, engine.RANGE1_READ_LENGTH);

        engine.telemetry.addData("Ultra Sonic", frontRangeCache[0] & 0xFF);
        engine.telemetry.addData("ODS", frontRangeCache[1] & 0xFF);
        engine.telemetry.addData("BACK ODS", engine.dsBack.getLightDetected());
        engine.telemetry.update();

        if (frontRangeCache[0] > balanceHigh) {

            engine.dcFrontRight.setPower(0.5);
            engine.dcBackRight.setPower(0.5);

            engine.dcFrontLeft.setPower(0.0);
            engine.dcBackLeft.setPower(0.0);


        } else if(frontRangeCache[0] < balanceLow) {

            engine.dcFrontRight.setPower(0.0);
            engine.dcBackRight.setPower(0.0);

            engine.dcFrontLeft.setPower(0.5);
            engine.dcBackLeft.setPower(0.5);
        }else{

            engine.dcFrontRight.setPower(0.5);
            engine.dcBackRight.setPower(0.5);

            engine.dcFrontLeft.setPower(0.5);
            engine.dcBackLeft.setPower(0.5);

        }

    }
}
