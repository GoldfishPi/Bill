package org.timecrafters.team.gfp.jewls.states.drive;

import android.util.Log;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/5/2017.
 */


/*
* back left
* front left
* front right
* back right
* */
public class gfp_jewlsDrive extends State {

    public int[] directions = new int[4];
    public boolean halt = false;
    private double haltTime;

    public double[] speeds = new double[4];

    @Override
    public void exec() {

        engine.dcBackLeft.setPower(directions[0] * speeds[0]);
        engine.dcFrontLeft.setPower(directions[1] * speeds[1]);
        engine.dcFrontRight.setPower(directions[2] * speeds[2]);
        engine.dcBackRight.setPower(directions[3] * speeds[3]);

    }

    @Override
    public void stop(){

        engine.dcFrontRight.setPower(0.0);
        engine.dcFrontLeft.setPower(0.0);

        engine.dcBackLeft.setPower(0.0);
        engine.dcBackRight.setPower(0.0);
        halt = false;
        Log.i(TAG, "SET MOTORS BACKWARD");

    }
}