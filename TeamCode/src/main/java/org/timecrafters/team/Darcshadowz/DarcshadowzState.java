package org.timecrafters.team.Darcshadowz;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by cyber on 1/3/2017.
 */

public class DarcshadowzState extends State {
    Servo roller;
    Servo otherRoller;
    DcMotor particleLift;
    DcMotor particleLift2;
    ServoController servoController;

    public DarcshadowzState(Engine engine) {
        this.engine = engine;

        servoController = engine.hardwareMap.servoController.get("thingy");
        roller = engine.hardwareMap.servo.get("roller");
        otherRoller = engine.hardwareMap.servo.get("otherRoller");
        particleLift = engine.hardwareMap.dcMotor.get("particleLift");
        particleLift2 = engine.hardwareMap.dcMotor.get("particleLift2");
    }

    @Override
    public void init() {
    }

    @Override
    public void exec() {
        if (engine.gamepad1.x) {

            roller.setPosition(-1.0);
            otherRoller.setPosition(1.0);
        } else {
            servoController.pwmDisable();
        }

        if (engine.gamepad1.left_stick_y < 0.0) {
            particleLift.setPower(-0.05);
//            DcMotorControllerEx
        }

        if (engine.gamepad1.left_stick_y > 0.0) {
            particleLift.setPower(0.45);
        }

        if (engine.gamepad1.left_stick_y == 0.0) {
            particleLift.setPower(0.0);
        }

        particleLift2.setPower(engine.gamepad1.right_stick_y);
    }
}
