package com.example.nawigacja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nawigacja.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TestActivity extends AppCompatActivity {
        public static final String EXTRA_SCORE = "Dodatkowy_Wynik";

        private static final long COUNTDOWN_IN_MILLIS = 30000;

        private static final String KEY_SCORE = "keyScore";
        private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
        private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
        private static final String KEY_ANSWERED = "keyAnswered";
        private static final String KEY_QUESTION_LIST = "keyQuestionList";


        private TextView textViewKategorie;
        private TextView textViewPytania;
        private TextView textViewWynik;
        private TextView textViewPytanielicznik;
        private TextView textViewCzas;
        private RadioGroup rbGroup;
        private RadioButton rb1;                //4 opcje wyboru
        private RadioButton rb2;
        private RadioButton rb3;
        private RadioButton rb4;
        private Button buttonPotwierdz;    //przycisk potwierdzajacy przenieienie dalej


        private ColorStateList textColorDefaultRb;    //kolor po zaznaczeniu dobrej zlej odpowiedzi
        private ColorStateList textColorDefaultCd;

        private CountDownTimer countDownTimer;
        private long timeLeftInMillis;


        private ArrayList<Pytania> pytaniaList;
        private int licznikPytan;       //licznik pytan ktore wyplenilismy
        private int licznikpytantotal;    //ile pytan wypelnilismy
        private Pytania danepytanie;        //na ktorym pytaniu jestesmy

        private int wynik;

        private boolean odpowiedz; //odpowiada za to co sie stanie kiedy klikniemy przycisk potwierdz, jezeli nie odpowiedziales pokazuje nastepne pytanie
        private long przyciskwroc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_test);
        textViewPytania = findViewById(R.id.text_view_question);
        textViewWynik = findViewById(R.id.text_view_score);
        textViewPytanielicznik = findViewById(R.id.text_view_question_count);
        textViewKategorie = findViewById(R.id.text_view_kategoria);
        textViewCzas = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonPotwierdz = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCzas.getTextColors();

        Intent intent = getIntent();
        int kategorieID = intent.getIntExtra(CwiczeniaFragment.EXTRA_KATEGORIA_ID, 0);
        String kategorieNazwa = intent.getStringExtra(CwiczeniaFragment.EXTRA_KATEGORIA_NAZWA);

        textViewKategorie.setText("Kategoria: " + kategorieNazwa);

        if(savedInstanceState == null) {

            CwiczeniaDbHelper dbHelper = CwiczeniaDbHelper.getInstance(this);
            pytaniaList = dbHelper.getPytania(kategorieID);
            licznikpytantotal = pytaniaList.size();
            Collections.shuffle(pytaniaList);


            pokazNastepnePytanie();
        }else {
            pytaniaList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);

            licznikpytantotal = pytaniaList.size();
            licznikPytan = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            danepytanie = pytaniaList.get(licznikPytan - 1);
            wynik = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            odpowiedz = savedInstanceState.getBoolean(KEY_ANSWERED);

            if(!odpowiedz){
                startOdliczanie();
            } else {
                updateCountDownText();
                pokazOdpowiedzprawidlowa();
            }

        }

        buttonPotwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!odpowiedz){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        sprawdzOdpowiedz();
                    } else {
                        Toast.makeText(TestActivity.this, "Prosze wybrać odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    pokazNastepnePytanie();
                }
            }
        });
    }
    private void pokazNastepnePytanie(){
        rb1.setTextColor(textColorDefaultRb);       //kolor pytan po dop
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();       //po wybraniu odpowiedzi odznacza wszystkie odpowiedzi tzw unselected button


        if (licznikPytan < licznikpytantotal ){
            danepytanie = pytaniaList.get(licznikPytan);
            textViewPytania.setText(danepytanie.getPytania());
            rb1.setText(danepytanie.getOpcja1());
            rb2.setText(danepytanie.getOpcja2());
            rb3.setText(danepytanie.getOpcja3());
            rb4.setText(danepytanie.getOpcja4());
            licznikPytan++;     //jezeli tutaj zadeklarowalem wczesniej inkrementacje to zaczynam od pytania 1 a nie 0, chodzi o to ze wczesniej dalem inkrementacje niz licznik pytan na dole

            textViewPytanielicznik.setText("Pytanie: " + licznikPytan + "/" + licznikpytantotal);
            odpowiedz = false;          //kiedy klikniemy potwierdzenie zatrzymujemy na tej odpowiedzi widok, aby nie przenosilo od razu do nastepnej
            buttonPotwierdz.setText("Potwierdź");  //kiedy nie wybralismy odpowiedzi bedzie potwierdz, gdy juz wybierzemy ma sie zmienic na nastepne pytanie

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startOdliczanie();


        } else {
            finishCwiczenia();

        }

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
                        sprawdzOdpowiedz();
                    }
                }.start();
            }

            private void updateCountDownText(){
                int minutes = (int) (timeLeftInMillis / 1000) / 60;
                int seconds = (int) (timeLeftInMillis / 1000) % 60;

                String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

                textViewCzas.setText(timeFormatted);

                if (timeLeftInMillis < 10000) {
                    textViewCzas.setTextColor(Color.RED);
                }else {
                    textViewCzas.setTextColor(textColorDefaultCd);
                }
            }



            private void sprawdzOdpowiedz(){
                odpowiedz = true;

                countDownTimer.cancel();

                RadioButton rbSelectd = findViewById(rbGroup.getCheckedRadioButtonId());
                int odpowiedzNr = rbGroup.indexOfChild(rbSelectd)+1;

                if (odpowiedzNr == danepytanie.getOdpowiedznr()) {
                    wynik++;
                    textViewWynik.setText("Wynik: " + wynik);

                }
                pokazOdpowiedzprawidlowa();
            }
    private void pokazOdpowiedzprawidlowa(){
                rb1.setTextColor(Color.RED);
                rb2.setTextColor(Color.RED);
                rb3.setTextColor(Color.RED);
                rb4.setTextColor(Color.RED);


                switch(danepytanie.getOdpowiedznr()){
                    case 1:
                        rb1.setTextColor(Color.GREEN);
                        textViewPytania.setText("Odpowiedź 1 jest prawidłowa");
                        break;
                    case 2:
                        rb2.setTextColor(Color.GREEN);
                        textViewPytania.setText("Odpowiedź 2 jest prawidłowa");
                        break;
                    case 3:
                        rb3.setTextColor(Color.GREEN);
                        textViewPytania.setText("Odpowiedź 3 jest prawdidłowa");
                        break;
                    case 4:
                        rb4.setTextColor(Color.GREEN);
                        textViewPytania.setText("Odpowiedź 4 jest prawidłowa");
                        break;
                }
                if (licznikPytan < licznikpytantotal){
                    buttonPotwierdz.setText("Następne");

                } else {
                    buttonPotwierdz.setText("Zakończ");
                }

            }

            private void finishCwiczenia() {
        Intent wynikIntent = new Intent();
        wynikIntent.putExtra(EXTRA_SCORE, wynik);
        setResult(RESULT_OK, wynikIntent);
                  finish();
            }


    @Override
    public void onBackPressed() {    //wyswietla toast czy chce zamknac aplikacje w trakcie testu
        if (przyciskwroc + 2000 > System.currentTimeMillis()) {
                finishCwiczenia();
        } else {
            Toast.makeText(this, "Naciśnij przycisk wstecz ponownie by wyjść", Toast.LENGTH_SHORT).show();
        }


        przyciskwroc = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, wynik);
        outState.putInt(KEY_QUESTION_COUNT, licznikPytan);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, odpowiedz);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, pytaniaList);
    }
}














