package com.mastercoding.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView textView2, textView3;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        btn2 = findViewById(R.id.btn2);

        //Getting full name from the first activity
        Intent i = getIntent();
        String full_name = i.getStringExtra("name");

        //Random Number Generating
        int random_Numb = generateRandNumb();
        textView3.setText(""+random_Numb);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Call the method
                shareData(full_name,random_Numb);
            }
        });
    }

    //Generating Random Number
    public int generateRandNumb(){

        //Create an object of Random class
        Random random = new Random();

        //Define the highest limit
        int upperLimit = 1000;

        int rndmNumbGenerated = random.nextInt(upperLimit);
        return rndmNumbGenerated;
    }

    public void shareData(String fullName,int rndmNum){

        //Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Converting int to String
        String num = String.valueOf(rndmNum);

        i.putExtra(Intent.EXTRA_SUBJECT,fullName);
        i.putExtra(Intent.EXTRA_TEXT, rndmNum);

        startActivity(Intent.createChooser(i,"Select a platform"));
    }
