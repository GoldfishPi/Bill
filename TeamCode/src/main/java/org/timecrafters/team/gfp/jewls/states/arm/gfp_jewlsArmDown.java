package org.timecrafters.team.gfp.jewls.states.arm;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/17/2017.
 */

public class gfp_jewlsArmDown extends State{

    private double startingPos;
    private double endTime;
    private boolean firstRun = true;
    private double startTime;

    public gfp_jewlsArmDown(Engine engine, double endTime ) {
        this.engine = engine;
        this.endTime = endTime;
    }

    @Override
    public void init() {
        startingPos = engine.dcArm.getCurrentPosition();
    }

    @Override
    public void exec() {
        if (firstRun){
            startTime = System.currentTimeMillis();
            firstRun = false;
        }
        if(System.currentTimeMillis() -( startTime + endTime) <= 0) {
            engine.dcArm.setPower(-0.6);
        }else {
            engine.dcArm.setPower(0.0);
            setFinished(true);
        }

    }

    @Override
    public void stop() {
        super.stop();
        engine.dcArm.setPower(0.0);
    }
}
