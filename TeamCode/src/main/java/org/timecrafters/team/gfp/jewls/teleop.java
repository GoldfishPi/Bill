package org.timecrafters.team.gfp.jewls;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsShoot;

/**
 * Created by t420 on 1/16/2017.
 */

public class teleop extends State {

    public teleop(Engine engine) {
        this.engine = engine;
    }

    private boolean loaded = true;
    private double shootTime;

    private double speed = 0.0;

    int[] directions = new int[4];
    double[] speeds = new double[4];

    boolean pushed = false;

    double startingPos;

    @Override
    public void init() {
        startingPos = engine.dcArm.getCurrentPosition();
    }

    @Override
    public void exec() {


        if(engine.gamepad1.dpad_up){
            directions[0] = 1;
            speeds[0] = 0.5;
            directions[1] = 1;
            speeds[1] = 1.0;
            directions[2] = 1;
            speeds[2] = 1.0;
            directions[3] = 1;
            speeds[3] = 0.5;
        }else if(engine.gamepad1.dpad_down){

            directions[0] = -1;
            speeds[0] = 1.0;
            directions[1] = -1;
            speeds[1] = 1.0;
            directions[2] = -1;
            speeds[2] = 1.0;
            directions[3] = -1;
            speeds[3] = 0.5;

        }else if(engine.gamepad1.dpad_left){


            directions[0] = -1;
            speeds[0] = 0.9;
            directions[1] = -1;
            speeds[1] = 1.0;
            directions[2] = 1;
            speeds[2] = 0.9;
            directions[3] = 1;
            speeds[3] = 1.0;

        }else if(engine.gamepad1.dpad_right){

            directions[0] = 1;
            speeds[0] = 1.0;
            directions[1] = 1;
            speeds[1] = 0.9;
            directions[2] = -1;
            speeds[2] = 1.0;
            directions[3] = -1;
            speeds[3] = 0.9;

            /*directions[0] = -1;
            speeds[0] = 0.5;
            directions[1] = -1;
            speeds[1] = 1.0;
            directions[2] = 1;
            speeds[2] = 1.0;
            directions[3] = 1;*/


        }else{
            directions[0] = 1;
            speeds[0] = 0.0;
            directions[1] = 1;
            speeds[1] = 0.0;
            directions[2] = 1;
            speeds[2] = 0.0;
            directions[3] = 1;
            speeds[3] = 0.0;
        }
        setDriveMotors(directions,speeds);

        //load and fire
        if(engine.gamepad1.x){
            engine.addProcess(new gfp_jewlsShoot(engine));
        }
        if(engine.gamepad1.b){
            engine.addProcess(new gfp_jewlsLoad(engine));
        }

        if(engine.gamepad1.y){
            engine.dcArm.setPower(-0.5);
        }else if(engine.gamepad1.a){
            engine.dcArm.setPower(0.5);
        }else {
            engine.dcArm.setPower(0.0);
        }

        engine.telemetry.addData("Speed", speed);
        engine.telemetry.update();
        if(engine.gamepad1.right_bumper){
            engine.svRightFront.setPower(-1.0);
            engine.svLeftFront.setPower(1.0);
        }else{
            engine.svRightFront.setPower(0.0);
            engine.svLeftFront.setPower(0.0);
        }

        if(engine.gamepad1.right_trigger >= 0.2){
            if(!pushed) {
                speed -= 0.1;
                pushed = true;
            }
        }else if (engine.gamepad1.right_bumper ){
            if(!pushed) {
                speed += 0.1;
                pushed = true;
            }

        }else{
            pushed = false;
        }

    }

     public void setDriveMotors(int[] directions, double[] speeds){
        engine.dcBackLeft.setPower(directions[0] * speeds[0]);
        engine.dcFrontLeft.setPower(directions[1] * speeds[1]);
        engine.dcFrontRight.setPower(directions[2] * speeds[2]);
        engine.dcBackRight.setPower(directions[3] * speeds[3]);
    }
}
