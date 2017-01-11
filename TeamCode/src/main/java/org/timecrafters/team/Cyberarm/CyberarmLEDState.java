package org.timecrafters.team.Cyberarm;

import com.qualcomm.robotcore.hardware.ServoController;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by cyberarm on 1/3/2017.
 */

public class CyberarmLEDState extends State {

    // REAL DEVICES
//    DcMotor particleLift;
//    DcMotor particleLift2;
//    DcMotor active_led_motor;
//    DcMotor inactive_led_motor;
    // Virtual Devices
    CyberarmVirtualDcMotor particleLift;
    CyberarmVirtualDcMotor particleLift2;
    CyberarmVirtualDcMotor active_led_motor;
    CyberarmVirtualDcMotor inactive_led_motor;
    ServoController servoController;
    int dash;
    int dot;
    double power;
    HashMap<String, int[]> morseCode;

    public CyberarmLEDState(Engine engine) {
        this.engine = engine;

        // Virtual Devices
        particleLift = new CyberarmVirtualDcMotor();
        particleLift2 = new CyberarmVirtualDcMotor();
        // Real Motors
//        particleLift = engine.hardwareMap.dcMotor.get("particleLift");
//        particleLift2 = engine.hardwareMap.dcMotor.get("particleLift2");
        dot  = 250; // milliseconds
        dash = (dot*3); // milliseconds
        morseCode = new HashMap<String, int[]>();
        power = 0.1;

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

    // Ruby For Life!!!
    void puts(String string) { System.out.println(string);}

    public void init(){
        System.out.println("Initializing");
        particleLift.setPower(0.1);
        particleLift2.setPower(0.1);
        puts("Initialized");
    }

    @Override
    public void exec() {
        System.out.print("Executing");
        animate(particleLift, particleLift2);
        // RED
        System.out.print("LOOPING");
        if (engine.gamepad1.right_bumper && !engine.gamepad1.left_bumper) {
            particleLift.setPower(power);
            particleLift2.setPower(0.0);
            System.out.println("RED RED RED");
            animate(particleLift, particleLift2);
        } else {
            if (!engine.gamepad1.left_bumper) {
                particleLift.setPower(power);
            }
        }

        // BLUE
        if (engine.gamepad1.left_bumper && !engine.gamepad1.right_bumper) {
            particleLift.setPower(0.0);
            particleLift2.setPower(power);
            System.out.println("BLUE BLUE BLUE");
            animate(particleLift2, particleLift);
        } else {
            if (!engine.gamepad1.right_bumper) {
                particleLift2.setPower(0.1);
            }
        }
    }

    void animate(CyberarmVirtualDcMotor onMotor, CyberarmVirtualDcMotor offMotor) {
        active_led_motor = onMotor;
        inactive_led_motor = offMotor;
//        letter("M");
//        letter("E");
//        letter("N");
//        letter("T");
//        letter("O");
//        letter("R");
//        letter("S");
//        newWord(); // insert "STOP" or change color drastically.
//
//        letter("R");
//        letter("O");
//        letter("C");
//        letter("K");

//        letter("H");
//        letter("E");
//        letter("L");
//        letter("L");
//        letter("0");
//        newWord();
//
//        letter("W");
//        letter("O");
//        letter("R");
//        letter("L");
//        letter("D");
//        newWord();
        sentence("Hello World");
    }

    void sentence(String _sentence) {
        puts("Sentence Processor: "+_sentence);
        String[] list = _sentence.trim().split("");

        for (int i = 0; i < list.length; i++) {
            System.out.println("Sentence processor: "+list[i]);
            if (list[i] == " ") {
                newWord();
            } else if(list[i].matches("\\^0-9$")) {
                // Do nothing
            } else {
                letter(list[i]);
            }
        }
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
            active_led_motor.setPower(power);
            inactive_led_motor.setPower(power);
            sleep(data[i]);
            active_led_motor.setPower(power);
            inactive_led_motor.setPower(0.0);
            sleep(dot);
        }
        // Letter Pause
        active_led_motor.setPower(power);
        inactive_led_motor.setPower(0.0);
        sleep(dot*2); // 3 unit (1 unit comes from the animator)
    }

    // Word Pause
    void newWord() {
        active_led_motor.setPower(power);
        inactive_led_motor.setPower(0.0);
        sleep(dot*7);
    }

    void sleep(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException errorObject) {
            // Java, you're funny.
        }
    }
}
