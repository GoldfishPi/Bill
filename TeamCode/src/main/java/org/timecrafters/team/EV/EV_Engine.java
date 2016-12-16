package org.timecrafters.team.EV;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;

/**
 * Created by cyber on 12/15/2016.
 */
@Autonomous(name = "beautiful baby", group = "Team")
public class EV_Engine extends Engine {

    @Override
    public void setProcesses() {
        processes[0][0] = EV_thisIsJustAState(this);

    }
}
