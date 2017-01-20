package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmInit;
import org.timecrafters.team.gfp.jewls.teleop;

/**
 * Created by t420 on 1/6/2017.
 */

@TeleOp(name = "TeleOp", group = "Jewls")
public class gfp_jewlsTele extends Engine {

    @Override
    public void setProcesses(){
        processes[0][0] = new gfp_jewlsInit(this);
        processes[0][1] = new gfp_jewlsArmInit(this);

        //processes[1][0] = new gfp_jewlsLoad(this);

        processes[1][0] = new teleop(this);


    }
}
