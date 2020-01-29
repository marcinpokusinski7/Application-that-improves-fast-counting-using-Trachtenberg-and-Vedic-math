package com.example.nawigacja;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;

import java.nio.charset.Charset;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class CwiczeniaFragment extends Fragment {
        private static final int REQUEST_CODE_QUIZ = 1;
        public static final String EXTRA_KATEGORIA_ID = "dodatkowaKategoriaID";
    public static final String EXTRA_KATEGORIA_NAZWA = "dodatkowaKategoriaNazwa";


    public static final String SHARED_PREFS = "sharedPrefs";
        public static final String KEY_HIGHSCORE = "keyHighscore";
    public static final String KEY_HIGHSCORE1 = "keyHighscore";

        private TextView textViewHighscore,textViewHighscore1;
        private Spinner spinerCategory;

        private int highscore, highscore1, highscore2;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cwiczenia, container, false);
        spinerCategory = v.findViewById(R.id.spiner_kat);
        textViewHighscore = v.findViewById(R.id.highscore);
        textViewHighscore1 = v.findViewById(R.id.highscore1);

        loadKategorie();
        loadHighscore();
        loadHighscore1();

            final LinearLayout Button_cwiczenia = v.findViewById(R.id.Button_cwiczenia);
            final LinearLayout Button_cwiczenia1 = v.findViewById(R.id.Button_cwiczenia1);


        Button_cwiczenia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button_cwiczenia1.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                //Intent intent = new Intent(view.getContext(), TestActivity.class);moje
                //view.getContext().startActivity(intent);  moje

                startCwiczenia1();
            }
        });







        Button_cwiczenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button_cwiczenia.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                //Intent intent = new Intent(view.getContext(), TestActivity.class);moje
                //view.getContext().startActivity(intent);  moje

                startCwiczenia();
            }
        });

        return v;
    }

    private void startCwiczenia1(){
        Kategorie wybraneKategorie = (Kategorie) spinerCategory.getSelectedItem();

        String nazwaKategorii = wybraneKategorie.getNazwa();
        int kategorieID = wybraneKategorie.getId();

        Intent intent = new Intent(getContext(), TestActivity.class);
        intent.putExtra(EXTRA_KATEGORIA_ID, kategorieID = 2);
        intent.putExtra(EXTRA_KATEGORIA_NAZWA, "Wedyjska");

        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }


    private void startCwiczenia2(){
        Kategorie wybraneKategorie = (Kategorie) spinerCategory.getSelectedItem();

        String nazwaKategorii = wybraneKategorie.getNazwa();
        int kategorieID = wybraneKategorie.getId();

        Intent intent = new Intent(getContext(), TestActivity.class);
        intent.putExtra(EXTRA_KATEGORIA_ID, kategorieID = 2);
        intent.putExtra(EXTRA_KATEGORIA_NAZWA, nazwaKategorii);

        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }







        private void startCwiczenia(){
        Kategorie wybraneKategorie = (Kategorie) spinerCategory.getSelectedItem();

            String nazwaKategorii = wybraneKategorie.getNazwa();
            int kategorieID = wybraneKategorie.getId();

            Intent intent = new Intent(getContext(), TestActivity.class);
            intent.putExtra(EXTRA_KATEGORIA_ID, kategorieID = 1);
            intent.putExtra(EXTRA_KATEGORIA_NAZWA, nazwaKategorii);

            startActivityForResult(intent, REQUEST_CODE_QUIZ);
        }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int wynik = data.getIntExtra(TestActivity.EXTRA_SCORE, 0);
                int wynik1 = data.getIntExtra(TestActivity.EXTRA_SCORE1, 0);
                if(wynik > highscore ){
                    updateHighscore(wynik);

                }
                if(wynik1 > highscore1){
                    updateHighscore1(wynik1);
                }
            }
        }
    }

    private void loadKategorie() {
        CwiczeniaDbHelper dbHelper = CwiczeniaDbHelper.getInstance(getContext());
        List<Kategorie> kategorie = dbHelper.getAllKategorie();

        ArrayAdapter<Kategorie> adapterKategorie = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, kategorie);
        adapterKategorie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinerCategory.setAdapter(adapterKategorie);



    }

    private void loadHighscore(){
        SharedPreferences prefs = this.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Najlepszy wynik: " + highscore);
    }
    private void loadHighscore1(){
        SharedPreferences prefs1 = this.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore1 = prefs1.getInt(KEY_HIGHSCORE1, 0);
        textViewHighscore1.setText("Najlepszy wynik: " + highscore1);
    }


    private void updateHighscore(int highscoreNew){
        highscore = highscoreNew;
        textViewHighscore.setText("Najlepszy wynik: " + highscore);

        SharedPreferences prefs = this.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
    private void updateHighscore1(int highscoreNew1){
        highscore1 = highscoreNew1;
        textViewHighscore1.setText("Najlepszy wynik: " + highscore1);

        SharedPreferences prefs1 = this.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs1.edit();
        editor.putInt(KEY_HIGHSCORE1, highscore1);
        editor.apply();
    }

}












