package jazevangelio.newvawepp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class AboutSection extends Fragment {

    private View myView;

    public AboutSection() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_about, container, false);

        WebView view = (WebView) myView.findViewById(R.id.content1);
        String text;
        text = "<html><body><p align=\"justify\">";
        text += "VAWfreePH is a personal safety mobile app developed " +
                "through the partnership of Philippine Commission on Women (PCW) and Technological Institute of the Philippines-Quezon City (TIP-QC). This app aims to provide public awareness and to popularize provisions of existing women human rights laws such as the RA 9262 or Anti-Violence Against" +
                " Women Act and RA 8353 or the Anti-Rape Act among others and to promote advocacy for a safer and fair environment for women. ";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) myView.findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "This mobile app features emergency modules which includes sending discreet SMS message to three (3) selected contacts alerting them of the exact location of the user and SOS button that intends to catch the attention of the people around the user during times of crisis. " +
                "Through this app, user can search for the nearest hospitals and/or police stations that provide services to VAW victim-survivor.";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) myView.findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "Furthermore, this app contains helplines where VAW victim-survivor can seek further assistance. " +
                "Aside from the safety and helpline features, the app provides information to user on the existing women human rights-related laws.";
        view3.loadData(text3, "text/html", "utf-8");

        return myView;
    }


}
