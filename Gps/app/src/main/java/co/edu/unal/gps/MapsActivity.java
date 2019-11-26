package co.edu.unal.gps;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final String MY_LOCATION_TITLE = "Mi Localización";
    private String title = MY_LOCATION_TITLE;
    private double latitude, longitude;
    private GoogleMap mMap;
    private int MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            return;
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        setMyLocation();
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
        mMap.setMyLocationEnabled(true);
        //mMap.setOnMyLocationButtonClickListener(this);
        //mMap.setOnMyLocationClickListener(this);


        // Add a marker in Sydney and move the camera
        double cor [] =setMyLocation();
        LatLng ubicacion = new LatLng(cor[0], cor[1]);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,12));

    }

    private double [] setMyLocation() {
        LocationServices.getFusedLocationProviderClient(this).getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    title = MY_LOCATION_TITLE;
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    //setMyMarker(title);
                }
            }
        });
        double cor[]={latitude,longitude};

        return cor;
    }


}
