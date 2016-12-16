package org.timecrafters.team.gfp.leo.drive;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 12/8/2016.
 */

public class gfp_LeoDriveRight extends gfp_LeoDrive {
    public gfp_LeoDriveRight(Engine engine,double speed,State shouldStop){
        this.engine = engine;
        this.speed = speed;
        this.shouldStop = shouldStop;
    }

    @Override
    public void init(){
        this.motor = engine.dcBackRight;
    }
}
