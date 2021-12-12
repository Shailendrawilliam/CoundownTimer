package com.shailendrawilliam.coundowntimer;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startCounting("2021-12-12 20:03:50");
    }
    private void startCounting(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        Date date = null;
        Date now = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        new CountDownTimer(date.getTime() - now.getTime(), 1000) {
            public void onTick(long millisUntilFinished) {
                long mMinutes = MILLISECONDS.toMinutes(millisUntilFinished);
                long mHours = MILLISECONDS.toHours(millisUntilFinished);

                long days = MILLISECONDS.toDays(millisUntilFinished);
                long hours = MILLISECONDS.toHours(millisUntilFinished);
                long minutes =  MILLISECONDS.toMinutes(millisUntilFinished);
                long seconds =    MILLISECONDS.toSeconds(millisUntilFinished);
                Log.v("MILLISECONDS"," days "+days+"   hours   "+ hours+"   mins  "+ minutes+"   secs "+ seconds);

            }

            public void onFinish() {

            }
        }.start();
    }
}