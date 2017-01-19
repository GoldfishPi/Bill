package org.timecrafters.team.gfp.jewls.states.drive.encoders.turn;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.gfp_jewlsDriveEncoders;

/**
 * Created by t420 on 1/18/2017.
 */

public class gfp_jewlsDriveEncodersRotate extends gfp_jewlsDriveEncoders {

    public gfp_jewlsDriveEncodersRotate(Engine engine,double runTime) {
        this.engine = engine;
        this.runForStop = runTime;
    }

    @Override
    public void init() {
        this.endPosition = 1000.0;
        directions[0] = -1;
        speeds[0] = 0.7;
        directions[1] = -1;
        speeds[1] = 0.3;
        directions[2] = 1;
        speeds[2] = 1.0;
        directions[3] = 1;
        speeds[3] = 0.5;
    }
}
//grr
