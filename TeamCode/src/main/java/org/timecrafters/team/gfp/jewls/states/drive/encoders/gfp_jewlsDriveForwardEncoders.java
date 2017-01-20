package org.timecrafters.team.gfp.jewls.states.drive.encoders;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 1/19/2017.
 */

public class gfp_jewlsDriveForwardEncoders extends gfp_jewlsDriveEncoders {

    public gfp_jewlsDriveForwardEncoders(Engine engine, double endPosition, double runTime) {
        this.engine = engine;
        this.endPosition = endPosition;
        this.runTime = runTime;
    }

    @Override
    public void init() {

        checkMotor = engine.dcBackRight;
        directions[0] = 1;
        speeds[0] = 0.5;
        directions[1] = 1;
        speeds[1] = 1.0;
        directions[2] = 1;
        speeds[2] = 1.0;
        directions[3] = 1;
        speeds[3] = 0.5;

    }
}
