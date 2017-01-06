package org.timecrafters.team.EV;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

import org.timecrafters.engine.State;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by cyber on 12/15/2016.
 */

public class EV_thisIsJustAState extends State {
    double speed = 0.1;
    boolean dPadUp = false;
    boolean dPadDown = false;
    boolean dPadRight = false;
    boolean dPadLeft = false;

    public EV_thisIsJustAState (EV_Engine engine ){

        /*
    * NAME YOUR CONFIG FILES THE SAME AS IN ROBOT PREFS
    * */

        this.engine = engine;
        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        engine.dcFrontLeft  = engine.hardwareMap.dcMotor.get("dcFrontLeft");
        engine.dcBackRight  = engine.hardwareMap.dcMotor.get("dcBackRight");
        engine.dcBackLeft   = engine.hardwareMap.dcMotor.get("dcBackLeft");

    }

    @Override
    public void init(){

    }

    @Override
    public void exec() {
        if (engine.gamepad1.dpad_up && !dPadUp) {
            dPadUp = true;
            engine.dcFrontRight.setPower(-1.0);
            engine.dcFrontLeft.setPower(1.0);
            engine.dcBackRight.setPower(1.0);
            engine.dcBackLeft.setPower(1.0);
        } else if (!engine.gamepad1.dpad_up && dPadUp) {
            dPadUp = false;
        }
//D pad down pressed
        if (engine.gamepad1.dpad_down && !dPadDown) {
            dPadDown = true;
            engine.dcFrontRight.setPower(1.0);
            engine.dcFrontLeft.setPower(-1.0);
            engine.dcBackRight.setPower(-1.0);
            engine.dcBackLeft.setPower(-1.0);
        } else if (!engine.gamepad1.dpad_up && dPadDown) {
            dPadDown = false;
        }

//D pad right pressed
        if (engine.gamepad1.dpad_right && !dPadRight) {
            dPadRight = true;
            engine.dcFrontRight.setPower(1.0);
            engine.dcFrontLeft.setPower(1.0);
            engine.dcBackRight.setPower(1.0);
            engine.dcBackLeft.setPower(-1.0);
        } else if (!engine.gamepad1.dpad_right && dPadRight) {
            dPadRight = false;
        }
//D pad left pressed
        if (engine.gamepad1.dpad_left && !dPadLeft) {
            dPadLeft = true;
            engine.dcFrontRight.setPower(-1.0);
            engine.dcFrontLeft.setPower(-1.0);
            engine.dcBackRight.setPower(-1.0);
            engine.dcBackLeft.setPower(1.0);
        } else if (!engine.gamepad1.dpad_left && dPadLeft) {
            dPadLeft = false;
        }
        if(engine.gamepad1.a) {
//        if(dPadUp || dPadDown || dPadLeft || dPadRight) {
            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);
            engine.dcBackLeft.setPower(0.0);
        }




//            engine.dcFrontRight.setPower(-1.0);
//            engine.dcFrontLeft.setPower(-1.0);
//            engine.dcBackRight.setPower(-1.0);
//            engine.dcBackLeft.setPower(1.0);



    }

//    @Override
//    void stop {
//
//    }
}
