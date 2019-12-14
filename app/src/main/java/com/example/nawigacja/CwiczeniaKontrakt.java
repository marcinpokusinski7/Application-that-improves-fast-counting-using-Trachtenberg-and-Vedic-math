package com.example.nawigacja;

import android.provider.BaseColumns;

public final class CwiczeniaKontrakt {


    private CwiczeniaKontrakt() {}

    public static class TablicaKategorii implements BaseColumns {
        public static final String NAZWA_TABELI = "Kategorie_pytan";
        public static final String NAZWA_KOLUMNY = "Nazwa";
    }


    public static class TablicaPytan implements BaseColumns {
        public static final String NAZWA_TABELI = "Pytania_cwiczenia";
        public static final String POLE_PYTAN = "Pytanie";
        public static final String Pole_Opcja1 = "Opcja_pierwsza";
        public static final String Pole_Opcja2 = "Opcja_druga";
        public static final String Pole_Opcja3 = "Opcja_trzecia";
        public static final String Pole_Opcja4 = "Opcja_czwarta";
        public static final String Pole_odpowiedzi_nr = "Odpowiedz_nr";
        public static final String Pole_Kategorii_ID = "Kategorie_id";
    }
}
