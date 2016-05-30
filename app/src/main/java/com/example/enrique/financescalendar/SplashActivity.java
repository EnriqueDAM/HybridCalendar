package com.example.enrique.financescalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    public static final int LOADING_COMPLETED = 100;
    protected ProgressBar progressBar = null;
    protected TextView textViewProgress = null;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        startProgress();
    }

    protected void startProgress() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textViewProgress = (TextView) findViewById(R.id.textLoading);
        final int[] progressStatus = {0};

        progressBar.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus[0] <= LOADING_COMPLETED) {
                    progressStatus[0] += 10;
                    if(progressStatus[0] == LOADING_COMPLETED)
                        checkUser();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    protected void checkUser() {
        Intent intent = new Intent(SplashActivity.this, CalendarActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
