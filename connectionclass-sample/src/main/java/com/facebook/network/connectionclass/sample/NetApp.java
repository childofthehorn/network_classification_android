package com.facebook.network.connectionclass.sample;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by childofthehorn on 1/13/16.
 */
public class NetApp extends Application {

    //default this to 1 which is a poor connection.
    public static int networkSpeedClass = 1;

    public static void setSpeed(int value) {
        networkSpeedClass = value;
    }

    public static int getSpeed() {
        return networkSpeedClass;
    }

}
