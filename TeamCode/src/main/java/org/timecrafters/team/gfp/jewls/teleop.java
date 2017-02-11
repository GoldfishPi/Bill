package org.timecrafters.team.gfp.jewls;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsShoot;

/**
 * Created by t420 on 1/16/2017.
 */

public class teleop extends State {

    private boolean loaded = true;
    private double shootTime;

    private double speed = 0.0;

    int[] directions = new int[4];
    double[] speeds = new double[4];

    boolean pushed = false;

    boolean ypushed = false;

    boolean startPressed = false;

    double startingPos;

    DcMotor winch;

    DcMotor leftFork;
    DcMotor rightFork;

    Servo presser;

    int inverse = 1;

    boolean xPressed = false;

    private double drivSspeed = 0.5;

    public teleop(Engine engine, Container container) {
        this.engine = engine;
        this.container = container;
    }

    @Override
    public void init() {

        winch = (DcMotor)container.get(Container.types.DCMOTOR,"winch");
        leftFork = (DcMotor)container.get(Container.types.DCMOTOR,"leftFork");
        leftFork.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightFork = (DcMotor)container.get(Container.types.DCMOTOR,"rightFork");
        rightFork.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        presser = (Servo)container.get(Container.types.SERVO,"presser");




    }

    @Override
    public void exec() {

        if(!startPressed && engine.gamepad1.start){
            inverse *= -1;
            startPressed = true;

        }else if(!engine.gamepad1.start){
            startPressed = false;
        }

        if(engine.gamepad1.y){
            engine.topArm.setPosition(200);
            engine.bottumArm.setPosition(200);
        }
        if(engine.gamepad1.a){
            engine.topArm.setPosition(0);
            engine.bottumArm.setPosition(0);
        }

        if(engine.gamepad1.dpad_up){
            directions[0] = 1;
            speeds[0] = drivSspeed;
            directions[1] = 1;
            speeds[1] = drivSspeed;
            directions[2] = 1;
            speeds[2] = drivSspeed;
            directions[3] = 1;
            speeds[3] = drivSspeed;
        }else if(engine.gamepad1.dpad_down){

            directions[0] = -1;
            speeds[0] = drivSspeed;
            directions[1] = -1;
            speeds[1] = drivSspeed;
            directions[2] = -1;
            speeds[2] = drivSspeed;
            directions[3] = -1;
            speeds[3] = drivSspeed;

        }else if(engine.gamepad1.dpad_left){

            //backleft
            directions[0] = -1;
            speeds[0] = drivSspeed;
            //front left
            directions[1] = -1;
            speeds[1] = drivSspeed;
            //front right
            directions[2] = 1;
            speeds[2] = drivSspeed;
            //back right
            directions[3] = 1;
            speeds[3] = drivSspeed;

        }else if(engine.gamepad1.dpad_right){

            directions[0] = 1;
            speeds[0] = drivSspeed;
            directions[1] = 1;
            speeds[1] = drivSspeed;
            directions[2] = -1;
            speeds[2] = drivSspeed;
            directions[3] = -1;
            speeds[3] = drivSspeed;


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
        if(engine.gamepad1.x && !xPressed){
            engine.addProcess(new gfp_jewlsShoot(engine));
            xPressed = true;
        }else{
            xPressed = false;
        }
        if(engine.gamepad1.b){
            engine.addProcess(new gfp_jewlsLoad(engine));
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

        if(engine.gamepad1.right_trigger > 0.2){
            drivSspeed = 0.5;
        }
        if(engine.gamepad1.left_trigger > 0.2){
            drivSspeed = 1.0;
        }

        /*
        *
        * GAMEPAD TWO
        *
        *
        * */

        if(engine.gamepad2.y){
            winch.setPower(1.0);
            Log.i(TAG, "Y PRESSED");

        }else if(engine.gamepad2.a){
            winch.setPower(-1.0);
        }else{
            winch.setPower(0.0);
        }

        if(engine.gamepad2.left_bumper){
            leftFork.setTargetPosition(leftFork.getCurrentPosition() + 100);
            rightFork.setTargetPosition(rightFork.getCurrentPosition() + 100);
        }

        if (engine.gamepad2.left_trigger > 0.2){

            leftFork.setTargetPosition(leftFork.getCurrentPosition() - 100);
            rightFork.setTargetPosition(rightFork.getCurrentPosition() - 100);

        }if(!engine.gamepad2.left_bumper && engine.gamepad2.left_trigger < 0.2){

            leftFork.setTargetPosition(leftFork.getCurrentPosition());
            rightFork.setTargetPosition(rightFork.getCurrentPosition());
            engine.telemetry.addData("wordes","No tongs in controll currently");
            engine.telemetry.update();

        }

        leftFork.setPower(1.0);
        rightFork.setPower(1.0);

        if(engine.gamepad2.x){
            presser.setPosition(180);
        }else if(engine.gamepad2.b){
            presser.setPosition(0);
        }

    }

     public void setDriveMotors(int[] directions, double[] speeds){
        engine.dcBackLeft.setPower(directions[0] * speeds[0]*inverse);
        engine.dcFrontLeft.setPower(directions[1] * speeds[1]*inverse);
        engine.dcFrontRight.setPower(directions[2] * speeds[2]*inverse);
        engine.dcBackRight.setPower(directions[3] * speeds[3]*inverse);
    }
}