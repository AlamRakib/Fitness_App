package com.example.piqofitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Locale;

public class BeginnersWorkout4Activity extends AppCompatActivity {

    private TextView timerTextView;
    private Button startButton;
    private Button pauseButton;
    private Button stopButton;

    private Button resetButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private boolean timerRunning;

    int counter;


    TextToSpeech textToSpeech;

    LottieAnimationView lottieAnimationView;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginners_workout4);


        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);
        lottieAnimationView = findViewById(R.id.animationView);



        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lottieAnimationView.getTag()!=null && lottieAnimationView.getTag().toString().contains("NOT_PLAYING")) {
                    if (mediaPlayer != null) mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.exercise4);
                    mediaPlayer.start();
                    lottieAnimationView.setImageResource(R.drawable.baseline_stop_circle_24);
                    lottieAnimationView.setTag("PLAYING_NOW");

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            lottieAnimationView.setImageResource(R.drawable.play);
                            lottieAnimationView.setTag("NOT_PLAYING");
                        }
                    });

                }else{

                    if(mediaPlayer!=null) mediaPlayer.release();
                    lottieAnimationView.setImageResource(R.drawable.play);
                    lottieAnimationView.setTag("NOT_PLAYING");

                }

            }
        });



        textToSpeech = new TextToSpeech(BeginnersWorkout4Activity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        timeLeftInMillis = 60000;  // 1 minute (adjust as per your requirement)
        updateTimer();


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak("Time Start ",TextToSpeech.QUEUE_FLUSH,null,null);
                startTimer();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void
            onClick(View view) {

                textToSpeech.speak("Times Restart",TextToSpeech.QUEUE_FLUSH,null,null);
                resetTimer();
            }
        });



    }






    private void startTimer() {
        if (!timerRunning) {
            countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    timerRunning = false;
                    // Perform any actions when the timer finishes.
                    timerTextView.setText("Finish!!");
                    textToSpeech.speak("Time stop",TextToSpeech.QUEUE_FLUSH,null,null);
                    startActivity(new Intent(getApplicationContext(), BeginnersActivity.class));

                }
            }.start();

            timerRunning = true;
            startButton.setEnabled(false);
            pauseButton.setEnabled(true);
            stopButton.setEnabled(true);
            resetButton.setEnabled(true);

        }
    }

    private void pauseTimer() {
        if (timerRunning) {
            countDownTimer.cancel();
            timerRunning = false;
            pauseButton.setEnabled(false);
            startButton.setEnabled(true);
            stopButton.setEnabled(true);
            resetButton.setEnabled(true);
            textToSpeech.speak("Take rest",TextToSpeech.QUEUE_FLUSH,null,null);
        }
    }

    private void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        timeLeftInMillis = 0;
        updateTimer();
        startButton.setEnabled(false);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        resetButton.setEnabled(true);
        textToSpeech.speak("Times Up",TextToSpeech.QUEUE_FLUSH,null,null);

    }

    private void updateTimer() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerTextView.setText(timeLeftFormatted);
    }

    private void resetTimer() {

        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(counter));
                counter = counter + 1;
            }

            public void onFinish() {

                timerTextView.setText("FINISH!!");
                textToSpeech.speak("Finish Time", TextToSpeech.QUEUE_FLUSH, null, null);
                startActivity(new Intent(getApplicationContext(), BeginnersActivity.class));


            }
        }.start();

        resetButton.setEnabled(false);

    }






    public void onBackPressed(){

        if(mediaPlayer!=null) mediaPlayer.release();
        lottieAnimationView.setImageResource(R.drawable.play);
        lottieAnimationView.setTag("NOT_PLAYING");
        startActivity(new Intent(getApplicationContext(), BeginnersActivity.class));

    }
}