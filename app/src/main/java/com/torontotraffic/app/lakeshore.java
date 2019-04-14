package com.torontotraffic.app;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
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


public class lakeshore extends AppCompatActivity implements OnTabChangeListener, OnMapReadyCallback {

    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lakeshore);

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


    public void onButtonClickLakeshore(View v)
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
            case R.id.lakeshoreparklawn:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9322.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9322e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9322w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreparklawn);
                break;
            case R.id.lakeshoreellis:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9318.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9318e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9318w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreellis);
                break;
            case R.id.lakeshorecolborne:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9317.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9317e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9317w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorecolborne);
                break;
            case R.id.lakeshoreparkside:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9333.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9333e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9333w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreparkside);
                break;
            case R.id.lakeshorejameson:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9314.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9314e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9314w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorejameson);
                break;
            case R.id.lakeshoredunn:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9312.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9312e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9312w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoredunn);
                break;
            case R.id.lakeshorebritishcolumbia:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9311.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9311e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9311w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorebc);
                break;
            case R.id.lakeshoreontario:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9310.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9310e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9310w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreontario);
                break;
            case R.id.lakeshoreontarioplace:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9309.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9309e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9309w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreontarioplace);
                break;
            case R.id.lakeshoreremembrance:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9308.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9308e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9308w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreremembrance);
                break;
            case R.id.lakeshorerees:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9306.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9306e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9306w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorerees);
                break;
            case R.id.lakeshorebay:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9304.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9304e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9304w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorebay);
                break;
            case R.id.lakeshoreyonge:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9303.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9303e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9303w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreyonge);
                break;
            case R.id.lakeshorejarvis:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9302.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9302e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9302w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorejarvis);
                break;
            case R.id.lakeshoreparliament:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9301.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9301e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9301w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreparliament);
                break;
            case R.id.lakeshoredonroadway:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9300.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9300e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9300w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoredonroadway);
                break;
            case R.id.lakeshoreleslie:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9323.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9323e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9323w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreleslie);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
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
        getMenuInflater().inflate(R.menu.lakeshore, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_lakeshore, container, false);
            return rootView;
        }
    }

}
