package org.timecrafters.team.gfp.leo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 11/1/2016.
 */

@Autonomous(name = "Leo Light Finder", group = "LEO")
public class gfp_LeoEngine extends Engine {

    @Override
    public void setProcesses(){

        processes[0][0] = new gfp_LeoInit(this);
        processes[1][0] = new gfp_LeoDriveForward(this);
        processes[2][0] = new gfp_LeoTurnRight();
        processes[3][0] = new gfp_LeoDriveToLight();
        processes[4][0] = new gfp_LeoPressButton();

    }
}
