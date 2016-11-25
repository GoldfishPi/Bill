package org.timecrafters.team.gfp.leo;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoTurnRight extends State {

    private boolean firstRun = false;
    private boolean rightFinished = false;
    private boolean leftFinished = false;

    int rightWheel;
    int leftWheel;

    public gfp_LeoTurnRight(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init(){

    }

    public void exec(){

        if(!firstRun){
            rightWheel = engine.dcBackRight.getCurrentPosition();
            leftWheel = engine.dcBackLeft.getCurrentPosition();
            firstRun = true;
        }

        if(engine.dcBackRight.getCurrentPosition() > rightWheel + 700){
            engine.dcBackRight.setPower(0.3);
        }else{
            engine.dcBackRight.setPower(0);
            rightFinished = true;
        }

        if(engine.dcBackLeft.getCurrentPosition() > leftWheel + 700){
            engine.dcBackLeft.setPower(0.3);
        }else{
            engine.dcBackLeft.setPower(0);
            leftFinished = true;
        }

        if(rightFinished && leftFinished){
            setFinished(true);
        }

    }
}
