package org.timecrafters.team.EV;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

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

        this.engine = engine;
        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("frontRight");
        engine.dcFrontLeft  = engine.hardwareMap.dcMotor.get("frontLeft");
        engine.dcBackRight  = engine.hardwareMap.dcMotor.get("backRight");
        engine.dcBackLeft   = engine.hardwareMap.dcMotor.get("backLeft");

        System.out.println("DC Motor: "+engine.dcBackLeft.toString());

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
}
