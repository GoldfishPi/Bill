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

        //back left
        directions[0] = 1;
        //front left
        directions[1] = -1;
        //front right
        directions[2] = 1;
        //back right
        directions[3] = -1;

    }
}
