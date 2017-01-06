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
        setMotors(engine.dcFrontLeft,1.0,0);
        setMotors(engine.dcFrontRight,1.0,1);
        setMotors(engine.dcBackRight,1.0,2);
        setMotors(engine.dcBackLeft,1.0,3);

        setDistance(500.0);
    }

}
