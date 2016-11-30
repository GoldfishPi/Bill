package org.timecrafters.team.gfp.leo;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoDrive extends State {

    State shouldStop;
    double speed;
    int motor;

    public gfp_LeoDrive(Engine engine,int motor,double speed, State shouldStop){
        this.engine = engine;
        this.shouldStop = shouldStop;
        this.motor = motor;
        this.speed = speed;

    }
    @Override
    public void init(){

    }

    @Override
    public void exec(){


        engine.telemetry.addData("HI",engine.getMotor(motor));
        engine.telemetry.update();

        //engine.getMotor(engine.dcBackLeft).setPower(0.5);

        /*if(!shouldStop.isFinished){
            motor.setPower(speed);
        }else{
            motor.setPower(0.0);
        }*/

    }
}