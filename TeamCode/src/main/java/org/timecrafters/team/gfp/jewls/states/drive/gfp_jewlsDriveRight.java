package org.timecrafters.team.gfp.jewls.states.drive;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 1/14/2017.
 */

public class gfp_jewlsDriveRight extends gfp_jewlsDrive {
    public gfp_jewlsDriveRight(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {

        directions[0] = 1;
        speeds[0] = 1.0;
        directions[1] = 1;
        speeds[1] = 0.5;
        directions[2] = -1;
        speeds[2] = 0.5;
        directions[3] = -1;
        speeds[3] = 1.0;

        /*
        * rotate clock wise
        *
        directions[0] = 1;
        speeds[0] = 1.0;
        directions[1] = 1;
        speeds[1] = 0.5;
        directions[2] = -1;
        speeds[2] = 0.5;
        directions[3] = -1;
        speeds[3] = 1.0;
        * */

    }
}
