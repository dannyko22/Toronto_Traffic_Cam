package com.torontotraffic.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class mapview extends ActionBarActivity {


    private LatLng locationLatLng;
    private GoogleMap mainMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mapview);

        mapId = R.id.mainmapView;
        mainMap = ((MapFragment) getFragmentManager().findFragmentById(mapId)).getMap();

        mapUtils.setup(mapId, mainMap);

        AdView mAdView = (AdView) findViewById(R.id.adViewMap);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}

