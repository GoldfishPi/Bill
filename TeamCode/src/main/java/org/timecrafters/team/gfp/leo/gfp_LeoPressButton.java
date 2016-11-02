package org.timecrafters.team.gfp.leo;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoPressButton extends State {

    private boolean start = false;
    private int startingPresserPos;

    @Override
    public void init(){

    }

    public void exec(){
        if(!start){
            startingPresserPos = dcPresser.getCurrentPosition();
            start = true;
        }else{
            if(dcPresser.getCurrentPosition() < startingPresserPos + 500){
                dcPresser.setPower(0.2);
            }else{
                dcPresser.setPower(0);
                setFinished(true);
            }
        }

    }
}
