package org.timecrafters.team;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
/**
 * Created by t420 on 10/18/2016.
 */

@Autonomous(name = "Blank Machine", group = "Team")
public class team_blankMachine extends Engine {
    @Override
    public void setProcesses() {

        processes[0][0] = new team_blankState(this);
        //processes[1] = state;
        //processes[2] = state;
    }
}
