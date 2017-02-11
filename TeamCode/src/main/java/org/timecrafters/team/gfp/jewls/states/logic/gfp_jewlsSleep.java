package org.timecrafters.team.gfp.jewls.states.logic;

import org.timecrafters.engine.State;

/**
 * Created by t420 on 2/11/2017.
 */

public class gfp_jewlsSleep extends State {


    double time;
    boolean firstrun = true;
    double startTime;

    public gfp_jewlsSleep(double time) {
        this.time = time;
    }

    @Override
    public void exec() {

        if(firstrun){
            startTime = System.currentTimeMillis();
            firstrun = false;
        }

        if(System.currentTimeMillis() -( startTime + time) <= 0){
            setFinished(true);
        }

    }
}
