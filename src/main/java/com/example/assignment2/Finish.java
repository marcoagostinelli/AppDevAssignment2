package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Finish extends AppCompatActivity {

    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 60000;
    TextView countdownText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Button openLink = findViewById(R.id.openLink);
        Button returnBtn = findViewById(R.id.returnBtn);
        countdownText = findViewById(R.id.countdon_text);



        startTimer();

        openLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset the cart
                MyApplication.setCart(new ArrayList<>());
                startActivity(new Intent(Finish.this,MainActivity.class));
            }
        });

    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void updateTimer(){
        int minute = (int) timeLeftInMilliseconds / 600000;
        int seconds = (int) timeLeftInMilliseconds % 600000 / 1000;

        String timeLeft;
        timeLeft = "" + minute;
        timeLeft += ":";
        if (seconds < 10) timeLeft += "0";
        timeLeft += seconds;

        countdownText.setText(timeLeft);
    }
}