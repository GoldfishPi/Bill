package org.timecrafters.team.gfp.jewls.states.drive.sensors;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/21/2017.
 */

public class gfp_jewlsDriveToDistance extends State {

    private byte[] frontRangeCache;

    public int[] directions = new int[4];
    public double[] speeds = new double[4];

    private int distance;

    public gfp_jewlsDriveToDistance(Engine engine, int distance) {
        this.engine = engine;
        this.distance = distance;
    }

    @Override
    public void init() {

        directions[0] = 1;
        speeds[0] = 0.3;
        directions[1] = 1;
        speeds[1] = 0.3;
        directions[2] = 1;
        speeds[2] = 0.3;
        directions[3] = 1;
        speeds[3] = 0.2;

    }

    @Override
    public void exec() {

        frontRangeCache = engine.dsFrontReader.read(engine.RANGE1_REG_START, engine.RANGE1_READ_LENGTH);

        engine.telemetry.addData("Ultra Sonic", frontRangeCache[0] & 0xFF);
        engine.telemetry.addData("ODS", frontRangeCache[1] & 0xFF);
        //engine.telemetry.addData("BACK ODS", engine.dsBack.getLightDetected());
        engine.telemetry.update();

        if (frontRangeCache[0] <= distance ) {

            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);

            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);

            setFinished(true);

        } else {

            engine.dcBackLeft.setPower(directions[0] * speeds[0]);
            engine.dcFrontLeft.setPower(directions[1] * speeds[1]);
            engine.dcFrontRight.setPower(directions[2] * speeds[2]);
            engine.dcBackRight.setPower(directions[3] * speeds[3]);

        }

    }
}

