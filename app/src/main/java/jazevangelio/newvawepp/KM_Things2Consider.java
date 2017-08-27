package jazevangelio.newvawepp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class KM_Things2Consider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_things2consider);

        //For Back Button on Title Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView titleText = (TextView) findViewById(R.id.titleText);
        TextView titleText1 = (TextView) findViewById(R.id.titleText1);
        TextView tx2 = (TextView) findViewById(R.id.textView2);
        TextView tx4 = (TextView) findViewById(R.id.textView4);
        TextView tx6 = (TextView) findViewById(R.id.textView6);
        TextView tx8 = (TextView) findViewById(R.id.textView8);
        TextView tx10 = (TextView) findViewById(R.id.textView10);


        Typeface typefaceTitle = Typeface.createFromAsset(getAssets(), "fonts/adam_reg.otf");
        titleText.setTypeface(typefaceTitle);
        titleText1.setTypeface(typefaceTitle);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/acid_reg.otf");
        tx2.setTypeface(typeface);
        tx4.setTypeface(typeface);
        tx6.setTypeface(typeface);
        tx8.setTypeface(typeface);
        tx10.setTypeface(typeface);

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
