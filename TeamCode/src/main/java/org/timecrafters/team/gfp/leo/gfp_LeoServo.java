package org.timecrafters.team.gfp.leo;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 11/22/2016.
 */

public class gfp_LeoServo extends State
{
    int servonum;
    double position;
    public gfp_LeoServo(Engine engine,int servonum,double position ){
        this.engine = engine;
        this.servonum = servonum;
        this.position = position;
    }

    @Override
    public void init(){}

    @Override
    public void exec(){
       if(servonum == 0){
           engine.svLeftBack.setPosition(position);
       }
        else  if(servonum == 1){
           engine.svLeftBack.setPosition(position);
       }
        setFinished(true);
    }
}
