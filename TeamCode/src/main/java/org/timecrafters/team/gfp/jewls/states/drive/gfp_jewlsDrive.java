package org.timecrafters.team.gfp.jewls.states.drive;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

import static org.firstinspires.ftc.teamcode.R.layout.motor;

/**
 * Created by t420 on 1/5/2017.
 */

public class gfp_jewlsDrive extends State {


    double speeds[] = new double[3];
    DcMotor motors[] = new DcMotor[3];

    double average;
    double distanceSet;

    @Override
    public void exec() {

        for (int i = 0; i < speeds.length; i++){
            average += motors[0].getCurrentPosition();
        }
        average /= motors.length;

        if(distanceSet <= average) {
            for(int i = 0; i < motors.length;i++){
                motors[i].setPower(speeds[i]);
            }
        }else{
            for(int i = 0; i < motors.length;i++){
                motors[i].setPower(0);
            }
        }
    }

    @Override
    public void stop(){
        for(int i = 0; i < motors.length;i++){
            motors[i].setPower(0);
        }
    }

    public void setDistance(double distance){
        distanceSet = distance;
    }

    public void setMotors(DcMotor motor, Double speed, int index){
        motors[index] = motor;
        speeds[index] = speed;
    }
}