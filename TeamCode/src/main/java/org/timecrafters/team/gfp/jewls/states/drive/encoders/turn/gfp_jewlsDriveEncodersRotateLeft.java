package org.timecrafters.team.gfp.jewls.states.drive.encoders.turn;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.gfp_jewlsDriveEncoders;

/**
 * Created by t420 on 1/18/2017.
 */

public class gfp_jewlsDriveEncodersRotateLeft extends gfp_jewlsDriveEncoders {

    public gfp_jewlsDriveEncodersRotateLeft(Engine engine, double endPosition , double runTime) {
        this.engine = engine;
        this.runTime = runTime;
        this.endPosition = endPosition;
    }

    @Override
    public void init() {
        this.checkMotor = engine.dcBackRight;
        directions[0] = -1;
        speeds[0] = 0.5;
        directions[1] = -1;
        speeds[1] = 1.0;
        directions[2] = 1;
        speeds[2] = 1.0;
        directions[3] = 1;
        speeds[3] = 0.5;
    }
}
//grr
