package org.timecrafters.team.gfp.jewls.states.shooter;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/10/2017.
 */

public class gfp_jewlsLoad extends State{

    public gfp_jewlsLoad(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {
        if(!engine.shooterTouch.isPressed()){
            engine.dcShooter.setPower(1.0);
        }else{
            engine.dcShooter.setPower(0.0);
            setFinished(true);
        }

        /*if(engine.shooterTouch.isPressed()){
            Log.i(TAG, "PRESSED");
        }*/
    }
}
