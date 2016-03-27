package com.torontotraffic.app;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;


public class HwySeven extends ActionBarActivity implements TabHost.OnTabChangeListener {

    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hwy_seven);

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




    public void onButtonClickHwySeven(View v)
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
            case R.id.hwy27onhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc26.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc26rpart1);
                bottomimage.setImageResource(R.drawable.loc26rpart2);
                getLatLong(R.array.hwy7on27);
                break;
            case R.id.pinevalley:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc6.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc6rpart1);
                bottomimage.setImageResource(R.drawable.loc6rpart2);
                getLatLong(R.array.hwy7pinevalley);
                break;
            case R.id.westononhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc7.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                topimage.setImageResource(R.drawable.loc7rpart1);
                bottomimage.setImageResource(R.drawable.loc7rpart2);
                getLatLong(R.array.hwy7weston);
                bottom_textbox = "";
                break;
            case R.id.janeonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc3.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc3rpart1);
                bottomimage.setImageResource(R.drawable.loc3rpart2);
                getLatLong(R.array.hwy7jane);
                break;
            case R.id.keeleonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc4.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc4rpart1);
                bottomimage.setImageResource(R.drawable.loc4rpart2);
                getLatLong(R.array.hwy7keele);
                break;
            case R.id.chalmersonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc18.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc18rpart1);
                bottomimage.setImageResource(R.drawable.loc18rpart2);
                getLatLong(R.array.hwy7chalmers);
                break;
            case R.id.valleymedeonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc19.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc19rpart1);
                bottomimage.setImageResource(R.drawable.loc19rpart2);
                getLatLong(R.array.hwy7valleymede);
                break;
            case R.id.westbeavercreekonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc20.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc20rpart1);
                bottomimage.setImageResource(R.drawable.loc20rpart2);
                getLatLong(R.array.hwy7westbeavercreek);
                break;
            case R.id.leslieonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc21.jpg";
                top_image = "";
                bottom_image = "";
                topimage.setImageResource(R.drawable.loc21rpart1);
                top_textbox = "Camera Views";
                bottom_textbox = "";
                bottomimage.setImageResource(R.drawable.loc21rpart2);
                getLatLong(R.array.hwy7lesley);
                break;
            case R.id.eastbeavercreekonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc22.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc22rpart1);
                bottomimage.setImageResource(R.drawable.loc22rpart2);
                getLatLong(R.array.hwy7eastbeavercreek);
                break;
            case R.id.fourofouronhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc2.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc2rpart1);
                bottomimage.setImageResource(R.drawable.loc2rpart2);
                getLatLong(R.array.hwy7404);
                break;
            case R.id.southtowncentreonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc17.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc17rpart1);
                bottomimage.setImageResource(R.drawable.loc17rpart2);
                getLatLong(R.array.hwy7southtowncentre);
                break;
            case R.id.mccowanonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc5.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc5rpart1);
                bottomimage.setImageResource(R.drawable.loc5rpart2);
                getLatLong(R.array.hwy7mccowan);
                break;
            case R.id.ninthlineonhwy7:
                image_url = "https://ww6.yorkmaps.ca/webtrafficimages/loc36.jpg";
                top_image = "";
                bottom_image = "";
                top_textbox = "Camera Views";
                bottom_textbox = "";
                topimage.setImageResource(R.drawable.loc36rpart1);
                bottomimage.setImageResource(R.drawable.loc36rpart2);
                getLatLong(R.array.hwy7ninthline);
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
            //bottomimage.setImageDrawable(null);
            //bottomimage.setImageResource(Color.TRANSPARENT);
        }
        top_textboxview.setText(top_textbox);
        bottom_textboxview.setText(bottom_textbox);

        mapUtils.setlocation(locationLatLng, mMap);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hwy_seven, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_hwy_seven, container, false);
            return rootView;
        }
    }

}
