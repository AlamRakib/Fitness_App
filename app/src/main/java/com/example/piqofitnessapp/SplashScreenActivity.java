package com.example.piqofitnessapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    Animation up,down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);


        //for full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.apppname);
        up = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.up_from_bottom_slow);
        textView.startAnimation(up);

        imageView = findViewById(R.id.logo);
        down = AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.down);
        imageView.startAnimation(down);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        },3500);
    }
}