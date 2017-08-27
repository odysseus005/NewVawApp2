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

public class RA8353 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra8353);

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

        // The Anti-Rape Law of 1997 redefines rape as:
        WebView view = (WebView) findViewById(R.id.content1);
        String text;
        text = "<html><body><p align=\"justify\">";
        text += "It is the act of taking photo or video coverage of a person or group of persons performing sexual act or any similar activity or of capturing an image of the private area of a person or persons without the latter's consent, under circumstances in which such person/s has/have a ";
        text += "reasonable expectation of privacy, or the act of selling, copying, reproducing, broadcasting, sharing, showing or exhibiting the photo or video coverage or recordings of such sexual act or similar activity through VCD/DVD, internet, cellular phones and similar means or device without the written consent of the person/s involved, notwithstanding that consent to record or take photo or video coverage of same was given by such persons.";
        text += "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

        //What constitutes rape?
        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "Rape is committed:";
        text2 += "<br/><br/>";
        text2 += "<i>By a man who shall have sexual intercourse with a woman under any of the following circumstances:</i>";
        text2 += "<br/><br/>";
        text2 +="<b>A.</b> Through force, threat, or intimidation;";
        text2 += "<br/><br/>";
        text2 +="<b>B.</b> When the victim is deprived of reason or is unconscious;";
        text2 += "<br/><br/>";
        text2 +="<b>C.</b> Through fraudulent machination or grave abuse of authority; and";
        text2 += "<br/><br/>";
        text2 +="<b>D.</b> When the victim is under twelve (12) years of age or is demented, even if none of the above circumstances are present.";
        text2 += "<br/><br/>";
        text2 += "<i>By any person who, under any of the above circumstances, commits an act of sexual assault by inserting his penis into another person's mouth or anal orifice, or any instrument or object, into the genital or oral orifice of another person.</i>";
        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        // Who can be raped?
        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "Anyone can be a rape victim, but the incidence of rape is more rampant in women and girls?";
        text3 += "</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");

        //Who can commit rape?
        WebView view4 = (WebView) findViewById(R.id.content4);
        String text4;
        text4 = "<html><body><p align=\"justify\">";
        text4 +="Any man or woman may be held liable for rape.";
        text4 += "<br/><br/>";
        text4 += "It is possible that a man may rape his own wife, an act deemed as ”marital rape.";
        text4 += "The penalty for rape in general may apply on the offender who commits marital rape.";
        text4 += "</p></body></html>";
        view4.loadData(text4, "text/html", "utf-8");

        //How is the crime punished?
        WebView view5 = (WebView) findViewById(R.id.content5);
        String text5;
        text5 = "<html><body><p align=\"justify\">";
        text5 +="The penalty varies depending on the act itself and the circumstances surrounding it.";
        text5 += "<br/><br/>";
        text5 += "<b>Reclusion Perpetua</b>";
        text5 += "<br/><br/>";
        text5 += "<i>Imprisonment from 20 to 40 years</i> is imposed on the offender if rape is committed through sexual intercourse.";
        text5 += "<br/><br/>";
        text5 += "<b>Prision Mayor</b>";
        text5 += "<br/><br/>";
        text5 += "<i>Imprisonment from 6 to 12 years</i> is imposed on the offender if rape was committed through oral or anal sex or through the use of any object or instrument that was inserted into the mouth or anal orifice of the woman or man.";
        text5 += "<br/><br/>";
        text5 += "This may also be elevated to <b>Reclusion Temporal</b> <i>Imprisonment from 12 to 20 years</i> or <b>Reclusion Perpetua</b> depending on the circumstances surrounding the crime.";
        text5 += "</p></body></html>";
        view5.loadData(text5, "text/html", "utf-8");

        //How is the crime punished?
        WebView view6 = (WebView) findViewById(R.id.content6);
        String text6;
        text6 = "<html><body><p align=\"justify\">";
        text6 += "<b>1.</b> Advice the victim to seek the help of a counselor or a therapist who is an expert in handling cases of sexual abuse.<br/>";
        text6 += "<br/><br/>";
        text6 += "<b>2.</b> Assist her in securing a safe and temporary shelter if she needs to move to another place for security reasons. She can be referred to a crisis center or any government agency that offers temporary shelter. <br/>";
        text6 += "<br/><br/>";
        text6 += "<b>3.</b> Make sure that the evidence is safe and intact. This would help should the victim decides to file a case. <br/>";
        text6 += "<br/><br/>";
        text6 += "<b>4.</b> Secure a Medico-legal certificate from a Medico-legal officer. Absence of bodily injuries does not mean that rape did not occur or that the case may not be pursued anymore. <br/>";
        text6 += "<br/><br/>";
        text6 += "<b>5.</b> Support the victim along the way when she o decides to file a case. <br/>";
        text6 += "<br/><br/>";
        text6 += "<b>6.</b> Ensure that she is prepared in all aspects. Make her understand the overall picture of the case. Inform her that it is possible that doctors, police, lawyers and judges would not be sensitive to her situation and experience. <br/>";
        text6 += "<br/><br/>";
        text6 += "<b>7.</b> Help the victim choose the lawyer who understands her most. <br/>";
        text6 += "<br/><br/>";
        text6 += "<b>8.</b> Coordinate with people who can assist or supprort her all throughout. <br/>";
        text6 += "</p></body></html>";
        view6.loadData(text6, "text/html", "utf-8");

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://pcw.gov.ph/sites/default/files/documents/laws/republic_act_8353.pdf"));
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