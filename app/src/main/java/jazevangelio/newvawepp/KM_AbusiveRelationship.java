package jazevangelio.newvawepp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class KM_AbusiveRelationship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_relationship);

        //For Back Button on Title Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tx0 = (TextView) findViewById(R.id.textView0);
        TextView tx00 = (TextView) findViewById(R.id.textView00);

        TextView tx2 = (TextView) findViewById(R.id.textView2);
        TextView tx4 = (TextView) findViewById(R.id.textView4);
        TextView tx6 = (TextView) findViewById(R.id.textView6);
        TextView tx8 = (TextView) findViewById(R.id.textView8);
        TextView tx10 = (TextView) findViewById(R.id.textView10);
        TextView tx12 = (TextView) findViewById(R.id.textView12);
        TextView tx14 = (TextView) findViewById(R.id.textView14);
        TextView tx16 = (TextView) findViewById(R.id.textView16);
        TextView tx18 = (TextView) findViewById(R.id.textView18);
        TextView tx20 = (TextView) findViewById(R.id.textView20);
        TextView tx22 = (TextView) findViewById(R.id.textView22);
        TextView tx24 = (TextView) findViewById(R.id.textView24);
        TextView tx26 = (TextView) findViewById(R.id.textView26);
        TextView tx28 = (TextView) findViewById(R.id.textView28);
        TextView tx30 = (TextView) findViewById(R.id.textView30);
        TextView tx32 = (TextView) findViewById(R.id.textView32);
        TextView tx34 = (TextView) findViewById(R.id.textView34);
        TextView tx36 = (TextView) findViewById(R.id.textView36);
        TextView tx38 = (TextView) findViewById(R.id.textView38);


        TextView titleText = (TextView) findViewById(R.id.titleText);
        TextView titleText1 = (TextView) findViewById(R.id.titleText1);
        Typeface typefaceTitle = Typeface.createFromAsset(getAssets(), "fonts/adam_reg.otf");
        titleText.setTypeface(typefaceTitle);
        titleText1.setTypeface(typefaceTitle);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/acid_reg.otf");
        tx0.setTypeface(typeface);
        tx00.setTypeface(typeface);
        tx2.setTypeface(typeface);
        tx4.setTypeface(typeface);
        tx6.setTypeface(typeface);
        tx8.setTypeface(typeface);
        tx10.setTypeface(typeface);
        tx12.setTypeface(typeface);
        tx14.setTypeface(typeface);
        tx16.setTypeface(typeface);
        tx18.setTypeface(typeface);
        tx20.setTypeface(typeface);
        tx22.setTypeface(typeface);
        tx24.setTypeface(typeface);
        tx26.setTypeface(typeface);
        tx28.setTypeface(typeface);
        tx30.setTypeface(typeface);
        tx32.setTypeface(typeface);
        tx34.setTypeface(typeface);
        tx36.setTypeface(typeface);
        tx38.setTypeface(typeface);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public static class KM5 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_km_safetytips);

            //For Back Button on Title Bar
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            TextView tx2 = (TextView) findViewById(R.id.textView2);
            TextView tx4 = (TextView) findViewById(R.id.textView4);
            TextView tx6 = (TextView) findViewById(R.id.textView6);
            TextView tx8 = (TextView) findViewById(R.id.textView8);
            TextView tx10 = (TextView) findViewById(R.id.textView10);
            TextView tx12 = (TextView) findViewById(R.id.textView12);
            TextView tx14 = (TextView) findViewById(R.id.textView14);
            TextView tx16 = (TextView) findViewById(R.id.textView16);

            Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/acid_reg.otf");
            tx2.setTypeface(typeface);
            tx4.setTypeface(typeface);
            tx6.setTypeface(typeface);
            tx8.setTypeface(typeface);
            tx10.setTypeface(typeface);
            tx12.setTypeface(typeface);
            tx14.setTypeface(typeface);
            tx16.setTypeface(typeface);
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home){
                finish();
                return true;
            }
            return super.onOptionsItemSelected(item);

        }
    }
}
