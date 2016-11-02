package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoInit extends State {

    public gfp_LeoInit(OpMode opmode){
        this.opMode = opmode;
    }

    @Override
    public void init(){
        dcBackLeft = opMode.hardwareMap.dcMotor.get("dcBackLeft");
        dcBackRight = opMode.hardwareMap.dcMotor.get("dcBackRight");

        dcBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        dcBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        dcShooter = opMode.hardwareMap.dcMotor.get("dcShooter");

        dcPresser = opMode.hardwareMap.dcMotor.get("dcPresser");
        dcPresser.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        colorSensor = opMode.hardwareMap.colorSensor.get("colorSensor");
        distanceSensorFront = opMode.hardwareMap.ultrasonicSensor.get("distanceSensorFront");
        distanceSensorRight = opMode.hardwareMap.ultrasonicSensor.get("distanceSensorRight");

    }

    @Override
    public void exec(){

        setFinished(true);
    }
}
