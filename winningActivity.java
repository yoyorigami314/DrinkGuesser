package com.example.drinkguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class winningActivity extends AppCompatActivity {

    private Button mPlayAgainButtton;
    private ImageView mWater;
    private ImageView mSoda;
    private ImageView mMilk;
    private ImageView mJuice;
    private ImageView mTea;
    private ImageView mBeer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        Intent i = getIntent();
        int secret = i.getIntExtra("drink",-999);

        mWater = findViewById(R.id.water_imageview);
        mSoda = findViewById(R.id.soda_imageview);
        mMilk = findViewById(R.id.milk_imageview);
        mJuice = findViewById(R.id.juice_imageview);
        mTea = findViewById(R.id.tea_imageview);
        mBeer = findViewById(R.id.beer_imageview);

        if(secret ==1){
            mWater.setVisibility(View.VISIBLE);
        } else if (secret ==2){
            mSoda.setVisibility(View.VISIBLE);
        } else if (secret == 3){
            mMilk.setVisibility(View.VISIBLE);
        } else if (secret == 4){
            mJuice.setVisibility(View.VISIBLE);
        } else if (secret == 5){
            mTea.setVisibility(View.VISIBLE);
        } else if (secret == 6){
            mBeer.setVisibility(View.VISIBLE);
        }

        mPlayAgainButtton = findViewById(R.id.play_again_button);
        mPlayAgainButtton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(winningActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
