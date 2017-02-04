package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.DELETEME;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInitContainer;
import org.timecrafters.team.gfp.jewls.states.forks.gfp_jewlsDeploy;

/**
 * Created by t420 on 2/4/2017.
 */

@Autonomous(name = "JewlsRed", group = "jewls" )
public class gfp_jewlsRed extends Engine {

    Container container = new Container();

    @Override
    public void setProcesses() {

        processes[0][0] = new gfp_jewlsInit(this);
        processes[0][1] = new gfp_jewlsInitContainer(this, container);
        processes[1][0] = new DELETEME(this, container);
        processes[2][0] = new gfp_jewlsDeploy(this, container,1000);


    }
}
