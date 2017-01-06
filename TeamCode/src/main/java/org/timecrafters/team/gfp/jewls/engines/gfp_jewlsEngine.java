package org.timecrafters.team.gfp.jewls.engines;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.drive.gfp_jewlsDrive;

/**
 * Created by t420 on 1/5/2017.
 */

public class gfp_jewlsEngine extends Engine {

    @Override
    public void setProcesses(){
        processes[0][0] = new gfp_jewlsInit(this);

    }
}
