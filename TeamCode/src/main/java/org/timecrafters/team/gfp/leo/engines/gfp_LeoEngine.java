package org.timecrafters.team.gfp.leo.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.leo.drive.gfp_LeoDrive;
import org.timecrafters.team.gfp.leo.drive.gfp_LeoDriveLeft;
import org.timecrafters.team.gfp.leo.drive.gfp_LeoDriveRight;
import org.timecrafters.team.gfp.leo.gfp_LeoInit;
import org.timecrafters.team.gfp.leo.sensor.color.gfp_LeoColorSensor;
import org.timecrafters.team.gfp.leo.sensor.color.gfp_LeoColorSensorLeft;

/**
 * Created by t420 on 11/1/2016.
 */

@Autonomous(name = "LEO:Drive", group = "LEO")
public class gfp_LeoEngine extends Engine {
    byte frontRangeSensor = 0;
    byte rightRangeSensor = 1;
    double sen = 0.5;

    @Override
    public void setProcesses() {
        /*
        * 0 left back
        * 1 right back
        * 2 presser d
        * 3 shooter*/
        processes[0][0] = new gfp_LeoInit(this);
        processes[1][0] = new gfp_LeoColorSensorLeft(this, 0.5);
        processes[1][1] = new gfp_LeoDriveLeft(this,0.5,processes[1][1]);
        processes[1][2] = new gfp_LeoDriveRight(this,0.5,processes[1][2]);
    }
}
