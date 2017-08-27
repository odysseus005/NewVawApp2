package jazevangelio.newvawepp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FakeCallReceiveActivity extends AppCompatActivity {

    Handler hand = new Handler();
    TextView ti;
    int i = 0;
    private long startTime;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_callreceiver);

        ImageButton rejectcall = (ImageButton) findViewById(R.id.rejectcall);
        rejectcall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent homeIntent= new Intent(FakeCallReceiveActivity.this, SOSSection.class);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(homeIntent);
                finish();
            }

        });

        final TextView textView = (TextView) findViewById(R.id.faketime);

       startTime = System.currentTimeMillis();
        handler.post(new Runnable() {
            @Override
            public void run() {
            long diff = System.currentTimeMillis() - startTime;
                textView.setText(secToTime(Integer.parseInt(Long.toString(diff / 1000))));
          handler.postDelayed(this, 1000);

            }

            String secToTime(int sec) {
                int second = sec % 60;
                int minute = sec / 60;
                if (minute >= 60) {
                    int hour = sec / 60;
                    minute %= 60;
                    return hour + ":" + (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);
                }
                return minute + ":" + (second < 10 ? "0" + second : second);
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(FakeCallReceiveActivity.this, SOSSection.class);
        startActivity(i);
        finish();
    }
}
