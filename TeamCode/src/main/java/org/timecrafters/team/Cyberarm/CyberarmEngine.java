package org.timecrafters.team.Cyberarm;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;

/**
 * Created by cyber on 1/3/2017.
 */
@TeleOp(name = "Led Control", group = "Team")
public class CyberarmEngine extends Engine {
    @Override
    public void setProcesses() {
        processes[0][0] = new CyberarmLEDState(this);

    }
}
