package org.timecrafters.team.gfp.jewls.states.servo;

import com.qualcomm.robotcore.hardware.Servo;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 2/11/2017.
 */

public class gfp_jewlsButtonPress extends State {

    Servo servo;
    double pos;

    public gfp_jewlsButtonPress(Engine engine, Container container,double pos) {

        this.engine = engine;
        this.container = container;
        this.pos = pos;

    }

    @Override
    public void init() {

            servo = (Servo) container.get(Container.types.SERVO, "presser");

    }

    @Override
    public void exec() {

        servo.setPosition(pos);

        if(servo.getPosition() == pos) {
            setFinished(true);
        }

    }
}
