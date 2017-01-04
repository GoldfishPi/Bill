package org.timecrafters.team.EV;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 12/15/2016.
 */

public class EV_init extends State {

    public EV_init (Engine engine){

        this.engine = engine;
    }
    @Override

    public void init(){

        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("frontRight");
        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("frontLeft");
        engine.dcBackRight = engine.hardwareMap.dcMotor.get("backRight");
        engine.dcBackLeft = engine.hardwareMap.dcMotor.get("backLeft");


    }

    @Override
    public void exec(){

        setFinished(true);

    }

}
