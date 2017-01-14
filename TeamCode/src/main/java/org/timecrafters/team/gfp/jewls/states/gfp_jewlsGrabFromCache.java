package org.timecrafters.team.gfp.jewls.states;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/13/2017.
 */

public class gfp_jewlsGrabFromCache extends State {
    public gfp_jewlsGrabFromCache(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {
        Log.i(TAG,Double.toString(engine.getCacheData(0,0)));
        setFinished(true);
    }
}
