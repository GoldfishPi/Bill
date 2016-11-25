package org.timecrafters.team;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 10/18/2016.
 */

public class team_blankState extends State {

    public team_blankState(Engine engine){
        this.engine = engine;
    }

    @Override
    public void init(){

    }

    @Override
    public void exec(){
        setFinished(true);
    }
}
