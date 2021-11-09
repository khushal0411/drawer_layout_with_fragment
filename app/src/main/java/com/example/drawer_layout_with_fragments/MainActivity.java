package com.example.drawer_layout_with_fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView Nav_view= findViewById(R.id.navigation);
        Nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
                int itemId = item.getItemId();
                Fragment frag = null;
                if(itemId==R.id.Calculator)
                {
                    frag =new Calculator();

                }
                else if(itemId==R.id.Currency_converter)
                {
                  frag =new Currency_Converter();


                }
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag);
                    transaction.commit();
                    drawer_layout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }
}