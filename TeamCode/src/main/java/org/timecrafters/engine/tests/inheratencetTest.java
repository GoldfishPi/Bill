package org.timecrafters.engine.tests;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.I2cAddr;

/**
 * Created by t420 on 9/29/2016.
 */

public class InheratencetTest extends State {

    public boolean csdata;
    public int num;
    private boolean ro = false;

    public InheratencetTest(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init() {



        engine.colorSensorRight = engine.hardwareMap.colorSensor.get("colorSensorRight");
        engine.colorSensorRight.setI2cAddress(I2cAddr.create7bit(0x1e));
        engine.colorSensorLeft = engine.hardwareMap.colorSensor.get("colorSensorLeft");
        engine.colorSensorLeft.setI2cAddress(I2cAddr.create7bit(0x26));

        engine.deviceInterfaceModule = engine.hardwareMap.deviceInterfaceModule.get("Sensors");

        System.out.println("PROGRAM : WORKING");
        Log.i("PROGRAM", "WORKING");
        engine.colorSensorLeft.enableLed(false);
        engine.colorSensorRight.enableLed(false);

    }

    @Override
    public void exec(){

        if(ro) {
            engine.colorSensorLeft.enableLed(true);
            engine.colorSensorRight.enableLed(true);
            ro = true;
            engine.deviceInterfaceModule.setLED(0, true);
        }else{
            engine.deviceInterfaceModule.setLED(0,false);
            ro = false;
        }

        /*if(engine.colorSensorLeft.blue() > 0 ) {
            engine.deviceInterfaceModule.setLED(0, true);
        }else{
            engine.deviceInterfaceModule.setLED(0,false);
        }

        if(engine.colorSensorRight.red() > 0 ) {
            engine.deviceInterfaceModule.setLED(1, true);
        }else{
            engine.deviceInterfaceModule.setLED(1,false);
        }*/


    }

}