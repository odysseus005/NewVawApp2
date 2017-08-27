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

public class RA7877 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra7877);

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
        text += "Under RA 7877, work, education, or training related sexual harassment is committed by an employer, employee, manager, supervisor, agent of the employer, teacher, instructor, professor, coach, trainer, or any person who, having authority, influence or moral ascendancy over another in a work or training or education environment, demands,requests or otherwise requires any sexual favor from the other, regardless of whether the demand, requests or requirement for submission is accepted or not by the object of said act.";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "<b>A.</b> The sexual favor is made as a condition in the hiring or in the employment, re-employment or continued employment of said individual, or in granting said individual favorable compensation terms, conditions, promotions, or privileges; or refusal to grant the sexual favor results in limiting, segregating or classifying the employee which in any way would discriminate, deprive or diminish employment opportunities or otherwise adversely affect said employee.";
        text2 += "<br/><br/>";
        text2 += "<b>B.</b> The above acts would impair the employee's rights or privilege under existing labor laws; or";
        text2 += "<br/><br/>";
        text2 += "<b>C.</b> The above acts would result in an intimidating, hostile or offensive environment for the employee.";
        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "<b>A.</b> Against one who is under the care, custody or supervision of the offender;";
        text3 += "<br/><br/>";
        text3 += "<b>B.</b> Against one whose education, training, apprenticeship, or tutorship is entrusted to the offender;";
        text3 += "<br/><br/>";
        text3 += "<b>C.</b> When the sexual favor is made a condition to the giving of a passing grade, or granting of honors and scholarships, or the payment of a stipend, allowance or other benefits, privileges, or considerations; or";
        text3 += "<br/><br/>";
        text3 += "<b>D.</b> When the sexual advances result in an intimidating, hostile or offensive environment for the student, trainee or apprentice.";
        text3 += "<br/><br/>";
        text3 += "<i>A person who directs or induces another person to commit any act of sexual harassment or who cooperates to commit the act, without which the said act would not have been committed, will also be held liable under the law.</i>";
        text3 += "</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");

        WebView view5 = (WebView) findViewById(R.id.content5);
        String text5;
        text5 = "<html><body><p align=\"justify\">";
        text5 += "The employer or head of office is required by the law to prevent the occurrence of sexual harassment acts and to provide the procedures for the resolution, settlement or prosecution of sexual harassment. Towards this end, the employer or head of office shall:";
        text5 += "<br/><br/>";
        text5 += "<b>A.</b> Promulgate appropriate rules and regulations in consultation with and jointly approved by the employees or students or trainees, through their duly designated representatives. Said rules and regulations shall prescribe the procedures for the investigation of sexual harassment cases and the administrative sanctions thereof.";
        text5 += "<br/><br/>";
        text5 += "<i>The said rules and regulations whould include guidelines on propoer decorum in the workplace and educational or training institutions.</i>";
        text5 += "<br/><br/>";
        text5 += "<i>Administrative sanctions shall not be a bar to prosecution in the propoer courts for unlawful acts of sexual harassment.</i>";
        text5 += "<br/><br/>";
        text5 += "<b>B.</b> Create a Committee on Decorum and investigation (CODi) of cases on sexual harassment. The committee shall conduct meetings or as the case may be, with officers and employees, teachers, instructors, professors, coaches, trainors and students or trainees to increase understanding and prevent of sexual harassment. It shall also conduct the investigation of alleged cases constituting sexual harassment.";
        text5 += "<br/><br/>";
        text5 += "<i>In the case of work-related environment, the committee shall be composed of atleast one (1) representative each from the management, the union, if any, the employees from the supervisoryrank, and from the rank and file employees.</i>";
        text5 += "<br/><br/>";
        text5 += "<i>In the case of educational or training institution, the committee shall be composed of at least one (1) representative from the administration, the trainors, teachers, instructors, professor or coaches, and students and trainees, as the case may be.</i>";
        text5 += "<br/><br/>";
        text5 += "<i>The employer or head of office, educational or training institution shall disseminate or post a copy of RA 7877 for the information of all concerned.</i>";
        text5 += "</p></body></html>";
        view5.loadData(text5, "text/html", "utf-8");

        WebView view6 = (WebView) findViewById(R.id.content6);
        String text6;
        text6 = "<html><body><p align=\"justify\">";
        text6 += "The employer or head of office, educational or training institution will be held liable for the damages arising from acts of sexual harassment if they are informed by the offended party of the occurrence of such acts, yet no action has been undertaken.";
        text6 += "</p></body></html>";
        view6.loadData(text6, "text/html", "utf-8");

        WebView view7 = (WebView) findViewById(R.id.content7);
        String text7;
        text7 = "<html><body><p align=\"justify\">";
        text7 += "Yes, the offended party may take independent action for damages incurred in the act of sexual harassment. She/he may also avail or relief.";
        text7 += "</p></body></html>";
        view7.loadData(text7, "text/html", "utf-8");

        WebView view8 = (WebView) findViewById(R.id.content8);
        String text8;
        text8 = "<html><body><p align=\"justify\">";
        text8 += "Any person who violates the provisions of the law shall be penalized by imprisonment of <b>not less than one (1) month nor more than six (6) months</b>, or a fine of not less than <b>Ten Thousand Pesos (P10,000)</b> nor more than <b>Twenty Thousand Pesos (P20,000)</b>, or both such fine and imprisonment at the discretion of the court.";
        text8 += "<br/><br/>";
        text8 += "Any action arising from the violation of the provisions of this Act shall prescribe in <b>three (3) years.</b>";
        text8 += "</p></body></html>";
        view8.loadData(text8, "text/html", "utf-8");

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://pcw.gov.ph/sites/default/files/documents/laws/republic_act_7877.pdf"));
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

