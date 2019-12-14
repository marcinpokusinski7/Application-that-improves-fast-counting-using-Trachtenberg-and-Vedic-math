package com.example.nawigacja;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment11;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment12;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment2;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment3;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment4;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment5;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment6;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment7;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment8;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment9;

public class TrachtenbergFragment extends Fragment {
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
        View v = inflater.inflate(R.layout.fragment_trachtenberg, container, false);

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

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment12 trachtenbergFragment12 = new TrachtenbergFragment12();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment12);

                transaction.commit();
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment11 trachtenbergFragment11 = new TrachtenbergFragment11();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment11);

                transaction.commit();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment9 trachtenbergFragment9 = new TrachtenbergFragment9();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment9);

                transaction.commit();
            }
        });


        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment8 trachtenbergFragment8 = new TrachtenbergFragment8();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment8);

                transaction.commit();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment7 trachtenbergFragment7 = new TrachtenbergFragment7();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment7);

                transaction.commit();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment6 trachtenbergFragment6 = new TrachtenbergFragment6();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment6);

                transaction.commit();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment5 trachtenbergFragment5 = new TrachtenbergFragment5();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment5);

                transaction.commit();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment4 trachtenbergFragment4 = new TrachtenbergFragment4();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment4);

                transaction.commit();
            }
        });



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment3 trachtenbergFragment3 = new TrachtenbergFragment3();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment3);

                transaction.commit();
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrachtenbergFragment2 trachtenbergFragment2 = new TrachtenbergFragment2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.replace(R.id.fragment_container, trachtenbergFragment2);

                transaction.commit();

            }
        });



        return v;
    }
    public void powrot()  {

    }

}

