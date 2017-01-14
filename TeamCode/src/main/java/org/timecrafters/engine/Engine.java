package org.timecrafters.engine;

import android.util.Log;

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

    //changed robot prefs
    public State[][] processes = new State[100][100];
    private Thread[] threads = new Thread[100];
    private int threadX = 0;

    public volatile double[][][] cache = new double[100][100][100];


    private static String TAG = "PROGRAM.ENGINE: ";
    private int x = 0;
    private int currentProcess = 0;
    private boolean machineFinished = false;
    private boolean opFininished = true;

    //sets processes
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

    //checks if ops are finished
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

    //kills all processes running when program endes
    @Override
    public void stop(){
        for(int x = 0;x < processes.length; x++) {
            for (int y = 0; y < processes.length; y++) {
                if(processes[x][y] != null) {
                    processes[x][y].setFinished(true);
                    processes[x][y].stop();
                    Log.i(TAG, "KILLED OP : " + "[" + Integer.toString(x) + "]" + "[" + Integer.toString(y) + "]");
                }else {
                    break;
                }
            }
        }
    }

    //set processes in extended classes
    public abstract void setProcesses();

    public int getProcessIndex(){
        return x;
    }

    //adds the ability to add processes inside states
    public void addProcess(State state){
        int y = 0;
        while (processes[getProcessIndex()][y] != null){
            y++;
        }
        if( y <= 100){
            processes[x][y] = state;
            Log.i(TAG, "ADDED STATE : " + "[" + Integer.toString(getProcessIndex()) + "]" + "[" + Integer.toString(y) + "]");
        }else{
            Log.i(TAG, "FAILED TO ADD STATE AT : " + "[" + Integer.toString(getProcessIndex()) + "]" + "[" + Integer.toString(y) + "]");
        }
    }

    //Allows other states to end processes on the same index
    public void endProcess(int index,State state){
        for(int i = 0; i < processes.length;i++){
            if(processes[index][i] == state){
                processes[index][i].setFinished(true);
                Log.i(TAG, "FORCED STOP AT : " + "[" + Integer.toString(getProcessIndex()) + "]" + "[" + Integer.toString(i) + "]");
                break;
            }
        }
    }

    public void addCacheData(int index, int layer, double data){
        cache[x][index][layer] = data;
    }

    public double getCacheData(int index, int layer){
        return cache[0][index][layer];
    }


}
