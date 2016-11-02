package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoDriveForward extends State {


    public gfp_LeoDriveForward(OpMode opmode){
        this.opMode = opmode;

    }
    @Override
    public void init(){

    }

    @Override
    public void exec(){

        if(distanceSensorFront.getUltrasonicLevel() < 5.0 ){
            dcBackRight.setPower(.5);
            dcBackLeft.setPower(.5);
        }else{
            dcBackRight.setPower(0);
            dcBackLeft.setPower(0);
            setFinished(true);
        }
    }
}
