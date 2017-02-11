package org.timecrafters.team.gfp.jewls.engines.OldEngines;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.arm.gfp_jewlsArmInit;
import org.timecrafters.team.gfp.jewls.states.drive.driveToColor.gfp_jewlsDriveToRed;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.gfp_jewlsDriveForwardEncoders;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.turn.gfp_jewlsDriveEncodersRotateLeft;
import org.timecrafters.team.gfp.jewls.states.drive.encoders.turn.gfp_jewlsDriveEncodersRotateRight;
import org.timecrafters.team.gfp.jewls.states.drive.sensors.gfp_jewlsDriveToDistance;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jelsShooterInit;
import org.timecrafters.team.gfp.jewls.states.shooter.gfp_jewlsLoad;

/**
 * Created by t420 on 1/5/2017.
 */

//@Autonomous(name = "Jewls", group = "Jewls")
public class gfp_jewlsEngine extends Engine {

    @Override
    public void setProcesses(){

        processes[0][0] = new gfp_jewlsInit(this);
        processes[1][0] = new gfp_jewlsLoad(this);
        processes[1][1] = new gfp_jewlsArmInit(this);
        processes[1][2] = new gfp_jelsShooterInit(this);

        /*processes[2][0] = new gfp_jewlsArmDown(this, 1500.0);
        processes[3][0] = new gfp_jewlsShoot(this);
        processes[4][0] = new gfp_jewlsLoad(this);

        processes[5][0] = new gfp_jewlsArmUp(this, 1500.0);

        processes[6][0] = new gfp_jewlsArmDown(this, 2000.0);
        processes[7][0] = new gfp_jewlsShoot(this);
        processes[8][0] = new gfp_jewlsLoad(this);

        processes[9][0] = new gfp_jewlsArmUp(this,1500.0);*/

        processes[2][0] = new gfp_jewlsDriveForwardEncoders(this, 300.0, 300.0);
        processes[3][0] = new gfp_jewlsDriveEncodersRotateLeft(this,1575, 2000.0);
        processes[4][0] = new gfp_jewlsDriveForwardEncoders(this, 8200.0, 1000.0);
        processes[5][0] = new gfp_jewlsDriveEncodersRotateRight(this, 500.0,1000.0);
        processes[6][0] = new gfp_jewlsDriveToDistance(this, 16);
        processes[7][0] = new gfp_jewlsDriveEncodersRotateRight(this, 500.0, 1000.0);
        processes[8][0] = new gfp_jewlsDriveToDistance(this, 8);
        processes[9][0] = new gfp_jewlsDriveToRed(this,0.25,0.2);
        processes[10][0] = new gfp_jewlsDriveEncodersRotateRight(this, 500, 1000.0);




        //processes[2][0] = new gfp_jewlsDriveBalance(this);

        //processes[15][0] = new gfp_driveToBlue(this);

        /*//driving to becon routine
        processes[2][0] = new gfp_jewlsDriveEncodersRotateLeft(this,2000.0, 2000.0);
        processes[3][0] = new gfp_jewlsDriveForwardEncoders(this, 6500.0, 1000.0);

        processes[4][0] = new gfp_jewlsDriveEncodersRotateRight(this, 1500.0, 1000.0 );*/


        //Inital shooting balls rutine
        /*processes[2][0] = new gfp_jewlsArmDown(this, 1500.0);
        processes[3][0] = new gfp_jewlsShoot(this);
        processes[4][0] = new gfp_jewlsLoad(this);

        processes[5][0] = new gfp_jewlsArmUp(this, 1500.0);
        processes[6][0] = new gfp_ballCapture(this, 500.0);

        processes[7][0] = new gfp_jewlsArmDown(this, 1000.0);
        processes[8][0] = new gfp_jewlsShoot(this);
        processes[9][0] = new gfp_jewlsLoad(this);

        processes[10][0] = new gfp_jewlsArmUp(this,500.0);
        */



    }
}


