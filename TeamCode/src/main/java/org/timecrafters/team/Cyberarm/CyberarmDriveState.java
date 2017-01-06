package org.timecrafters.team.Cyberarm;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by cyber on 1/5/2017.
 */

public class CyberarmDriveState extends State {
    double speed = 0.1;
    boolean dPadUp = false;
    boolean dPadDown = false;
    boolean dPadRight = false;
    boolean dPadLeft = false;


    public CyberarmDriveState(Engine engine) {
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
        if (engine.gamepad1.dpad_up) {
            engine.dcFrontRight.setPower(-1.0);
            engine.dcFrontLeft.setPower(1.0);
            engine.dcBackRight.setPower(1.0);
            engine.dcBackLeft.setPower(1.0);
        }
//D pad down pressed
        else if (engine.gamepad1.dpad_down) {
            engine.dcFrontRight.setPower(1.0);
            engine.dcFrontLeft.setPower(-1.0);
            engine.dcBackRight.setPower(-1.0);
            engine.dcBackLeft.setPower(-1.0);
        }

//D pad right pressed
        else if (engine.gamepad1.dpad_right) {
            engine.dcFrontRight.setPower(1.0);
            engine.dcFrontLeft.setPower(1.0);
            engine.dcBackRight.setPower(1.0);
            engine.dcBackLeft.setPower(-1.0);
        }
//D pad left pressed
        else if (engine.gamepad1.dpad_left) {
            engine.dcFrontRight.setPower(-1.0);
            engine.dcFrontLeft.setPower(-1.0);
            engine.dcBackRight.setPower(-1.0);
            engine.dcBackLeft.setPower(1.0);

        } else {
            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);
            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);
        }
    }
}
