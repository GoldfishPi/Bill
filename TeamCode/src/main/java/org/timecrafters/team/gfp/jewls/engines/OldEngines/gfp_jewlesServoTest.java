package org.timecrafters.team.gfp.jewls.engines.OldEngines;

import org.timecrafters.engine.Engine;
import org.timecrafters.team.gfp.jewls.gfp_jewlsInit;
import org.timecrafters.team.gfp.jewls.states.arm.servo.gfp_jewlsArmUpServo;

/**
 * Created by t420 on 1/24/2017.
 */


//@Autonomous(name = "ServoTest", group = "Jewls")
public class gfp_jewlesServoTest extends Engine {
    @Override
    public void setProcesses() {
        processes[0][0] = new gfp_jewlsInit(this);
        processes[1][0] = new gfp_jewlsArmUpServo(this);
    }
}
