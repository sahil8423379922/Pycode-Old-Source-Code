package com.priyanka.pycode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//import android.priyanka.pycode.R;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Result extends AppCompatActivity {

    private TextView txtProgress;
    private ProgressBar progressBar;
    private int pStatus = 0;
    private Handler handler = new Handler();
    private int correctQues1;
    private int setprogress = 100;
    private int wrongQues1;
    private int score1;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.priyanka.pycode.R.layout.activity_result);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest1);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        Intent intent = getIntent();
        correctQues1 = intent.getIntExtra("CorrectQues", 0);
        wrongQues1 = intent.getIntExtra("WrongQues", 0);
        score1 = intent.getIntExtra("UserScore", 0);
        //totalQuestion1 = intent.getIntExtra("TotalQuestion", 0);
        txtProgress = (TextView) findViewById(R.id.txtProgress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pStatus <= ((correctQues1*10))/2.5) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(pStatus);
                            txtProgress.setText(pStatus + " %");
                        }
                    });
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();

        findViewById(R.id.student_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result.this, Progress_report.class));
                Intent progress_data = new Intent(Result.this, Progress_report.class);
                progress_data.putExtra("UserScore1", score1);
                progress_data.putExtra("CorrectQues1", correctQues1);
                progress_data.putExtra("WrongQues1", wrongQues1);
                startActivity(progress_data);

            }
        });

        findViewById(R.id.playagain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();

                    mInterstitialAd.setAdListener(new AdListener() {

                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            startActivity(new Intent(Result.this, Fundamental_play_quiz.class));
                        }
                    });

                } else {
                    startActivity(new Intent(Result.this, Fundamental_play_quiz.class));
                }
            }
        });
    }





}
