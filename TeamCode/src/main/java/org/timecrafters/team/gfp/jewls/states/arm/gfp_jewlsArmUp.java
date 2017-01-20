package org.timecrafters.team.gfp.jewls.states.arm;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/10/2017.
 */

public class gfp_jewlsArmUp extends State {
    private double startingPos;
    private double endTime;
    private boolean firstRun = true;
    private double startTime;

    public gfp_jewlsArmUp(Engine engine, double endTime) {
        this.engine = engine;
        this.endTime = endTime;
    }

    @Override
    public void exec() {


        if (firstRun){
            startTime = System.currentTimeMillis();
            firstRun = false;
        }
        if(System.currentTimeMillis() -( startTime + endTime) <= 0) {
            engine.dcArm.setPower(1.0);
        }else {
            engine.dcArm.setPower(0.1);
            setFinished(true);
        }
    }

    @Override
    public void stop() {
        super.stop();
        engine.dcArm.setPower(0.0);
    }
}
