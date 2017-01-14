package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmUp;
import org.timecrafters.team.gfp.jewls.states.drive.gfp_jewlsDriveRight;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;

/**
 * Created by t420 on 1/5/2017.
 */

@Autonomous(name = "Jewls", group = "Jewls")
public class gfp_jewlsEngine extends Engine {

    @Override
    public void setProcesses(){
        processes[0][0] = new gfp_jewlsInit(this);

        processes[1][0] = new gfp_jewlsLoad(this);
        processes[2][0] = new gfp_jewlsArmUp(this);
        processes[2][1] = new gfp_jewlsDriveRight(this);

        /*processes[1][0] = new gfp_jewlsLoad(this);
        processes[2][0] = new gfp_jewlsShoot(this);*/

    }
}
