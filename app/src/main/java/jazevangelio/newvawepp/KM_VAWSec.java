package jazevangelio.newvawepp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class KM_VAWSec extends AppCompatActivity {
    public Button RA1, RA2, RA3, RA4, RA5, RA6, RA7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_vawsec);

        //For Back Button on Title Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RA1 = (Button) findViewById(R.id.btnRA1);
        RA2 = (Button) findViewById(R.id.btnRA2);
        RA3 = (Button) findViewById(R.id.btnRA3);
        RA4 = (Button) findViewById(R.id.btnRA4);
        RA5 = (Button) findViewById(R.id.btnRA5);
        RA6 = (Button) findViewById(R.id.btnRA6);
        RA7 = (Button) findViewById(R.id.btnRA7);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;
        RA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA7877.class);
                startActivity(intent1);
            }
        });

        RA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA8353.class);
                startActivity(intent1);
            }
        });

        RA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA8505.class);
                startActivity(intent1);
            }
        });

        RA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA9208.class);
                startActivity(intent1);
            }
        });

        RA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA9262.class);
                startActivity(intent1);
            }
        });

        RA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA9710.class);
                startActivity(intent1);
            }
        });

        RA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, RA9995.class);
                startActivity(intent1);
            }
        });

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
