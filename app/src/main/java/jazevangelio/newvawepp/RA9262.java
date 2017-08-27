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

public class RA9262 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra9262);

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
        text += "Any act of gender-based violence that results in or is likely result in physical, sexual or psychological harm or suffering to women, including threats of such acts, coercion or arbitrary deprivation of liberty, whether occuring in public or private (UNCEDAW, 1993).";
        text += "<br/><br/>";
        text += "VAW arises from unequal power relations between women and men and become socially acceptable through traditional and cultural beliefs, norms and social institutions.";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "The general term used to describe violence that occurs as a result of role expectations associated with women and men, the power relations between them, and specific contexts in their society. It means that women are subjected to violence or abuse because they are women.";
        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "Anti-Violence Against Women and their Children (VAWC) Act of 2004 seeks to address the prevalence against women and their children (VAWC) by their intimate partners like:";
        text3 += "<br/><br/>";
        text3 += "- Husband or ex-husband<br/>";
    //    text3 += "<br/><br/>";
        text3 += "- Live-in partner or former live-in partner<br/>";
    //    text3 += "<br/><br/>";
        text3 += "- Boyfriend/girlfriend or ex-boyfriend/ex-girifriend<br/>";
    //    text3 += "<br/><br/>";
        text3 += "- Dating partner or former dating partner";
        text3 += "<br/><br/>";
        text3 += "<b><i>Classifies VAWC as a public crime.</b></i>";
        text3 += "</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");

        WebView view4 = (WebView) findViewById(R.id.content4);
        String text4;
        text4 = "<html><body><p align=\"justify\">";
        text4 += "It refers to any act or series of acts committed by any person against a woman who is his wife, former wife, or against a woman with whom the person has or had sexual or dating relationship, or with whom he has a common child, or against her child whether legitimate or illegitimate, within or without the family abode, which result in or is likely to result in physical, sexual, psychological harm or suffering,\n" +
                "or economic abuse including threats of such acts, battery, assault, coercion, harassment or arbitrary deprivation of liberty.";
        text4 += "<br/><br/>";
        text4 += "Children are those below 18 years of age or older but are incapable of taking care of themselves (as stated in RA 7610). It includes biological children of the victim and other children under her care.";
        text4 += "<br/><br/>";
        text4 += "Dating relationship is one which has a romantic involvement. it means that a relationship existed between a woman and a partner who is abusive or has previously abused her, whether or not the relationship was formal.";
        text4 += "<br/><br/>";
        text4 += "Sexual relations refer to a single sexual act which may or may not result in the bearing of a common child.";
        text4 += "</p></body></html>";
        view4.loadData(text4, "text/html", "utf-8");

        WebView view5 = (WebView) findViewById(R.id.content5);
        String text5;
        text5 = "<html><body><p align=\"justify\">";
        text5 += "<b>1. PHYSICAL VIOLENCE</b> refers to acts that include bodily or physical harm;";
        text5 += "<br/><br/>";
        text5 += "<b>2. SEXUAL VIOLENCE</b> refers to an act which is sexual in nature, committed against a woman or her child. It includes, but is not limited to:";
        text5 += "<br/><br/>";
        text5 += "<b>2.a.</b> Rape, sexual harassment, acts of Iasciviousness, treating a woman or her child as a sex abject, making demeaning and sexually suggestive remarks, physically attacking the sexual parts of the victim\\'s body, forcing the victim to watch obscene publications and indecent shows or forcing the woman or her child to do indecent acts and/or make films thereof, forcing the wife and mistress/lover to live in the conjugal home or sleep together in the same room with the abuser;";
        text5 += "<br/><br/>";
        text5 += "<b>2.b.</b> Acts causing or attempting to cause the victim to engage in any sexual activity by force, threat offorce, physical or other harm or threat of physical or other harm or coercion; and";
        text5 += "<br/><br/>";
        text5 += "<b>2.c.</b> Prostituting the woman or her child.";
        text5 += "<br/><br/>";
        text5 += "<b>3. PSYCHOLOGICAL VIOLENCE </b> refers to acts or omissions causing or likely to cause mental or emotional suffering of the victim such as but not limited to intimidation, harassment, stalking, damage to property, public ridicule or humiliation, repeated verbal abuse and marital infidelity. it includes causing or allowing the victim to witness the physical, sexual, or psychological abuse of a member of the family to which the victim belongs, or to witness pornography in any form or to witness abusive injury to pets or unlawful or unwanted deprivation of the right to custody and/or visitation of common children.";
        text5 += "<br/><br/>";
        text5 += "<b>4. ECONOMIC ABUSE</b> refers to acts that make or attempt to make a woman financially dependent.";
        text5 += "<br/><br/>";
        text5 += "This includes but is not limited to the following:";
        text5 += "<br/><br/>";
        text5 += "Withdrawal of financial support or preventing the victim from engaging in any legitimate profession, occupation, business or activity, deprivation of financial resources and the right to conjugal community or property owned in common, destroying household property or controlling the victim‘s own money or properties.";
        text5 += "</p></body></html>";
        view5.loadData(text5, "text/html", "utf-8");

        WebView view6 = (WebView) findViewById(R.id.content6);
        String text6;
        text6 = "<html><body><p align=\"justify\">";
        text6 += "The law recognizes the unequal relations between a man and a woman in an abusive relationship where the woman is usually at a disadvantage. Thus the law protects the woman and her children.\n\\n\\n-The law recognizes the unequal relations between a man and a woman in an abusive relationship where the woman is usually at a disadvantage. Thus the law protects the woman and her children.";
        text6 += "<br/><br/>";
        text6 += "The victim-child who is a minor (legitimate and illegitimate), and a person aged 18 years and beyond who doesn\\'t have the ability to decide for herself/himself because of an emotional, physical and mental illness can make full use of the law.";
        text6 += "<br/><br/>";
        text6 += "Any child under the care of a woman is also protected under the law.";
        text6 += "</p></body></html>";
        view6.loadData(text6, "text/html", "utf-8");

        WebView view7 = (WebView) findViewById(R.id.content7);
        String text7;
        text7 = "<html><body><p align=\"justify\">";
        text7 += "Under the law, the offended party may file a criminal action, or apply for Protection Order either as an independent action or as an incident in civil or criminal action and other remedies.";
        text7 += "</p></body></html>";
        view7.loadData(text7, "text/html", "utf-8");

        WebView view8 = (WebView) findViewById(R.id.content8);
        String text8;
        text8 = "<html><body><p align=\"justify\">";
        text8 += "Women can also be liable under the law. These are the lesbian partners/girlfriends or former partners of the victim with whom she has or had a sexual or dating relationship.";
        text8 += "</p></body></html>";
        view8.loadData(text8, "text/html", "utf-8");

        WebView view9 = (WebView) findViewById(R.id.content9);
        String text9;
        text9 = "<html><body><p align=\"justify\">";
        text9 += "He may file a complaint or case under the Revised Penal Code.";
        text9 += "</p></body></html>";
        view9.loadData(text9, "text/html", "utf-8");

        WebView view10 = (WebView) findViewById(R.id.content10);
        String text10;
        text10 = "<html><body><p align=\"justify\">";
        text10 += "Any citizen having personal knowledge of the circumstances involving the commission of the crime may file a complaint because violence against women and their children is considered a PUBLIC crime.";
        text10 += "</p></body></html>";
        view10.loadData(text10, "text/html", "utf-8");

        WebView view11 = (WebView) findViewById(R.id.content11);
        String text11;
        text11 = "<html><body><p align=\"justify\">";
        text11 += "Cases may be filed in the Regional Trial Court designated as FAMILY COURT of the place where the crime was committed. These courts have original and exclusive jurisdiction over these cases.";
        text11 += "</p></body></html>";
        view11.loadData(text11, "text/html", "utf-8");

        WebView view12 = (WebView) findViewById(R.id.content12);
        String text12;
        text12 = "<html><body><p align=\"justify\">";
        text12 += "Offenders proven in court to be guilty of the crime shall be penalized with:";
        text12 += "<br/><br/>";
        text12 += "<b>a.</b> Imprisonment ranging from 1 month and 1 day to 20 years.<br/>";
        text12 += "<b>b.</b> Payment of P100,000 to P300,000 in damages.<br/>";
        text12 += "<b>c.</b> Mandatory psychological counseling or psychiatric treatment.";
        text12 += "</p></body></html>";
        view12.loadData(text12, "text/html", "utf-8");

        WebView view13 = (WebView) findViewById(R.id.content13);
        String text13;
        text13 = "<html><body><p align=\"justify\">";
        text13 += "RA 9262 acknowledges that women who have retaliated against their partner or who commit violence as a form of self-defense may have suffered from Battered Woman Syndrome (BWS).";
        text13 += "<br/><br/>";
        text13 += "BWS refers to a pattern of psychological and behavioral Symptoms found in battered women as a result of a long history of abuse.";
        text13 += "<br/><br/>";
        text13 += "Any victim who suffers from BWS should be diagnosed by a Psychiatric expert or a clinical psychologist. This will also help the victim in obtaining a just decision in her case.";
        text13 += "<br/><br/>";
        text13 += "The law does not allow the offender to have custody of minor children. Their care is still entrusted to the woman even if she is found to have BWS.";
        text13 += "</p></body></html>";
        view13.loadData(text13, "text/html", "utf-8");

        WebView view14 = (WebView) findViewById(R.id.content14);
        String text14;
        text14 = "<html><body><p align=\"justify\">";
        text14 += "It is an order issued by the Barangay or the Court to prevent further acts of violence against a woman or her child and to grant other necessary relief, under RA 9262. There are three (3) kinds of protection order:";
        text14 += "<br/><br/>";
        text14 += "<b>1.</b> Barangay Protection Order(BPO)<br/>";
        text14 += "<b>2.</b> Temporary Protection Order (TPO)<br/>";
        text14 += "<b>3.</b> Permanent Protection Order (PPO)";
        text14 += "</p></body></html>";
        view14.loadData(text14, "text/html", "utf-8");

        WebView view15 = (WebView) findViewById(R.id.content15);
        String text15;
        text15 = "<html><body><p align=\"justify\">";
        text15 += "Anyone of the following may apply for protection order:";
        text15 += "<br/><br/>";
        text15 += "<b>a.</b> the offended party.";
        text15 += "<br/><br/>";
        text15 += "<b>b.</b> parents, or guardians of the offended party.";
        text15 += "<br/><br/>";
        text15 += "<b>c.</b> ascendants, descendants or collateral relatives, within the fourth civil degree or consanguinity or affinity";
        text15 += "<br/><br/>";
        text15 += "<b>d.</b> officers or social workers of the DSWD or LGUs.";
        text15 += "<br/><br/>";
        text15 += "<b>e.</b> police officers, preferably those in-charge of women and children’s desk.";
        text15 += "<br/><br/>";
        text15 += "<b>f.</b> punong barangay or barangay kagawad";
        text15 += "<br/><br/>";
        text15 += "<b>g.</b> lawyers, counselors, therapists, health care providers of the petitioner.";
        text15 += "<br/><br/>";
        text15 += "<b>h.</b> at least two (2) concerned citizens of the city or municipality where VAWC happened and who have personal knowledge of the offense committed.";
        text15 += "</p></body></html>";
        view15.loadData(text15, "text/html", "utf-8");

    }

    // Start - PDF Download
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://www.pcw.gov.ph/sites/default/files/documents/resources/ra_9262_and_irr.pdf"));
            startActivity(link);
            return true;
        } else if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_download, menu);
        return true;
    }
    // End - PDF Download
}

