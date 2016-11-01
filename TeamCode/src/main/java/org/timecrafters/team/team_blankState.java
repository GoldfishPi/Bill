package org.timecrafters.team;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 10/18/2016.
 */

public class team_blankState extends State {


    @Override
    public void init(){

    }

    @Override
    public void exec(){
        setFinished(true);
    }
}
