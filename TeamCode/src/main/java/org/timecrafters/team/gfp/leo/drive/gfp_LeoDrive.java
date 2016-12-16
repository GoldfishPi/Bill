package org.timecrafters.team.gfp.leo.drive;

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

    public double speed;
    public DcMotor motor;
    public State shouldStop;

    @Override
    public void init(){

    }
    @Override
    public void exec(){
        motor.setPower(speed);

    }
}