package com.shefali.customer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;

import static android.graphics.Color.rgb;

public class ChooseLocation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    LatLng sorc;
    LatLng destin;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);

        getSupportActionBar().hide();

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mToolbar.setTitle(" Home ");
        mToolbar.setTitleTextColor(rgb(220,20,60));

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,mToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //----------------------------------------Source Autocomplete-----------------------------------------

        final PlaceAutocompleteFragment src = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.source);
        src.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            public static final String TAG = "Set Location";

            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                String sadd = String.valueOf(place.getAddress());
                // Toast.makeText(getApplicationContext(), pname, Toast.LENGTH_SHORT).show();
                // Log.i(TAG, "Place: " + place.getName());
                //String t1= retS(sadd);
                sorc = place.getLatLng();
                b.putString("Source", sadd);
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });



        //----------------------------------------Destination Autocomplete-----------------------------------------

        PlaceAutocompleteFragment dest = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.destination);

        dest.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            public static final String TAG = "Set Location";


            @Override
            public void onPlaceSelected(Place place) {
                String dadd = String.valueOf(place.getAddress());
                // TODO: Get info about the selected place.
                // Log.i(TAG, "Place: " + place.getName());
                // String t1= retD(dadd);
                b.putString("Destination", dadd);
                destin = place.getLatLng();
            }

          /*  public String retD(String x)
            {
                return  x;
            }*/

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "An error occurred: " + status);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
