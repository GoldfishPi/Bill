package org.timecrafters.team.gfp.jewls.states.drive.encoders;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.states.drive.gfp_jewlsDrive;

/**
 * Created by t420 on 2/10/2017.
 */

public class gfp_jewlsDriveBackEncoders extends gfp_jewlsDrive {

    public double endPosition;
    public double runTime;
    public DcMotor checkMotor;

    private boolean firstRun = true;
    private double startPosition;

    public  double startTime;

    public gfp_jewlsDriveBackEncoders(Engine engine, double endPosition, double runTime) {

        this.engine = engine;
        this.endPosition = endPosition;
        this.runTime = runTime;

    }

    @Override
    public void init() {

        checkMotor = engine.dcBackRight;
        directions[0] = -1;
        speeds[0] = 0.5;
        directions[1] = -1;
        speeds[1] = 1.0;
        directions[2] = -1;
        speeds[2] = 1.0;
        directions[3] = -1;
        speeds[3] = 0.5;

    }

    @Override
    public void exec() {


        if(firstRun) {
            startTime = System.currentTimeMillis();
            startPosition = checkMotor.getCurrentPosition();
            firstRun = false;
        }

        Log.i(TAG, "CURRENT"+Double.toString((checkMotor.getCurrentPosition())));
        Log.i(TAG,"EXPECTED"+Double.toString(startPosition+endPosition) );
        if ( checkMotor.getCurrentPosition() >= startPosition+endPosition ){

            engine.dcBackLeft.setPower(directions[0] * speeds[0]);
            engine.dcFrontLeft.setPower(directions[1] * speeds[1]);
            engine.dcFrontRight.setPower(directions[2] * speeds[2]);
            engine.dcBackRight.setPower(directions[3] * speeds[3]);

        }else {

            engine.dcFrontRight.setPower(0.0);
            engine.dcFrontLeft.setPower(0.0);

            engine.dcBackLeft.setPower(0.0);
            engine.dcBackRight.setPower(0.0);

            setFinished(true);
        }
    }

    public void setUp(double endPosition, double runForTime, DcMotor motor){
        this.endPosition = endPosition;
        this.runTime = runForTime;
        this.checkMotor = motor;
    }
}
