package org.timecrafters.team.gfp.jewls.states.forks;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 2/4/2017.
 */

public class gfp_jewlsDeploy extends State {

    DcMotor leftMotor;
    DcMotor rightMotor;

    private boolean firstRun = true;
    private double startingPos;
    private double turnPos;

    public gfp_jewlsDeploy(Engine engine, Container container,double turnPos) {

        this.engine = engine;
        this.container = container;
        this.turnPos = turnPos;

    }

    @Override
    public void init() {
        leftMotor = (DcMotor)container.get(Container.types.DCMOTOR,"leftFork");
        rightMotor = (DcMotor)container.get(Container.types.DCMOTOR,"rightFork");

    }

    @Override
    public void exec() {
        if(firstRun){

            startingPos = leftMotor.getCurrentPosition();

            firstRun = false;
        }

        if(leftMotor.getCurrentPosition() + turnPos >= 0) {
            leftMotor.setPower(-1.0);
            rightMotor.setPower(-1.0);
        }
        else{
            leftMotor.setPower(0);
            rightMotor.setPower(0);
        }
    }
}
