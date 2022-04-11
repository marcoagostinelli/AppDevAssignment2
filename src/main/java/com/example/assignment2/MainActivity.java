package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//-------------------------------------
// Assignment 2
// Written by: Marco Agostinelli 2034731
// For Application Development 2 (Mobile) - Winter 2022
//-------------------------------------

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gifts = findViewById(R.id.viewGifts);
        Button flowers = findViewById(R.id.viewFlowers);

        gifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Gifts.class);
                startActivity(intent);
            }
        });
        flowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Flowers.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favourite_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.favourite:
                startActivity(new Intent(MainActivity.this,Favourites.class));
                return true;
            case R.id.cart:
                startActivity(new Intent(MainActivity.this,Cart.class));
                return true;
        }

        return true;
    }
}