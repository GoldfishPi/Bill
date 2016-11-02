package org.timecrafters.team.gfp.leo;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoDriveToLight extends State {

    private boolean foundLight = false;
    @Override
    public void init(){

    }

    @Override
    public void exec(){

        if(!foundLight){

            if(colorSensor.blue() > 10 || colorSensor.red() > 10){
                dcBackRight.setPower(0);
                dcBackLeft.setPower(0);
                foundLight = true;
            }else{
                dcBackLeft.setPower(0.2);
                dcBackRight.setPower(0.2);
            }
        }else{
            setFinished(true);
        }

    }
}
