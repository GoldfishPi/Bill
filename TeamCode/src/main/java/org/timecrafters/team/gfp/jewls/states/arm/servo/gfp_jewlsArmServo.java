package org.timecrafters.team.gfp.jewls.states.arm.servo;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/30/2017.
 */

public class gfp_jewlsArmServo extends State {

    double pos;

    public gfp_jewlsArmServo(Engine engine, double position) {
        this.engine = engine;
        this.pos = position;
    }   //swosodnf asiudmfna0s

    @Override
    public void init() {

        /*double currentPositionTop = engine.topArm.getPosition();
        double currentPositionBottum = engine.bottumArm.getPosition();*/

        engine.topArm.setPosition(0);
        engine.bottumArm.setPosition(0);


    }

    @Override
    public void exec() {

        engine.topArm.setPosition(pos);
        engine.bottumArm.setPosition(pos);

        Log.i(TAG, Double.toString(engine.topArm.getPosition()));


        setFinished(true);

        if (engine.topArm.getPosition() == pos && engine.bottumArm.getPosition() == pos) {
            setFinished(true);
        }
    }

    @Override
    public void stop() {

        /*double currentPositionTop = engine.topArm.getPosition();
        double currentPositionBottum = engine.bottumArm.getPosition();

        engine.topArm.setPosition(currentPositionTop);
        engine.bottumArm.setPosition(currentPositionBottum);*/
    }
}


