package org.timecrafters.team.gfp.leo;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/3/2016.
 */

public class gfp_LeoDriveTest extends State {

    public  gfp_LeoDriveTest(Engine engine){
        this.engine = engine;
    }

    public double range = .5;
    @Override
    public void init(){

    }

    public void exec(){
        if(engine.colorSensorRight.blue() > range){
            engine.dcBackLeft.setPower(0.5);
            engine.dcBackRight.setPower(0.5);
        }
        else if(engine.colorSensorRight.red() > range){
            engine.dcBackLeft.setPower(-0.5);
            engine.dcBackRight.setPower(-0.5);
        }else{
            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);
        }
        engine.dcPresser.setPower(0.5);

    }
}
