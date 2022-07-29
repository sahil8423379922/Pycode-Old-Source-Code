package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.priyanka.pycode.R;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class module_middle extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_middle);
        findViewById(R.id.module_course).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(module_middle.this,Modules.class));
            }
        });


        findViewById(R.id.modules_quiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(module_middle.this,Fundamental_play_quiz.class));
            }
        });

        findViewById(R.id.module_program).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(module_middle.this,moreprograms.class));
            }
        });

        findViewById(R.id.module_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(module_middle.this,Video.class));
            }
        });

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest1);



    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(module_middle.this,startcourse.class));
        super.onBackPressed();
    }
}
