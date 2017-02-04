package org.timecrafters.team.gfp.jewls.engines.OldEngines;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;

/**
 * Created by t420 on 1/31/2017.
 */


//@Autonomous(name = "TableTest", group = "Jewls")
public class gfp_jewlsHashTest extends Engine {

    private Container container = new Container();

    @Override
    public void setProcesses() {
        processes[0][0] = new gfp_jewlsInit(this);
        container.put(Container.types.DCMOTOR, "dc", dcBackLeft);
    }
}
