package com.torontotraffic.app;


import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * Created by Danny on 13/02/14.
 */

public class GMapUtils  {

    private UiSettings mapUISetting;

    public void setup(int mapid, GoogleMap mMap)
    {
        mMap.setTrafficEnabled(true);
        mMap.setBuildingsEnabled(true);

        mapUISetting = mMap.getUiSettings();
        mapUISetting.setMyLocationButtonEnabled(true);
        mapUISetting.setTiltGesturesEnabled(false);
        mapUISetting.setRotateGesturesEnabled(false);
        mapUISetting.setCompassEnabled(true);

        mMap.setMyLocationEnabled(true);

        final LatLng locationLatLngSetup = new LatLng(43.7746244,-79.4034245);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(locationLatLngSetup) // Sets the center of the map
                .zoom(10)                   // Sets the zoom
                .bearing(0) // Sets the orientation of the camera to north
                .tilt(0)    // Sets the tilt of the camera to 0 degrees
                .build();    // Creates a CameraPosition from the builder

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                cameraPosition));
    }

    public void setlocation(LatLng locationLatLng, GoogleMap mMap)
    {

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(locationLatLng) // Sets the center of the map
                .zoom(12)                   // Sets the zoom
                .bearing(0) // Sets the orientation of the camera to north
                .tilt(0)    // Sets the tilt of the camera to 0 degrees
                .build();    // Creates a CameraPosition from the builder

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                cameraPosition));

        mMap.clear();

        mMap.addMarker(new MarkerOptions()
                .position(locationLatLng)
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.cctvlogo)));


    }

}
