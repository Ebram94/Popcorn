package com.androidtutorialpoint.androidviewpagerexample.Adapter;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class GPSTracker extends Service implements LocationListener {
    static Context context;
    static boolean isGPSEnabled = false;
    static Location location = null;
    static LocationManager locManager = null;

    static final float minDistance = 0;
    static final long minTime = 0;

    public GPSTracker(Context con) {
        context = con;
        locManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        getLocation();
    }

    @SuppressLint("MissingPermission")
    public void getLocation() {
        if (locManager != null) {
            isGPSEnabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (isGPSEnabled) {
                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,this);
                location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            else{
                Toast.makeText(context, "GPS Disabled", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location newLoc) {
        location = newLoc;
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}

