package com.example.nawigacja.TrachtenbergTeoria;


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
import com.example.nawigacja.TrachtenbergFragment;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrachtenbergFragment6 extends Fragment {
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
    int number = new Random().nextInt(10000);
    private ImageView refresh;



    public TrachtenbergFragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trachtenberg_fragment6, container, false);
        wynik = (EditText) v.findViewById(R.id.wynik);
        sprawdz = (Button) v.findViewById(R.id.sprawdz);
        losowaliczba = (TextView) v.findViewById(R.id.losowaliczba);
        back = (Button) v.findViewById(R.id.back);
        kolumna1 = (EditText) v.findViewById(R.id.kolumna1);
        kolumna2 = (EditText) v.findViewById(R.id.kolumna2);
        kolumna3 = (EditText) v.findViewById(R.id.kolumna3);
        kolumna4 = (EditText) v.findViewById(R.id.kolumna4);
        refresh = (ImageView) v.findViewById(R.id.refresh);
        //losowaliczba.setText(generowanieString(6));
        losowaliczba.setText(Integer.toString(number));

        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wynik.setText(Integer.toString(number*6));
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wynik.getText().clear();
                Random rand = new Random();
                number = rand.nextInt(10000);
                String myString = String.valueOf(number);
                losowaliczba.setText(myString);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment trachtenbergFragment = new TrachtenbergFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment);

                transaction.commit();

            }
        });


        return v;

    }

}
