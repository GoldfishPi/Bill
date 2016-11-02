package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/1/2016.
 */

public class gfp_LeoDistanceSensor extends State {

    public volatile boolean isFinished = false;
    public volatile double distance;
    public gfp_LeoDistanceSensor(OpMode opmode){
        this.opMode = opmode;
    }

    @Override
    public void init(){

    }

    public void exec(){
        if (!isFinished) {
            distance = distanceSensorFront.getUltrasonicLevel();
        }
    }
}
