package com.example.nawigacja.TestGlowny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nawigacja.R;

import org.w3c.dom.Text;

public class TestFragment extends Fragment {
    private LinearLayout button_trach;
    int lastscore;
    long lasttime;
    int best1, best2, best3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_test, container, false);
        TextView highscore = v.findViewById(R.id.highscore1);

        final LinearLayout button_trach = v.findViewById(R.id.trach);
        final LinearLayout button_wed = v.findViewById(R.id.button_wed);
        final LinearLayout button_comp = v.findViewById(R.id.button_compare);
        button_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_comp.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                Intent intent = new Intent(getContext(), Testall.class);
                startActivity(intent);
            }


        });
        button_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_wed.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                Intent intent = new Intent(getContext(), Testwed.class);
                startActivity(intent);
            }


        });
        button_trach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_trach.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                Intent intent = new Intent(getContext(), Testact.class);
                startActivity(intent);
            }


        });
        SharedPreferences preferences = this.getActivity().getSharedPreferences("PREFS", getContext().MODE_PRIVATE);
        lastscore = preferences.getInt("lastscore", 0);
        best1 = preferences.getInt("best1", 0);
        if(lastscore > best1){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best1",best1);
            editor.apply();
        }
        highscore.setText("Najlepszy wynik: "+best1);
        return v;
    }

}
