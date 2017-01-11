package org.timecrafters.team.gfp.jewls.engines;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;

/**
 * Created by t420 on 1/6/2017.
 */

public class gfp_jewlsTele extends Engine {

    @Override
    public void setProcesses(){
        processes[0][0] = new gfp_jewlsInit(this);

    }
}
