package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.priyanka.pycode.R;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class patern_programs extends AppCompatActivity {
    Bundle b;
    Intent i;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patern_programs);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        i = new Intent(patern_programs.this, loadprogram.class);
        b = new Bundle();



        findViewById(R.id.p1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "61";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "62";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "63";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "64";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });


        findViewById(R.id.p5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "65";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "66";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "67";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(patern_programs.this, loadprogram.class));
                String p1 = "68";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(patern_programs.this,moreprograms.class));
        super.onBackPressed();
    }
}
