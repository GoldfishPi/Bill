package org.timecrafters.engine.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;

/**
 * Created by t420 on 9/29/2016.
 */

@Autonomous(name = "Test:Runtime", group = "Goldfish")
public class RuntimeTest extends Engine {

    public RuntimeTest(){
        processes = this.processes;
    }
    private InheratencetTest it = new InheratencetTest(this);


    @Override
    public void setProcesses() {
        processes[0][0] = new InheratencetTest(this);
        //processes[0][1] = new TouchSensorTest(this);

    }
}