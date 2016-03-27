package com.torontotraffic.app;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.android.gms.maps.model.LatLng;


public class Gardiner extends ActionBarActivity implements TabHost.OnTabChangeListener {


    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardiner);

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
        // TODO Auto-generated method stub
//        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
//        {
//            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.DKGRAY); //unselected
//        }
//        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.WHITE); // selected
    }



    public void onButtonClickGardiner(View v)
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
            case R.id.fourtwoseven:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc36.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc36e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc36w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardiner427);
                break;
            case R.id.kiplingqew:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc34.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc34e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc34w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerkipling);
                break;
            case R.id.islingtonqew:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc33.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc33e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc33w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerislington);
                break;
            case R.id.royalyork:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc32.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc32e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc32w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerroyalyork);
                break;
            case R.id.grand:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc31.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc31e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc31w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinergrand);
                break;
            case R.id.parklawn:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc30.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc30e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc30w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerparklawn);
                break;
            case R.id.palacepier:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc29.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc29e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc29w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerpalacepier);
                break;
            case R.id.humber:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc26.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc26e.jpg";
                bottom_image = "";
                top_textbox = "Looking East";
                bottom_textbox = "";
                getLatLong(R.array.hwygardinerhumber);
                break;
            case R.id.kingsway:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc25.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc25e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc25w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerkingsway);
                break;
            case R.id.ellis:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc24.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc24e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc24w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerellis);
                break;
            case R.id.sunnyside:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc23.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc23e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc23w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinersunnyside);
                break;
            case R.id.dowling:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc22.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc22e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc22w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerdowling);
                break;
            case R.id.dunn:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc21.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc21e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc21w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerdunn);
                break;
            case R.id.dufferingardiner:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc20.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc20e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc20w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerdufferin);
                break;
            case R.id.strachan:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc16.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc16e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc16w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerstrachan);
                break;
            case R.id.bathurst:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc14.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc14e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc14w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerbathurst);
                break;
            case R.id.spadina:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc13.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc13e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc13w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerspadina);
                break;
            case R.id.eastspadina:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc133.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc133e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc133w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerespadina);
                break;
            case R.id.skydome:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc12.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc12e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc12w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerskydome);
                break;
            case R.id.york:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc10.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc10e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc10w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardineryork);
                break;
            case R.id.jarvis:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc6.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc6e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc6w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerjarvis);
                break;
            case R.id.cherry:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc3.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc3e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc3w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinercherry);
                break;
            case R.id.dvpgardiner:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc2.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc2e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc2w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwygardinerdvp);
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
        imgLoader.DisplayImage(image_url, loader, image);

        if (!TextUtils.isEmpty(top_image)) {
            imgLoader.DisplayImage(top_image,loader,topimage);
        }
        else
        {
            //image.setImageResource(R.drawable.blacksquare);
        }

        if (!TextUtils.isEmpty(bottom_image)) {
            imgLoader.DisplayImage(bottom_image,loader,bottomimage);
        }
        else
        {
            bottomimage.setImageDrawable(null);
            bottomimage.setImageResource(Color.TRANSPARENT);
        }
        top_textboxview.setText(top_textbox);
        bottom_textboxview.setText(bottom_textbox);

        mapUtils.setlocation(locationLatLng, mMap);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gardiner, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_gardiner, container, false);
            return rootView;
        }
    }

}
