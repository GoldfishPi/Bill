package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmDown;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmInit;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmUp;
import org.timecrafters.team.gfp.jewls.states.ballcapture.gfp_ballCapture;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsShoot;

/**
 * Created by t420 on 1/5/2017.
 */

@Autonomous(name = "Jewls", group = "Jewls")
public class gfp_jewlsEngine extends Engine {

    @Override
    public void setProcesses(){

        processes[0][0] = new gfp_jewlsInit(this);
        processes[1][0] = new gfp_jewlsLoad(this);
        processes[1][1] = new gfp_jewlsArmInit(this);

        processes[2][0] = new gfp_jewlsArmDown(this, 1500.0);
        processes[3][0] = new gfp_jewlsShoot(this);
        processes[4][0] = new gfp_jewlsLoad(this);

        processes[5][0] = new gfp_jewlsArmUp(this, 1500.0);
        processes[6][0] = new gfp_ballCapture(this, 500.0);

        processes[7][0] = new gfp_jewlsArmDown(this, 1000.0);
        processes[8][0] = new gfp_jewlsShoot(this);
        processes[9][0] = new gfp_jewlsLoad(this);



    }
}


