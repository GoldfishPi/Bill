package org.timecrafters.team.gfp.jewls.engines.OldEngines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInitContainer;
import org.timecrafters.team.gfp.jewls.states.drive.driveToColor.gfp_jewlsDriveToRed;
import org.timecrafters.team.gfp.jewls.states.servo.gfp_jewlsButtonPress;

/**
 * Created by t420 on 1/24/2017.
 */


@Autonomous(name = "ServoTest", group = "Jewls")
public class gfp_jewlesServoTest extends Engine {
    Container container = new Container();
    @Override
    public void setProcesses() {
        processes[0][0] = new gfp_jewlsInit(this);
        processes[0][1] = new gfp_jewlsInitContainer(this,container);
        //processes[1][0] = new gfp_jewlsDriveBalance(this,0.1);

        processes[1][0] = new gfp_jewlsDriveToRed(this,0.1,2.0);
        processes[2][0] = new gfp_jewlsButtonPress(this,container,0.0);
    }
}
