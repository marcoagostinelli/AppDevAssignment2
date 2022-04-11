package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checkout extends AppCompatActivity {

    double sum =0;//the sum of the total cost
    ArrayList<String> items = MyApplication.getCart();//the items in the cart
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button confirm = findViewById(R.id.confirm);
        TextView totalCost = findViewById(R.id.totalCost);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this,Finish.class));
            }
        });
        List allPrices = Arrays.asList(MyApplication.getPrices());
        for (int i=0;i<items.size();i++){ //add every item to the total cost
            if (Arrays.asList(MyApplication.getGiftNames()).contains(items.get(i))){//if the current item is a gift
                List<String> gifts = Arrays.asList(MyApplication.getGiftNames());
                // get the index of the current item (in gifts) and add 10 so its correct price can be taken from all prices
                sum+= Double.valueOf(allPrices.get(gifts.indexOf(items.get(i))+10).toString());
            }else{
                List<String> flowers = Arrays.asList(MyApplication.getFlowerNames());
                sum+= Double.valueOf(allPrices.get(flowers.indexOf(items.get(i))).toString());
            }
        }
        totalCost.setText("$"+String.format("%.2f",sum));
    }
}