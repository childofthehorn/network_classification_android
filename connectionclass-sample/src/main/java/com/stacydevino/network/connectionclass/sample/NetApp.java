package com.stacydevino.network.connectionclass.sample;


/**
 * Created by childofthehorn on 1/13/16.
 * aka Stacy Devino (stacydevino@gmail.com)
 *
 * This file is provided with a GPLv3 lic.
 * http://www.gnu.org/licenses/gpl-3.0.en.html
 */
public class NetApp {

    //default this to 1 which is a poor connection.
    public static int networkSpeedClass = 1;

    public static void setSpeed(int value) {
        networkSpeedClass = value;
    }

    public static int getSpeed() {
        return networkSpeedClass;
    }

}
