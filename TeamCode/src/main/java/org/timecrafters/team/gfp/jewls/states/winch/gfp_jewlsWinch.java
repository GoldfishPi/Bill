package org.timecrafters.team.gfp.jewls.states.winch;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.timecrafters.engine.Container;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 2/4/2017.
 */

public class gfp_jewlsWinch extends State {


    private DcMotor winch;
    private OpticalDistanceSensor sensor;

    private double distance;

    private boolean firstrun = true;

    private double initalDistance;

    public gfp_jewlsWinch(Engine engine, Container container, double distance) {
        this.container = container;
        this.engine = engine;
        this.distance = distance;
    }

    @Override
    public void init() {
        winch = (DcMotor) container.get(Container.types.DCMOTOR,"winch");
        sensor = (OpticalDistanceSensor) container.get(Container.types.OPTICALDISTANCE, "dsWinch");
        //winch.setPower(-1.0);

        engine.telemetry.addData(TAG,sensor.getLightDetected());
        engine.telemetry.update();
    }

    @Override
    public void exec() {

        if(firstrun){

            initalDistance = averageSensors(55);

            firstrun = false;
        }

        engine.telemetry.addData(TAG,averageSensors(10));
        engine.telemetry.update();

        if(distance > initalDistance){
            if(distance > averageSensors(3) ){
                winch.setPower(-1.0);
            }else{
                winch.setPower(0.0);
                setFinished(true);
            }
        }else{
            if(distance < averageSensors(3) ){
                winch.setPower(1.0);
            }else{
                winch.setPower(0.0);
                setFinished(true);
            }
        }

        /*
        if(sensor.getLightDetected() > distance) {
            winch.setPower(1.0);
        }else if(sensor.getLightDetected() < distance){
            winch.setPower(-1.0);
        }*/

    }

    public double averageSensors(int sampleSize){

        double[] inputs = new double[2];
        double sum = 0;

        for(int i = 0; i < sampleSize; i++){

            sum += sensor.getLightDetected();

        }

        return  sum/sampleSize;

    }


}
