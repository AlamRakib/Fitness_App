package com.example.piqofitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BeginnersActivity extends AppCompatActivity {



    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginners);

        cardView1 = findViewById(R.id.carView1Id);
        cardView2 = findViewById(R.id.carView2Id);
        cardView3 = findViewById(R.id.carView3Id);
        cardView4 = findViewById(R.id.carView4Id);
        cardView5 = findViewById(R.id.carView5Id);
        cardView6 = findViewById(R.id.carView6Id);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), WorkoutTimerActivity.class));

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), BeginnerWorkout2Activity.class));

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), BeginnersWorkout3Activity.class));

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), BeginnersWorkout4Activity.class));

            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), BeginnersWorkout5Activity.class));

            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), BeginnersWorkout6Activity.class));

            }
        });




    }


    public void onBackPressed(){


        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }





}