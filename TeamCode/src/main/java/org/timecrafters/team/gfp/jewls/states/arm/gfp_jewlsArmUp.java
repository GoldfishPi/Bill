package org.timecrafters.team.gfp.jewls.states.arm;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/10/2017.
 */

public class gfp_jewlsArmUp extends State {
    public gfp_jewlsArmUp(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {

        engine.dcArm.setPower(1.0);

    }
}
