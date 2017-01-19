package org.timecrafters.team.gfp.jewls.states.ballcapture;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/18/2017.
 */

public class gfp_ballCapture extends State {

    private double endTime;
    private  boolean firstRun = true;
    private double startTime;
    public gfp_ballCapture(Engine engine, double endTime) {
        this.engine = engine;
        this.endTime = endTime;
    }

    @Override
    public void exec() {
        if(firstRun){
            startTime = System.currentTimeMillis();
            firstRun = false;
        }

        if(System.currentTimeMillis() -( startTime + endTime) <= 0) {
            engine.svRightFront.setPower(-1.0);
            engine.svLeftFront.setPower(1.0);
        }else{
            engine.svRightFront.setPower(0.0);
            engine.svLeftFront.setPower(0.0);
            setFinished(true);
        }
    }
}
