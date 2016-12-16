package org.timecrafters.team.gfp.leo.drive;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 12/8/2016.
 */

public class gfp_LeoDriveLeft extends gfp_LeoDrive {
    public gfp_LeoDriveLeft(Engine engine, double speed, State shouldstop){
        this.engine = engine;
        this.speed = speed;
        this.shouldStop = shouldstop;
    }

    @Override
    public void init(){
        this.motor = this.engine.dcBackLeft;
    }
}