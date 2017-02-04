package org.timecrafters.team.gfp.jewls.states.arm.servo;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/30/2017.
 */

public class gfp_jewlsArmUpServo extends State{

    public gfp_jewlsArmUpServo(Engine engine) {
        this.engine = engine;
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

        engine.topArm.setPosition(180);
        engine.bottumArm.setPosition(180);

        //Yog soron
        // Doom sayer
        //remind me to stop writing random things like a crazzy person.

        //
    }

    @Override
    public void stop() {

        /*double currentPositionTop = engine.topArm.getPosition();
        double currentPositionBottum = engine.bottumArm.getPosition();

        engine.topArm.setPosition(currentPositionTop);
        engine.bottumArm.setPosition(currentPositionBottum);*/
    }
}


