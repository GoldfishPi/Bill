package org.timecrafters.team.gfp.jewls.states.sensors.distance.optical;

import android.util.Log;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 1/13/2017.
 */

public class gfp_jewlsOpticalDistanceSensor extends State {
    public gfp_jewlsOpticalDistanceSensor(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void exec() {
        Log.i(TAG, Double.toString(engine.dsFront.getRawLightDetected()));
        engine.telemetry.addData("dsFront", engine.dsFront.getLightDetected());
        engine.telemetry.update();
    }
}
