package org.timecrafters.engine;

import android.nfc.Tag;
import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.timecrafters.engine.tests.inheratencetTest;

import java.lang.reflect.Array;

/**
 * Created by t420 on 9/29/2016.
 * First sucess ful test was 5:00 6 thur oct 2016
 */

public abstract class engine extends OpMode {

    public caseBase[][] processes = new caseBase[100][100];
    private Thread[] threads = new Thread[100];
    private int threadX = 0;


    private static String TAG = "PROGRAM.ENGINE: ";
    private int x = 0;
    private int currentProcess = 0;
    private boolean machineFinished = false;
    private boolean opFininished = true;

    public void init() {
        setProcesses();
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
            }
        }

    }

    public abstract void setProcesses();
}
