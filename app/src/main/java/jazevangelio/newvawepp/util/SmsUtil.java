package jazevangelio.newvawepp.util;


import android.location.Location;
import android.net.Uri;
import android.telephony.SmsManager;

public class SmsUtil {

/*
    public static void sendLocationSMS(String phoneNumber, Double lat, Double lng,String user, String contact) {


        String uri = "http://maps.google.com/maps?saddr=" + lat+","+lng;

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(uri));
        smsManager.sendTextMessage(phoneNumber, null, "Hi! "+contact+"\n It's me, "+user +" My current location is "+smsBody.toString(), null, null);


    }


    public static void sendTurnOffSMS(String phoneNumber, Double lat, Double lng,String user, String contact) {


        String uri = "http://maps.google.com/maps?saddr=" + lat+","+lng;

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(uri));
        smsManager.sendTextMessage(phoneNumber, null, "Hi! "+contact+"\n It's me, "+user +" I already turn off my Emergency Notification "+smsBody.toString(), null, null);


    }


    public static void sendLocationSMSEmergency(String phoneNumber, Double lat, Double lng,String user, String contact) {


        String uri = "http://maps.google.com/maps?saddr=" + lat+","+lng;

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(uri));
        smsManager.sendTextMessage(phoneNumber, null, "Emergency Notification! \n Hi! "+contact+"\n It's me, "+user +" can you help me? My location is "+smsBody.toString(), null, null);

    }

    public static void sendNotification(String phoneNumber,String user, String contact) {




        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsManager.sendTextMessage(phoneNumber, null, "\n Hi! "+contact+"\n It's me, "+user +" I added you on my emergency contact", null, null);

    }*/




    public static void sendLocationSMS(String phoneNumber, Double lat, Double lng,String user, String contact) {


        String uri = "http://maps.google.com/maps?saddr=" + lat+","+lng;

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(uri));
        smsManager.sendTextMessage(phoneNumber, null, "VAWfreePH: Hi! "+contact+"\nThis is, "+user +". I'm at "+smsBody.toString()+". If you could kindly check up on me. Thank you.", null, null);


    }


    public static void sendTurnOffSMS(String phoneNumber, Double lat, Double lng,String user, String contact) {


        String uri = "http://maps.google.com/maps?saddr=" + lat+","+lng;

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(uri));
        smsManager.sendTextMessage(phoneNumber, null, "VAWfreePH: Hi! "+contact+"\nThis is, "+user +". I have turned off my VAWfreePH emergency alarm. I'm probably fine and I would appreciate of you contact me as soon as possible. Thank you.", null, null);


    }


    public static void sendLocationSMSEmergency(String phoneNumber, Double lat, Double lng,String user, String contact) {


        String uri = "http://maps.google.com/maps?saddr=" + lat+","+lng;

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append(Uri.parse(uri));
        smsManager.sendTextMessage(phoneNumber, null, "VAWfreePH: Hi! "+contact+"\nThis is, "+user +". I triggered my VAWfreePH emergency alarm and I need your help! I'm currently at "+smsBody.toString(), null, null);

    }

    public static void sendNotification(String phoneNumber,String user, String contact) {

        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsManager.sendTextMessage(phoneNumber, null, "VAWfreePH: Hi! "+contact+"\nThis is, "+user +". I'm using this safety app and I've added you as my trusted emergency contact. That means that you will be receiving an alert message any time in case I'm in danger. Thank you.", null, null);

    }

}
