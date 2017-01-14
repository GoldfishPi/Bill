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
        directions[1] = 1;
        directions[2] = 1;
        directions[3] = 1;
    }

}
