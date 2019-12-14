package com.example.nawigacja.Rozgrzewka;

import java.util.Random;

public class Question {


    private int firstNumber;
    private int secondNumber;
    private int answer;

    //4 mozliwosci wybory odpowiedzi
    private int [] answerArray;

    //ktora z mozliwosci jest prawidlowa
    private int answerNumber;


    private int difficultylimit;

    //wyswietla pytanie
    private String question;



    //nowe losowe pytanie

    public Question(int difficultylimit){
        this.difficultylimit = difficultylimit;
        Random randomNumber = new Random();

        this.firstNumber = randomNumber.nextInt(difficultylimit);
        this.secondNumber = randomNumber.nextInt(difficultylimit);
        this.answer = this.firstNumber + this.secondNumber;
        this.question = firstNumber + " + " + secondNumber  + " = ";

        this.answerNumber = randomNumber.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};
        this.answerArray[0] = answer + 3;
        this.answerArray[1] = answer + 2;
        this.answerArray[2] = answer + 6;       //przykladowa roznica w odpwoiedziach
        this.answerArray[3] = answer + -2;

        this.answerArray = randomArray(this.answerArray);

        answerArray[answerNumber] = answer;

    }

    //randomarray czyli losowa pozycja odpowiedzi

    private int [] randomArray(int[] array){
        int index, temp;

        Random randomnumber = new Random();

        for (int i = array.length - 1; i > 0 ; i--){
            index = randomnumber.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }


    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getDifficultylimit() {
        return difficultylimit;
    }

    public void setDifficultylimit(int difficultylimit) {
        this.difficultylimit = difficultylimit;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
