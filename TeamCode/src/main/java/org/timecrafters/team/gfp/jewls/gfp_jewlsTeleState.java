package org.timecrafters.team.gfp.jewls;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/6/2017.
 */

public class gfp_jewlsTeleState extends State {

    private double rightPower = 1.0;
    private double leftPower = 0.9;

    @Override
    public void exec(){
        if (engine.gamepad1.dpad_up) {
            engine.dcFrontRight.setPower(-rightPower);
            engine.dcFrontLeft.setPower(leftPower);
            engine.dcBackRight.setPower(rightPower);
            engine.dcBackLeft.setPower(leftPower);
        }
//D pad down pressed
        else if (engine.gamepad1.dpad_down) {
            engine.dcFrontRight.setPower(rightPower);
            engine.dcFrontLeft.setPower(-leftPower);
            engine.dcBackRight.setPower(-rightPower);
            engine.dcBackLeft.setPower(-leftPower);
        }

//D pad right pressed
        else if (engine.gamepad1.dpad_right) {
            engine.dcFrontRight.setPower(rightPower);
            engine.dcFrontLeft.setPower(leftPower);
            engine.dcBackRight.setPower(rightPower);
            engine.dcBackLeft.setPower(-leftPower);
        }
//D pad left pressed
        else if (engine.gamepad1.dpad_left) {
            engine.dcFrontRight.setPower(-rightPower);
            engine.dcFrontLeft.setPower(-leftPower);
            engine.dcBackRight.setPower(-rightPower);
            engine.dcBackLeft.setPower(leftPower);

        }
        //rotate
        if (engine.gamepad1.a) {
            engine.dcFrontRight.setPower(rightPower);
            engine.dcFrontLeft.setPower(-leftPower);
            engine.dcBackRight.setPower(rightPower);
            engine.dcBackLeft.setPower(-leftPower);
        }
        else if (engine.gamepad1.b) {
            engine.dcFrontRight.setPower(-rightPower);
            engine.dcFrontLeft.setPower(leftPower);
            engine.dcBackRight.setPower(-rightPower);
            engine.dcBackLeft.setPower(leftPower);
        }

        else {
            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);
            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);
        }

    }
}
