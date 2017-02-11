package org.timecrafters.team.gfp.jewls.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInitContainer;
import org.timecrafters.team.gfp.jewls.states.arm.servo.gfp_jewlsArmServo;
import org.timecrafters.team.gfp.jewls.states.ballcapture.gfp_ballCapture;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.gfp_jewlsDriveForwardEncoders;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.turn.gfp_jewlsDriveEncodersRotateRight;
import org.timecrafters.team.gfp.jewls.states.forks.gfp_jewlsDeploy;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsShoot;
import org.timecrafters.team.gfp.jewls.states.winch.gfp_jewlsWinch;

/**
 * Created by t420 on 2/11/2017.
 */

@Autonomous(name = "JewlsBlue", group = "jewls")
public class gfp_jewlsBlue extends Engine {

    Container container = new Container();

    @Override
    public void setProcesses() {
        processes[0][0] = new gfp_jewlsInit(this);
        processes[0][1] = new gfp_jewlsInitContainer(this, container);
        processes[0][2] = new gfp_jewlsLoad(this);
        processes[1][0] = new gfp_jewlsDeploy(this, container, -50, 0.7);
        processes[2][0] = new gfp_jewlsWinch(this, container, 0.030);
        processes[3][0] = new gfp_jewlsArmServo(this, 1.0);
        processes[4][0] = new gfp_jewlsShoot(this);
        processes[5][0] = new gfp_jewlsLoad(this);

        processes[6][0] = new gfp_jewlsArmServo(this, 0.0);
        processes[6][1] = new gfp_ballCapture(this, 1200);

        processes[7][0] = new gfp_jewlsArmServo(this, 1.0);

        processes[8][0] = new gfp_jewlsShoot(this);
        processes[9][0] = new gfp_jewlsLoad(this);

        processes[10][0] = new gfp_jewlsArmServo(this,0.0);

        processes[11][0] = new gfp_jewlsDriveForwardEncoders(this,600,500);
        processes[12][0] = new gfp_jewlsDriveEncodersRotateRight(this,500,500);
        processes[13][0] = new gfp_jewlsDriveForwardEncoders(this,2250,1000);


    }
}
