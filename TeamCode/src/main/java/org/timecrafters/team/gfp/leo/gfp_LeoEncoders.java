package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/25/2016.
 */

public class gfp_LeoEncoders extends State {

    DcMotor motor;
    double pos;
    public gfp_LeoEncoders(Engine engine, DcMotor motor,double position){
        this.engine = engine;
        this.motor = motor;
        this.pos = position;
    }

    @Override
    public void init(){
    }

    @Override
    public void exec(){

        if(motor.getCurrentPosition() >= pos){
            setFinished(true);
        }

    }
}
