package org.timecrafters.team.gfp.jewls.states.shooter;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/14/2017.
 */

public class gfp_jewlsShoot extends State {

    private boolean loaded = false;
    private double shootTime;

    public gfp_jewlsShoot(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {

        if(engine.shooterTouch.isPressed() && !loaded){
            loaded = true;
            engine.dcShooter.setPower(1.0);
            Log.i(TAG, "LOADED");
            shootTime = System.currentTimeMillis() + 500.0;
        }else if(System.currentTimeMillis() >= shootTime && loaded && engine.shooterTouch.isPressed() ){
            engine.dcShooter.setPower(0.0);
            Log.i(TAG, "FIRED");
            setFinished(true);
        }

    }
}
