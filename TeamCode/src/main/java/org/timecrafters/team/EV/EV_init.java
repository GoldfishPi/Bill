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
        /*
    * NAME YOUR CONFIG FILES THE SAME AS IN ROBOT PREFS
    * */

        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        engine.dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontLeft");
        engine.dcBackRight = engine.hardwareMap.dcMotor.get("dcBackRight");
        engine.dcBackLeft = engine.hardwareMap.dcMotor.get("dcBackLeft");


    }

    @Override
    public void exec(){

        setFinished(true);

    }

}
