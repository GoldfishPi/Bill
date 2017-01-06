package org.timecrafters.team.gfp;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/5/2017.
 */

public class gfp_jewlsInit extends State {

    public gfp_jewlsInit(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init(){
        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        engine.dcFrontLeft  = engine.hardwareMap.dcMotor.get("dcFrontLeft");
        engine.dcBackRight  = engine.hardwareMap.dcMotor.get("dcBackRight");
        engine.dcBackLeft   = engine.hardwareMap.dcMotor.get("dcBackLeft");
    }

    @Override
    public void exec(){
        setFinished(true);
    }
}
