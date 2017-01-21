package org.timecrafters.team.gfp.jewls.states.drive.sensors;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 1/20/2017.
 */

public class gfp_jewlsDriveLeftSensors extends gfp_jewlsDriveSenosr {

    public gfp_jewlsDriveLeftSensors(Engine engine) {
        super(engine);
    }

    @Override
    public void init() {
        directions[0] = 1;
        speeds[0] = 1.0;
        directions[1] = -1;
        speeds[1] = 0.7;
        directions[2] = 1;
        speeds[2] = 1.0;
        directions[3] = -1;
        speeds[3] = 0.7;
    }
}
