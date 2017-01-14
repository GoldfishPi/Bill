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

        if(engine.dcArm.getCurrentPosition() <= 900.0) {
            engine.dcArm.setPower(1.0);
        }else{
            engine.dcArm.setPower(0.4);
        }
    }

    @Override
    public void stop() {
        super.stop();
        engine.dcArm.setPower(0.0);
    }
}
