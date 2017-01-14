package org.timecrafters.team.gfp.jewls.states;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/13/2017.
 */

public class gfp_jewlsAddToCache extends State {
    public gfp_jewlsAddToCache(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {
        engine.addCacheData(0,0,0.1);
        setFinished(true);
    }
}
