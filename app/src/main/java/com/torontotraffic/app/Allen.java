package com.torontotraffic.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class Allen extends AppCompatActivity implements OnTabChangeListener, OnMapReadyCallback {

    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allen);

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


    public void onButtonClickAllen(View v)
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
            case R.id.allenlawrence:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9404.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9404n.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9404s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.allenlawrence);
                break;
            case R.id.allenglengrove:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9403.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9403n.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9403s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.allenglengrove);
                break;
            case R.id.allenviewmount:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9402.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9402n.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9402s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.allenviewmount);
                break;
            case R.id.allenelmridge:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9401.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9401n.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9402s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.allenelmridge);
                break;
            case R.id.alleneglinton:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9400.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9400n.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9400e.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking East";
                getLatLong(R.array.alleneglinton);
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
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.allen, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapUtils.setup(mapId, mMap);
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
            View rootView = inflater.inflate(R.layout.fragment_allen, container, false);
            return rootView;
        }
    }

}
