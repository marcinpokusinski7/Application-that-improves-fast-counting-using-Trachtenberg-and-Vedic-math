package com.example.nawigacja.TestGlowny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nawigacja.R;

import org.w3c.dom.Text;

import java.util.prefs.PreferenceChangeListener;

import static android.content.Context.MODE_PRIVATE;

public class TestFragment extends Fragment {
    private LinearLayout button_trach, button_best;
    int lastscore, lastscorewed, lastscoreall;
    long lasttime;

    int best1, best4, best7;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        TextView highscore = v.findViewById(R.id.highscore1);
        TextView highscore1 = v.findViewById(R.id.highscore6);
        TextView highscore2 = v.findViewById(R.id.highscore7);
        final LinearLayout button_trach = v.findViewById(R.id.trach);
        final LinearLayout button_wed = v.findViewById(R.id.button_wed);
        final LinearLayout button_comp = v.findViewById(R.id.button_compare);
        final LinearLayout button_best = v.findViewById(R.id.button_best);

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
        button_best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_best.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                Intent intent = new Intent(getContext(), TestHighscorecheck.class);
                startActivity(intent);
            }


        });


        SharedPreferences preferences = this.getActivity().getSharedPreferences("PREFS", getContext().MODE_PRIVATE);
        SharedPreferences preferences1 = this.getActivity().getSharedPreferences("PREFSWED", getContext().MODE_PRIVATE);
        SharedPreferences preferences3 = this.getActivity().getSharedPreferences("PREFSALL", getContext().MODE_PRIVATE);

        lastscore = preferences.getInt("lastscore", 0);
        lastscorewed = preferences1.getInt("lastscorewed", 0);
        lastscoreall = preferences3.getInt("lastscoreall", 0);
        best1 = preferences.getInt("best1", 0);
        best4 = preferences1.getInt("best4", 0);
        best7 = preferences3.getInt("best7", 0);

        if (lastscore > best1) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best1", best1);
            editor.apply();


        }


        if (lastscorewed > best4) {
            SharedPreferences.Editor editorwed = preferences1.edit();
            editorwed.putInt("best4", best4);
            editorwed.apply();

        }

        if (lastscoreall > best7) {
            SharedPreferences.Editor editorall = preferences3.edit();
            editorall.putInt("best7", best7);
            editorall.apply();

        }


        highscore.setText("Najlepszy wynik: " + best1);
        highscore1.setText("Najlepszy wynik: " + best4);
        highscore2.setText("Najlepszy wynik: " + best7);




        return v;
    }



}
