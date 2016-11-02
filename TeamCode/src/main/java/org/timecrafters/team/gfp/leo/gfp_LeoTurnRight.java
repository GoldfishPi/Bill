package org.timecrafters.team.gfp.leo;

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

    @Override
    public void init(){

    }

    public void exec(){

        if(!firstRun){
            rightWheel = dcBackRight.getCurrentPosition();
            leftWheel = dcBackLeft.getCurrentPosition();
            firstRun = true;
        }

        if(dcBackRight.getCurrentPosition() > rightWheel + 700){
            dcBackRight.setPower(0.3);
        }else{
            dcBackRight.setPower(0);
            rightFinished = true;
        }

        if(dcBackLeft.getCurrentPosition() > leftWheel + 700){
            dcBackLeft.setPower(0.3);
        }else{
            dcBackLeft.setPower(0);
            leftFinished = true;
        }

        if(rightFinished && leftFinished){
            setFinished(true);
        }

    }
}
