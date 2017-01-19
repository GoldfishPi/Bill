package org.timecrafters.team.gfp.jewls;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/5/2017.
 */

public class gfp_jewlsInit extends State {

    public gfp_jewlsInit(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {

        //Setting Drive train variables
        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        engine.dcFrontLeft = engine.hardwareMap.dcMotor.get("dcFrontLeft");
        engine.dcBackRight = engine.hardwareMap.dcMotor.get("dcBackRight");
        engine.dcBackLeft = engine.hardwareMap.dcMotor.get("dcBackLeft");

        //setting drive train run mode
        engine.dcFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        engine.dcFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        engine.dcBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        engine.dcBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //reservse front right motor;
        engine.dcFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        //reverse back left motor
        engine.dcBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        //setting arm and shooter variables
        engine.dcArm = engine.hardwareMap.dcMotor.get("dcArm");
        engine.dcShooter = engine.hardwareMap.dcMotor.get("dcShooter");

        //setting shooter run mode
        engine.dcShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //setting arm and shooter run mode
        engine.dcArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        engine.dcShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //setting touch sensor variables
        engine.shooterTouch = engine.hardwareMap.touchSensor.get("shooterTouch");

        //setting optical distance sensor
        engine.dsBack = engine.hardwareMap.opticalDistanceSensor.get("dsBack");

        //setting servos for ball capture
       /* engine.svLeftBack = engine.hardwareMap.servo.get("svLeftFront");
        engine.svLeftBack = engine.hardwareMap.servo.get("svRightFront");
        engine.svLeftBack = engine.hardwareMap.servo.get("svLeftBack");
        engine.svLeftBack = engine.hardwareMap.servo.get("svRightBack");*/

        engine.svRightFront = engine.hardwareMap.crservo.get("svRightFront");
        engine.svLeftFront = engine.hardwareMap.crservo.get("svLeftFront");
    }

    @Override
    public void exec() {
        setFinished(true);
    }
}
