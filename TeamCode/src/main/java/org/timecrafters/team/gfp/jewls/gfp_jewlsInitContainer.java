package org.timecrafters.team.gfp.jewls;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 2/4/2017.
 */

public class gfp_jewlsInitContainer extends State{

    private Container container;

    public gfp_jewlsInitContainer(Engine engine, Container container) {
        this.engine = engine;
        this.container = container;
    }

    @Override
    public void init() {

        //Winch
        DcMotor winch = engine.hardwareMap.dcMotor.get("dcWinch");
        winch.setDirection(DcMotorSimple.Direction.REVERSE);
        winch.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        container.put(Container.types.DCMOTOR,"winch",winch);

        //Ds Up
        OpticalDistanceSensor dsWinch = engine.hardwareMap.opticalDistanceSensor.get("dsWinch");
        container.put(Container.types.OPTICALDISTANCE,"dsWinch",dsWinch);

        //Left Fork
        DcMotor dcLeftFork = engine.hardwareMap.dcMotor.get("dcLeftFork");
        dcLeftFork.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        container.put(Container.types.DCMOTOR,"leftFork",dcLeftFork);

        //Right Fork
        DcMotor dcRightFork = engine.hardwareMap.dcMotor.get("dcRightFork");
        dcRightFork.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcRightFork.setDirection(DcMotorSimple.Direction.REVERSE);
        container.put(Container.types.DCMOTOR,"rightFork",dcRightFork);


    }

    @Override
    public void exec() {
        setFinished(true);
    }
}
