package com.example.piqofitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3;
    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1 = findViewById(R.id.cardView1Id);
        cardView2 = findViewById(R.id.cardView2Id);
        cardView3 = findViewById(R.id.cardView3Id);

        button1 = findViewById(R.id.button1Id);
        button2 = findViewById(R.id.button2Id);
        button3 = findViewById(R.id.buttonn3Id);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInternet()) {

                    Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                            "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();

                    Intent myintent = new Intent(MainActivity.this, VideoplayerActivity.class);
                    myintent.putExtra("videoid", "mNAZ7U6sHlc");
                    startActivity(myintent);
                    Toast.makeText(MainActivity.this, "Wait a few second! Video is loading...", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                            "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();
                }


            }
        });


        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInternet()) {

                    Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                            "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();

                    Intent myintent = new Intent(MainActivity.this, VideoplayerActivity.class);
                    myintent.putExtra("videoid", "a3exjmIV4Qo");
                    startActivity(myintent);
                    Toast.makeText(MainActivity.this, "Wait a few second! Video is loading...", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                            "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();
                }


            }
        });


        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInternet()) {

                    Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                            "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();

                    Intent myintent = new Intent(MainActivity.this, VideoplayerActivity.class);
                    myintent.putExtra("videoid", "OC7xQbSA4Vs");
                    startActivity(myintent);
                    Toast.makeText(MainActivity.this, "Wait a few second! Video is loading...", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                            "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();
                }


            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), BeginnersActivity.class));


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), IntermediateActivity.class));


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), AdvancedActivity.class));


            }
        });





    }



    private boolean checkInternet() {

        //===============================
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && networkInfo != null && networkInfo.isConnected()) {
            Network nw = connectivityManager.getActiveNetwork();
            if (nw == null) return false;
            NetworkCapabilities actNw = connectivityManager.getNetworkCapabilities(nw);
            return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH));
        }
        NetworkInfo nwInfo = connectivityManager.getActiveNetworkInfo();
        return nwInfo != null && nwInfo.isConnected();


    }





}