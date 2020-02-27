package com.example.drinkguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button mWaterButton;
    private Button mSodaButton;
    private Button mMilkButton;
    private Button mJuiceButton;
    private Button mTeaButton;
    private Button mBeerButton;
    private Button mCheatButton;

    private static final String KEY_INDEX = "index";

    private int secret = new Random().nextInt(6)+1;
    private int guesses = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState !=null){
            secret = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        setContentView(R.layout.activity_main);

        //Set buttons as variables
        mWaterButton = findViewById(R.id.water_button);
        mSodaButton = findViewById(R.id.soda_button);
        mMilkButton=findViewById(R.id.milk_button);
        mJuiceButton=findViewById(R.id.juice_button);
        mTeaButton=findViewById(R.id.tea_button);
        mBeerButton=findViewById(R.id.beer_button);

        mCheatButton = findViewById(R.id.cheat_button);


        mWaterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(1);
            }
        });
        mSodaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(2);
            }
        });
        mMilkButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(3);
            }
        });
        mJuiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(4);
            }
        });
        mTeaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(5);
            }
        });
        mBeerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(6);
            }
        });

        mCheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              String answer;
              if (secret == 1){
                  answer = "Water";
              } else if (secret == 2){
                  answer = "Soda";
              } else if (secret == 3){
                  answer = "Milk";
              } else if (secret == 4){
                  answer = "Juice";
              } else if (secret == 5) {
                  answer = "Tea";
              } else if (secret == 6) {
                  answer = "Beer";
              } else {
                  answer = "ERROR";
              }
              Toast.makeText(MainActivity.this,answer,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void checkAnswer(int selection){
        if(selection == secret){
            //if correct then go to the winning screen
            Intent i = new Intent(MainActivity.this, winningActivity.class);
            i.putExtra("drink", secret);
            startActivity(i);
        } else{
            //else decrease guesses and go to losing screen if out of guesses
            //display number of guesses left
            guesses --;
            if (guesses <= 0){
                Intent i = new Intent(MainActivity.this, LosingActivity.class);
                startActivity(i);
            }else {
                String message = "Incorrect, try " + guesses + " more time(s).";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, secret);
    }

}
