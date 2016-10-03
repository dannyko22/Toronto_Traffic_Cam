package com.torontotraffic.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;


public class Four_O_Three extends ActionBarActivity implements TabHost.OnTabChangeListener, OnMapReadyCallback {


    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four__o__three);

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


    public void onButtonClick403(View v)
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
            case R.id.four03dundas:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc68.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc68.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc68.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403dundas);
                break;
            case R.id.four03winston:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc72.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc72.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc72.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403winston);
                break;
            case R.id.four03erinmills:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc74.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc74.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc74.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403erinmills);
                break;
            case R.id.four03creditview:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc77.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc77.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc77.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403creditview);
                break;
            case R.id.four03mavis:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/loc79.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/TopPictures/loc79.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/BurlCamera/ReferencePictures/BottomPictures/loc79.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403mavis);
                break;
            case R.id.four03hurontario:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc122.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc122.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc122.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403hurontario);
                break;
            case R.id.four03centralpkwy:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc121.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc121.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc121.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwy403centralpwy);
                break;
            case R.id.four03eglinton:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc44.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc44.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc44.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy403eglinton);
                break;
            case R.id.four03matheson:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc43.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc43.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc43.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy403matheson);
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
        getMenuInflater().inflate(R.menu.four__o__three, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_four__o__three, container, false);
            return rootView;
        }
    }

}
