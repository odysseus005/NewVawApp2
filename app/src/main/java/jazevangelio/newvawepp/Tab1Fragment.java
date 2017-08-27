package jazevangelio.newvawepp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by User on 2/28/2017.
 */

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";
    public ToggleButton num1, num2, num3, num4, num5, num6, num7, num8, email1;
    private Uri uri; Intent emailIntent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.helpdesk1_fragment,container,false);

        //Num
        num1 = (ToggleButton) myView.findViewById(R.id.btnHot1);
        num2 = (ToggleButton) myView.findViewById(R.id.btnHot2);
        num3 = (ToggleButton) myView.findViewById(R.id.btnHot3);
        num4 = (ToggleButton) myView.findViewById(R.id.btnHot4);
        num5 = (ToggleButton) myView.findViewById(R.id.btnHot5);
        num6 = (ToggleButton) myView.findViewById(R.id.btnHot6);
        num7 = (ToggleButton) myView.findViewById(R.id.btnHot7);
        num8 = (ToggleButton) myView.findViewById(R.id.btnHot8);
        //Email
        email1 = (ToggleButton) myView.findViewById(R.id.btnEmail1);

        num1.setOnClickListener(onClickListener);
        num2.setOnClickListener(onClickListener);
        num3.setOnClickListener(onClickListener);
        num4.setOnClickListener(onClickListener);
        num5.setOnClickListener(onClickListener);
        num6.setOnClickListener(onClickListener);
        num7.setOnClickListener(onClickListener);
        num8.setOnClickListener(onClickListener);

        email1.setOnClickListener(onClickListener);
        return myView;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            switch(v.getId()){

                //Num
                case R.id.btnHot1:
                    uri = Uri.parse("tel: 6313014");
                    intentHere();
                    break;
                case R.id.btnHot2:
                    uri = Uri.parse("tel: 6313018");
                    intentHere();
                    break;
                case R.id.btnHot3:
                    uri = Uri.parse("tel: 4266001");
                    intentHere();
                    break;
                case R.id.btnHot4:
                    uri = Uri.parse("tel: 3538762");
                    intentHere();
                    break;
                case R.id.btnHot5:
                    uri = Uri.parse("tel: +639175839343");
                    intentHere();
                    break;
                case R.id.btnHot6:
                    uri = Uri.parse("tel: +09199918264");
                    intentHere();
                    break;
                case R.id.btnHot7:
                    uri = Uri.parse("tel: 7217738");
                    intentHere();
                    break;
                case R.id.btnHot8:
                    uri = Uri.parse("tel: 9214389");
                    intentHere();
                    break;

                //Email
                case R.id.btnEmail1:
                    Toast.makeText(getActivity(), "Email Section Intent.", Toast.LENGTH_SHORT).show();
//                    emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{String.valueOf(R.string.email_1)});
//                    sendEmail();
                    break;
                default:
                    break;
            }

        }
    };

    public void intentHere(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        startActivity(intent);

    }

//    @SuppressLint("LongLogTag")
//    public void sendEmail() {
//        Log.i("Send email", "");
//        String[] TO = {""};
//        String[] CC = {""};
//        emailIntent = new Intent(Intent.ACTION_SEND);
//
//        emailIntent.setData(Uri.parse("mailto:"));
//        emailIntent.setType("text/plain");
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//        emailIntent.putExtra(Intent.EXTRA_CC, CC);
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
//        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
//
//        try {
//            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
//            this.getActivity().finish();
//            Log.i("Finished sending email...", "");
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(getActivity(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
//        }
//    }
}
