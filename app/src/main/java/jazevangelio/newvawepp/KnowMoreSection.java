package jazevangelio.newvawepp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class KnowMoreSection extends Fragment {

    public ImageButton B1, B2, B3, B4, B5;
    private View myView;

    public KnowMoreSection() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_knowmore, container, false);

        Toolbar toolbar = (Toolbar) myView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        TextView titleText = (TextView) myView.findViewById(R.id.titleText);
        TextView titleText1 = (TextView) myView.findViewById(R.id.titleText1);
        TextView titleText2 = (TextView) myView.findViewById(R.id.titleText2);
        TextView titleText3 = (TextView) myView.findViewById(R.id.titleText3);
        TextView titleText4 = (TextView) myView.findViewById(R.id.titleText4);
        TextView titleText5 = (TextView) myView.findViewById(R.id.titleText5);
        TextView titleText6 = (TextView) myView.findViewById(R.id.titleText6);
        TextView titleText7 = (TextView) myView.findViewById(R.id.titleText7);
        TextView titleText8 = (TextView) myView.findViewById(R.id.titleText8);

        Typeface typefaceTitle = Typeface.createFromAsset(getActivity().getAssets(), "fonts/adam_reg.otf");

        titleText.setTypeface(typefaceTitle);
        titleText1.setTypeface(typefaceTitle);
        titleText2.setTypeface(typefaceTitle);
        titleText3.setTypeface(typefaceTitle);
        titleText4.setTypeface(typefaceTitle);
        titleText5.setTypeface(typefaceTitle);
        titleText6.setTypeface(typefaceTitle);
        titleText7.setTypeface(typefaceTitle);
        titleText8.setTypeface(typefaceTitle);

        B1 = (ImageButton) myView.findViewById(R.id.btn1);
        B2 = (ImageButton) myView.findViewById(R.id.btn2);
        B3 = (ImageButton) myView.findViewById(R.id.btn3);
        B4 = (ImageButton) myView.findViewById(R.id.btn4);
        B5 = (ImageButton) myView.findViewById(R.id.btn5);
        addListenerOnImageButton();

        return myView;
    }

    public void addListenerOnImageButton() {

        final Context context = getActivity();
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, KM_AboutVAW.class);
                startActivity(intent1);
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, KM_VAWSec.class);
                startActivity(intent1);
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), KM_Things2Consider.class);
                startActivity(i);
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, KM_AbusiveRelationship.class);
                startActivity(intent1);
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, KM_SafetyTips.class);
                startActivity(intent1);
            }
        });

    }

}
