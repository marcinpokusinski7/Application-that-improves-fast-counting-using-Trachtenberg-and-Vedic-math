package com.example.nawigacja.TestGlowny;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.nawigacja.Pytania;

public class QuestionClass implements Parcelable{

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public int getRightOpt() {
        return rightOpt;
    }

    public void setRightOpt(int rightOpt) {
        this.rightOpt = rightOpt;
    }

    public QuestionClass(String que, String opt1, String opt2, String opt3, String opt4, int rightOpt) {
        this.que = que;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.rightOpt = rightOpt;
    }

    private int id;
    private String que;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int rightOpt;




    protected QuestionClass(Parcel in) {

        que = in.readString();
        opt1 = in.readString();
        opt2 = in.readString();
        opt3 = in.readString();
        opt4 = in.readString();
        rightOpt = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(que);
        dest.writeString(opt1);
        dest.writeString(opt2);
        dest.writeString(opt3);
        dest.writeString(opt4);
        dest.writeInt(rightOpt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionClass> CREATOR = new Parcelable.Creator<QuestionClass>() {
        @Override
        public QuestionClass createFromParcel(Parcel in) {
            return new QuestionClass(in);
        }

        @Override
        public QuestionClass[] newArray(int size) {
            return new QuestionClass[size];
        }
    };


}
