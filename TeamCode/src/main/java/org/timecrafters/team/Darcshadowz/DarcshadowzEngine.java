package org.timecrafters.team.Darcshadowz;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;

/**
 * Created by cyber on 1/3/2017.
 */
@TeleOp(name = "The Springy Device", group = "Team")
public class DarcshadowzEngine extends Engine {
    @Override
    public void setProcesses() {
        processes[0][0] = new DarcshadowzState(this);


    }
}
