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
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;


public class Four_two_seven extends ActionBarActivity implements TabHost.OnTabChangeListener {


    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_two_seven);

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


    public void onButtonClick427(View v)
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
            case R.id.fourtwosevenrathburn:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc77.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc77.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc77.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy427rathburn);
                break;
            case R.id.fourtwosevenburnhamthorpe:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc76.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc76.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc76.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy427burnhamthorpe);
                break;
            case R.id.fourtwosevenqew:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc48.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc48.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc48.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy427QEW);
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
        imgLoader.DisplayImage(top_image,loader,topimage);
        imgLoader.DisplayImage(bottom_image,loader,bottomimage);
        top_textboxview.setText(top_textbox);
        bottom_textboxview.setText(bottom_textbox);

        mapUtils.setlocation(locationLatLng, mMap);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.four_two_seven, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_four_two_seven, container, false);
            return rootView;
        }
    }

}
