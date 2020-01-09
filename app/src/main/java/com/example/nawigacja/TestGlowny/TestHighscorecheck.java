package com.example.nawigacja.TestGlowny;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nawigacja.R;

import java.util.Locale;

public class TestHighscorecheck extends AppCompatActivity {
    TextView timeone, scoreone, scorewedyjska, timewedyjska, scoreall, timeall ;
    LinearLayout back;

    int lastscore, lastscorewed, lastscoreall;
    long lasttime, lasttimewed, lasttimeall;
    int best1, best2, best3, best4, best5, best6, best7, best8, best9;
    long time1, time2, time3, time4, time5, time6, time7, time8, time9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_highscore);
        timeone = (TextView) findViewById(R.id.timeone);
        scoreone = (TextView) findViewById(R.id.scoreone);
        scorewedyjska = (TextView) findViewById(R.id.scorewedyjska);
        timewedyjska = (TextView) findViewById(R.id.timewedyjska);
        scoreall = (TextView) findViewById(R.id.scoreall);
        timeall = (TextView) findViewById(R.id.timeall);
        back = (LinearLayout) findViewById(R.id.button_bestscore);



        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        SharedPreferences preferencess = getSharedPreferences("PREFS",0);
        lastscore = preferences.getInt("lastscore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);
        lasttime = preferencess.getLong("lasttime", 0);
        time1 = preferencess.getLong("time1", 0);
        time2 = preferencess.getLong("time2", 0);
        time3 = preferencess.getLong("time3", 0);

        SharedPreferences preferences1 = getSharedPreferences("PREFSWED",0);
        SharedPreferences preferences2 = getSharedPreferences("PREFSWED",0);
        lastscorewed = preferences1.getInt("lastscorewed", 0);
        best4 = preferences1.getInt("best4", 0);
        best5 = preferences1.getInt("best5", 0);
        best6 = preferences1.getInt("best6", 0);
        lasttimewed = preferences2.getLong("lasttimewed", 0);
        time4 = preferences2.getLong("time4", 0);
        time5 = preferences2.getLong("time5", 0);
        time6 = preferences2.getLong("time6", 0);

        SharedPreferences preferences3 = getSharedPreferences("PREFSALL",0);
        SharedPreferences preferences4 = getSharedPreferences("PREFSALL",0);
        lastscoreall = preferences3.getInt("lastscoreall", 0);
        best7 = preferences3.getInt("best7", 0);
        best8 = preferences3.getInt("best8", 0);
        best9 = preferences3.getInt("best9", 0);
        lasttimeall = preferences4.getLong("lasttimeall", 0);
        time7 = preferences4.getLong("time7", 0);
        time8 = preferences4.getLong("time8", 0);
        time9 = preferences4.getLong("time9", 0);


        long milis= time1;
        long milis1= time2;
        long milis2 = time3;
        long minutes = (milis / 1000) / 60;
        long seconds =  (milis/ 1000) % 60;
        long min1 =  (milis1 / 1000) / 60;
        long sec1 =  (milis1 / 1000) % 60;
        long min2=   (milis2 / 1000) / 60;
        long sec2 = (milis2 / 1000) % 60;


        scoreone.setText("" +best1 + "\n"+
                "" +best2 + "\n"+
                "" +best3 + "\n");
        timeone.setText("" +String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds) + "\n"+
                "" +String.format(Locale.getDefault(),"%02d:%02d",min1,sec1) + "\n"+
                "" +String.format(Locale.getDefault(),"%02d:%02d",min2,sec2) + "\n");


        long milis4= time4;
        long milis5= time5;
        long milis6 = time6;
        long minutes4 = (milis4 / 1000) / 60;
        long seconds4 =  (milis4/ 1000) % 60;
        long min5 =  (milis5 / 1000) / 60;
        long sec5 =  (milis5 / 1000) % 60;
        long min6=   (milis6 / 1000) / 60;
        long sec6 = (milis6 / 1000) % 60;


        scorewedyjska.setText("" +best4 + "\n"+
                "" +best5 + "\n"+
                "" +best6 + "\n");
        timewedyjska.setText("" +String.format(Locale.getDefault(),"%02d:%02d",minutes4,seconds4) + "\n"+
                "" +String.format(Locale.getDefault(),"%02d:%02d",min5,sec5) + "\n"+
                "" +String.format(Locale.getDefault(),"%02d:%02d",min6,sec6) + "\n");


        long milis7= time7;
        long milis8= time8;
        long milis9 = time9;
        long min7 = (milis7 / 1000) / 60;
        long sec7 =  (milis7/ 1000) % 60;
        long min8 =  (milis8 / 1000) / 60;
        long sec8 =  (milis8 / 1000) % 60;
        long min9=   (milis9 / 1000) / 60;
        long sec9 = (milis9 / 1000) % 60;


        scoreall.setText("" +best7 + "\n"+
                "" +best8 + "\n"+
                "" +best9 + "\n");
        timeall.setText("" +String.format(Locale.getDefault(),"%02d:%02d",min7,sec7) + "\n"+
                "" +String.format(Locale.getDefault(),"%02d:%02d",min8,sec8) + "\n"+
                "" +String.format(Locale.getDefault(),"%02d:%02d",min9,sec9) + "\n");



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.setBackgroundResource(R.drawable.bg_item_cho);
                finish();

            }

        });




    }

}





