package com.torontotraffic.app;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class Four_O_One extends ActionBarActivity implements OnTabChangeListener, OnMapReadyCallback {

    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four__o__one);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }



    }


    // override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);

        // create the TabHost that will contain the Tabs
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.setOnTabChangedListener(this);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("Camera");
        tab1.setContent(R.id.cameraTab);

        tab2.setIndicator("Map");
        tab2.setContent(R.id.mapTab);


        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

        mapId = R.id.mapView;
        //mMap = ((MapFragment) getFragmentManager().findFragmentById(mapId)).getMap();
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(mapId);
        mapFragment.getMapAsync(this);



//        MMSDK.initialize(this);
//        MMAdView adView = (MMAdView) findViewById(R.id.adView);
//
//        //Replace YOUR_APID with the APID provided to you by Millennial Media
//        adView.setApid("152783");
//
//        //Set your metadata in the MMRequest object
//        MMRequest request = new MMRequest();
//
//        //Add the MMRequest object to your MMAdView.
//        adView.setMMRequest(request);
//        adView.getAd();

    }


    public void getLatLong(int locationId)
    {
        String[] location1 = getResources().getStringArray(locationId);

        double d1 = Double.parseDouble(location1[0].trim());
        double d2 = Double.parseDouble(location1[1].trim());

        locationLatLng = new LatLng(d1,d2);
    }


    @Override
    public void onTabChanged(String tabId) {
//        // TODO Auto-generated method stub
//        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
//        {
//            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.DKGRAY); //unselected
//        }
//        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.WHITE); // selected
    }


    public void onButtonClick(View v)
    {


        // Loader image - will be shown before loading image
        int loader = R.drawable.loading;

        // Imageview to show
        ImageView image = (ImageView) findViewById(R.id.trafficView);
        ImageView topimage = (ImageView)findViewById(R.id.topView);
        ImageView bottomimage = (ImageView)findViewById(R.id.bottomView);
        TextView top_textboxview = (TextView)findViewById(R.id.toptextbox);
        TextView bottom_textboxview = (TextView)findViewById(R.id.bottomtextbox);

        String image_url = "";
        String top_image = "";
        String bottom_image = "";
        String top_textbox = "";
        String bottom_textbox = "";

        // Image url
        switch (v.getId())
        {
            case R.id.four10:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc40.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc40.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc40.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401410);
                break;
            case R.id.tomken:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc39.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc39.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc39.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401tomken);
                break;
            case R.id.dixie:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc38.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc38.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc38.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401dixie);
                break;
            case R.id.ecreek:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc37.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc37.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc37.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401ecreek);
                break;
            case R.id.transfer:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc36.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc36.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc36.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401transfer);
                break;
            case R.id.pearson:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc35.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc35.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc35.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401pearson);
                break;
            case R.id.renforth:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc34.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc34.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc34.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401renforth);
                break;
            case R.id.carlingview:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc32.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc32.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc32.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401carlingview);
                break;
            case R.id.hwy27:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc30.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc30.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc30.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401hwy27);
                break;
            case R.id.martingrove:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc29.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc29.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc29.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401martingrove);
                break;
            case R.id.kipling:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc28.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc28.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc28.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401kipling);
                break;
            case R.id.hwy409:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc27.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc27.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc27.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401409);
                break;
            case R.id.islington:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc26.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc26.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc26.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401islington);
                break;
            case R.id.weston:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc25.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc25.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc25.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401weston);
                break;
            case R.id.jane:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc22.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc22.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc22.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401jane);
                break;
            case R.id.keele:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc19.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc19.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc19.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401keele);
                break;
            case R.id.caledonia:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc18.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc18.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc18.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401caledonia);
                break;
            case R.id.dufferin:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc17.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc17.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc17.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401dufferin);
                break;
            case R.id.bathurst:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc14.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc14.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc14.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401bathurst);
                break;
            case R.id.avenue:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc13.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc13.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc13.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401avenue);
                break;
            case R.id.hoggshollow:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc12.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc12.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc12.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401hoggshollow);
                break;
            case R.id.yonge:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc11.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc11.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc11.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401yonge);
                break;
            case R.id.eyonge:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc50.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc50.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc50.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401eyonge);
                break;
            case R.id.bayview:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc51.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc51.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc51.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401bayview);
                break;
            case R.id.ebayview:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc52.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc52.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc52.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401ebayview);
                break;
            case R.id.leslie:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc53.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc53.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc53.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401leslie);
                break;
            case R.id.donmills:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc54.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc54.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc54.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401donmills);
                break;
            case R.id.dvp:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc57.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc57.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc57.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401edvp);
                break;
            case R.id.vicpark:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc58.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc58.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc58.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401vicpark);
                break;
            case R.id.warden:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc59.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc59.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc59.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401warden);
                break;
            case R.id.birchmount:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc60.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc60.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc60.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401birchmount);
                break;
            case R.id.kennedy:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc61.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc61.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc61.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401kennedy);
                break;
            case R.id.midland:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc62.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc62.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc62.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401midland);
                break;
            case R.id.brimley:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc63.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc63.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc63.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401brimley);
                break;
            case R.id.mccowan:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc64.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc64.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc64.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401mccowan);
                break;
            case R.id.bellamy:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc65.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc65.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc65.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401bellamy);
                break;
            case R.id.markham:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc66.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc66.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc66.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401markham);
                break;
            case R.id.neilson:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc68.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc68.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc68.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401neilson);
                break;
            case R.id.morningside:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc70.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc70.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc70.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401morningside);
                break;
            case R.id.meadowvale:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc73.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc73.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc73.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401meadowvale1);
                break;
            case R.id.portunion:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc92.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc92.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc92.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401portunion);
                break;
            case R.id.whitesroadsouth:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc95.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc95.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc95.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401whitesroadnorth);
                break;
            case R.id.liverpool:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc97.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc97.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc97.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401liverpool);
                break;
            case R.id.brock:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc99.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc99.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc99.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401brock);
                break;
            case R.id.westney:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc102.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc102.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc102.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401westney);
                break;
            case R.id.harwood:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc103.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc103.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc103.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy401harwood);
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }
        // ImageLoader class instance
        ImageLoader imgLoader = new ImageLoader(getApplicationContext());

        // whenever you want to load an image from url
        // call DisplayImage function
        // url - image url to load
        // loader - loader image, will be displayed before getting image
        // image - ImageView

        Picasso.with(this).invalidate(image_url);
        Picasso.with(this).load(image_url).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE).into(image);

        Picasso.with(this).load(bottom_image).into(bottomimage);
        Picasso.with(this).load(top_image).into(topimage);
        top_textboxview.setText(top_textbox);
        bottom_textboxview.setText(bottom_textbox);

        mapUtils.setlocation(locationLatLng, mMap);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapUtils.setup(mapId, mMap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.four__o__one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_four__o__one, container, false);
            return rootView;
        }
    }

}
