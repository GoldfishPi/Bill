package org.timecrafters.team.gfp.jewls.states.drive;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 1/5/2017.
 */

public class gfp_jewlsDriveForward extends gfp_jewlsDrive {

    public gfp_jewlsDriveForward(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init(){
        directions[0] = 1;
        speeds[0] = 0.7;
        directions[1] = 1;
        speeds[1] = 0.3;
        directions[2] = 1;
        speeds[2] = 1.0;
        directions[3] = 1;
        speeds[3] = 0.5;
    }

}
