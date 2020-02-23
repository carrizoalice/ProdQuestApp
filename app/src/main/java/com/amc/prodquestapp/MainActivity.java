package com.amc.prodquestapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.top_bar);*/


        recyclerView = findViewById(R.id.recycler_view);

        Integer[] langLogo = {R.drawable.logo_prune, R.drawable.logo_rapsodia, R.drawable.logo_paula, R.drawable.logo_sarkany,R.drawable.logo_jazmin_chebar, R.drawable.logo_wanama};

        String[] langName = {"Prune", "Rapsodia", "Paula", "Sarkany", "Jazmín", "Wanama"};

        mainModels = new ArrayList<>();
        for (int i=0; i<langLogo.length; i++){
            MainModel model = new MainModel(langLogo[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
        MainActivity.this, LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //initialize MainAdapter

        mainAdapter = new MainAdapter(MainActivity.this, mainModels);
        recyclerView.setAdapter(mainAdapter);

    }
}
