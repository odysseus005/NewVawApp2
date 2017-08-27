package jazevangelio.newvawepp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Camera;
import android.icu.util.Calendar;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.ui.emergency.EmergencyListActivity;
import jazevangelio.newvawepp.util.SmsUtil;
import im.delight.android.location.SimpleLocation;


public class SOSSection extends AppCompatActivity {

    private MediaPlayer mp;
    private AudioManager audio;
    private int maxVol, currentVol, sampleVolume;
    private boolean hasFlash;
    private Camera camera;
    private boolean isFlashOn, isVolumeOn;
    private Camera.Parameters parameters;
    private TextView tvname, tvphone, flashlightText, volumeText;
    private ImageView flashlightImage, volumeImage, forfakecallImage, foremailImage, forphotoImage;
    private ImageButton SOSButton;
    private Realm realm;

    private static final int CONTENT_REQUEST = 1337;
    private File output = null;

    AlertDialog show;
    private jazevangelio.newvawepp.PulsatorLayout mPulsator;

    private Thread blink;
    private SimpleLocation location;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sos_1);

        realm = Realm.getDefaultInstance();
        //For Back Button on Title Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        location = new SimpleLocation(this);

        mPulsator = (jazevangelio.newvawepp.PulsatorLayout) findViewById(R.id.pulsator);
        //For the Pulsing Ewan
            mPulsator.setCount(3);
            mPulsator.getDuration(7.0);
            mPulsator.setColor(Color.parseColor("#ff5e14"));
            mPulsator.start();

        //For Flashlight
        hasFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!hasFlash) {
            // device doesn't support flash
            // Show alert message and close the application
            android.app.AlertDialog alert = new android.app.AlertDialog.Builder(SOSSection.this)
                    .create();
            alert.setTitle("Error");
            alert.setMessage("Sorry, your device doesn't support flash light!");
            alert.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // closing the application
                    finish();
                }
            });
            alert.show();
            return;
        }

        // get the camera
        getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        getCamera();
        isFlashOn = false;
        flashlightImage = (ImageView) findViewById(R.id.flashlightImage);
        flashlightText = (TextView) findViewById(R.id.flashlightText);
        CardView forFlashlight = (CardView) findViewById(R.id.forFlashlight);
        forFlashlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn) {
                    flashlightText.setText("Flashlight On");
                    isFlashOn = false;
                    blink.interrupt();
                } else {
                    isFlashOn = true;
                    flashlightText.setText("Flashlight Off");
                    //start blinking flash thread
                    blink = new Thread(new Runnable() {
                        public void run() {
                            Camera camera = Camera.open();
                            Camera.Parameters parameters = camera.getParameters();
                            while (isFlashOn == true) {//Will loop until off button is pressed.
                                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);//flash on
                                camera.setParameters(parameters);
                                camera.startPreview();
                                try {
                                    Thread.sleep(100);//sleep for 1 millisecond
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);//flash off
                                camera.setParameters(parameters);
                                camera.startPreview();
                            }
                        }
                    });
                    blink.start();
                }

            }
        });

        //MGA IMAGE VIEW
        volumeImage = (ImageView) findViewById(R.id.volumeImage);
        SOSButton = (ImageButton) findViewById(R.id.SOSButton);
        foremailImage = (ImageView) findViewById(R.id.foremailImage);
        forfakecallImage = (ImageView) findViewById(R.id.forfakecallImage);
        forphotoImage = (ImageView) findViewById(R.id.forphotoImage);

        volumeText = (TextView) findViewById(R.id.volumeText);
        CardView forVolume = (CardView) findViewById(R.id.forVolume);
        forVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVolumeOn==false) {
                    isVolumeOn = true;
                    if(isVolumeOn){
                        //Button sa taas
                        volumeImage.setImageResource(R.drawable.red_sound_off);
                        volumeText.setText("Sound Off");
                        volumeText.setTextColor(Color.parseColor("#ee1c24"));

                            mPulsator.setCount(7);
                            mPulsator.getDuration(2.5);
                            mPulsator.setColor(Color.parseColor("#ee1c42"));
                            mPulsator.start();

                        SOSButton.setBackgroundResource(R.drawable.red_ic_sos);
                        foremailImage.setBackgroundResource(R.drawable.red_ic_email);
                        forfakecallImage.setBackgroundResource(R.drawable.red_ic_phone);
                        forphotoImage.setBackgroundResource(R.drawable.red_ic_camera);

                        flashlightImage.setBackgroundResource(R.drawable.red_flashlight_on);
                        flashlightText.setTextColor(Color.parseColor("#ee1c42"));

                        Toast.makeText(SOSSection.this, "SOUND ON", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    isVolumeOn = false;
                    if(!isVolumeOn){
                        //Button sa taas
                        volumeImage.setImageResource(R.drawable.sound_on);
                        volumeText.setText("Sound On");
                        volumeText.setTextColor(Color.parseColor("#ff5e14"));

                        mPulsator.setCount(3);
                        mPulsator.getDuration(7.0);
                        mPulsator.setColor(Color.parseColor("#ff5e14"));
                        mPulsator.start();

                        SOSButton.setBackgroundResource(R.drawable.ic_sos);
                        foremailImage.setBackgroundResource(R.drawable.ic_email);
                        forfakecallImage.setBackgroundResource(R.drawable.ic_phone);
                        forphotoImage.setBackgroundResource(R.drawable.ic_camera);

                        flashlightImage.setBackgroundResource(R.drawable.flashlight_on);
                        flashlightText.setTextColor(Color.parseColor("#ff5e14"));

                        Toast.makeText(SOSSection.this, "SOUND OFF", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        //Button for Contact
        CardView forContact = (CardView) findViewById(R.id.forContact);
        forContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EmergencyListActivity.class));
            }
        });

        //Button for Message
        CardView forMessage = (CardView) findViewById(R.id.forMessage);
        forMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = realm.where(User.class).findFirst();
                List<Emergency> emergencies = realm.where(Emergency.class).findAll();
                if (!emergencies.isEmpty()) {
                    for (Emergency emergency : emergencies) {
                        try {
                            SmsUtil.sendLocationSMS(emergency.getContact(), location.getLatitude(), location.getLongitude(),user.getFirstname(),emergency.getName());
                        }catch (Exception e)
                        {
                            Log.d("Error",e+"");
                            showAlert("Can't Access Location");
                        }
                    }
                    showAlert("Sending Emergency Text...");

                }else
                    showAlert("No Emergency Contact! Add ");


            }
        });


        //Button for FakeCall
        CardView forFakeCall = (CardView) findViewById(R.id.forFakeCall);
        forFakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogForFakeCall();
            }
        });

        //Button for TakePhoto
        CardView forTakePhoto = (CardView) findViewById(R.id.forTakePhoto);
        forTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        //Button for SOS, yung pinakagitna teh
        ImageButton forSOSButton = (ImageButton) findViewById(R.id.SOSButton);
        forSOSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FOR SOS TO, di to yung para sa flashlight
                if (isFlashOn) {
                    flashOff();
                } else {
                    openDialogForSOSButton();
                    if(isVolumeOn==false){
                        isFlashOn = true;
                        flashlightText.setText("Flashlight Off");
                        //start blinking flash thread
                        blink = new Thread(new Runnable() {
                            public void run() {
                                Camera camera = Camera.open();
                                Camera.Parameters parameters = camera.getParameters();
                                while (isFlashOn == true) {//Will loop until off button is pressed.
                                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);//flash on
                                    camera.setParameters(parameters);
                                    camera.startPreview();
                                    try {
                                        Thread.sleep(100);//sleep for 1 millisecond
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);//flash off
                                    camera.setParameters(parameters);
                                    camera.startPreview();
                                }
                            }
                        });
                        blink.start();
                    }else {
                        flashOn();
                    }

                }
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            Intent i = new Intent(SOSSection.this, MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SOSSection.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    //For Flashlight
    //Method for turning on Flash
    public void flashOn(){
        isFlashOn = true;

        //Initialize and play sound
        mp = MediaPlayer.create(SOSSection.this, R.raw.alarm);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }
        });
        mp.start();

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        currentVol = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVol = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, maxVol, AudioManager.FLAG_SHOW_UI);
        audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

        //start blinking flash thread
        blink = new Thread(new Runnable() {
            public void run() {
                Camera camera = Camera.open();
                Camera.Parameters parameters = camera.getParameters();
                while (isFlashOn == true) {//Will loop until off button is pressed.
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);//flash on
                    camera.setParameters(parameters);
                    camera.startPreview();
                    try {
                        Thread.sleep(100);//sleep for 1 millisecond
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);//flash off
                    camera.setParameters(parameters);
                    camera.startPreview();
                }
            }
        });
        blink.start();
    }

    //Turning Off flash
    public void flashOff() {
        isFlashOn = false;
        blink.interrupt();

        //stop audio
        try {
            mp.reset();
            mp.prepare();
            mp.stop();
            mp.release();
            mp = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Get the camera
    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                parameters = camera.getParameters();
            } catch (RuntimeException e) {
                Log.e(" ", e.getMessage());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // on pause turn off the flash
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (checkLocationPermission()) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                location = new SimpleLocation(this);
                location.beginUpdates();
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        getCamera();
        sampleVolume = 0;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
            camera = null;
        }

    }

    //For Fake Call
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri contactData = data.getData();
            Cursor c =  getContentResolver().query(contactData, null, null, null, null);
            if (c.moveToFirst()) {

                String phoneNumber="",emailAddress="";
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                //http://stackoverflow.com/questions/866769/how-to-call-android-contacts-list   our upvoted answer

                String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if ( hasPhone.equalsIgnoreCase("1"))
                    hasPhone = "true";
                else
                    hasPhone = "false" ;

                if (Boolean.parseBoolean(hasPhone))
                {
                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ contactId,null, null);
                    while (phones.moveToNext())
                    {
                        phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    phones.close();
                }

                tvname.setText(" "+name);
                tvphone.setText(" "+phoneNumber);
                Log.d("curs", name + " num" + phoneNumber + " ");
            }
            c.close();
        }
    }
    public void setUpAlarm(long selectedTimeInMilliseconds, String fakeName, String fakeNumber) {
        Intent intents = new Intent(this, FakeRingingActivity.class);
        intents.putExtra("myfakename", fakeName);
        intents.putExtra("myfakenumber", fakeNumber);
        startActivity(intents);
        finish();
    }

    public void openDialogForFakeCall(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_for_fakecall, null);
        tvname = (TextView) view1.findViewById(R.id.tvname);
        tvphone = (TextView) view1.findViewById(R.id.tvphone);
        show = builder.create();

        Button fakeContact = (Button) view1.findViewById(R.id.btnContact);
        fakeContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        Button fakeCallButton = (Button) view1.findViewById(R.id.btnCall);
        fakeCallButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int selectedTime = 0;

                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(java.util.Calendar.SECOND, 0);
                long currentFakeTime =  calendar.getTimeInMillis();

                String fakeNameEntered = tvname.getText().toString();
                String fakeNumberEntered = tvphone.getText().toString();
                if(fakeNameEntered.equals("") || fakeNumberEntered.equals("")){
                    Toast.makeText(SOSSection.this, "You must both name and number", Toast.LENGTH_SHORT).show();
                    return;
                }
                System.out.println("Fake name" + fakeNameEntered);
                System.out.println("Fake number" + fakeNumberEntered);

                setUpAlarm(currentFakeTime, fakeNameEntered, fakeNumberEntered);
            }
        });

        builder.setView(view1);
        builder.show();

    }

    //Take Photo
    private void openCamera() {
        FileOutputStream fos = null;
        String status = Environment.getExternalStorageState();

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            File dir = new File(Environment.getExternalStorageDirectory(),
                    "DCIM");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String filename = "" + System.currentTimeMillis();
            File output = new File(dir, filename + ".jpg");
            i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
            startActivityForResult(i, CONTENT_REQUEST);
        }
    }

    //For SOS
    public void openDialogForSOSButton() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_for_sos, null);
        show = builder.create();




        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        location = new SimpleLocation(SOSSection.this);
                        User user = realm.where(User.class).findFirst();
                        List<Emergency> emergencies = realm.where(Emergency.class).findAll();
                        if (!emergencies.isEmpty()) {
                            for (Emergency emergency : emergencies) {
                                try {
                                    SmsUtil.sendLocationSMSEmergency(emergency.getContact(), location.getLatitude(), location.getLongitude(),user.getFirstname(),emergency.getName());
                                }catch (Exception e)
                                {
                                    Log.d("Error",e+"");
                                    showAlert("Can't Access Location");
                                }
                            }
                            showAlert("Sending Emergency Text...");

                        }else
                            showAlert("No Emergency Contact! Add ");




                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {

                            @Override
                            public void run() {

                            }
                        }, 300000);

                    }
                });
            }
        }, 0, 300000);

        //Button for TakePhoto
        CardView forTurnOffAlarm = (CardView) view1.findViewById(R.id.forTurnOffAlarm);
        forTurnOffAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFlashOn){
                    flashOff();
                    show.dismiss();
                }
                timer.cancel();
            }
        });
        //Button for TakePhoto
        CardView forCall911 = (CardView) view1.findViewById(R.id.forCall911);
        forCall911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel: 911");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(uri);
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                show.dismiss();
            }
        });

        builder.setView(view1);
        builder.show();
        builder.setCancelable(true);

        mp = MediaPlayer.create(SOSSection.this, R.raw.alarm);
        if(!show.isShowing()){
            if(isFlashOn){
                flashOff();
            }
            if (mp.isPlaying()) {
                mp.stop();
            }
        }
    }


    public void showAlert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
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
                                ActivityCompat.requestPermissions(SOSSection.this,
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
                    SOSSection.this.finish();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }



        }
    }

}
