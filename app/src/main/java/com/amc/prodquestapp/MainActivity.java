package com.amc.prodquestapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    ArrayList<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.top_bar);*/


        recyclerView = findViewById(R.id.recycler_view);

        final Integer[] langLogo = {R.drawable.logo_prune, R.drawable.logo_rapsodia, R.drawable.logo_paula, R.drawable.logo_sarkany,R.drawable.logo_jazmin_chebar, R.drawable.logo_wanama};

        final String[] langName = {"Prune", "Rapsodia", "Paula", "Sarkany", "Jazmín", "Wanama"};

        mainModels = new ArrayList<>();
        for (int i=0; i<langLogo.length; i++){
            MainModel model = new MainModel(langLogo[i]);
            mainModels.add(model);
        }

        nombres = new ArrayList<>();
        for (int i=0; i<langName.length; i++){
            String names = new String(langName[i]);
            nombres.add(names);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
        MainActivity.this, LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //initialize MainAdapter

        mainAdapter = new MainAdapter(MainActivity.this, mainModels);

        //para onclick
        mainAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Selección: " + nombres.get(recyclerView.getChildAdapterPosition(view)), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(mainAdapter);



    }


    //METODO BTN
    public void Sarkany(View view){
        Intent sarkany = new Intent(this, MarcaActivity.class);
        startActivity(sarkany);


    }
}
