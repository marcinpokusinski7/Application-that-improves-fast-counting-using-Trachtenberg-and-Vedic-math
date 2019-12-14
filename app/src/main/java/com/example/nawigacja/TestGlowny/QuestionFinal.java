package com.example.nawigacja.TestGlowny;

import java.util.Random;

public class QuestionFinal {
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

    public String questions[] = {
            "Podaj wynik: " + random2 + "*2" + " = ",
            "Podaj wynik: " + random3 + "*3" + " = ",
            "Podaj wynik: " + random4 + "*4" + " = ",
            "Podaj wynik: " + random5 + "*5" + " = ",
            "Podaj wynik: " + random6 + "*6" + " = ",
            "Podaj wynik: " + random7 + "*7" + " = ",
            "Podaj wynik: " + random8 + "*8" + " = ",
            "Podaj wynik: " + random9 + "*9" + " = ",
            "Podaj wynik: " + random11 + "*11" + " = ",
            "Podaj wynik: " + random12 + "*12" + " = ",

    };


    public String choices[][] = {
            {" "+random2*2, "B: ", "C: ", "D: "},
            {" "+random3*3, "B: ", "C: ", "D: "},
            {" "+random4*4, "B: ", "C: ", "D: "},
            {" "+random5*5, "B: ", "C: ", "D: "},
            {" "+random6*6, "B: ", "C: ", "D: "},
            {" "+random7*7, "B: ", "C: ", "D: "},
            {" "+random8*8, "B: ", "C: ", "D: "},
            {" "+random9*9, "B: ", "C: ", "D: "},
            {" "+random11*11, "B: ", "C: ", "D: "},
            {" "+random12*12, "B: ", "C: ", "D: "}
    };

    public String correctAnswer[] = {
            " "+random2*2,
            " "+random3*3,
            " "+random4*4,
            " "+random5*5,
            " "+random6*6,
            " "+random7*7,
            " "+random8*8,
            " "+random9*9,
            " "+random11*11,
            " "+random12*12
    };
    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a) {
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a) {
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a) {
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a) {
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        final String answer = correctAnswer[a];
        return answer;
    }
}