package com.example.nawigacja.TestGlowny;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nawigacja.R;
import com.example.nawigacja.TrachtenbergTeoria.TrachtenbergFragment4;

public class TestFragment extends Fragment {
    private LinearLayout button_trach;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_test, container, false);


        final LinearLayout button_trach = v.findViewById(R.id.button_trach);


        button_trach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_trach.setBackgroundResource(R.drawable.bg_item_cho);
                //przycisk do cwiczen z podswietleniem na szaro, wyswietla fragment cwiczenia
                Intent intent = new Intent(getContext(), Testact.class);
                startActivity(intent);
            }


        });
        return v;
    }

}
