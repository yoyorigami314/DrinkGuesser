package com.example.drinkguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LosingActivity extends AppCompatActivity {

    private Button mPlayAgainButtton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);

        mPlayAgainButtton = findViewById(R.id.play_again_button);
        mPlayAgainButtton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(LosingActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
