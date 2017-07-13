package com.wordpress.nikant20.locationmanagerdemo;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    Notification notification;


    double latitude, longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);






    }

    private void notificationshow() {

        if(latitude == 30.8597753 && longitude == 75.8607141){
            builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("Welcome to Hostel");
            builder.setContentText("Location is: "+latitude+" - "+longitude);
            builder.setSmallIcon(R.drawable.ic_geography);
            builder.setDefaults(Notification.DEFAULT_ALL);
            notification = builder.build();

            notificationManager.notify(101,notification);

        }
        else if(latitude == 30.902282 && longitude == 75.8201693){
            builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("Welcome to Auribises");
            builder.setContentText("Location is: "+latitude+" - "+longitude);
            builder.setSmallIcon(R.drawable.ic_geography);
            builder.setDefaults(Notification.DEFAULT_ALL);
            notification = builder.build();

            notificationManager.notify(101,notification);
        }
        else{
            builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("Location");
            builder.setContentText("Location is: "+latitude+" - "+longitude);
            builder.setSmallIcon(R.drawable.ic_geography);
            builder.setDefaults(Notification.DEFAULT_ALL);
            notification = builder.build();

            notificationManager.notify(101,notification);
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {



            return;
        }
        location = locationManager.getLastKnownLocation(bestProvider);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        notificationshow();

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
