package org.timecrafters.engine.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.caseBase;
import org.timecrafters.engine.engine;

/**
 * Created by t420 on 9/29/2016.
 */

@Autonomous(name = "Test:Runtime", group = "Goldfish")
public class runtimeTest extends engine {

    public runtimeTest(){

    }
    private inheratencetTest it = new inheratencetTest();

    @Override
    public void setProcesses() {
        processes[0] = new inheratencetTest();

    }
}