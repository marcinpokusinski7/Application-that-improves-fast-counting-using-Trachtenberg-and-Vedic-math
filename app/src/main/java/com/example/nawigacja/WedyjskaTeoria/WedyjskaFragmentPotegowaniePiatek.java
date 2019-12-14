package com.example.nawigacja.WedyjskaTeoria;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nawigacja.R;
import com.example.nawigacja.WedyjskaFragment;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class WedyjskaFragmentPotegowaniePiatek extends Fragment {
    private Button back;
    private EditText kolumna1;
    private EditText kolumna2;
    private EditText kolumna3;
    private EditText kolumna4;
    private EditText kolumna5;
    private EditText kolumna6;
    private EditText kolumna7;
    private EditText kolumna8;
    private EditText kolumna9;
    private EditText kolumna10;
    private TextView losowaliczba;
    private EditText wynik;
    private Button sprawdz;
    private ImageView refresh;
    private TextView potega;

    int number;


    public WedyjskaFragmentPotegowaniePiatek() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wedyjska_potegowanie5, container, false);
        wynik = (EditText) v.findViewById(R.id.wynik);
        sprawdz = (Button) v.findViewById(R.id.sprawdz);
        losowaliczba = (TextView) v.findViewById(R.id.losowaliczba);
        back = (Button) v.findViewById(R.id.back);
        potega = (TextView) v.findViewById(R.id.potega);
        kolumna1 = (EditText) v.findViewById(R.id.kolumna1);
        kolumna2 = (EditText) v.findViewById(R.id.kolumna2);
        kolumna3 = (EditText) v.findViewById(R.id.kolumna3);
        kolumna4 = (EditText) v.findViewById(R.id.kolumna4);
        refresh = (ImageView) v.findViewById(R.id.refresh);
        //losowaliczba.setText(generowanieString(6));
        losowaliczba.setText(Integer.toString(number));






        Random rand = new Random();
        number = rand.nextInt(1000/5)*5;
        if (number%10 == 0|| number == 0 || number == 5){
            number=number+5;

        }
        String myString = String.valueOf(number);
        losowaliczba.setText(myString);
        sprawdz.setOnClickListener(new View.OnClickListener() {                // potegowanie liczb z koncowka 5
            @Override
            public void onClick(View view) {
                wynik.setText(Integer.toString(number*number));
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wynik.getText().clear();
                Random rand = new Random();
                number = rand.nextInt(1000/5)*5;
                if (number%10 == 0|| number == 0 || number == 5){
                    number=number+5;

                }
                String myString = String.valueOf(number);
                losowaliczba.setText(myString);
            }
        });





        potega.setText("\u00B2");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WedyjskaFragment wedyjskaFragment = new WedyjskaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, wedyjskaFragment);

                transaction.commit();

            }
        });




        return v;

    }



    /*private String generowanieString(int lenght){
        char[] chars = "123456789".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 4; i++){

            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }*/

}
