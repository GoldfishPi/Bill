package org.timecrafters.team.gfp.jewls.states.drive.encoders;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.team.gfp.jewls.states.drive.gfp_jewlsDrive;

/**
 * Created by t420 on 1/18/2017.
 */

public class gfp_jewlsDriveEncoders extends gfp_jewlsDrive {

    public double endPosition;
    public double runTime;
    public DcMotor checkMotor;

    private boolean firstRun = true;
    private double startPosition;

    public  double startTime;

    @Override
    public void exec() {


        if(firstRun) {
            startTime = System.currentTimeMillis();
            startPosition = checkMotor.getCurrentPosition();
            firstRun = false;
        }
        if ( (startPosition+ endPosition) - checkMotor.getCurrentPosition()  >= 0 ){

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
