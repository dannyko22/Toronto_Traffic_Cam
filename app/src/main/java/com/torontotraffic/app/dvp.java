package com.torontotraffic.app;

import android.graphics.Color;
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
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;


public class dvp extends ActionBarActivity implements TabHost.OnTabChangeListener {


    private LatLng locationLatLng;
    private GoogleMap mMap;
    private int mapId;
    private GMapUtils mapUtils = new GMapUtils();

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvp);

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

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub
//        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
//        {
//            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.DKGRAY); //unselected
//        }
//        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.WHITE); // selected
    }


    public void getLatLong(int locationId)
    {
        String[] location1 = getResources().getStringArray(locationId);

        double d1 = Double.parseDouble(location1[0].trim());
        double d2 = Double.parseDouble(location1[1].trim());

        locationLatLng = new LatLng(d1,d2);
    }

    public void onButtonClickDVP(View v)
    {


        // Loader image - will be shown before loading image
        int loader = R.drawable.loading;

        // Imageview to show
        ImageView image = (ImageView) findViewById(R.id.trafficView);
        ImageView topimage = (ImageView)findViewById(R.id.topView);
        ImageView bottomimage = (ImageView)findViewById(R.id.bottomView);
        TextView top_textboxview = (TextView)findViewById(R.id.toptextbox);
        TextView bottom_textboxview = (TextView)findViewById(R.id.bottomtextbox);


        String image_url;
        String top_image = "";
        String bottom_image = "";
        String top_textbox = "";
        String bottom_textbox = "";

        // Image url
        switch (v.getId())
        {
            case R.id.ave16404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc144.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc144.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc144.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404ave16);
                break;
            case R.id.hwy7404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc143.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc143.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc143.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404hwy7);
                break;
            case R.id.nhwy407404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc142.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc142.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc142.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404nhwy407);
                break;
            case R.id.shwy407404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc141.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc141.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc141.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404shwy407);
                break;
            case R.id.john404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc140.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc140.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc140.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404john);
                break;
            case R.id.nsteeles404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc139.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc139.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc139.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404nsteeles);
                break;
            case R.id.steeles404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc138.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc138.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc138.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404steeles);
                break;
            case R.id.ssteeles404:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc137.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc137.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc137.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwy404ssteeles);
                break;
            case R.id.dvpfinch:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc135.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc83.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc83.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpfinch);
                break;
            case R.id.dvpvanhorne:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc134.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc82.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc82.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpvanhorne);
                break;
            case R.id.sheppardhov:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc133.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc81.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc81.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpsheppardhov);
                break;
            case R.id.fouroone:
                image_url = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/loc55.jpg";
                top_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/TopPictures/loc55.jpg";
                bottom_image = "http://www.cdn.mto.gov.on.ca/english/traveller/compass/camera/pictures/ReferencePictures/BottomPictures/loc55.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvp401);
                break;
            case R.id.yorkmills:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc80.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc80n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc80s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpyorkmills);
                break;
            case R.id.threevalleys:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc79.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc79n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc79s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvp3valleys);
                break;
            case R.id.lawrence:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc78.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc78n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc78s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvplawrence);
                break;
            case R.id.twintunnels:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc77.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc77n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc77s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvptwintunnels);
                break;
            case R.id.wynford:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc81.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc81n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc81s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpwynford);
                break;
            case R.id.eglinton:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc76.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc76n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc76s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpeglinton);
                break;
            case R.id.stdennis:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc75.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc75n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc75s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpstdennis);
                break;
            case R.id.spanbridge:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc74.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc74n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc74s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpspanbridge);
                break;
            case R.id.cnrailway:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc73.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc73n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc73s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpcnrailway);
                break;
            case R.id.donmillsdvp:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc71.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc71n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc71s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpdonmills);
                break;
            case R.id.millwood:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc70.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc70n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc70s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpmillwood);
                break;
            case R.id.beechwood:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc69.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc69n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc69s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpbeechwood);
                break;
            case R.id.bloorramp:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc68.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc68n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc68s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpbloorramp);
                break;
            case R.id.danforth:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc67.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc67n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc67s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpdanforth);
                break;
            case R.id.dundas:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc66.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc66n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc66s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpdundas);
                break;
            case R.id.eastern:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc65.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc65n.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc65s.jpg";
                top_textbox = "Looking North";
                bottom_textbox = "Looking South";
                getLatLong(R.array.hwydvpeastern);
                break;
            case R.id.gardinerramp:
                image_url = "http://opendata.toronto.ca/transportation/cameras/loc2.jpg";
                top_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc2e.jpg";
                bottom_image = "http://www1.toronto.ca/City%20Of%20Toronto/Transportation%20Services/Rescu%20Traffic%20Cameras/Files/images/loc2w.jpg";
                top_textbox = "Looking East";
                bottom_textbox = "Looking West";
                getLatLong(R.array.hwydvpgardiner);
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
        getMenuInflater().inflate(R.menu.dvp, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_dvp, container, false);
            return rootView;
        }
    }

}
