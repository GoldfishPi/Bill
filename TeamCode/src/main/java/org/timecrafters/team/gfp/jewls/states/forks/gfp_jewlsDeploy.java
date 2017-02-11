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
    private int turnPos;

    private boolean rightFinished = false;
    private boolean leftFinished = false;

    private double power;

    public gfp_jewlsDeploy(Engine engine, Container container,int turnPos,double power) {

        this.engine = engine;
        this.container = container;
        this.turnPos = turnPos;
        this.power = power;

    }

    @Override
    public void init() {
        leftMotor = (DcMotor)container.get(Container.types.DCMOTOR,"leftFork");
        rightMotor = (DcMotor)container.get(Container.types.DCMOTOR,"rightFork");

    }

    @Override
    public void exec() {

        rightMotor.setTargetPosition(turnPos);
        leftMotor.setTargetPosition(turnPos);

        rightMotor.setPower(power);
        leftMotor.setPower(power);

        if(rightMotor.isBusy() && leftMotor.isBusy()){


        }else{
            setFinished(true);
        }

    }
}
