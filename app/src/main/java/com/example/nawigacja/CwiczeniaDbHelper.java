package com.example.nawigacja;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.nawigacja.CwiczeniaKontrakt.*;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CwiczeniaDbHelper extends SQLiteOpenHelper {
    private static final String BAZADANYCH_NAZWA = "Cwiczenia.db";
    private static final int BAZADANYCH_WERSJA = 1;
    int random = new Random().nextInt(10000);
    final int random1 = new Random().nextInt(30);
    final int random2 = new Random().nextInt(30);
    final int random3 = new Random().nextInt(30);
    final int random4 = new Random().nextInt(10000);
    private static CwiczeniaDbHelper instance;
        int wynik;
    private SQLiteDatabase db;   // odnosnik



    private CwiczeniaDbHelper(Context context) {
        super(context, BAZADANYCH_NAZWA, null, BAZADANYCH_WERSJA);
    }

    public static synchronized CwiczeniaDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new CwiczeniaDbHelper(context.getApplicationContext());
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {  //public void onCreate(SQLiteDatabase SQLiteDatabase)
        this.db = db;

        final String SQL_STWORZ_KATEGORIE_TABLE = "CREATE TABLE " +
                TablicaKategorii.NAZWA_TABELI + "( " +
                TablicaKategorii._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TablicaKategorii.NAZWA_KOLUMNY + " TEXT " +
                ")";

        final String SQL_STWORZ_BAZE_PYTAN = "CREATE TABLE " +
                TablicaPytan.NAZWA_TABELI + " ( " +
                TablicaPytan._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TablicaPytan.POLE_PYTAN + " TEXT, " +
                TablicaPytan.Pole_Opcja1 + " TEXT, " +
                TablicaPytan.Pole_Opcja2 + " TEXT, " +
                TablicaPytan.Pole_Opcja3 + " TEXT, " +
                TablicaPytan.Pole_Opcja4 + " TEXT, " +
                TablicaPytan.Pole_odpowiedzi_nr + " INTEGER, " +
                TablicaPytan.Pole_Kategorii_ID + " INTEGER, " +
                "FOREIGN KEY(" + TablicaPytan.Pole_Kategorii_ID +  ") REFERENCES " +
                TablicaKategorii.NAZWA_TABELI + "(" + TablicaKategorii._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_STWORZ_KATEGORIE_TABLE);
        db.execSQL(SQL_STWORZ_BAZE_PYTAN);
        WypelnijTablicaKategorii();
        WypelnijPytaniaZbior();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TablicaKategorii.NAZWA_TABELI);
        db.execSQL("DROP TABLE IF EXISTS " + TablicaPytan.NAZWA_TABELI);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void WypelnijTablicaKategorii(){
        Kategorie c1 = new Kategorie("Trachtenberg");
        addKategoria(c1);
        Kategorie c2 = new Kategorie("Matematyka Wedyjska");
        addKategoria(c2);
        Kategorie c3 = new Kategorie("Ciekawostki");
        addKategoria(c3);
    }
    private void addKategoria(Kategorie kategorie){
        ContentValues cv = new ContentValues();
        cv.put(TablicaKategorii.NAZWA_KOLUMNY, kategorie.getNazwa());
        db.insert(TablicaKategorii.NAZWA_TABELI, null, cv);
    }

    private void WypelnijPytaniaZbior(){
        Pytania p1 = new Pytania("Jaką cyfrę dodajemy każdej liczbie z przodu, kiedy zaczynamy mnożenie?: ", "1", "0", "2", "3", 2, Kategorie.TRACHTENBERG);
        dodajPytanie(p1);
        Pytania p2 = new Pytania("Jaka liczba nie występuje w mnożeniu systemem Trachtenberga?", "10", "12", "2", "11", 1, Kategorie.TRACHTENBERG);
        dodajPytanie(p2);
        Pytania p3 = new Pytania("Liczba sąsiednia to cyfra występująca: ", "Po prawej stronie cyfry", "Po lewej stronie cyfry", "Na końcu liczby", "Na początku liczby", 1, Kategorie.TRACHTENBERG);
        dodajPytanie(p3);
        Pytania p4 = new Pytania("Jeżeli cyfra nie ma sąsiada to: ", "Przyjmujemy 1", "Przyjmujemy cyfrę na której działamy", "Mnożymy przez 2", "Przyjmujemy 0", 4 , Kategorie.TRACHTENBERG);
        dodajPytanie(p4);
        Pytania p5 = new Pytania("W mnożeniu przez 11 liczbę sąsiednią: ", "Odejmujemy", "Mnożymy", "Dodajemy", "Dzielimy", 3, Kategorie.TRACHTENBERG);
        dodajPytanie(p5);
        Pytania p6 = new Pytania("Zaczynając mnożenie liczby zapisujemy: ", "Łącznie z liczbą przez którą mnożymy", "Dwie ostatnie i dwie pierwsze", "Od pierwszej cyfry", "Od ostatniej cyfry", 4 , Kategorie.TRACHTENBERG);
        dodajPytanie(p6);
        Pytania p7 = new Pytania("W mnożeniu przez 9: ", "Pierwszą od 10, kolejne od 9", "Wszystkie liczby odjemujemy od 10", "Pierwsza od 9, kolejne od 10", "Wszystkie liczby odejmujemy od 9", 1, Kategorie.TRACHTENBERG);
        dodajPytanie(p7);
        Pytania p8 = new Pytania("Jeżeli cyfra wyjściowa jest nieparzysta w niektorych równaniach dodajemy liczbę: ", "3", "4", "1", "5", 4 , Kategorie.TRACHTENBERG);
        dodajPytanie(p8);
        Pytania p9 = new Pytania("W mnożeniu przez 6: ", "Mnożymy przez 3", "Połowę sąsiedniej liczby", "Mnożymy przez 2", "Do każdej cyfry dodajemy sąsiednią liczbę", 1, Kategorie.TRACHTENBERG);
        dodajPytanie(p9);
        Pytania p10 = new Pytania("Jeżeli w wyniku otrzymamy liczbę wiekszą od 10 to: ", "Dodajemy całą do liczby poniżej", "Dodajemy resztę z 10", "Dodajemy samą 10", "Dzielimy na pół i dodajemy", 2, Kategorie.TRACHTENBERG);
        dodajPytanie(p10);
        Pytania p11 = new Pytania("Wynik każdej liczby odczytujemy od: ", "Góry", "Dołu", "Prawej", "Lewej", 2, Kategorie.TRACHTENBERG);
        dodajPytanie(p11);
        Pytania p12 = new Pytania("W mnożeniu przez 3 wynik po odjęciu od 10 i 9: ", "Mnożymy przez 3", "Mnożymy przez 4", "Mnożymy przez 2", "Dzielimy przez 2", 3, Kategorie.TRACHTENBERG);
        dodajPytanie(p12);
        Pytania p13 = new Pytania("W którym wieku sformułowane zostały reguły matematyki wedyjskiej? ", "XXI", "XX", "XIX", "XVIII", 2, Kategorie.WEDYJSKA);
        dodajPytanie(p13);
        Pytania p14 = new Pytania("Jaką nazwę nosi sutra stosowana przy odejmowania potęg liczby 10: ", "Wszystkie od 9, ostatnia od 10", "Wszystkie od 10, ostatnia od 9", "Wszystkie od 10", "Wszystkie od 9", 1 , Kategorie.WEDYJSKA);
        dodajPytanie(p14);
        Pytania p15 = new Pytania("Jak można przetłumaczyć duplex? ", "Potrojenie", "Podwojenie", "Podzielenie", "Złączenie", 2, Kategorie.WEDYJSKA);
        dodajPytanie(p15);
        Pytania p16 = new Pytania("W jaki sposób uzyskujemy wynik kwadratowy liczb które w podstawie mają 5 na końcu?", "Mnożymy przez siebie", "Rozdzielamy", "Dodajemy", "Zestawiamy", 4, Kategorie.WEDYJSKA);
        dodajPytanie(p16);
        Pytania p17 = new Pytania("W mnożeniu liczb bliskich 100 liczby odejmujemy od: ", "Siebie", "Liczby 101", "Sumy liczb", "Liczby 100", 4, Kategorie.WEDYJSKA);
        dodajPytanie(p17);
        Pytania p18 = new Pytania("Duplex z liczby 34 wynosi: ", "28", "7", "12", "24", 4, Kategorie.WEDYJSKA);
        dodajPytanie(p18);

    }
    private void dodajPytanie(Pytania pytania) {
        ContentValues cv = new ContentValues();
        cv.put(TablicaPytan.POLE_PYTAN, pytania.getPytania());
        cv.put(TablicaPytan.Pole_Opcja1, pytania.getOpcja1());
        cv.put(TablicaPytan.Pole_Opcja2, pytania.getOpcja2());
        cv.put(TablicaPytan.Pole_Opcja3, pytania.getOpcja3());
        cv.put(TablicaPytan.Pole_Opcja4, pytania.getOpcja4());
        cv.put(TablicaPytan.Pole_odpowiedzi_nr, pytania.getOdpowiedznr());
        cv.put(TablicaPytan.Pole_Kategorii_ID, pytania.getKategorieID());
        db.insert(TablicaPytan.NAZWA_TABELI, null, cv);
    }
    public List<Kategorie> getAllKategorie() {
        List<Kategorie> kategorieList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TablicaKategorii.NAZWA_TABELI, null);

        if (c.moveToFirst()) {
            do {
                Kategorie kategorie = new Kategorie();
                kategorie.setId((c.getInt(c.getColumnIndex(TablicaKategorii._ID))));
                kategorie.setNazwa(c.getString(c.getColumnIndex(TablicaKategorii.NAZWA_KOLUMNY)));
                kategorieList.add(kategorie);
            }while (c.moveToNext());
        }
        c.close();
        return kategorieList;
    }


    public ArrayList<Pytania> getAllPytania(){
        ArrayList<Pytania> PytaniaList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TablicaPytan.NAZWA_TABELI, null);

        if (c.moveToFirst()) {
            do{
                Pytania pytania = new Pytania();
                pytania.setId(c.getInt(c.getColumnIndex(TablicaPytan._ID)));
                pytania.setPytania(c.getString(c.getColumnIndex(TablicaPytan.POLE_PYTAN)));
                pytania.setOpcja1(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja1)));
                pytania.setOpcja2(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja2)));
                pytania.setOpcja3(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja3)));
                pytania.setOpcja4(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja4)));
                pytania.setOdpowiedznr(c.getInt(c.getColumnIndex(TablicaPytan.Pole_odpowiedzi_nr)));
                pytania.setKategorieID(c.getInt(c.getColumnIndex(TablicaPytan.Pole_Kategorii_ID)));
                PytaniaList.add(pytania);
            }while (c.moveToNext());
        }
        c.close();
        return PytaniaList;
    }
    public ArrayList<Pytania> getPytania(int kategorieID) {
        ArrayList<Pytania> pytaniaList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = TablicaPytan.Pole_Kategorii_ID + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(kategorieID)};

        Cursor c = db.query(
                TablicaPytan.NAZWA_TABELI,
                null,
                selection,
                selectionArgs,
                null,
                null,
                "RANDOM() LIMIT 5 "
        );
        if (c.moveToFirst()){
            do {
                Pytania pytania = new Pytania();
                pytania.setId(c.getInt(c.getColumnIndex(TablicaPytan._ID)));
                pytania.setPytania(c.getString(c.getColumnIndex(TablicaPytan.POLE_PYTAN)));
                pytania.setOpcja1(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja1)));
                pytania.setOpcja2(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja2)));
                pytania.setOpcja3(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja3)));
                pytania.setOpcja4(c.getString(c.getColumnIndex(TablicaPytan.Pole_Opcja4)));
                pytania.setOdpowiedznr(c.getInt(c.getColumnIndex(TablicaPytan.Pole_odpowiedzi_nr)));
                pytania.setKategorieID(c.getInt(c.getColumnIndex(TablicaPytan.Pole_Kategorii_ID)));
                pytaniaList.add(pytania);
            }while(c.moveToNext());
        }
        c.close();
        return pytaniaList;






    }




}
