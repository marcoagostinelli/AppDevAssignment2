package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String[] names = MyApplication.getCart().toArray(new String[0]);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(this,names,MyApplication.getPrices());
        recyclerView.setAdapter(adapter);

        Button checkout = findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart.this,Checkout.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.favourite:
                startActivity(new Intent(Cart.this,Favourites.class));
                return true;
            case R.id.cart:
                startActivity(new Intent(Cart.this,Cart.class));
                return true;
        }

        return true;
    }
}