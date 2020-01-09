package com.example.nawigacja.TestGlowny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nawigacja.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Testall extends AppCompatActivity{

    int random2 = new Random().nextInt(10000);
    int random3 = new Random().nextInt(80000);
    int random4 = new Random().nextInt(10000);
    int random5 = new Random().nextInt(10000);
    int random6 = new Random().nextInt(10000);
    int random7 = new Random().nextInt(10000);
    int random8 = new Random().nextInt(10000);
    int random9 = new Random().nextInt(10000);
    int random11 = new Random().nextInt(10000);
    int random12 = new Random().nextInt(10000);
    final int rand1 = new Random().nextInt(2) + 30;
    final int rand2 = new Random().nextInt(2) + 10;
    final int rand3= new Random().nextInt(2) + 50;
    int deficiency = new Random().nextInt(99-80)+80;
    int number = new Random().nextInt(99-2)+2;
    int inv = new Random().nextInt(100-2)+2;
    int cross = new Random().nextInt(60-2)+2;
    int cross1 = new Random().nextInt(60-2)+2;
    int deficiency1 = new Random().nextInt(99-80)+80;
    int sub = 100000;

    private CountDownTimer Timer;
    private long timeLeftInMillis;

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    TextView tv, tvquestion, tvtimer, tvscore, et_result;
    long lastTimeRecorded;
    EditText et_text;
    private int questionnr =1 ;
    private long buttononback;
    Button submitbutton, quitbutton;
    RadioButton rb1,rb2,rb3,rb4;
    int conter = 0 ;
    ArrayList<QuestionClassCompare> queList = new ArrayList<>();
    private long przyciskwroc;
    private int questioncountertotal;
    private int questioncounter;
    private QuestionClassCompare questionnow;
    private boolean answer;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private RadioGroup rbGroup;
    private int score;
    int min = 0;
    int sec = 0;

    List<RadioButton> buttons = new ArrayList<>();
    RadioGroup lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_glowny_compare);
        lastTimeRecorded = System.currentTimeMillis();
        final TextView score = (TextView)findViewById(R.id.text_view_score);
        submitbutton=(Button)findViewById(R.id.button_confirm_next);
        tvtimer = findViewById(R.id.text_view_countdown);
        tv=(TextView) findViewById(R.id.text_view_question);
        et_text=(EditText) findViewById(R.id.Et_text);
        et_result =(TextView) findViewById(R.id.Et_result);
        tvquestion = (TextView) findViewById(R.id.text_view_question_count);
        tvscore = (TextView) findViewById(R.id.text_view_score);
        rb1=(RadioButton) findViewById(R.id.radio_button1);
        rb2=(RadioButton) findViewById(R.id.radio_button2);
        rb3 =(RadioButton) findViewById(R.id.radio_button3);
        rb4=(RadioButton)findViewById(R.id.radio_button4);
        rbGroup = findViewById(R.id.radio_group);

        lay = (RadioGroup) findViewById(R.id.radio_group);
        textColorDefaultRb = et_text.getTextColors();
        textColorDefaultCd = tvtimer.getTextColors();


        //load questions

        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random2 +"*" +2 , ""+(random2*2), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random3 +"*" +3 , ""+(random3*3), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random4 +"*" +4 , ""+(random4*4), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random5 +"*" +5 , ""+(random5*5), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random6 +"*" +6 , ""+(random6*6), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random7 +"*" +7 , ""+(random7*7), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random8 +"*" +8 , ""+(random8*8), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random9 +"*" +9 , ""+(random9*9), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random11 +"*" +11 , ""+(random11*11), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik działania: " +random12 +"*" +12 , ""+(random12*12), 1));


            //wed
        queList.add(new QuestionClassCompare("Wybierz poprawny wynik potęgi kwadratowej: " +inv +("\u00B2") , ""+(inv*inv),1));
        queList.add(new QuestionClassCompare("Wybierz poprawny wynik potęgi kwadratowej: " +number +("\u00B2") , ""+(number*number), 1));
        queList.add(new QuestionClassCompare("Jaki jest poprawny wynik różnicy liczb: " +sub +"-" +random3 , ""+(sub-random3), 1));
        queList.add(new QuestionClassCompare("Wybierz poprawny wynik iloczynu liczb: " +deficiency +"*" +deficiency1 , ""+(deficiency*deficiency1), 1));
        queList.add(new QuestionClassCompare("Jaki jest wynik iloczynu liczb: " +cross +"*" +cross1 , ""+(cross*cross1), 1));




        Timer = new CountDownTimer(3600000,1000) {
            @Override

            public void onTick(long millisUntilFinished) {

                if (sec==59){
                    sec = 0;
                    min = min+1;
                    String text = String.format(Locale.getDefault(),"%02d:%02d",min,sec);

                    tvtimer.setText(text);

                }else {
                    sec = sec+1;
                    String text = String.format(Locale.getDefault(),"%02d:%02d",min,sec);
                    tvtimer.setText(text);

                }

            }

            @Override

            public void onFinish() {


            }

        }.start();






        questioncountertotal = queList.size();
        //load ques and ans
        shownextquestion();

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answer){
                    if (et_text.getText().length() != 0){
                        checkanswer();
                    } else {
                        Toast.makeText(Testall.this, "Prosze wpisać odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    shownextquestion();


                }
            }
        });




    }
    private void shownextquestion(){
        et_result.setTextColor(textColorDefaultRb);       //kolor pytan po dop
        et_text.setEnabled(true);
        et_text.getText().clear();       //po wybraniu odpowiedzi odznacza wszystkie odpowiedzi tzw unselected button
        et_result.setText(null);
        if (questioncounter < questioncountertotal ){
            questionnow = queList.get(questioncounter);
            tv.setText(questionnow.getQue());
           // et_result.setText(questionnow.getOpt1());

            questioncounter++;     //jezeli tutaj zadeklarowalem wczesniej inkrementacje to zaczynam od pytania 1 a nie 0, chodzi o to ze wczesniej dalem inkrementacje niz licznik pytan na dole

            tvquestion.setText("Pytanie: " + questioncounter + "/" + questioncountertotal);
            answer = false;          //kiedy klikniemy potwierdzenie zatrzymujemy na tej odpowiedzi widok, aby nie przenosilo od razu do nastepnej
            submitbutton.setText("Potwierdź");  //kiedy nie wybralismy odpowiedzi bedzie potwierdz, gdy juz wybierzemy ma sie zmienic na nastepne pytanie

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;



        } else {
            Intent intent = new Intent(getApplicationContext(), TestHighscore.class);
            startActivity(intent);
            finishTest();

        }

    }

    public void loadQuestions(int n) {
        QuestionClassCompare q = queList.get(n);
        tv.setText("#" + (n + 1) + " " + q.getQue());
        et_result.setText("" + q.getOpt1());

    }

    private void checkanswer(){
        answer = true;

        if (et_text.getText().toString().equals(questionnow.getOpt1())){
            score++;
            tvscore.setText("Wynik: " + score);
        }


        showCorrectopt();
    }



    private void showCorrectopt(){
            et_text.setEnabled(false);


        if(et_text.getText().toString().equals(questionnow.getOpt1())){
            et_result.setTextColor(Color.GREEN);
            et_result.setText("Odpowiedź jest prawidłowa");
        }else {
            et_result.setTextColor(Color.RED);
            et_result.setText("Zła odpowiedź\nWynik to: " +questionnow.getOpt1());
        }
       /* switch(questionnow.getRightOpt()){
            case 1:
                et_result.setTextColor(Color.GREEN);
                tv.setText("Odpowiedź " +questionnow.getOpt1() + " jest prawidłowa");
                break;

        }*/
        if (questioncounter < questioncountertotal){
            submitbutton.setText("Następne");

        } else {
            Timer.cancel();
            submitbutton.setText("Zakończ");
            long elapsedTime = System.currentTimeMillis() - lastTimeRecorded;
            SharedPreferences preferences3 = getSharedPreferences("PREFSALL",0);
            SharedPreferences.Editor editorall = preferences3.edit();
            SharedPreferences preferences4 = getSharedPreferences("PREFSALL",0);
            SharedPreferences.Editor editortimeall = preferences4.edit();
            editorall.putInt("lastscoreall",score);
            editortimeall.putLong("lasttimeall", elapsedTime);
            editorall.apply();
            editortimeall.apply();

        }

    }
    private void finishTest() {

        finish();
    }
    @Override
    public void onBackPressed() {    //wyswietla toast czy chce zamknac aplikacje w trakcie testu
        if (przyciskwroc + 2000 > System.currentTimeMillis()) {
            finishTest();
        } else {
            Toast.makeText(this, "Naciśnij przycisk wstecz ponownie by wyjść", Toast.LENGTH_SHORT).show();
        }


        przyciskwroc = System.currentTimeMillis();
    }


}



