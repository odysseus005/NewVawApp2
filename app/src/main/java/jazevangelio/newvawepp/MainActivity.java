package jazevangelio.newvawepp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.FacebookSdk;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import jazevangelio.newvawepp.app.Constants;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.ui.login.LoginActivity;
import jazevangelio.newvawepp.ui.map.hospital.MapActivity;
import jazevangelio.newvawepp.ui.map.police.MapPoliceActivity;
import jazevangelio.newvawepp.ui.profile.ProfileActivity;
import jazevangelio.newvawepp.util.CircleTransform;

import static android.view.View.GONE;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final int SMS_PERMISSION_CODE = 0;
    private static final int MY_PERMISSIONS_REQUEST = 1;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    Realm realm;
    User user;
    private TextView txtName;
    private TextView txtEmail;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_main);

        int Permission_All = 1;
        String[] Permissions = {Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION};
        if(!hasPermissions(this, Permissions)){
            ActivityCompat.requestPermissions(this, Permissions, Permission_All);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.colorPrimaryDark)));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //About Section
        WebView view = (WebView) findViewById(R.id.content1);
        String text;
        text = "<html><body><p align=\"justify\">";
        text += "VAWfreePH is a personal safety mobile app developed " +
                "through the partnership of Philippine Commission on Women (PCW) and Technological Institute of the Philippines-Quezon City (TIP-QC). This app aims to provide public awareness and to popularize provisions of existing women human rights laws such as the RA 9262 or Anti-Violence Against" +
                " Women Act and RA 8353 or the Anti-Rape Act among others and to promote advocacy for a safer and fair environment for women. ";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "This mobile app features emergency modules which includes sending discreet SMS message to three (3) selected contacts alerting them of the exact location of the user and SOS button that intends to catch the attention of the people around the user during times of crisis. " +
                "Through this app, user can search for the nearest hospitals and/or police stations that provide services to VAW victim-survivor.";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "Furthermore, this app contains helplines where VAW victim-survivor can seek further assistance. " +
                "Aside from the safety and helpline features, the app provides information to user on the existing women human rights-related laws.";
        view3.loadData(text3, "text/html", "utf-8");
        realm = Realm.getDefaultInstance();
        user = realm.where(User.class).findFirst();
        txtName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvNumber1);
        txtEmail= (TextView) navigationView.getHeaderView(0).findViewById(R.id.txt_email);
        imgProfile = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imageView);
        if (user != null) {
            updateUI();
        }


    }

    private void updateUI() {

        txtName.setText(user.getFirstname());
        txtEmail.setText(user.getEmail());
        String imageURL = "https://payapp.tip.edu.ph/api/storage/app/image/default_buyer.png";
        if (user.getImage() != null && !user.getImage().isEmpty()) {
            imageURL = Constants.URL_IMAGE+user.getImage()+".jpg";
        }

//        if (user.getFbID() != null && !user.getFbID().isEmpty()) {
//            imageURL2 = Endpoints.IMAGE_URL_FB.replace(Endpoints.IMG_HOLDER, user.getFbID());
//        }

        Log.d("MainActivity", "imageUrl: " + imageURL);
        Glide.with(this)
                .load(imageURL)
                .transform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            dialogOnBackPress();
        }
    }

    protected void dialogOnBackPress() {
        new android.support.v7.app.AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        final RelativeLayout linearCF = (RelativeLayout) findViewById(R.id.linear_cf);
        FragmentManager fragmentManager = getSupportFragmentManager();
        String title;
        final Context con = this;
        if (id == R.id.home) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    linearCF.setVisibility(View.VISIBLE);
                    Intent i = new Intent(con, MainActivity.class);
                    startActivity(i);
                }
            }, 250);
            //finish();
        } else if (id == R.id.nav_laws) {
            linearCF.setVisibility(GONE);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new KnowMoreSection())
                    .commit();
            title = "VAW Laws";
            getSupportActionBar().setTitle(title);
        } else if (id == R.id.nav_danger) {
            linearCF.setVisibility(GONE);
            Intent i = new Intent(MainActivity.this, SOSSection.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_seekhelp) {
            linearCF.setVisibility(GONE);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new SeekHelpSection())
                    .commit();
            title = "Seek Help";
            Toast.makeText(this, "Seek Help",
                    Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_hospital) {
            startActivity(new Intent(this, MapActivity.class));
        }else if (id == R.id.nav_police) {
            startActivity(new Intent(this, MapPoliceActivity.class));
        } else if (id == R.id.Logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Log Out");
            builder.setMessage("Are you sure?");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Do nothing but close the dialog
                    final Realm realm = Realm.getDefaultInstance();
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.deleteAll();
                        }
                    }, new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            realm.close();
                            // TODO: 12/4/2016 add flag to clear all task
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            MainActivity.this.finish();
                        }
                    }, new Realm.Transaction.OnError() {
                        @Override
                        public void onError(Throwable error) {
                            realm.close();
                            Log.e("TAG", "onError: Error Logging out (deleting all data)", error);
                        }
                    });
                    finish();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // Do nothing
                    dialog.dismiss();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if (id == R.id.Account) {
            startActivity(new Intent(this, ProfileActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static boolean hasPermissions(Context context, String... permissions){

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && context!=null && permissions!=null){
            for(String permission: permissions){
                if(ActivityCompat.checkSelfPermission(context, permission)!=PackageManager.PERMISSION_GRANTED){
                    return  false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case SMS_PERMISSION_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // SMS related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
            case MY_PERMISSIONS_REQUEST:{
                if(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                }else{

                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_CAMERA:{
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_LOCATION:{
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                }
                return;
            }
        }
    }


}
