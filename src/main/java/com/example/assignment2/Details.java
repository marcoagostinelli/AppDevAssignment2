package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle intent = getIntent().getExtras();
        TextView textName = findViewById(R.id.textName);
        TextView textPrice = findViewById(R.id.textPrice);
        Button addToCart = findViewById(R.id.addToCart);
        Button addToFavourites = findViewById(R.id.addToFavourites);

        textName.setText(intent.getString("name"));
        textPrice.setText("$"+intent.getString("price"));

        //if item is already in favourites, display remove from favourites
        if (MyApplication.getFavourites().contains(textName.getText())){
            addToFavourites.setText("Remove From Favourites");

            addToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList fav = MyApplication.getFavourites();
                    fav.remove(textName.getText());
                    MyApplication.setFavourites(fav);
                    //reload the activity
                    finish();
                    startActivity(getIntent());
                }
            });
        }else{
            //if item is not in favourites...
            addToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList fav = MyApplication.getFavourites();
                    fav.add(textName.getText());
                    MyApplication.setFavourites(fav);
                    //reload the activity
                    finish();
                    startActivity(getIntent());
                }
            });
        }

        //options for cart:
        if (MyApplication.getCart().contains(textName.getText())){
            addToCart.setText("Remove From Cart");

            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList cart = MyApplication.getCart();
                    cart.remove(textName.getText());
                    MyApplication.setCart(cart);
                    finish();
                    startActivity(getIntent());
                }
            });
        }else{
            //if item is not in cart...
            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList cart = MyApplication.getCart();
                    cart.add(textName.getText());
                    MyApplication.setCart(cart);
                    finish();
                    startActivity(getIntent());
                }
            });
        }



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
                startActivity(new Intent(Details.this,Favourites.class));
                return true;
            case R.id.cart:
                startActivity(new Intent(Details.this,Cart.class));
                return true;
        }

        return true;
    }
}