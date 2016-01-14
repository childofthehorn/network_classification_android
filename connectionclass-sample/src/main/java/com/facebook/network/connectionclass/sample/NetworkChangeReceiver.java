package com.facebook.network.connectionclass.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
/**
 * Created by childofthehorn on 1/13/16.
 */
public class NetworkChangeReceiver extends BroadcastReceiver {
    // This will be a speed of 1-3 with 3 being the highest and 0 meaning nothing
    int networkSpeed = 0;

        @Override
    public void onReceive(Context context, Intent intent) {
        networkIntent(intent, context,  "nettrack");
    }

    private void networkIntent (Intent intent, Context context, String name){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (intent.getExtras() != null){
            int networkType = intent.getExtras().getInt(ConnectivityManager.EXTRA_NETWORK_TYPE);
            boolean isWiFi = networkType == ConnectivityManager.TYPE_WIFI;
            boolean isMobile = networkType == ConnectivityManager.TYPE_MOBILE;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(networkType);
            boolean isConnected = networkInfo.isConnected();

            if(!isConnected){
                networkSpeed = 0;
            }

            // Go full speed when on Wifi
            if(isConnected && isWiFi){
                networkSpeed = 3;
            }

            if(isConnected && isMobile) {
                String typeString = "Unknown";
                switch (networkType) {
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                        typeString = "EDGE";
                        networkSpeed = 1;
                        break;
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                        typeString = "GPRS";
                        networkSpeed = 1;
                        break;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                        typeString = "UMTS";
                        networkSpeed = 1;
                        break;
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                        typeString = "CDMA";
                        networkSpeed = 1;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        typeString = "EVDO";
                        networkSpeed = 2;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        typeString = "EVDO";
                        networkSpeed = 2;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        typeString = "EVDO";
                        networkSpeed = 2;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                        typeString = "HSDPA";
                        networkSpeed = 2;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                        typeString = "HSPA";
                        networkSpeed = 2;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                        typeString = "EHRPD";
                        networkSpeed = 3;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        typeString = "HSPAP";
                        networkSpeed = 3;
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        typeString = "LTE";
                        networkSpeed = 3;
                        break;
                    default:
                        typeString = "UNKNOWN";
                        networkSpeed = 2;
                        break;
                }
            }
            //Change the speed that will be pulled when the device receives a network change
            NetApp.setSpeed(networkSpeed);

        }

    }

}
