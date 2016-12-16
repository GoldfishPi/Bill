package org.timecrafters.engine;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by t420 on 9/29/2016.
 * First sucess ful test was 5:00 6 thur oct 2016
 */
/*

::::::::: ::::::::::: :::        :::
:+:    :+:    :+:     :+:        :+:
+:+    +:+    +:+     +:+        +:+
+#++:++#+     +#+     +#+        +#+
+#+    +#+    +#+     +#+        +#+
#+#    #+#    #+#     #+#        #+#
######### ########### ########## ##########

 */
//metron
    //multi engineered threading reconizing organizing

public abstract class Engine extends RobotPrefs {

    public State[][] processes = new State[100][100];
    private Thread[] threads = new Thread[100];
    private int threadX = 0;


    private static String TAG = "PROGRAM.ENGINE: ";
    private int x = 0;
    private int currentProcess = 0;
    private boolean machineFinished = false;
    private boolean opFininished = true;

    public void init() {
        setProcesses();
        for(int i = 0;i < processes.length;i++) {
            for (int y = 0; y < processes.length; y++) {
                if(processes[i][y] != null) {
                    processes[i][y].init();
                    Log.i(TAG, "INIT" + "[" + Integer.toString(i) + "]" + "[" + Integer.toString(y) + "]");
                }
            }
        }
    }

    public void loop() {
        if (!opFininished && !machineFinished) {
            for (int y = 0; y < processes.length; y++) {

                if (processes[x][y] != null) {
                    if (processes[x][y].isFinished) {
                        opFininished = true;
                        Log.i(TAG, "FINISHED OP : " + "[" + Integer.toString(x) + "]" + "[" + Integer.toString(y) + "]");
                    } else {
                        opFininished = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (opFininished) {
                x++;
            }

        } else {
            if (processes[x][0] != null) {
                //set next state.
                for (int i = 0; i < processes.length; i++) {
                    threads[i] = new Thread(processes[x][i]);
                    threads[i].start();
                }
                opFininished = false;


                currentProcess = x;
                Log.i(TAG, "Started State : " + Integer.toString(x));


            } else if (processes[x][0] == null && !machineFinished) {
                Log.i(TAG, "MACHINE TERMINATED");
                machineFinished = true;
                stop();
            }
        }

    }

    @Override
    public void stop(){
        for(int i = 0;i < processes.length;i++) {
            for (int y = 0; y < processes.length; y++) {
                if(processes[i][y] != null) {
                    processes[i][y].isFinished = true;
                }
            }
        }
    }

    public abstract void setProcesses();
}
