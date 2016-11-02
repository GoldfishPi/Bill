package org.timecrafters.engine;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by t420 on 9/29/2016.
 */

//Setup robot prefrance

public abstract class RobotPrefs {

    public ColorSensor colorSensor;

    public DcMotor dcBackLeft;
    public DcMotor dcBackRight;
    public DcMotor dcShooter;
    public DcMotor dcPresser;

    public UltrasonicSensor distanceSensorFront;
    public UltrasonicSensor distanceSensorRight;

    public TouchSensor touchSensor;


}