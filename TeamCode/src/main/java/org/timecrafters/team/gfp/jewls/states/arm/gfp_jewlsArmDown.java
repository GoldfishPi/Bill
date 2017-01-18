package org.timecrafters.team.gfp.jewls.states.arm;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/17/2017.
 */

public class gfp_jewlsArmDown extends State{

    private double startingPos;

    public gfp_jewlsArmDown(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        startingPos = engine.dcArm.getCurrentPosition();
    }

    @Override
    public void exec() {
        engine.dcArm.setPower(-0.5);
    }

    @Override
    public void stop() {
        super.stop();
        engine.dcArm.setPower(0.0);
    }
}
