package com.example.nawigacja;

import androidx.annotation.NonNull;

public class Kategorie {
    public static final int TRACHTENBERG = 1;
    public static final int WEDYJSKA = 2;
    public static final int CIEKAWOSTKI = 3;

    private int id;
    private String nazwa;

    public Kategorie(){

    }

    public Kategorie(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @NonNull
    @Override
    public String toString() {
        return getNazwa();
    }
}
