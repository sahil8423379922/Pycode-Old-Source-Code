package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
//import android.priyanka.pycode.R;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Progress_report extends AppCompatActivity {
    private TextView correctquestion;
    private TextView wrongquestion;
    private TextView performance;
    private TextView prcentage_value;
    private TextView score_value;
    private TextView highscore;
    private Button home;
    private int hs = 0;
    int score;
    private InterstitialAd mInterstitialAd;
    Highscore mydb;
    String value;
    Integer value1 = 0;
    Integer number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_report);
        mydb = new Highscore(this);
        setupUI();
        fetchValue();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }


    private void fetchValue() {

        Intent intent = getIntent();

        score =intent.getIntExtra("UserScore1", 0);
        int correctQues = intent.getIntExtra("CorrectQues1", 0);
        int wrongQues = intent.getIntExtra("WrongQues1", 0);
        int percentage = 0;
        percentage = score / 5;





        Cursor cursor = mydb.getAlldata();
        if (cursor.getCount() == 0) {


            mydb.insertdata(value1);


        } else {

            StringBuffer buffer = new StringBuffer();
            cursor.moveToLast();
            buffer.append(cursor.getInt(1));
            //value1 = Integer.parseInt(value);
            value = buffer.toString();
            number = Integer.parseInt(value);


            if (number < score) {

                hs = score;
                mydb.updataData("1",hs);
                highscore.setText(String.valueOf(hs));

            } else {
                highscore.setText(String.valueOf(number));
            }
        }

        prcentage_value.setText(String.valueOf(percentage));
        score_value.setText(String.valueOf(score) + "/250");
        wrongquestion.setText(String.valueOf(wrongQues) + "/25");
        correctquestion.setText(String.valueOf(correctQues) + "/25");


        if (percentage < 33) {
            performance.setText("Poor");
        } else if (percentage <= 45) {
            performance.setText("Good");
        } else if (percentage <= 65) {
            performance.setText("Better");
        } else if (percentage <= 75) {
            performance.setText("Very Good");
        } else {
            performance.setText("Excellent");
        }




    }

    private void setupUI() {
        correctquestion = findViewById(R.id.correct);
        wrongquestion = findViewById(R.id.wrong);
        performance = findViewById(R.id.show_performance);
        prcentage_value = findViewById(R.id.percentege);
        score_value = findViewById(R.id.score);
        highscore = findViewById(R.id.high_score);
        home = findViewById(R.id.homebutton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();

                    mInterstitialAd.setAdListener(new AdListener() {

                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            startActivity(new Intent(Progress_report.this, startcourse.class));
                        }
                    });

                } else {
                    startActivity(new Intent(Progress_report.this, startcourse.class));
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            mInterstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    startActivity(new Intent(Progress_report.this, startcourse.class));
                }
            });

        } else {
            startActivity(new Intent(Progress_report.this, startcourse.class));
        }

    }
}
