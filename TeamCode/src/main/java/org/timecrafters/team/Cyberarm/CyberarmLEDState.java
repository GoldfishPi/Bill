package org.timecrafters.team.Cyberarm;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by cyberarm on 1/3/2017.
 */

public class CyberarmLEDState extends State {

    Servo roller;
    Servo otherRoller;
    DcMotor particleLift;
    DcMotor particleLift2;
    ServoController servoController;
    DcMotor active_led_motor;
    DcMotor inactive_led_motor;
    int dash;
    int dot;
    HashMap<String, int[]> morseCode;

    public CyberarmLEDState(Engine engine) {
        this.engine = engine;

        servoController = engine.hardwareMap.servoController.get("thingy");
        roller = engine.hardwareMap.servo.get("roller");
        otherRoller = engine.hardwareMap.servo.get("otherRoller");
        particleLift = engine.hardwareMap.dcMotor.get("particleLift");
        particleLift2 = engine.hardwareMap.dcMotor.get("particleLift2");
        dot  = 100; // milliseconds
        dash = 300; // milliseconds
        morseCode = new HashMap<String, int[]>();

        morseCode.put("A", new int[]{dot, dash});
        morseCode.put("B", new int[]{dash, dot, dot, dot});
        morseCode.put("C", new int[]{dash, dot, dash, dot});
        morseCode.put("D", new int[]{dash, dot, dot});
        morseCode.put("E", new int[]{dot});
        morseCode.put("F", new int[]{dot, dot, dash, dot});
        morseCode.put("G", new int[]{dash, dash, dot});
        morseCode.put("H", new int[]{dot, dot, dot, dot});
        morseCode.put("I", new int[]{dot, dot});
        morseCode.put("J", new int[]{dot, dash, dash, dash});
        morseCode.put("K", new int[]{dash, dot, dash});
        morseCode.put("L", new int[]{dot, dash, dot, dot});
        morseCode.put("M", new int[]{dash, dash});
        morseCode.put("N", new int[]{dash, dot});
        morseCode.put("O", new int[]{dash, dash, dash});
        morseCode.put("P", new int[]{dot, dash, dash, dot});
        morseCode.put("Q", new int[]{dash, dash, dot, dash});
        morseCode.put("R", new int[]{dot, dash, dot});
        morseCode.put("S", new int[]{dot, dot, dot});
        morseCode.put("T", new int[]{dash});
        morseCode.put("U", new int[]{dot, dot, dash});
        morseCode.put("V", new int[]{dot, dot, dot, dash});
        morseCode.put("W", new int[]{dot, dash, dash});
        morseCode.put("X", new int[]{dash, dot, dot, dash});
        morseCode.put("Y", new int[]{dash, dot, dash, dash});
        morseCode.put("Z", new int[]{dash, dash, dot, dot});

    }

    @Override
    public void init(){
        particleLift.setPower(0.1);
        particleLift2.setPower(0.1);
    }

    @Override
    public void exec() {
        // RED
        System.out.print("LOOPING");
        if (engine.gamepad1.right_bumper && !engine.gamepad1.left_bumper) {
            particleLift.setPower(0.1);
            particleLift2.setPower(0.0);
            System.out.println("RED RED RED");
            animate(particleLift, particleLift2);
        } else {
            if (!engine.gamepad1.left_bumper) {
                particleLift.setPower(0.1);
            }
        }

        // BLUE
        if (engine.gamepad1.left_bumper && !engine.gamepad1.right_bumper) {
            particleLift.setPower(0.0);
            particleLift2.setPower(0.1);
            System.out.println("BLUE BLUE BLUE");
            animate(particleLift2, particleLift);
        } else {
            if (!engine.gamepad1.right_bumper) {
                particleLift2.setPower(0.1);
            }
        }
    }

    void animate(DcMotor onMotor, DcMotor offMotor) {
        active_led_motor = onMotor;
        inactive_led_motor = offMotor;
        letter("M");
        letter("E");
        letter("N");
        letter("T");
        letter("O");
        letter("R");
        letter("S");
        newWord(); // insert "STOP" or change color drastically.

        letter("R");
        letter("O");
        letter("C");
        letter("K");
        newWord();
    }

    void letter(String _letter) {
        if (_letter.length() > 1) { throw new Error("Only one letter at a time.");}
        String l = _letter.toUpperCase();
        int[] data = morseCode.get(l);
        System.out.println("letter: "+l+" data array: "+data);
        if (data != null) {
            animateMorseCode(data);
        } else {
            System.out.println("Error: data for letter '"+l+"' is null");
        }
    }

    void animateMorseCode(int[] data) {
        for (int i = 0; i < data.length; i++) {
//            row(new int[][]{off, off, off, off, off, off, off, off});
            active_led_motor.setPower(0.1);
            inactive_led_motor.setPower(0.1);
            sleep(data[i]);
//            row(new int[][]{color, color, color, color, color, color, color, color});
            active_led_motor.setPower(0.1);
            inactive_led_motor.setPower(0.0);
            sleep(dot);
        }
        // Letter Pause
        active_led_motor.setPower(0.1);
        inactive_led_motor.setPower(0.0);
        sleep(dot*2); // 3 unit (1 unit comes from the animator)
    }

    // Word Pause
    void newWord() {
        active_led_motor.setPower(0.1);
        active_led_motor.setPower(0.0);
        sleep(dot*7);
    }

    void sleep(Integer milliseconds) {
        try {
            active_led_motor.setPower(0.1);
            inactive_led_motor.setPower(0.0);
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException errorObject) {
            // Java, you're funny.
        }
    }
}
