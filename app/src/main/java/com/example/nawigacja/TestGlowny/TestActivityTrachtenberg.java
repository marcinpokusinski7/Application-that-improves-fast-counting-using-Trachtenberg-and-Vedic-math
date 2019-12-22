package com.example.nawigacja.TestGlowny;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import com.example.nawigacja.MainActivity;
import com.example.nawigacja.R;
import com.example.nawigacja.Rozgrzewka.Question;
import com.example.nawigacja.TestActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TestActivityTrachtenberg extends AppCompatActivity{
    int random2 = new Random().nextInt(10000);
    int random3 = new Random().nextInt(10000);
    int random4 = new Random().nextInt(10000);
    int random5 = new Random().nextInt(10000);
    int random6 = new Random().nextInt(10000);
    int random7 = new Random().nextInt(10000);
    int random8 = new Random().nextInt(10000);
    int random9 = new Random().nextInt(10000);
    int random11 = new Random().nextInt(10000);
    int random12 = new Random().nextInt(10000);
    final int diffone = new Random().nextInt(30);
    final int difftwo = new Random().nextInt(30);
    final int diffthree = new Random().nextInt(30);
    final int difffour = new Random().nextInt(30);

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    TextView tv, tvquestion, tvtimer;
    private ColorStateList textColorDefaultCd;
    private int questionnr =1 ;
    private long buttononback;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
   ;

    String questions[] = {
            "Podaj wynik: " +random2 + "*2" + " = ",
            "Podaj wynik: " +random3 + "*3" + " = ",
            "Podaj wynik: " +random4 + "*4" + " = ",
            "Podaj wynik: " +random5 + "*5" + " = ",
            "Podaj wynik: " +random6 + "*6" + " = ",
            "Podaj wynik: " +random7 + "*7" + " = ",
            "Podaj wynik: " +random8 + "*8" + " = ",
            "Podaj wynik: " +random9 + "*9" + " = ",
            "Podaj wynik: " +random11 + "*11" + " = ",
            "Podaj wynik: " +random12 + "*12" + " = ",

    };
    Integer answers[] = {random2*2, random3*3, random4*4, random5*5, random6*6, random7*7, random8*8, random9*9, random11*11, random12*12};
    Integer opt[] = {
            random2*2, random2*2+1, random2*2-1, random2*2+3,
            random3*3, random3*2+1, random3*2-1, random3*2+3,
            random4*4, random4*2+1, random2*2-1, random2*2+3,
            random5*5, random5*2+1, random2*2-1, random2*2+3,
            random6*6, random6*2+1, random2*2-1, random2*2+3,
            random7*7, random7*2+1, random2*2-1, random2*2+3,
            random8*8, random8*2+1, random2*2-1, random2*2+3,
            random9*9, random9*2+1, random2*2-1, random2*2+3,
            random11*11, random11*2+1, random2*2-1, random2*2+3,
            random12*12, random12*2+1, random2*2-1, random2*2+3,
    };


    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_glowny_trachtenberg);

        final TextView score = (TextView)findViewById(R.id.text_view_score);
        startOdliczanie();
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");


        submitbutton=(Button)findViewById(R.id.button_confirm_next);
        tvtimer = findViewById(R.id.text_view_countdown);
        tv=(TextView) findViewById(R.id.text_view_question);
        tvquestion = (TextView) findViewById(R.id.text_view_question_count);
        radio_g=(RadioGroup)findViewById(R.id.radio_group);
        rb1=(RadioButton) findViewById(R.id.radio_button1);
        rb2=(RadioButton) findViewById(R.id.radio_button2);
        rb3=(RadioButton) findViewById(R.id.radio_button3);
        rb4=(RadioButton)findViewById(R.id.radio_button4);
        tv.setText(questions[flag]);
        rb1.setText(String.valueOf(opt[0]));
        rb2.setText(String.valueOf(opt[1]));
        rb3.setText(String.valueOf(opt[2]));
        rb4.setText(String.valueOf(opt[3]));
        textColorDefaultCd = tvtimer.getTextColors();
        submitbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                Integer ansText = Integer.parseInt(uans.getText().toString());
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals((answers[flag]))) {
                    correct++;
                    questionnr ++;
                    tvquestion.setText("Pytanie: " + questionnr + "/10");
                    updateCountDownText();
                    if(questionnr == 10) {
                        submitbutton.setText("Zakończ");
                    }
                    Toast.makeText(getApplicationContext(), "Odpowiedż poprawna", Toast.LENGTH_SHORT).show();
                }
                else {
                    updateCountDownText();
                    wrong++;
                    questionnr ++;
                    tvquestion.setText("Pytanie: " + questionnr + "/10");
                    Toast.makeText(getApplicationContext(), "Odpowiedź niepoprawna", Toast.LENGTH_SHORT).show();
                    if(questionnr == 10){
                        submitbutton.setText("Zakończ");

                    }
                }

                flag++;


                if (score != null)
                    score.setText("Wynik: "+correct+"/10");

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText((String.valueOf(opt[flag*4])));
                    rb2.setText(String.valueOf(opt[flag*4+1]));
                    rb3.setText(String.valueOf(opt[flag*4+2]));
                    rb4.setText(String.valueOf(opt[flag*4+3]));
                }
                else
                {

                    marks=correct;
                    finish();
                    correct = 0;
                }
                radio_g.clearCheck();
            }
        });


    }
    @Override
    public void onBackPressed() {    //wyswietla toast czy chce zamknac aplikacje w trakcie testu
        if (buttononback + 2000 > System.currentTimeMillis()) {
            finish();
            correct = 0;
        } else {
            Toast.makeText(this, "Naciśnij przycisk wstecz ponownie by wyjść", Toast.LENGTH_SHORT).show();
        }


        buttononback = System.currentTimeMillis();
    }
    private void startOdliczanie() {
        countDownTimer = new CountDownTimer(timeLeftInMillis+100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
//sprawdzodp
            }
        }.start();
    }
    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tvtimer.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            tvtimer.setTextColor(Color.RED);
        }else {
            tvtimer.setTextColor(textColorDefaultCd);
        }
    }



}




