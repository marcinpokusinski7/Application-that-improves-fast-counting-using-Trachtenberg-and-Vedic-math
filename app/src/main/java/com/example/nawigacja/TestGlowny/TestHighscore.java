package com.example.nawigacja.TestGlowny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nawigacja.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestHighscore extends AppCompatActivity {
        TextView timeone, scoreone, scorewedyjska, timewedyjska ;
        LinearLayout back;

        int lastscore, lastscore1;
        long lasttime, lasttime1;
        int best1, best2, best3, best4, best5, best6;
        long time1, time2, time3, time4, time5, time6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_highscore);
    timeone = (TextView) findViewById(R.id.timeone);
    scoreone = (TextView) findViewById(R.id.scoreone);
    scorewedyjska = (TextView) findViewById(R.id.scorewedyjska);
        timewedyjska = (TextView) findViewById(R.id.timewedyjska);
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
        lastscore1 = preferences1.getInt("lastscorewed", 0);
        best4 = preferences1.getInt("best4", 0);
        best5 = preferences1.getInt("best5", 0);
        best6 = preferences1.getInt("best6", 0);
        lasttime1 = preferences2.getLong("lasttimewed", 0);
        time4 = preferences2.getLong("time4", 0);
        time5 = preferences2.getLong("time5", 0);
        time6 = preferences2.getLong("time6", 0);

        if(lastscore > best3){
            best3 = lastscore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3",best3);
            editor.apply();

            time3 = lasttime;
            SharedPreferences.Editor editortime = preferencess.edit();
            editortime.putLong("time3",time3);
            editortime.apply();
        }
        if(lastscore > best2){
            int temp = best2;
            best2 = lastscore;
            best3= temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2",best2);
            editor.putInt("best3",best3);
            editor.apply();

            long temptime = time2;
            time2 = lasttime;
            time3 = temptime;
            SharedPreferences.Editor editortime = preferencess.edit();
            editortime.putLong("time2",time2);
            editortime.putLong("time3",time3);
            editortime.apply();

        }
        if(lastscore > best1){
            int temp = best1;
            best1 = lastscore;
            best2= temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2",best2);
            editor.putInt("best1",best1);
            editor.apply();


            long temptime = time1;
            time1 = lasttime;
            time2 = temptime;
            SharedPreferences.Editor editortime = preferencess.edit();
            editortime.putLong("time2",time2);
            editortime.putLong("time1",time1);
            editortime.apply();



        }
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

        if(lastscore1 > best6){
            best6 = lastscore1;
            SharedPreferences.Editor editorwed = preferences1.edit();
            editorwed.putInt("best6",best6);
            editorwed.apply();

            time6 = lasttime1;
            SharedPreferences.Editor editorwedt = preferences2.edit();
            editorwedt.putLong("time6",time6);
            editorwedt.apply();
        }
        if(lastscore1 > best5){
            int temp = best5;
            best5 = lastscore1;
            best6= temp;
            SharedPreferences.Editor editorwed = preferences1.edit();
            editorwed.putInt("best5",best5);
            editorwed.putInt("best6",best6);
            editorwed.apply();

            long temptime = time5;
            time5 = lasttime;
            time6 = temptime;
            SharedPreferences.Editor editorwedt = preferences2.edit();
            editorwedt.putLong("time5",time5);
            editorwedt.putLong("time6",time6);
            editorwedt.apply();

        }
        if(lastscore1 > best4){
            int temp = best4;
            best4 = lastscore1;
            best5= temp;
            SharedPreferences.Editor editorwed = preferences1.edit();
            editorwed.putInt("best5",best5);
            editorwed.putInt("best4",best4);
            editorwed.apply();


            long temptime = time4;
            time4 = lasttime1;
            time5 = temptime;
            SharedPreferences.Editor editorwedt = preferences2.edit();
            editorwedt.putLong("time5",time5);
            editorwedt.putLong("time4",time4);
            editorwedt.apply();



        }
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

    }

}



