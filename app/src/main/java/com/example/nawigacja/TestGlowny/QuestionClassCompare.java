package com.example.nawigacja.TestGlowny;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionClassCompare implements Parcelable{

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

    public int getRightOpt() {
        return rightOpt;
    }

    public void setRightOpt(int rightOpt) {
        this.rightOpt = rightOpt;
    }

    public QuestionClassCompare(String que, String opt1, int rightOpt) {
        this.que = que;
        this.opt1 = opt1;
        this.rightOpt = rightOpt;
    }

    private int id;
    private String que;
    private String opt1;
    private int rightOpt;




    protected QuestionClassCompare(Parcel in) {

        que = in.readString();
        opt1 = in.readString();

        rightOpt = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(que);
        dest.writeString(opt1);

        dest.writeInt(rightOpt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionClassCompare> CREATOR = new Creator<QuestionClassCompare>() {
        @Override
        public QuestionClassCompare createFromParcel(Parcel in) {
            return new QuestionClassCompare(in);
        }

        @Override
        public QuestionClassCompare[] newArray(int size) {
            return new QuestionClassCompare[size];
        }
    };


}
