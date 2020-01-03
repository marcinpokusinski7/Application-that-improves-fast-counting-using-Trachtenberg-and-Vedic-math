package com.example.nawigacja.Rozgrzewka;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nawigacja.R;

public class WarmUpMain extends Fragment {
    Test t = new Test();


    private TextView textViewQuestion, textViewScore, textViewPytanielicznik, textViewTime, tv_bottom;



    private Button rb1;                //4 opcje wyboru
    private Button rb2;
    private Button rb3;
    private Button rb4;
    private Button btn_start;    //przycisk potwierdzajacy przenieienie dalej
    ProgressBar prog_timer;



    int secondRemaining = 30;

    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long l) {
            secondRemaining=secondRemaining-1;
            textViewTime.setText(Integer.toString(secondRemaining)+" sekund");
            prog_timer.setProgress(30-secondRemaining);

        }

        @Override
        public void onFinish() {

            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
            rb4.setEnabled(false);
            tv_bottom.setText("Czas się skończył: " + t.getNumberCorrect() + "/" +(t.getTotalQuestions() -1));


            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            }, 4000);

        }
    };


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_rozgrzewka, container, false);

        super.onCreate(savedInstanceState);


        textViewQuestion = v.findViewById(R.id.textViewQuestion);
        textViewScore = v.findViewById(R.id.textViewScore);
        textViewPytanielicznik = v.findViewById(R.id.text_view_question_count);
        textViewTime = v.findViewById(R.id.textViewTime);
tv_bottom = v.findViewById(R.id.tv_bottom);
        rb1 = v.findViewById(R.id.rb1);
        rb2 = v.findViewById(R.id.rb2);
        rb3 = v.findViewById(R.id.rb3);
        rb4 = v.findViewById(R.id.rb4);
        prog_timer = v.findViewById(R.id.prog_timer);
        btn_start = v.findViewById(R.id.btn_start);


        textViewTime.setText("0 sekund");
        textViewQuestion.setText("");
        textViewScore.setText("Wynik: 0");

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;


                btn_start.setVisibility(View.INVISIBLE);
                secondRemaining = 30;
                t = new Test();
                timer.start();


                nextQuestion();


            }
        };


        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                btn_start.setVisibility(View.INVISIBLE);
                t.checkAnswer(answerSelected);
                textViewScore.setText("Wynik: " + t.getScore());

                nextQuestion();


            }
        };
        btn_start.setOnClickListener(startButtonClickListener);

        rb1.setOnClickListener(answerButtonClickListener);
        rb2.setOnClickListener(answerButtonClickListener);
        rb3.setOnClickListener(answerButtonClickListener);
        rb4.setOnClickListener(answerButtonClickListener);


        nextQuestion();
        timer.start();
        return v;
    }



    private void nextQuestion(){
        t.makeNewQuestion();
        int [] answer = t.getCurrentQuestion().getAnswerArray();
        rb1.setText(Integer.toString(answer[0]));
        rb2.setText(Integer.toString(answer[1]));
        rb3.setText(Integer.toString(answer[2]));
        rb4.setText(Integer.toString(answer[3]));
        textViewQuestion.setText(t.getCurrentQuestion().getQuestion());

        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(true);
        textViewQuestion.setText(t.getCurrentQuestion().getQuestion());
        tv_bottom.setText(t.getNumberCorrect() + "/" + (t.getTotalQuestions() - 1));
    }




}

