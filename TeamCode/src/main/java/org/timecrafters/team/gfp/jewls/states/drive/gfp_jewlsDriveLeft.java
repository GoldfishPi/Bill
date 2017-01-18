package org.timecrafters.team.gfp.jewls.states.drive;

/**
 * Created by t420 on 1/14/2017.
 */

public class gfp_jewlsDriveLeft extends gfp_jewlsDrive {

    @Override
    public void init() {
        //back left
        directions[0] = -1;
        //front left
        directions[1] = 1;
        //front right
        directions[2] = -1;
        //back right
        directions[3] = 1;
    }
}
