package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmInit;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;
import org.timecrafters.team.gfp.jewls.teleop;

/**
 * Created by t420 on 1/5/2017.
 */

@TeleOp(name = "Jewls", group = "Jewls")
public class gfp_jewlsEngine extends Engine {

    @Override
    public void setProcesses(){
        processes[0][0] = new gfp_jewlsInit(this);
        processes[0][1] = new gfp_jewlsArmInit(this);

        processes[1][0] = new gfp_jewlsLoad(this);
        //processes[2][0] = new gfp_jewlsArmUp(this);
        processes[2][0] = new teleop(this);

        /*processes[1][0] = new gfp_jewlsLoad(this);
        processes[2][0] = new gfp_jewlsShoot(this);*/

        /*
        * Remind Goldfish to transfer xmage images it takes a long ass time to download them
        * */

    }
}


