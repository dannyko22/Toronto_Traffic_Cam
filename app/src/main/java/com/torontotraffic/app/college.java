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
import com.google.android.gms.maps.model.LatLng;


public class college extends ActionBarActivity implements OnTabChangeListener {

    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

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


    public void onButtonClickCollege(View v)
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
            case R.id.collegebeverley:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8039.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8039e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8039w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.collegebeverley);
                break;
            case R.id.collegeuniversity:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8038.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8038e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8038w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.collegeuniversity);
                break;
            case R.id.collegebay:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8037.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8037e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8037w.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.collegebay);
                break;
            case R.id.collegeyonge:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8036.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8036e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8036w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.collegeyonge);
                break;
            case R.id.collegechurch:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8035.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8035e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8035w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.collegechurch);
                break;
            case R.id.collegejarvis:
                image_url = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/CameraImages/loc8034.jpg";
                top_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8034e.jpg";
                bottom_image = "http://opendata.toronto.ca/transportation/tmc/rescucameraimages/ComparisonImages/loc8034w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.collegejarvis);
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
        getMenuInflater().inflate(R.menu.college, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_college, container, false);
            return rootView;
        }
    }

}
