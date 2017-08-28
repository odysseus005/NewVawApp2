package jazevangelio.newvawepp.util;


import android.location.Location;
import android.net.Uri;
import android.telephony.SmsManager;

public class SmsUtil {


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

    }

}
