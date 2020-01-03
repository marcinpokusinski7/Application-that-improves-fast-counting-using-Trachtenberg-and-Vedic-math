package com.example.nawigacja.Rozgrzewka;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nawigacja.R;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment9;

public class WarmUpBridge extends Fragment {
    LinearLayout warmup;
    private boolean isBackActivated;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_wrampupbridge, container, false);

        super.onCreate(savedInstanceState);

       warmup = v.findViewById(R.id.button_warmup);

        warmup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarmUpMain warmUpMain = new WarmUpMain();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, warmUpMain);

                transaction.commit();
            }
        });



        return v;
    }





}





