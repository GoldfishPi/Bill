package org.timecrafters.team.EV;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by cyber on 12/15/2016.
 */

public class EV_thisIsJustAState extends State {

    public EV_thisIsJustAState (Engine engine ){

        this.engine = engine;

    }

    @Override
    public void init(){


    }
    @Override
    public void exec() {

        for (int times = 0; times < 100) {
            engine.dcFrontRight.setPower(1.0);
            engine.dcFrontLeft.setPower(1.0);
            engine.dcBackRight.setPower(1.0);
            engine.dcBackLeft.setPower(1.0);

        }
        setFinished(true);

    }
}
