package com.example.nawigacja.TestGlowny;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
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

import com.example.nawigacja.MainActivity;
import com.example.nawigacja.R;
import com.example.nawigacja.Rozgrzewka.Question;
import com.example.nawigacja.TestActivity;

import java.util.Random;

public class TestActivityTrachtenberg extends AppCompatActivity implements View.OnClickListener  {


    public static final String EXTRA_SCORE = "Dodatkowy_Wynik";

    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion, textViewScore, textViewPytanielicznik, textViewTime;

    private ColorStateList textColorDefaultRb;    //kolor po zaznaczeniu dobrej zlej odpowiedzi
    private ColorStateList textColorDefaultCd;

    private RadioGroup rbGroup;
    private RadioButton rb1;                //4 opcje wyboru
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonPotwierdz;    //przycisk potwierdzajacy przenieienie dalej
    ProgressBar progressBar;
    int i = 0;


    private int score;

    private boolean answered;

    private boolean odpowiedz; //odpowiada za to co sie stanie kiedy klikniemy przycisk potwierdz, jezeli nie odpowiedziales pokazuje nastepne pytanie
    private long przyciskwroc;


    private QuestionFinal question = new QuestionFinal();

    private String answer;
    private int questionLength = question.questions.length;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.test_glowny_trachtenberg);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewPytanielicznik = findViewById(R.id.text_view_question_count);
        textViewTime = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        textColorDefaultRb = rb1.getTextColors();
        buttonPotwierdz = findViewById(R.id.button_confirm_next);

        random = new Random();





    NextQuestion(random.nextInt(questionLength));
        buttonPotwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        NextQuestion(random.nextInt(questionLength));
                    } else {
                        Toast.makeText(TestActivityTrachtenberg.this, "Prosze wybrać odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                }
        });







    }
    public void onClick(View v) {
        switch (v.getId()){



            case R.id.rb1:
                if(rb1.getText() == answer){
                    rb1.setTextColor(Color.GREEN);
                    rb2.setTextColor(Color.RED);
                    rb3.setTextColor(Color.RED);
                    rb4.setTextColor(Color.RED);

                }

                break;

            case R.id.rb2:
                if(rb2.getText() == answer){
                    rb1.setTextColor(Color.RED);
                    rb2.setTextColor(Color.GREEN);
                    rb3.setTextColor(Color.RED);
                    rb4.setTextColor(Color.RED);

                }

                break;

            case R.id.rb3:
                if(rb3.getText() == answer){
                    rb1.setTextColor(Color.RED);
                    rb2.setTextColor(Color.RED);
                    rb3.setTextColor(Color.GREEN);
                    rb4.setTextColor(Color.RED);

                }

                break;

            case R.id.rb4:
                if(rb4.getText() == answer){
                    rb1.setTextColor(Color.RED);
                    rb2.setTextColor(Color.RED);
                    rb3.setTextColor(Color.RED);
                    rb4.setTextColor(Color.GREEN);

                }

                break;
        }
    }



    private void NextQuestion(int a){
        textViewQuestion.setText(question.getQuestion(a));
        rb1.setText(question.getchoice1(a));
        rb2.setText(question.getchoice2(a));
        rb3.setText(question.getchoice3(a));
        rb4.setText(question.getchoice4(a));

        rbGroup.clearCheck();
        answer = question.getCorrectAnswer(a);
    }







}




