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

public class RA8505 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra8505);

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
        text += "An act Providing assistance and Protection for rape victims, Establishing for the purpose a Rape crisis center in every Province and city, authorizing The appropriation of funds Therefor, and for other purposes.";
        text += "<br/><br/>";
        text +="<i>Be  it  enacted  by  the  Senate  and  House  of  Representatives of  the  Philippines  in  Congress  assembled:</i>";
        text += "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 +="It is hereby declared the policy of the State to provide necessary assistance and protection for rape victims. Toward this end, the government shall coordinate its various agencies and non-government organizations to work hand in hand for the establishment and operation of a rape crisis center in every province and city that shall assist and protect rape victims in the litigation of their cases and their recovery.";
        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 +="The Department of Social Welfare and Development (DSWD), the Department of Health (DOH), the Department of the Interior and Local Government (DILG), the Department of Justice (DOJ), and a lead non-government organization (NGO) with proven track record or experience in handling sexual abuse cases, shall establish in every province and city a rape crisis center located in a government hospital or health clinic or in any other suitable place for the purpose of:";
        text3 += "<br/><br/>";
        text3 += "<b>(a)</b> Providing rape victims with psychological counselling, medical and health services, including their medico-legal examination";
        text3 += "<br/><br/>";
        text3 += "<b>(b)</b> Securing free legal assistance or service, when necessary, for rape victims;";
        text3 += "<br/><br/>";
        text3 += "<b>(c)</b> Assisting rape victims in the investigation to hasten the arrest of offenders and the filing of cases in court;";
        text3 += "<br/><br/>";
        text3 += "<b>(d)</b> Ensuring the privacy and safety of rape victims;";
        text3 += "<br/><br/>";
        text3 += "<b>(e)</b> Providing psychological counseling and medical services when necessary for the family of rape victims;";
        text3 += "<br/><br/>";
        text3 += "<b>(f)</b> Developing and undertaking a training program for law enforcement officers, public prosecutors, lawyers, medico-legal officers, social workers, and barangay officials on human rights and responsibilities; gender sensitivity and legal management of rape cases; and";
        text3 += "<br/><br/>";
        text3 += "<b>(g)</b> Adopting and implementing programs for the recovery of rape victims.";
        text3 += "<br/><br/>";
        text3 += "The DSWD shall be the lead agency in the establishment and operation of the Rape Crisis Center.";
        text3 += "</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");


        WebView view4 = (WebView) findViewById(R.id.content4);
        String text4;
        text4 = "<html><body><p align=\"justify\">";
        text4 +="Upon receipt by the police of the complaint for rape, it shall be the duty of the police officer to:";
        text4 += "<br/><br/>";
        text4 +="<b>(a)</b> Immediately refer the case to the prosecutor for inquest investigation if the accused is detained; otherwise, the rules of court shall apply;";
        text4 += "<br/><br/>";
        text4 +="<b>(b)</b> Arrange for counselling and medical services for the offended party; and";
        text4 += "<br/><br/>";
        text4 += "<b>(c)</b> Immediately make a report on the action taken.";
        text4 += "<br/><br/>";
        text4 += "It shall be the duty of the police officer or the examining physician, who must be of the same gender as the offended party, to ensure that only persons expressly authorized by the offended party shall be allowed inside the room where the investigation or medical or physical examination is being conducted.";
        text4 += "<br/><br/>";
        text4 +="For this purpose, a women’s desk must be established in every police precinct throughout the country to provide a police woman to conduct investigation of complaints of women rape victims. In the same manner, the preliminary investigation proper or inquest of women rape victims must be assigned to female prosecutor or prosecutors after the police shall have endorsed all the pertinent papers thereof to the same office.";
        text4 += "</p></body></html>";
        view4.loadData(text4, "text/html", "utf-8");

        WebView view5 = (WebView) findViewById(R.id.content5);
        String text5;
        text5 = "<html><body><p align=\"justify\">";
        text5 += "At any stage of the investigation, prosecution and trial of a complaint for rape, the police officer, the prosecutor, the court and its officers, as well as the parties to the complaint shall recognize the right to privacy of the offended party and the accused. Towards this end, the police officer, prosecutor, or the court to whom the complaint has been referred may, whenever necessary to ensure fair and impartial proceedings, and after considering all circumstances for the best interest of the parties, order a closed-door investigation, prosecution or trial and 10 that the name and personal circumstances of the offended party and/or the accused, or any other information tending to establish their identities, and such circumstances or information on the complaint shall not be disclosed to the public";
        text5 += "<br/></br/>";
        text5 += "The investigating officer or prosecutor shall inform the parties that the proceedings can be conducted in a language or dialect known or familiar to them.";
        text5 += "</p></body></html>";
        view5.loadData(text5, "text/html", "utf-8");

        WebView view6 = (WebView) findViewById(R.id.content6);
        String text6;
        text6 = "<html><body><p align=\"justify\">";
        text6 +="In prosecutions for rape, evidence of complainant’s past sexual conduct, opinion thereof or of his/her reputation shall not be admitted unless, and only to the extent that the court finds, that such evidence is material and relevant to the case.";
        text6 += "</p></body></html>";
        view6.loadData(text6, "text/html", "utf-8");

        WebView view7 = (WebView) findViewById(R.id.content7);
        String text7;
        text7 = "<html><body><p align=\"justify\">";
        text7 += "For the establishment and operation of the rape crisis centers during the first year of implementation of this Act, the amount of One hundred twenty million pesos (P120,000,000.00) shall be charged against the Organizational Adjustment Fund, as follows: Sixty million pesos (P60,000,000.00) for the DSWD; and Twenty million pesos (P20,000,000.00) each for the DOH, DILG, and DOJ, respectively. Thereafter, the necessary amount for the rape crisis centers shall be included in the budgetary allocations for the agencies concerned in the annual General Appropriations Act.";
        text7 += "</p></body></html>";
        view7.loadData(text7, "text/html", "utf-8");

        WebView view8 = (WebView) findViewById(R.id.content8);
        String text8;
        text8 = "<html><body><p align=\"justify\">";
        text8 += "Within ninety (90) days upon the approval of this Act, all concerned agencies shall formulate rules and regulations as may be necessary for the proper implementation thereof.";
        text8 += "</p></body></html>";
        view8.loadData(text8, "text/html", "utf-8");

        WebView view9 = (WebView) findViewById(R.id.content9);
        String text9;
        text9 = "<html><body><p align=\"justify\">";
        text9 += "If  any  part,  section  or provision of this Act is declared invalid or unconstitutional, the other parts thereof not affected thereby shall remain valid.";
        text9 += "</p></body></html>";
        view9.loadData(text9, "text/html", "utf-8");

        WebView view10 = (WebView) findViewById(R.id.content10);
        String text10;
        text10 = "<html><body><p align=\"justify\">";
        text10 += "All  laws,  acts,  presidential decrees, executive orders, administrative orders, rules and regulations inconsistent with or contrary to the provisions of this Act are deemed amended, modified or repealed accordingly.";
        text10 += "</p></body></html>";
        view10.loadData(text10, "text/html", "utf-8");

        WebView view11 = (WebView) findViewById(R.id.content11);
        String text11;
        text11 = "<html><body><p align=\"justify\">";
        text11 += "This  Act  shall  take  effect  fifteen (15)  days  after  completion  of  its  publication  in  at  least  two  (2) newspapers  of  general  circulation";
        text11 += "</p></body></html>";
        view11.loadData(text11, "text/html", "utf-8");

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://pcw.gov.ph/sites/default/files/documents/laws/republic_act_8505.pdf"));
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

