package com.androidtutorialpoint.androidviewpagerexample.View;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.androidtutorialpoint.androidviewpagerexample.Model.Cinema;
import com.androidtutorialpoint.androidviewpagerexample.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private MarkerOptions options = new MarkerOptions();
    private ArrayList<LatLng> latlngs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Cinema C =new Cinema();
        List<String>name=new ArrayList<String>();
        Bundle extra = getIntent().getBundleExtra("extra");
        ArrayList<Cinema> objects = (ArrayList<Cinema>) extra.getSerializable("objects");

        for(Cinema c:objects){
            latlngs.add(new LatLng(c.getLat(), c.getLon()));
           name.add( c.get_Name());
        }
        // Add a marker in Sydney and move the camera
        for (int i=0;i<latlngs.size();i++) {
            options.position(latlngs.get(i));
            options.title(name.get(i));
            googleMap.addMarker(options);
        }

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlngs.get(1), 12));
    }
}
