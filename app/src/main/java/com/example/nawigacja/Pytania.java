package com.example.nawigacja;

import android.os.Parcel;
import android.os.Parcelable;

public class Pytania implements Parcelable {
    private int id;
    private String pytania;
    private String opcja1;
    private String opcja2;
    private String opcja3;
    private String opcja4;
    private int odpowiedznr;
    private int kategorieID;


    public Pytania() {}
    public Pytania(String pytania, String opcja1, String opcja2, String opcja3, String opcja4, int odpowiedznr, int kategorieID) {
        this.pytania = pytania;
        this.opcja1 = opcja1;
        this.opcja2 = opcja2;
        this.opcja3 = opcja3;
        this.opcja4 = opcja4;
        this.odpowiedznr = odpowiedznr;
        this.kategorieID = kategorieID;
    }

    protected Pytania(Parcel in) {
        id = in.readInt();
        pytania = in.readString();
        opcja1 = in.readString();
        opcja2 = in.readString();
        opcja3 = in.readString();
        opcja4 = in.readString();
        odpowiedznr = in.readInt();
        kategorieID = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(pytania);
        dest.writeString(opcja1);
        dest.writeString(opcja2);
        dest.writeString(opcja3);
        dest.writeString(opcja4);
        dest.writeInt(odpowiedznr);
        dest.writeInt(kategorieID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pytania> CREATOR = new Creator<Pytania>() {
        @Override
        public Pytania createFromParcel(Parcel in) {
            return new Pytania(in);
        }

        @Override
        public Pytania[] newArray(int size) {
            return new Pytania[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPytania() {
        return pytania;
    }

    public void setPytania(String pytania) {
        this.pytania = pytania;
    }

    public String getOpcja1() {
        return opcja1;
    }

    public void setOpcja1(String opcja1) {
        this.opcja1 = opcja1;
    }

    public String getOpcja2() {
        return opcja2;
    }

    public void setOpcja2(String opcja2) {
        this.opcja2 = opcja2;
    }

    public String getOpcja3() {
        return opcja3;
    }

    public void setOpcja3(String opcja3) {
        this.opcja3 = opcja3;
    }

    public String getOpcja4() {
        return opcja4;
    }

    public void setOpcja4(String opcja4) {
        this.opcja4 = opcja4;
    }

    public int getOdpowiedznr() {
        return odpowiedznr;
    }

    public void setOdpowiedznr(int odpowiedznr) {
        this.odpowiedznr = odpowiedznr;
    }

    public int getKategorieID() {
        return kategorieID;
    }

    public void setKategorieID(int kategorieID) {
        this.kategorieID = kategorieID;
    }
}
