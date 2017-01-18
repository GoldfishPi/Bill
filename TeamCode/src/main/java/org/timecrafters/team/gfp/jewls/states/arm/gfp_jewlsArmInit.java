package org.timecrafters.team.gfp.jewls.states.arm;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/17/2017.
 */

public class gfp_jewlsArmInit extends State {

    public gfp_jewlsArmInit(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        double time = System.currentTimeMillis();
        while (engine.dcArm.getCurrentPosition() <= 1000 && System.currentTimeMillis() + 10000.0 <= time) {
            engine.dcArm.setPower(1.0);
        }
        engine.dcArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        engine.dcArm.setPower(0.1);
        engine.dcArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void exec() {
        setFinished(true);
    }
}
