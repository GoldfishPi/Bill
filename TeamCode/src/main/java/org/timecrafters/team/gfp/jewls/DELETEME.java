package org.timecrafters.team.gfp.jewls;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 2/4/2017.
 */

public class DELETEME extends State {


    private DcMotor winch;
    private OpticalDistanceSensor sensor;

    public DELETEME(Engine engine, Container container) {
        this.container = container;
        this.engine = engine;
    }

    @Override
    public void init() {
        winch = (DcMotor) container.get(Container.types.DCMOTOR,"winch");
        sensor = (OpticalDistanceSensor) container.get(Container.types.OPTICALDISTANCE, "dsWinch");
        //winch.setPower(-1.0);
    }

    @Override
    public void exec() {
        if(sensor.getLightDetected() > 0.016) {
            winch.setPower(1.0);
        }else{
            winch.setPower(0.0);
            setFinished(true);
        }

    }
}
