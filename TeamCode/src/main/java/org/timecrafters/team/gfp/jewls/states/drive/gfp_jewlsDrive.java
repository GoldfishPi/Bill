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

    @Override
    public void exec() {

        engine.dcBackLeft.setPower(directions[0] * 1.0);
        engine.dcFrontLeft.setPower(directions[1] * 1.0);
        engine.dcFrontRight.setPower(directions[2] * 1.0);
        engine.dcBackRight.setPower(directions[3] * 1.0);

    }

    @Override
    public void stop(){

        engine.dcFrontRight.setPower(-1.0);
        engine.dcFrontLeft.setPower(-1.0);

        engine.dcBackLeft.setPower(-1.0);
        engine.dcBackRight.setPower(-1.0);
        halt = false;
        Log.i(TAG, "SET MOTORS BACKWARD");

    }
}