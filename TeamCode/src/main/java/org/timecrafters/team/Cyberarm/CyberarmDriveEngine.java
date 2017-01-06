package org.timecrafters.team.Cyberarm;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;

/**
 * Created by cyber on 1/5/2017.
 */

@TeleOp(name = "Mentor's Drive", group = "Team")
public class CyberarmDriveEngine extends Engine {
    @Override
    public void setProcesses() {
        processes[0][0] = new CyberarmDriveState(this);

    }

    @Override
    public void stop() {
        processes[0][0].setFinished(true);
    }
}
