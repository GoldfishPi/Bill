package org.timecrafters.engine;


import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by t420 on 9/29/2016.
 */

//Setup robot prefrance

    /*
    * NAME YOUR CONFIG FILES THE SAME AS IN ROBOT PREFS
    * */
public abstract class RobotPrefs extends OpMode {

    final String TAG = "program.robotprefs";

    public volatile DeviceInterfaceModule deviceInterfaceModule;

    public volatile ColorSensor colorSensorRight;
    public volatile ColorSensor colorSensorLeft;

    public volatile DcMotor dcShooter;
    public volatile DcMotor dcPresser;
    public volatile DcMotor dcArm;

    public volatile DcMotor dcFrontRight;
    public volatile DcMotor dcBackRight;
    public volatile DcMotor dcFrontLeft;
    public volatile DcMotor dcBackLeft;

    public volatile I2cDevice distanceSensorFront;
    public volatile I2cDevice distanceSensorRight;

    public volatile I2cDeviceSynch dsFrontReader;
    public volatile I2cDeviceSynch dsRightReader;

    public volatile OpticalDistanceSensor dsFront;
    public volatile OpticalDistanceSensor dsBack;

    public volatile TouchSensor shooterTouch;

    public volatile Servo svRightFront;
    public volatile Servo svLeftFront;
    public volatile Servo svRightBack;
    public volatile Servo svLeftBack;

    public volatile DcMotor[] motors = new DcMotor[12];




    public DcMotor getMotor(int motor){
        motors[0] = dcBackLeft;
        motors[1] = dcBackRight;
        motors[2] = dcFrontLeft;
        motors[3] = dcFrontRight;
        motors[4] = dcPresser;
        motors[5] = dcShooter;
        Log.i(TAG,Integer.toString(motor));
        return motors[motor];

    }


}