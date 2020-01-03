package com.example.nawigacja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.MenuItem;


import com.example.nawigacja.Rozgrzewka.WarmUpBridge;
import com.example.nawigacja.Rozgrzewka.WarmUpMain;
import com.example.nawigacja.TestGlowny.TestFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Umozliwia otwarcie paska narzedzi.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //tworzenie przycisku w rogu ekranu, ktory odwraca sie po kliknieciu menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    //Pozwala nam od razu otworzyc okno glowne na fragmencie nav_glowna
       if (savedInstanceState == null) { //pozwala odwrocic urzadzenie bez uzycia ondestroy przez oncreate + otwiera ja w tym samym miejscu po zamknieciu
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new GlownaFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_glowna);}
    }
//Wywolanie fragmentow i otworzenie ich w ui
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_glowna:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GlownaFragment()).commit();
                break;
            case R.id.nav_cwiczenia:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CwiczeniaFragment()).commit();
                break;
            case R.id.nav_trachtenberg:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TrachtenbergFragment()).commit();
                break;
            case R.id.nav_wedyjska:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WedyjskaFragment()).commit();
                break;
            case R.id.nav_test:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TestFragment()).commit();
                break;
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WarmUpBridge()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }




//powrot do drawera
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
