package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Favourites extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String[] names = MyApplication.getFavourites().toArray(new String[0]);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(this,names,MyApplication.getPrices());
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.favourite:
                startActivity(new Intent(Favourites.this,Favourites.class));
                return true;
            case R.id.cart:
                startActivity(new Intent(Favourites.this,Cart.class));
                return true;
        }

        return true;
    }

}