package org.timecrafters.team.gfp.jewls.states.servo;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/24/2017.
 */

public class servo extends State {

    public servo(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        engine.buttonPresser.setPosition(0.0);
    }

    @Override
    public void exec() {
        engine.buttonPresser.setPosition(180.0);
    }
}
