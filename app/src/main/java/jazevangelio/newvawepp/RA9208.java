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

public class RA9208 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra9208);

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

        WebView view1 = (WebView) findViewById(R.id.content1);
        String text1;
        text1 = "<html><body><p align=\"justify\">";
        text1 += "<b><i>Trafficking in persons is an Illegal act and ls considered a violation of human rights. it has three (3) inter-related and inter-related elements for a situation to be considered trafficking in persons:</i></b><br/><br/>";
        text1 += "<b>ACTS</b><br/>";
        text1 += "It involves the recruitment, obtaining, hiring, providing, offering, transportation, transfer, maintaining, harboring, or receipt of persons with or without the victim\\'s consent or knowledge, within or across national borders;<br/><br/>";
        text1 += "<b>MEANS</b><br/>";
        text1 += "It is committed by use of threat, or use of force, or other forms or coercion, abduction, fraud, deception, abuse of power or of position, taking advantage of the vulnerability of the person, or the giving or receiving of payments or benefits to achieve the consent of a person having control over another person; and<br/><br/>";
        text1 += "<b>PURPOSE</b><br/>";
        text1 += "It is done for the purpose of exploitation or the prostitution of others or other forms of sexual exploitation, forced labor or services, slavery, involuntary servitude or the removal or sale of organs.<br/><br/><br/>";
        text1 += "<i>The recruitment, transportation, transfer, harboring, adoption or receipt of a child for the purpose of exploitation or when the adoption ls induced by any form of consideration for exploitative purposes shall also be considered as 'trafficking in persons' even if it does not in valve any of the means mentioned above.</i>";
        text1 += "</p></body></html>";
        view1.loadData(text1, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "<b>1. Acts of TIP </b><i>includes all acts committed by any natural or juridical person where all the three elements of TIP (acts, means purpose) are present. Some examples are: </i><br/>";
        text2 += "- recruitment, hiring, offering, transferring, harboring or receiving any person for the purpose of <b>prostitution, pornography or sexual exploitation, under the pretext of domestic or overseas employment or apprenticeship</b>;<br/>";
        text2 += "- undertaking or organizing tours and travel plans consisting of tourism packages or activities for the purpose of utilizing and offering persons for prostitution, pornography or sexual exploitation;<br/>";
        text2 += "- maintaining or hiring a person to engage in prostitution or pornography;<br/>";
        text2 += "- adopting persons by any form of consideration for <b>exploitative purposes</b>; and<br/>";
        text2 += "- recruitment, hiring, adopting, transporting, obtaining, harboring, offering, receiving or abducting a person, by means of threat or use of force, fraud, deceit, violence, coercion, or intimidation for the purpose of <b>removal or sale of organs of said person.</b><br/><br/>";
        text2 += "Any person found guilty of acts of TIP shall be penalized with imprisonment of twenty years and a fine of not less than a million but not more than 2 million pesos.<br/><br/>";

        text2 += "<b>2. Acts of Promote TIP </b><i>includes all acts that encourages or facilitates TlP such as: </i><br/>";
        text2 += "- knowingly using or allowing the use of any house or establishment for promoting TIP;<br/>";
        text2 += "- facilitating the use of tampered or fake documents to evade government regulatory and pre-departure requirements;<br/>";
        text2 += "- production, publication, broadcast and distribution, including use of ICT for propaganda materials that promote TIP;<br/>";
        text2 += "- assisting in the conduct of misrepresentation or fraud in securing clearances and necessary exit documents from government, and facilitating exit/entry of persons possessing tampered or fraudulent travel documents for promoting TIP;<br/>";
        text2 += "- preventing a trafficked person from seeking redress from appropriate agencies by confiscating or destroying his/her passport, travel or personal documents;<br/>";
        text2 += "- tampering with or destroying of evidence, or influencing or attempting to influence witnesses in an investigation or prosecution of a TlP case;<br/>";
        text2 += "- destroying, concealing, removing, confiscating or possessing travel and/or working documents of any person in order to maintain the labor or services of that person; and<br/>";
        text2 += "- using one's office to impede the investigation, prosecution or execution of lawful orders in a case.<br/><br/>";
        text2 += "Any person found guilty of acts that promote TlP shall be penalized with imprisonment of 15 years and a fine of not less than 500 thousand but not more than 1 million pesos.<br/><br/>";

        text2 += "<b>3. Use of Trafficked Persons </b><i>any person who buys or engages the services of trafficked persons for prostitution shall be penalized with imprisonment ranging from six (6) years to forty (40) years and fine ranging from 50 thousand to 5 million pesos.</i><br/><br/>";
        text2 += "<i>In addition to imprisonment and line, an offender who is a foreigner shall be immediately deported and permanently barred from entering the country after serving jail terms, while an offender who is a public official shall be dismissed from service and suffer perpetual absolute disqualification to hold public office. </i><br/>";


        text2 += "<b>4. Qualified TIP </b><i>the act will be considered as qualified TIP when:</i><br/><br/>";
        text2 += "- the trafficked person is a child;<br/>";
        text2 += "- there is adoption under RA 8043 (Inter-Country Adoption Act) and said adoption is for the purpose of prostitution, pornography, sexual exploitation, forced labor, slavery, involuntary servitude or debt bondage;<br/>";
        text2 += "- the crime is committed by a syndicate or is large scale;<br/>";
        text2 += "- the offender is a spouse, ascendant, parent, sibling, guardian or a person who exercises authority over the trafficked person;<br/>";
        text2 += "- the offense is committed by a public official or employee;<br/>";
        text2 += "- the trafficked person is recruited to engage in prostitution with any member of the military or law enforcement agencies;<br/>";
        text2 += "- the offender is a member of the military or law enforcement agencies;<br/>";
        text2 += "- the trafficked person died, became insane, suffered mutilation, or got infected with HIV/AIDS;<br/>";
        text2 += "- the offender commits one or more acts of TIP over a period of 60 or more days; and<br/>";
        text2 += "- the offender directs or through another manages the trafficking victim in carrying out the exploitative purpose of trafficking.<br/><br/>";
        text2 += "Qualified trafficking shall be penalized by life imprisonment and a fine of not less than 2 million but not more than 5 million pesos.<br/><br/>";

        text2 += "<b>5. Attempted TIP </b><i>where there are acts to initiate the commission of a trafficking offense but the offender failed to or did not execute all the elements of the crime, by accident or by reason a voluntary desistance, such overt acts shall be dee commit an act of TIP in cases where the victim is a child, any of the following acts shall also be deemed as attempted TIP:</i><br/><br/>";
        text2 += "- facilitating the travel of a child who travels alone to a foreign country or territory without valid reason and without the required clearance or permit from the DSWD, or a written permit or justification from the child’s parent or legal guardian;<br/>";
        text2 += "- executing, for a consideration, an affidavit of consent or a written consent for adoption;<br/>";
        text2 += "- recruiting a woman to bear a child for the purpose of selling the child;<br/>";
        text2 += "- simulating a birth for the purpose of selling the child; and<br/>";
        text2 += "- soliciting a child and acquiring the custody thereof through any means, for the purpose of selling the child.<br/><br>";
        text2 += "Any person found guilty of committing attempted TlP shall be penalized with imprisonment of 15 years and a fine of pot less than 500 thousand but not more than 1 million pesos<br/>";

        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://library.pcw.gov.ph/sites/default/files/ra-9208-trafficking-irr.pdf"));
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

