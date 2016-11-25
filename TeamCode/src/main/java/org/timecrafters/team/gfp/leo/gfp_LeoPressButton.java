package org.timecrafters.team.gfp.leo;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoPressButton extends State {

    private boolean start = false;
    private int startingPresserPos;

    public gfp_LeoPressButton(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init(){

    }

    public void exec(){
        if(!start){
            startingPresserPos = engine.dcPresser.getCurrentPosition();
            start = true;
        }else{
            if(engine.dcPresser.getCurrentPosition() < startingPresserPos + 500){
                engine.dcPresser.setPower(0.2);
            }else{
                engine.dcPresser.setPower(0);
                setFinished(true);
            }
        }

    }
}
