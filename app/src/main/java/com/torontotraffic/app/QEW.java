package com.torontotraffic.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class QEW extends AppCompatActivity implements TabHost.OnTabChangeListener, OnMapReadyCallback {


    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qew);

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
        // TODO Auto-generated method stub
//        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
//        {
//            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.DKGRAY); //unselected
//        }
//        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.WHITE); // selected
    }


    public void onButtonClickQEW(View v)
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
            case R.id.eastmall:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc47.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc47.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc47.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewemall);
                break;
            case R.id.westmall:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc46.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc46.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc46.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewwmall);
                break;
            case R.id.dixieqew:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc44.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc44.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc44.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewdixie);
                break;
            case R.id.cawthra:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc42.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc42.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc42.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewcawthra);
                break;
            case R.id.hurontario:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc40.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc40.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc40.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewhurontario);
                break;
            case R.id.mississaugard:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc38.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc38.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc38.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewmississaugard);
                break;
            case R.id.southdownrd:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc36.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc36.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc36.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewsouthdown);
                break;
            case R.id.winstonchurchill:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc34.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc34.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc34.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewwinstonchurchill);
                break;
            case R.id.ford:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc32.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc32.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc32.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewford);
                break;
            case R.id.trafalgar:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc29.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc29.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc29.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewtrafalgar);
                break;
            case R.id.dorval:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc27.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc27.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc27.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewdorval);
                break;
            case R.id.fourthline:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc25.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc25.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc25.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewfourthline);
                break;
            case R.id.thirdline:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc24.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc24.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc24.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewthirdline);
                break;
            case R.id.bronte:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc22.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc22.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc22.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewbronte);
                break;
            case R.id.burloak:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc20.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc20.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc20.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewburloak);
                break;
            case R.id.appleby:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc18.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc18.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc18.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewappleby);
                break;
            case R.id.walker:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc16.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc16.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc16.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewwalker);
                break;
            case R.id.guelph:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc14.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc14.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc14.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewguelph);
                break;
            case R.id.eastbrant:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc13.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc13.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc13.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewebrant);
                break;
            case R.id.westbrant:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc12.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc12.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc12.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewwbrant);
                break;
            case R.id.fairview:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc09.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc09.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc09.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewfairview);
                break;
            case R.id.lakeshoreqew:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc08.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc08.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc08.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewlakeshore);
                break;
            case R.id.burlingtonskyway:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc05.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc05.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc05.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewburlingtonskyway);
                break;
            case R.id.woodward:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc02.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc02.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc02.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewwoodword);
                break;
            case R.id.burlingtonqew:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc01.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc01.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc01.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewburlingtonqew);
                break;
            case R.id.redhillvalley:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc100.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc100.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc100.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewredhill);
                break;
            case R.id.centennial:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc101.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc101.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc101.jpg";
                top_textbox = "Toronto Bound";
                bottom_textbox = "Niagara Bound";
                getLatLong(R.array.hwyqewcentennial);
                break;
            case R.id.seventh:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc84.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc84.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc84.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewseventh);
                break;
            case R.id.ontariost:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc88.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc88.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc88.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewontariost);
                break;
            case R.id.niagarast:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc90.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc90.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc90.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewniagarast);
                break;
            case R.id.bunting:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc93.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc93.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc93.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewbunting);
                break;
            case R.id.glendale:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc95.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc95.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc95.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewglendale);
                break;
            case R.id.mountainrd:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc97.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc97.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc97.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewmountainrd);
                break;
            case R.id.bowen:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc55.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc55.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc55.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewbowen);
                break;
            case R.id.thompson:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc56.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc56.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc56.jpg";
                top_textbox = "Niagara Bound";
                bottom_textbox = "Toronto Bound";
                getLatLong(R.array.hwyqewthompson);
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
        getMenuInflater().inflate(R.menu.qew, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_qew, container, false);
            return rootView;
        }
    }

}
