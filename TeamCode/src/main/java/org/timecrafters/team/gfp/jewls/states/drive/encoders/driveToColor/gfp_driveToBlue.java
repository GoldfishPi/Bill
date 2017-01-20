package org.timecrafters.team.gfp.jewls.states.drive.encoders.driveToColor;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/19/2017.
 */

public class gfp_driveToBlue extends State {

    public int[] directions = new int[4];
    public boolean halt = false;
    private double haltTime;

    public double[] speeds = new double[4];

    public gfp_driveToBlue(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        directions[0] = 1;
        speeds[0] = 0.5;
        directions[1] = 1;
        speeds[1] = 0.1;
        directions[2] = 1;
        speeds[2] = .8;
        directions[3] = 1;
        speeds[3] = 0.3;
    }

    @Override
    public void exec() {
        engine.colorSensorRight.enableLed(true);
        Log.i(TAG, Double.toString(engine.colorSensorRight.blue()));
        engine.telemetry.addData("COLOR : ", engine.colorSensorRight.argb());
        engine.telemetry.update();
        /*if(engine.colorSensorRight.blue() >= 3.0){
            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);

            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);
        }else{
            engine.dcBackLeft.setPower(directions[0] * speeds[0]);
            engine.dcFrontLeft.setPower(directions[1] * speeds[1]);
            engine.dcFrontRight.setPower(directions[2] * speeds[2]);
            engine.dcBackRight.setPower(directions[3] * speeds[3]);
        }*/
    }

    /*
    * loop{
    *   if see blue color{
    *       end
    *   }else{
    *   drive
    *   }
    * }
    * */
}
