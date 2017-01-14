package org.timecrafters.team.gfp.jewls.states;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;

/**
 * Created by t420 on 1/14/2017.
 */

public class gfp_jewlsTimer extends State {
    public gfp_jewlsTimer(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {
        engine.addProcess(new gfp_jewlsLoad(engine));
    }
}
