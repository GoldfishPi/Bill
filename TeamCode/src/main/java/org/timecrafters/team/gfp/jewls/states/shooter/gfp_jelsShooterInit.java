package org.timecrafters.team.gfp.jewls.states.shooter;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/21/2017.
 */

public class gfp_jelsShooterInit extends State {


    public gfp_jelsShooterInit(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        while(!engine.shooterTouch.isPressed()){
            engine.dcShooter.setPower(1.0);
        }
        engine.dcShooter.setPower(0.0);
        setFinished(true);
    }

    @Override
    public void exec() {

    }
}
