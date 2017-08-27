package jazevangelio.newvawepp.ui.map.hospital;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.databinding.ActivityMapsBinding;
import jazevangelio.newvawepp.databinding.DialogMarkerClickBinding;
import jazevangelio.newvawepp.databinding.DialogShowNearestBinding;
import jazevangelio.newvawepp.model.data.Company;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.NearCompany;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.ui.emergency.EmergencyListActivity;
import jazevangelio.newvawepp.util.BitmapUtils;
import jazevangelio.newvawepp.util.FusedLocation;
import jazevangelio.newvawepp.util.SmsUtil;


public class MapActivity extends MvpActivity<MapView, MapPresenter> implements MapView, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private GoogleMap mMap;
    private ProgressDialog progressDialog;
    private Realm realm;
    private LatLngBounds bounds;
    private View markerRestIcon, markerUserIcon;
    private String TAG = MapActivity.class.getSimpleName();
    private PlaceAutocompleteFragment autocompleteFragment;
    private Marker myMarker = null;
    private ActivityMapsBinding binding;
    private MapListAdapter adapter;
    private FusedLocation fusedLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps);
        binding.setView(getMvpView());



        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        realm = Realm.getDefaultInstance();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        initializeMap();


        fusedLocation = new FusedLocation(this, new FusedLocation.Callback() {
            @Override
            public void onLocationResult(Location location) {
                Log.e(TAG, "Location Triggered\n" + location.getLongitude() + "," + location.getLatitude());
                stopLoading();
                setMyMarker(new LatLng(location.getLatitude(), location.getLongitude()));
            }
        });
        ;
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fusedLocation.isGPSEnabled()) {
                    fusedLocation.showSettingsAlert();
                } else {
                    fusedLocation.getCurrentLocation(1);
                    startLoading();
                    Log.e(TAG, "Getting Location");
                }
            }
        });

        binding.fab2.setVisibility(View.GONE);


    }

    private void initializeMap() {
        if (!isGooglePlayServicesAvailable()) {
            finish();
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        markerRestIcon = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.marker_hospital, null);
        markerUserIcon = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.marker_user, null);

        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(Place.TYPE_COUNTRY)
                .setCountry("PH")
                .build();
        autocompleteFragment.setFilter(typeFilter);
        autocompleteFragment.setHint("Search Place");
        autocompleteFragment.setBoundsBias(new LatLngBounds(new LatLng(14.503863, 120.859556), new LatLng(14.767616, 121.088896)));
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());//get place details here
                //my marker
                setMyMarker(place.getLatLng());
                Log.i(TAG, "Place Coordinates: " + place.getLatLng());//get place details here
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

    }

    private void setMyMarker(LatLng latLng) {
        if (myMarker != null) {
            myMarker.remove();
        }
        myMarker = mMap.addMarker(new MarkerOptions().position(latLng)
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapUtils.createDrawableFromView(MapActivity.this, markerUserIcon))));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

        binding.fab2.setVisibility(View.VISIBLE);

        presenter.getNearest(myMarker.getPosition().latitude, myMarker.getPosition().longitude);
    }

    @NonNull
    @Override
    public MapPresenter createPresenter() {
        return new MapPresenter();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(14.599512, 120.984222), 15));


        presenter.onStart();

    }


    @Override
    public void showNearest() {
        final Realm realm = Realm.getDefaultInstance();
        //hide green button
        binding.fab2.setVisibility(View.GONE);

        DialogShowNearestBinding dialogBinding = DataBindingUtil.inflate(
                getLayoutInflater(),
                R.layout.dialog_show_nearest,
                null,
                false);
        final Dialog dialog = new Dialog(MapActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                realm.close();
                binding.fab2.setVisibility(View.VISIBLE);
            }
        });

        //adapter
        dialogBinding.nearestRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MapListAdapter(this);
        dialogBinding.nearestRecyclerView.setAdapter(adapter);


        final RealmResults<NearCompany> nearestCompanies = realm.where(NearCompany.class).findAll().sort("distance", Sort.ASCENDING);
        setNearestCompany(nearestCompanies);

        dialog.show();
    }


    @Override
    public void setNearestCompany(List<NearCompany> companyList) {
        adapter.setList(companyList);
    }



    @Override
    public void startLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(MapActivity.this);
            progressDialog.setCanceledOnTouchOutside(true);
            //progressDialog.setMessage(s);
        }
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        if (progressDialog != null) progressDialog.dismiss();
    }

    @Override
    public void showAlert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateMap() {
        final Realm realm = Realm.getDefaultInstance();
        mMap.clear();
        List<Company> companies = realm.where(Company.class).findAll();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        MarkerOptions markerOptions = new MarkerOptions();
        if (!companies.isEmpty()) {
            for (Company company : companies) {
                markerOptions.position(new LatLng(company.getCompanyLat(), company.getCompanyLng()));
                markerOptions.title(company.getCompanyName());
                markerOptions.snippet(company.getCompanyId() + "");
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapUtils.createDrawableFromView(this, markerRestIcon)));
                builder.include(markerOptions.getPosition());
                mMap.addMarker(markerOptions);

            }
            bounds = builder.build();
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 100);
            mMap.animateCamera(cu);

        }

        realm.close();

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        try {
            final Company company = realm.where(Company.class).equalTo("companyId", Integer.parseInt(marker.getSnippet())).findFirst();
            DialogMarkerClickBinding dialogBinding = DataBindingUtil.inflate(
                    getLayoutInflater(),
                    R.layout.dialog_marker_click,
                    null,
                    false);
            final Dialog dialog = new Dialog(MapActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setContentView(dialogBinding.getRoot());
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialogBinding.setCompany(company);
            dialog.setCancelable(false);
            dialogBinding.close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();

            return true;
        }catch (Exception e)
        {

        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (checkLocationPermission()) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {


            }
        }

    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }


    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Permission")
                        .setMessage("Location Request")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(MapActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {


                    }

                } else {
                    showAlert("Can't use this feature without location permission");
                    MapActivity.this.finish();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }



        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
        realm.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_refresh:
                mMap.clear();
                binding.fab2.setVisibility(View.GONE);
                presenter.getCompany();
                return true;

          /*  case R.id.action_emergency:
                startActivity(new Intent(this, EmergencyListActivity.class));
                return true;

            case R.id.action_message:
                final Realm realm = Realm.getDefaultInstance();
                User user = realm.where(User.class).findFirst();




                List<Emergency> emergencies = realm.where(Emergency.class).findAll();

                if (!emergencies.isEmpty()) {
                    for (Emergency emergency : emergencies) {
                    try {


                        SmsUtil.sendLocationSMS(emergency.getContact(), myMarker.getPosition().latitude, myMarker.getPosition().latitude,user.getFirstname(),emergency.getName());


                    }catch (Exception e)
                    {
                        Log.d("Error",e+"");
                        showAlert("Can't Access Location");
                    }
                    }
                    showAlert("Sending Emergency Text...");

                }else
                    showAlert("No Emergency Contact!");

                return true;*/

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
