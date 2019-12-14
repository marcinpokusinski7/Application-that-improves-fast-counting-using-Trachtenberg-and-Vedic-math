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
        Pytania p1 = new Pytania("Jaki jest wynik działania: " +random +"*" +2 , "A: "+random*2, "B: "+(random*2+random1), "C: "+(random*2+random2), "D: "+(random*2+random3), 1, Kategorie.TRACHTENBERG);
        dodajPytanie(p1);
        Pytania p2 = new Pytania("Wynik będzie wynosił", "A", "B", "C", "D", 2, Kategorie.WEDYJSKA);
        dodajPytanie(p2);
        Pytania p3 = new Pytania("Jaka będzie suma liczb?", "A", "B", "C", "D", 3, Kategorie.CIEKAWOSTKI);
        dodajPytanie(p3);
        Pytania p4 = new Pytania("Jaki będzie wynik z tego działania", "A", "B", "C", "D", 4 , Kategorie.WEDYJSKA);
        dodajPytanie(p4);
        Pytania p5 = new Pytania("Jaki jest wynik działania: " +random4 +"*" +2 , "A: "+(random*2+random2), "B: "+(random*2+random1), "C: "+random4*2, "D: "+(random*2+random3), 3, Kategorie.TRACHTENBERG);
        dodajPytanie(p5);
        Pytania p6 = new Pytania("Jaki jest wynik działania 3", "A", "B", "C", "D", 1, Kategorie.CIEKAWOSTKI);
        dodajPytanie(p6);



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
                null
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
