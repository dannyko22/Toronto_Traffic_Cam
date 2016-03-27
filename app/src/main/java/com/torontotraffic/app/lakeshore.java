package com.torontotraffic.app;

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
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class lakeshore extends ActionBarActivity implements OnTabChangeListener {

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
        mMap = ((MapFragment) getFragmentManager().findFragmentById(mapId)).getMap();


        mapUtils.setup(mapId, mMap);

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
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc37.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc37e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc37w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreparklawn);
                break;
            case R.id.lakeshoreellis:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc137.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc137e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc137w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreellis);
                break;
            case R.id.lakeshorecolborne:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc150.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc150e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc150w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorecolborne);
                break;
            case R.id.lakeshoreparkside:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc136.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc136e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc136w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreparkside);
                break;
            case R.id.lakeshorejameson:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc135.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc135e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc135w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorejameson);
                break;
            case R.id.lakeshoredunn:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc134.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc134e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc134w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoredunn);
                break;
            case R.id.lakeshorebritishcolumbia:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc19.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc19e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc19w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorebc);
                break;
            case R.id.lakeshoreontario:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc18.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc18e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc18w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreontario);
                break;
            case R.id.lakeshoreontarioplace:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc17.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc17e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc17w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreontarioplace);
                break;
            case R.id.lakeshoreremembrance:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc15.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc15e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc15w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreremembrance);
                break;
            case R.id.lakeshorerees:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc11.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc11e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc11w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorerees);
                break;
            case R.id.lakeshorebay:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc8.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc8e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc8w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorebay);
                break;
            case R.id.lakeshoreyonge:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc7.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc7e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc7w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreyonge);
                break;
            case R.id.lakeshorejarvis:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc5.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc5e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc5w.jpgg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshorejarvis);
                break;
            case R.id.lakeshoreparliament:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc4.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc4e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc4w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoreparliament);
                break;
            case R.id.lakeshoredonroadway:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc1.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc1e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc1w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.lakeshoredonroadway);
                break;
            case R.id.lakeshoreleslie:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc120.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc120e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc120w.jpg";
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
        imgLoader.DisplayImage(image_url, loader, image);
        imgLoader.DisplayImage(top_image,loader,topimage);
        imgLoader.DisplayImage(bottom_image,loader,bottomimage);
        top_textboxview.setText(top_textbox);
        bottom_textboxview.setText(bottom_textbox);

        mapUtils.setlocation(locationLatLng, mMap);

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
