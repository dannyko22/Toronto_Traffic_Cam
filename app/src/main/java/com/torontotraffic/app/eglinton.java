package com.torontotraffic.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
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
import com.squareup.picasso.Picasso;


public class eglinton extends ActionBarActivity implements OnTabChangeListener, OnMapReadyCallback {

    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eglinton);

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


    public void onButtonClickEglinton(View v)
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
            case R.id.eglintonjane:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8069.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8069e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8069w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonjane);
                break;
            case R.id.eglintonblackcreek:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8068.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8068e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8068w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonblackcreek);
                break;
            case R.id.eglintonkeele:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8067.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8067e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8067w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonkeele);
                break;
            case R.id.eglintoncaledonia:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8066.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8066e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8066w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintoncaledonia);
                break;
            case R.id.eglintondufferin:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8070.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8070e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8070w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintondufferin);
                break;
            case R.id.eglintonallen:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc9400.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9400e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc9400w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonallen);
                break;
            case R.id.eglintonbathurst:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8065.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8065e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8065w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonbathurst);
                break;
            case R.id.eglintonavenue:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8064.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8064e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8064w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonavenue);
                break;
            case R.id.eglintonyonge:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8063.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8063e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8063w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonyonge);
                break;
            case R.id.eglintonbayview:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8062.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8062e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8062w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonbayview);
                break;
            case R.id.eglintonlaird:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8061.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8061e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8061w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonlaird);
                break;
            case R.id.eglintonleslie:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8060.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8060e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8060w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonleslie);
                break;
            case R.id.eglintondonmills:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8059.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8059e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8059w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintondonmills);
                break;
            case R.id.eglintoncreditunion:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8058.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8058e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8058w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintoncreditunion);
                break;
            case R.id.eglintonvictoriapark:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8057.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8057e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8057w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonvictoriapark);
                break;
            case R.id.eglintonwarden:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8056.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8056e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8056w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonwarden);
                break;
            case R.id.eglintonbirchmount:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8055.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8055e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8055w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonbirchmount);
                break;
            case R.id.eglintonkennedy:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8054.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8054e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8054w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.eglintonkennedy);
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
        Picasso.with(this).load(image_url).into(image);
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
        getMenuInflater().inflate(R.menu.eglinton, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_eglinton, container, false);
            return rootView;
        }
    }

}
