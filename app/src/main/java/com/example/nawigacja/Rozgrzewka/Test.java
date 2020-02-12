package com.example.nawigacja.Rozgrzewka;

import java.util.ArrayList;
import java.util.List;

public class Test {


    private List<Question> questions;
    private int numberCorrect;
    private int totalQuestions;
    private int score;
    private Question currentQuestion;

    public Test() {
        numberCorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new Question(10);
        questions = new ArrayList<Question>();
    }

    public void makeNewQuestion(){
        currentQuestion = new Question(totalQuestions * 2+7);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect = false;
        if (currentQuestion.getAnswer() == submittedAnswer){
            numberCorrect++;
            isCorrect=true;
        }
        score = score + 1;
        return isCorrect;
    }






    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }


}
