package jazevangelio.newvawepp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class RA9995 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra9995);

        //For Back Button on Title Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Snackbar
        snackout = Snackbar.make(toolbar ,"PDF Downloaded", Snackbar.LENGTH_LONG)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        WebView view = (WebView) findViewById(R.id.content1);
        String text;
        text = "<html><body><p align=\"justify\">";
        text += "It is the act of taking photo or video coverage of a person or group of persons performing sexual act or any similar activity or of capturing an image of the private area of a person or persons without the latter's consent, under circumstances in which such person/s has/have a reasonable expectation of privacy, or the act of selling, copying, reproducing, broadcasting, sharing, showing or exhibiting the photo or video coverage or recordings of such sexual act or similar activity through VCD/DVD, internet, cellular phones and similar means or device without the written consent of the person/s involved, notwithstanding that consent to record or take photo or video coverage of same was given by such persons.";
        text += "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "- When the person believes that one could undress in privacy without being concerned that an image of him or her is being taken; and<br/>";
        text2 += "- When a reasonable person would believe that one’s private area would not be visible regardless of whether the person is in a public or private place.";
        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "- To take photo or video coverage of a person or group of persons performing sexual act or any similar activity or to capture an image of the private area of a person/s such as the naked or undergarment clad genitals, public area, buttocks or female breast without the consent of the person/s involved and under circumstances in which the person/s has/have a reasonable expectation of privacy;<br/>";
        text3 += "<br/><br/>";
        text3 += "-	To copy or reproduce, or to cause to be copied or reproduced, such photo or video or recording of sexual act or any similar activity with or without consideration";
        text3 += "<br/><br/>";
        text3 += "- To sell or distribute, or cause to be sold or distributed, such photo or video or recording of sexual act, whether it be the original copy or reproduction thereof; or";
        text3 += "<br/><br/>";
        text3 += "- To publish or broadcast, or cause to be published or broadcast, whether in print or broadcast media, or show or exhibit the photo or video coverage or recordings of such sexual act or any similar activity through VCD/DVD, internet, cellular phones and other similar means or device.";
        text3 += "</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");

        WebView view4 = (WebView) findViewById(R.id.content4);
        String text4;
        text4 = "<html><body><p align=\"justify\">";
        text4 += "<b>A. Offender is a natural person</b> <br/>";
        text4 += "- Imprisonment of not less than three (3) years but not more than seven (7) years.";
        text4 += "- Fine of not less than One hundred thousand pesos (P100,000.00) but not more than Five hundred thousand pesos (P500,000.00)<br/>";
        text4 += "<b>B. Offender is a juridical person</b> <br/>";
        text4 += "- License or franchise shall be automatically revoked.<br/>";
        text4 += "<b>C. Offender is a public officer or employee</b> <br/>";
        text4 += "- Administratively liable.<br/>";
        text4 += "<b>D. Offender is an alien</b> <br/>";
        text4 += "- Subject to deportation after serving sentence and payment of fines.";
        text4 += "</p></body></html>";
        view4.loadData(text4, "text/html", "utf-8");

        WebView view5 = (WebView) findViewById(R.id.content5);
        String text5;
        text5 = "<html><body><p align=\"justify\">";
        text5 += "If the person merely consented to the taking of the photo or the video recording and did not give written consent for its reproduction, distribution, and broadcasting, then anyone committing the said acts shall be held liable under R.A. 9995.";
        text5 += "</p></body></html>";
        view5.loadData(text5, "text/html", "utf-8");

        WebView view6 = (WebView) findViewById(R.id.content6);
        String text6;
        text6 = "<html><body><p align=\"justify\">";
        text6 += "Any peace officer who is authorized by a written order of the court to use the record as evidence. Provided, that such written order shall only be issued or granted upon written application and the examination under oath or affirmation of the applicant.";
        text6 += "</p></body></html>";
        view6.loadData(text6, "text/html", "utf-8");

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://library.pcw.gov.ph/sites/default/files/republic-act-9995.pdf"));
            startActivity(link);
            return true;
        } else if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //PDF
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_download, menu);
        return true;
    }
}
