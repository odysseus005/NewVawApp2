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

public class RA9710 extends AppCompatActivity {
    private Snackbar snackout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra9710);

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
        text += "The RA 9710 or the Magna Carta of Women of 2009: a comprehensive women's human rights law that seeks to eliminate discrimination" +
                "against women by recognizing, respecting, protecting fulling and promoting the rights of Filipino women, especially those in the marginalized sectors.";
        text += "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

        WebView view2 = (WebView) findViewById(R.id.content2);
        String text2;
        text2 = "<html><body><p align=\"justify\">";
        text2 += "<b>a.</b> any gender-based distinction, exclusion, or restriction which has the effect or purpose of impairing or nullifying the recognition, enjoyment, or exercise by women, irrespective of their marital status. on the basis of equality of men and women, of human rights and fundamental freedoms in the political, economic, social, cultural, civil or any other field;";
        text2 += "<br/><br/>";
        text2 += "<b>b.</b> any act or omission, including by law, policy, administrative measure, or practice, that directly or indirectly excludes or restricts women in the recognition and promotion of their rights and their access to enjoyment of opportunities, benefrts, or privileges;";
        text2 += "<br/><br/>";
        text2 += "<b>c.</b> a measure or practice of general application that fails to provide for mechanisms to offset or address sex or gender based disadvantages or limitations of women, as a result of which women are denied or restricted in the recognition and protection of their rights and in their access to and enjoyment of opportunities, benefits, or privileges; or women, more than men are shown to have suffered the greater adverse effects of those measures or practices; and";
        text2 += "<br/><br/>";
        text2 += "<b>d.</b> discrimination compounded by or intersecting with other grounds, status or condition, such as ethnicity, age, poverty, or religion.";
        text2 += "</p></body></html>";
        view2.loadData(text2, "text/html", "utf-8");

        WebView view3 = (WebView) findViewById(R.id.content3);
        String text3;
        text3 = "<html><body><p align=\"justify\">";
        text3 += "All rights in the Philippine Constitution and those rights recognized underinternational instruments duly" +
                "signed and ratified by the Philippines, in consonance with Philippine laws shall be rights of women under the Magna Carta of Women. These rights shall be enjoyed without discrimination since the law prohibits discrimination against women, whether done by public and private entities or individuals.";
        text3 += "</p></body></html>";
        view3.loadData(text3, "text/html", "utf-8");

        WebView view4 = (WebView) findViewById(R.id.content4);
        String text4;
        text4 = "<html><body><p align=\"justify\">";
        text4 += "<b>Protection from all forms of violence, including those committed by the State</b>";
        text4 += "which includes the incremental increase in the recruitment and training of women in government services that cater to women victims of gender-related offenses. It also ensures mandatory training on human rights and gender sensitivity to all government personnel involved in the protection and defense of women against gender-based violence, and mandates local government units to establish a Violence Against Women Desk in every barangay to address violence against women cases [implementing agencies: CSC, DBM, NAPOLCOM, NBI, DOJ, OPPAP, DND-AFP, DSWD, DILG, DepEd, DOH, NCIP, NCMF, PCW, CHR, PNP, CHED, LGUS)];";
        text4 += "<br/><br/>";

        text4 += "<b>Protection and security in times of disaster, calamities and other crisis situations</b>";
        text4 += "especially in all phases of relief, recovery, rehabilitation. and reconstruction efforts, including protection from sexual exploitation and other sexual and gender-based Violence [NDRRMC, particularly DSWD, DND-OCD, DILG. LGUs];";
        text4 += "<br/><br/>";

        text4 += "<b>Participation and representation </b>";
        text4 += "including undertaking temporary special measures and affirmative actions to accelerate and ensure women's equitable participation and representation in the third level civil service (50-50 gender balance), development councils and planning bodies (40% membership), as well as political parties and international bodies, including the private sector [CSC, CESB. RDCs, DFA, DTl, DSWD. COMELEC, Local Chief Executives];";
        text4 += "<br/><br/>";

        text4 += "<b>Equal treatment before the law </b>";
        text4 += "including the State’s review and when necessary amendment or repeal of existing laws that are discriminatory to women (Congress, Executive-Legislative body);";
        text4 += "<br/><br/>";

        text4 += "<b>Equal access and elimination of discrimination against women in education, scholarships and training </b>";
        text4 += "which includes revising educational materials and curricula to remove gender stereotypes and images, and outlawing the expulsion, non-readmission, prohibiting enrollment and other related discrimination against women students and faculty due to pregnancy outside marriage [DepEd,CHED, TESDA, DOJ, DSWD. CHR. PNP, LGUs];";
        text4 += "<br/><br/>";

        text4 += "<b>Equal participation in sports </b>";
        text4 += "which includes measures to ensure that gender-based discrimination in competitive and non-competitive sports is removed so that women and girls can benent from sports development [PSC, GAB, DepEd, CHED, SUCs, sports-related organizations];";
        text4 += "<br/><br/>";

        text4 += "<b>Non-discrimination in employment in the field of military, police, and other similar services </b>";
        text4 += "which includes according the same promotional privileges and opportunities as their men counterpart, including pay increases, additional benefits, and awards, based on competency and quality of performance. The dignity of women in the military, police and other similar services shall always be respected, they shall be accorded with same capacity as men to act in and enter into contracts, including marriage, as well as be entitled to leave benefits for women such as maternity leave, as provided for in existing laws. It also includes the revision or abolition of practices and policies that restrict women from availing combat and non-combat training that are open to men, or from taking other functions other than administrative duties [DND, DILG, PNPA, PPSC, DOJ, PMA, OCS, LGUs];";
        text4 += "<br/><br/>";

        text4 += "<b>Non-discrimination and non-derogatory portrayal of women in media and film </b>";
        text4 += "to raise the consciousness of the general public in recognizing the dignity of women and the role and contribution of women in family, community, and the society through the strategic use of mass media l0PS, NTC, MTRCB, FAP, FDCP, PMB, NCCA, women's media NGOs, LGUs];";
        text4 += "<br/><br/>";

        text4 += "<b>Comprehensive health services and health information education </b>";
        text4 += "covering all stages of a woman's life cycle, and which addresses the major causes of women’s mortality and morbidity, including access to, among others, maternal care, responsible, ethical, legal, safe and effective methods of family planning and encouraging healthy lifestyles and activities to prevent diseases [DOH, DepEd, CHED, PhilHealth, DOLE, LGUs];";
        text4 += "<br/><br/>";

        text4 += "<b>Special leave benefits</b> ";
        text4 += "of two months with full pay based on gross monthly compensation, for women employees who undergo surgery caused by gynecological disorders, provided that they have rendered continuous aggregate employment service of at least six (6) months for the last twelve(l2) months [CSC, DOLE]; and";
        text4 += "<br/><br/>";

        text4 += "<b>Equal rights in matters relating to marriage and family relations. </b>";
        text4 += "The State shall ensure the same rights of women and men to enter into and leave marriages; freely choose a spouse; decide on the number and spacing of their children; enjoy personal rights inducing the choice of a profession; own acquire and administer their property; and acquire, change. or retain their nationality. It also states that the betrothal and marriage of a child shall have no legal effect [DSWD, DOH, POPCOM, Supreme Court, DOJ, IBP, LGUs].";

        text4 += "</p></body></html>";
        view4.loadData(text4, "text/html", "utf-8");

        WebView view11 = (WebView) findViewById(R.id.content11);
        String text11;
        text11 = "<html><body><p align=\"justify\">";
        text11 += "<b>a. Food security and resources for food production</b> including equal rights in the titling of the land and issuance of stewardship contracts and patents [DA, BFAR, NFARMC, BPRE, PFDA, NDA, ATI, DOST, DOST-lTDI, DTI, FDA, DOE, DAR, DENR. DOT, DPWH, LRA, NCIP, TESDA, SUCs/HEIs, LGUs];";
        text11 += "<br/><br/>";
        text11 += "<b>b. Localized, accessible, secure, and affordable housing</b> including consultation and involvement of women in community planning and development [HUDCC, NHA, HGC, NHMFC, SHFC, HLURB, HDMF, PCUP. LGUs];";
        text11 += "<br/><br/>";
        text11 += "<b>c. Decent work standards</b> including creation of jobs in acceptable conditions of freedom, equality, security. and human dignity [DOLE CSC, POEA, OWWA, DTI, DFA. NAPC];";
        text11 += "<br/><br/>";
        text11 += "<b>d. Employment, livelihood, credit, capital and technology</b> lDOLE. 00F, DTI, DOST. DSWD, DA, DOF, DAR, DENR, TESDA, NAPC, NCIP, BSP, PCFC, GFls, MFis, TRC, and othef BSOs. GSIS. SSS];";
        text11 += "<br/><br/>";
        text11 += "<b>e. Skills training</b> for women migrant and returning migrant workers and equal opportunity in scholarship especially in research and development, aimed towards women friendly farm technology [DOLE, and its attached agencies and other concerned offices];";
        text11 += "<br/><br/>";
        text11 += "<b>f. Representation and participation</b> in policy-making or decision-making bodies in the regional, national, and international levels IPARC. PARCCOM, BARC, community-based resource management bodies mechanisms, NAFC, NFARMC, NCli’, PCUP. LHBs, NAPC Basic Sectoral Councils];";
        text11 += "<br/><br/>";
        text11 += "<b>g. Access to information</b> regarding policies on women, including development and making available information, education, and communication (lEC) materials on specinc programs, services, and funding outlays that affect women [ALL GOVERNMENT AGENCIES, LGUs);";
        text11 += "<br/><br/>";
        text11 += "<b>h. Social protection</b> to reduce poverty and vulnerability to risks and enhance the social status and rights of all women [DSWD, DA. DOLE, POEA, OWWA, DTi, DFA. SSS, GSlS. PhiiHeaith, BSP, NAPC. NCDA, disaster coordinating councils. LGUs];";
        text11 += "<br/><br/>";
        text11 += "<b>i. Recognition and preservation of cultural identity and integrity</b> provided that these cultural systems and practices are not discriminatory to women [NCCA, NCiP, NCMF, RCBW-ARMM. CHED, DepED];";
        text11 += "<br/><br/>";
        text11 += "<b>j. Inclusion in discussions on peace and development</b> [OPAPP, PCW, CHR, RCBW, BCH-ARMM, NCIP, DepEd. CHED. SUCs, AFP, PNP, TESDA. DSWD, DOH. LGUs];";
        text11 += "<br/><br/>";
        text11 += "<b>k. Services and interventions for Women in Especially Difficult Circumstances</b> or WEDC [DSWD, DOLE. TESDA. DOH. DOJ. CHR, PNF‘, BJMP, BuCor, PPB, NBi, Bi. LGUs];";
        text11 += "<br/><br/>";
        text11 += "<b>l. Protecton of Girl-Children</b> against all forms of discrimination in education, health and nutrition, and skills development [CWC, ECCD, DepEd, NClP. NCMF. CHED. 1ESDA, DILG. RCBW, BCH-ARMM. LGUs, LCPCs]; and";
        text11 += "<br/><br/>";
        text11 += "<b>m. Protection of Senior Citizens</b> from gender-based violence and suspected cases of abuse and neglect [OSCA, DSWD, DOH, LGUs].";
        text11 += "</p></body></html>";
        view11.loadData(text11, "text/html", "utf-8");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pdf) {
            snackout.show();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse("http://library.pcw.gov.ph/sites/default/files/ra-9710-magna-carta-women-irr_0.pdf"));
            startActivity(link);
            return true;
        } else if (id == android.R.id.home) {
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

