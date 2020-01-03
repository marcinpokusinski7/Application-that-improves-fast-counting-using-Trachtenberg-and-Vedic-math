package com.example.nawigacja.TrachtenbergTeoria;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nawigacja.R;
import com.example.nawigacja.TrachtenbergFragment;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrachtenbergFragment5 extends Fragment {
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
    private ColorStateList textColorDefaultRb;
    private TextView losowaliczba;
    private EditText wynik;
    private Button sprawdz;
    int number = new Random().nextInt(10000);
    private ImageView refresh;
    CardView expandableView;
    Button arrowBtn;
    CardView cardView;


    public TrachtenbergFragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trachtenberg_fragment5, container, false);
        wynik = (EditText) v.findViewById(R.id.wynik);
        sprawdz = (Button) v.findViewById(R.id.sprawdz);
        losowaliczba = (TextView) v.findViewById(R.id.losowaliczba);
        back = (Button) v.findViewById(R.id.back);
        kolumna1 = (EditText) v.findViewById(R.id.kolumna1);
        kolumna2 = (EditText) v.findViewById(R.id.kolumna2);
        kolumna3 = (EditText) v.findViewById(R.id.kolumna3);
        kolumna4 = (EditText) v.findViewById(R.id.kolumna4);
        kolumna5 = (EditText) v.findViewById(R.id.kolumna5);
        kolumna6 = (EditText) v.findViewById(R.id.kolumna6);
        kolumna7 = (EditText) v.findViewById(R.id.kolumna7);
        kolumna8 = (EditText) v.findViewById(R.id.kolumna8);
        kolumna9 = (EditText) v.findViewById(R.id.kolumna9);
        kolumna10 = (EditText) v.findViewById(R.id.kolumna10);
        refresh = (ImageView) v.findViewById(R.id.refresh);
        //losowaliczba.setText(generowanieString(6));
        losowaliczba.setText(Integer.toString(number));
        expandableView = (CardView) v.findViewById(R.id.expandableView);
        arrowBtn = (Button) v.findViewById(R.id.arrowBtn);
        cardView = (CardView) v.findViewById(R.id.cardView);

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableView.getVisibility()==View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_arrrow_up);
                }else{
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }


        });

        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wynik.getText().toString().equals( wynik.getText().toString())){
                    wynik.setText(Integer.toString(number*5));
                    wynik.setTextColor(Color.GREEN);
                }
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kolumna1.getText().clear();
                kolumna2.getText().clear();
                kolumna3.getText().clear();
                kolumna4.getText().clear();
                kolumna5.getText().clear();
                kolumna6.getText().clear();
                kolumna7.getText().clear();
                kolumna8.getText().clear();
                kolumna9.getText().clear();
                kolumna10.getText().clear();
                wynik.getText().clear();
                wynik.setTextColor(textColorDefaultRb);
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