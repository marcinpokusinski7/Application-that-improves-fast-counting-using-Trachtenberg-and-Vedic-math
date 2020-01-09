package com.example.nawigacja.TestGlowny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nawigacja.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Testwed extends AppCompatActivity{

    int random2 = new Random().nextInt(1000);
    int random3 = new Random().nextInt(10000-5351) + 5351;
    int random4 = new Random().nextInt(100-11) + 11;
    int random5 = new Random().nextInt(100-11) + 11;
    int deficiency = new Random().nextInt(99-80)+80;
    int deficiency1 = new Random().nextInt(99-80)+80;
    int number = new Random().nextInt(1000/5)*5;

    int sub = 100000;

    final int rand1 = new Random().nextInt(2) + 30;
    final int rand2 = new Random().nextInt(2) + 10;
    final int rand3= new Random().nextInt(2) + 50;


    private CountDownTimer Timer;
    private long timeLeftInMillis;

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    TextView tv, tvquestion, tvtimer, tvscore;

    private int questionnr =1 ;
    private long buttononback;
    Button submitbutton, quitbutton;
    RadioButton rb1,rb2,rb3,rb4;
    int conter = 0 ;
    ArrayList<QuestionClass> queList = new ArrayList<>();
    private long przyciskwroc;
    private int questioncountertotal;
    private int questioncounter;
    private QuestionClass questionnow;
    private boolean answer;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private RadioGroup rbGroup;
    private int score;
    private TextView potega;
    long lastTimeRecorded;
    int min = 0;
    int sec = 0;
    List<RadioButton> buttons = new ArrayList<>();
    RadioGroup lay;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_glowny_wedyjska);



        final TextView score = (TextView)findViewById(R.id.text_view_score);
        submitbutton=(Button)findViewById(R.id.button_confirm_next);
        tvtimer = findViewById(R.id.text_view_countdown);
        tv=(TextView) findViewById(R.id.text_view_question);
        tvquestion = (TextView) findViewById(R.id.text_view_question_count);
        tvscore = (TextView) findViewById(R.id.text_view_score);
        rb1=(RadioButton) findViewById(R.id.radio_button1);
        rb2=(RadioButton) findViewById(R.id.radio_button2);
        rb3 =(RadioButton) findViewById(R.id.radio_button3);
        rb4=(RadioButton)findViewById(R.id.radio_button4);
        rbGroup = findViewById(R.id.radio_group);
        lastTimeRecorded = System.currentTimeMillis();
        lay = (RadioGroup) findViewById(R.id.radio_group);
        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = tvtimer.getTextColors();
        number = new Random().nextInt(1000/5)*5;
        if (number%10 == 0|| number == 0 || number == 5){
            number=number+5;

        }

        //load questions
        queList.add(new QuestionClass("Wybierz poprawny wynik potęgi kwadratowej: " +random2 +("\u00B2") , ""+(random2*random2+rand1), ""+(random2*random2+rand2),
                ""+random2*random2, ""+(random2*random2+rand3), 3));
        queList.add(new QuestionClass("Wybierz poprawny wynik potęgi kwadratowej: " +(number) +("\u00B2") , ""+(number*number+rand2), ""+(number*number+rand1),
                ""+number*number, ""+(number*number+rand3), 3));
        queList.add(new QuestionClass("Jaki jest poprawny wynik różnicy liczb: " +sub +"-" +random3 , ""+(sub-random3+rand2), ""+(sub-random3+rand3),
                ""+(sub-random3), ""+(sub-random3+rand1), 3));
        queList.add(new QuestionClass("Wybierz poprawny wynik iloczynu liczb: " +(deficiency*deficiency1) , ""+(deficiency*deficiency1+rand3), ""+(deficiency*deficiency1+rand2),
                ""+deficiency*deficiency1, ""+(deficiency*deficiency1+rand1), 3));
        queList.add(new QuestionClass("Jaki jest wynik iloczynu liczb: " +random4 +"*" +random5 , ""+(random4*random5+rand1), ""+(random4*random5+rand2),
                ""+random4*random5, ""+(random4*random5+rand3), 3));










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
        rbGroup.removeAllViews();
        buttons.add(rb1);
        buttons.add(rb2);
        buttons.add(rb3);
        buttons.add(rb4);
        Collections.shuffle(buttons);
            for (RadioButton rb :
                    buttons) {
                lay.addView(rb, new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }



        //load ques and ans
    shownextquestion();

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answer){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkanswer();
                    } else {
                        Toast.makeText(Testwed.this, "Prosze wybrać odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    shownextquestion();


                }
            }
        });




    }
    private void shownextquestion(){
        rb1.setTextColor(textColorDefaultRb);       //kolor pytan po dop
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();       //po wybraniu odpowiedzi odznacza wszystkie odpowiedzi tzw unselected button
        rbGroup.removeAllViews();
        Collections.shuffle(buttons);
        for (RadioButton rb :
                buttons) {
            lay.addView(rb, new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }


        if (questioncounter < questioncountertotal ){
            questionnow = queList.get(questioncounter);
            tv.setText(questionnow.getQue());
            rb1.setText(questionnow.getOpt1());
            rb2.setText(questionnow.getOpt2());
            rb3.setText(questionnow.getOpt3());
            rb4.setText(questionnow.getOpt4());
            questioncounter++;     //jezeli tutaj zadeklarowalem wczesniej inkrementacje to zaczynam od pytania 1 a nie 0, chodzi o to ze wczesniej dalem inkrementacje niz licznik pytan na dole

            tvquestion.setText("Pytanie: " + questioncounter + "/" + questioncountertotal);
            answer = false;          //kiedy klikniemy potwierdzenie zatrzymujemy na tej odpowiedzi widok, aby nie przenosilo od razu do nastepnej
            submitbutton.setText("Potwierdź");  //kiedy nie wybralismy odpowiedzi bedzie potwierdz, gdy juz wybierzemy ma sie zmienic na nastepne pytanie

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;



        } else {
            Intent intent = new Intent(getApplicationContext(), TestHighscorewed.class);
            startActivity(intent);
            finishTest();


        }

    }

    public void loadQuestions(int n) {
        QuestionClass q = queList.get(n);
        tv.setText("#" + (n + 1) + " " + q.getQue());
        rb1.setText("" + q.getOpt1());
        rb2.setText("" + q.getOpt2());
        rb3.setText("" + q.getOpt3());
        rb4.setText("" + q.getOpt4());
    }

    private void checkanswer(){
        answer = true;
        RadioButton rbSelectd = findViewById(rbGroup.getCheckedRadioButtonId());
        int odpowiedzNr = rbGroup.indexOfChild(rbSelectd)+1;
        if (rb3.isChecked()){
            score++;
            tvscore.setText("Wynik: " + score);
        }


        showCorrectopt();
    }



    private void showCorrectopt(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);


        switch(questionnow.getRightOpt()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                tv.setText("Odpowiedź " +rb1.getText() + " jest prawidłowa");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                tv.setText("Odpowiedź " +rb2.getText() + " jest prawidłowa");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                tv.setText("Odpowiedź " +rb3.getText() + " jest prawidłowa");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                tv.setText("Odpowiedź " +rb4.getText() + " jest prawidłowa");
                break;
        }
        if (questioncounter < questioncountertotal){
            submitbutton.setText("Następne");

        } else {
            Timer.cancel();
            submitbutton.setText("Zakończ");
            long elapsedTime = System.currentTimeMillis() - lastTimeRecorded;
            SharedPreferences preferences1 = getSharedPreferences("PREFSWED",0);
            SharedPreferences.Editor editorwed = preferences1.edit();
            SharedPreferences preferences2 = getSharedPreferences("PREFSWED",0);
            SharedPreferences.Editor editorwedt = preferences2.edit();
            editorwed.putInt("lastscorewed",score);
            editorwedt.putLong("lasttimewed", elapsedTime);
            editorwed.apply();
            editorwedt.apply();
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




