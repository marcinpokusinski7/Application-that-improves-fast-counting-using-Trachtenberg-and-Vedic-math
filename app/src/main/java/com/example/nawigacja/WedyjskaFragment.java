package com.example.nawigacja;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nawigacja.WedyjskaTeoria.WedyjskaFragmentBydeficiency;
import com.example.nawigacja.WedyjskaTeoria.WedyjskaFragmentPotegowanie;
import com.example.nawigacja.WedyjskaTeoria.WedyjskaFragmentPotegowaniePiatek;
import com.example.nawigacja.WedyjskaTeoria.WedyjskaFragmentSub;
import com.example.nawigacja.WedyjskaTeoria.WedyjskaFragmentVertCross;

public class WedyjskaFragment extends Fragment {

    private CardView btn2;
    private CardView btn3;
    private CardView btn4;
    private CardView btn5;
    private CardView btn6;
    private CardView btn7;
    private CardView btn8;
    private CardView btn9;
    private CardView btn10;
    private CardView btn11;
    private CardView btn12;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wedyjska, container, false);

        btn2 = (CardView) v.findViewById(R.id.btn2);
        btn3 = (CardView) v.findViewById(R.id.btn3);
        btn4 = (CardView) v.findViewById(R.id.btn4);
        btn5 = (CardView) v.findViewById(R.id.btn5);
        btn6 = (CardView) v.findViewById(R.id.btn6);
        btn7 = (CardView) v.findViewById(R.id.btn7);
        btn8 = (CardView) v.findViewById(R.id.btn8);
        btn9 = (CardView) v.findViewById(R.id.btn9);

        btn11 = (CardView) v.findViewById(R.id.btn11);
        btn12 = (CardView) v.findViewById(R.id.btn12);


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WedyjskaFragmentBydeficiency wedyjskaFragmentBydeficiency = new WedyjskaFragmentBydeficiency();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
               // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container,wedyjskaFragmentBydeficiency);

                transaction.commit();

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WedyjskaFragmentSub wedyjskaFragmentSub = new WedyjskaFragmentSub();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
               // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container,wedyjskaFragmentSub);

                transaction.commit();

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WedyjskaFragmentVertCross wedyjskaFragmentVertCross = new WedyjskaFragmentVertCross();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
               // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, wedyjskaFragmentVertCross);

                transaction.commit();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WedyjskaFragmentPotegowanie wedyjskaFragmentPotegowanie = new WedyjskaFragmentPotegowanie();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
               // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, wedyjskaFragmentPotegowanie);

                transaction.commit();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WedyjskaFragmentPotegowaniePiatek wedyjskaFragmentPotegowaniePiatek = new WedyjskaFragmentPotegowaniePiatek();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
               // transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, wedyjskaFragmentPotegowaniePiatek);

                transaction.commit();

            }
        });




    return v;
    }

}
