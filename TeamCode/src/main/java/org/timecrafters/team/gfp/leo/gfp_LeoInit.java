package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoInit extends State {

    public gfp_LeoInit(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init(){
        engine.dcBackLeft = engine.hardwareMap.dcMotor.get("dcBackLeft");
        engine.dcBackRight = engine.hardwareMap.dcMotor.get("dcBackRight");

        engine.dcBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        engine.dcBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        engine.dcBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

        engine.dcShooter = engine.hardwareMap.dcMotor.get("dcShooter");

        engine.dcPresser = engine.hardwareMap.dcMotor.get("dcPresser");
        engine.dcPresser.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //set color sensors
        engine.colorSensorRight = engine.hardwareMap.colorSensor.get("colorSensorRight");
        engine.colorSensorLeft  = engine.hardwareMap.colorSensor.get("colorSensorLeft");

        //set color sensor adresses
        engine.colorSensorRight.setI2cAddress(I2cAddr.create7bit(0x1e));
        engine.colorSensorLeft.setI2cAddress(I2cAddr.create7bit(0x26));

        //setup distance sensors
        engine.distanceSensorFront = engine.hardwareMap.i2cDevice.get("distanceSensorFront");
        engine.distanceSensorRight = engine.hardwareMap.i2cDevice.get("distanceSensorRight");

        //setup distance sensor readers
        engine.dsFrontReader = new I2cDeviceSynchImpl(engine.distanceSensorFront,new I2cAddr(0x28),false);
        engine.dsRightReader = new I2cDeviceSynchImpl(engine.distanceSensorFront,new I2cAddr(0x13),false);

        //engadge distance sensors
        engine.dsFrontReader.engage();
        engine.dsRightReader.engage();

        //TODO make a more get rid of this function after testing
        engine.servoOne = engine.hardwareMap.servo.get("servoOne");
        engine.servoTwo = engine.hardwareMap.servo.get("servoTwo");


        /*distanceSensorFront = opMode.hardwareMap.opticalDistanceSensor.get("distanceSensorFront");
        distanceSensorRight = opMode.hardwareMap.opticalDistanceSensor.get("distanceSensorRight");*/

    }

    @Override
    public void exec(){

        setFinished(true);
    }
}
