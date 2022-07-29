package com.priyanka.pycode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
//import android.priyanka.pycode.R;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class loadprogram extends AppCompatActivity {
    private WebView load;
    private TextView textView;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadprogram);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        Toolbar toolbar = findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();

                    mInterstitialAd.setAdListener(new AdListener() {

                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            startActivity(new Intent(loadprogram.this, moreprograms.class));
                        }
                    });

                } else {
                    startActivity(new Intent(loadprogram.this, moreprograms.class));
                }
            }
        });


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        load = findViewById(R.id.loadprogram);
        load.getSettings().setJavaScriptEnabled(true);
        Bundle b = getIntent().getExtras();
        String code = b.getString("program1");
        if (code.equals("1")) {
         load.loadUrl("file:///android_asset/p1.html");
        }
        if (code.equals("2")) {
            load.loadUrl("file:///android_asset/p2.html");

        }
        if (code.equals("3")) {
            load.loadUrl("file:///android_asset/p3.html");

        }
        if (code.equals("4")) {
            load.loadUrl("file:///android_asset/p4.html");

        }
        if (code.equals("5")) {
            load.loadUrl("file:///android_asset/p5.html");

        }
        if (code.equals("6")) {
            load.loadUrl("file:///android_asset/p6.html");

        }
        if (code.equals("7")) {
            load.loadUrl("file:///android_asset/p7.html");

        }
        if (code.equals("8")) {
            load.loadUrl("file:///android_asset/p8.html");

        }
        if (code.equals("9")) {
            load.loadUrl("file:///android_asset/p1.html");

        }
        if (code.equals("10")) {
            load.loadUrl("file:///android_asset/p10.html");

        }
        if (code.equals("11")) {
            load.loadUrl("file:///android_asset/p11.html");

        }
        if (code.equals("12")) {
            load.loadUrl("file:///android_asset/p12.html");

        }
        if (code.equals("13")) {
            load.loadUrl("file:///android_asset/p13.html");

        }
        if (code.equals("14")) {
            load.loadUrl("file:///android_asset/p14.html");


        }
        if (code.equals("15")) {
            load.loadUrl("file:///android_asset/p15.html");

        }
        if (code.equals("16")) {
            load.loadUrl("file:///android_asset/p16.html");

        }
        if (code.equals("17")) {
            load.loadUrl("file:///android_asset/p17.html");

        }
        if (code.equals("18")) {
            load.loadUrl("file:///android_asset/p18.html");

        }
        if (code.equals("19")) {
            load.loadUrl("file:///android_asset/p19.html");

        }
        if (code.equals("20")) {
            load.loadUrl("file:///android_asset/p20.html");

        }
        if (code.equals("21")) {
            load.loadUrl("file:///android_asset/p21.html");

        }
        if (code.equals("91")) {
            load.loadUrl("file:///android_asset/basic/b1.html");

        }
        if (code.equals("92")) {
            load.loadUrl("file:///android_asset/basic/b2.htm");

        }
        if (code.equals("93")) {
            load.loadUrl("file:///android_asset/basic/b3.htm");

        }
        if (code.equals("94")) {
            load.loadUrl("file:///android_asset/basic/b4.htm");

        }
        if (code.equals("95")) {
            load.loadUrl("file:///android_asset/basic/b5.htm");

        }
        if (code.equals("96")) {
            load.loadUrl("file:///android_asset/condirtion/c1.htm");

        }
        if (code.equals("97")) {
            load.loadUrl("file:///android_asset/condirtion/c2.htm");

        }
        if (code.equals("98")) {
            load.loadUrl("file:///android_asset/condirtion/c3.htm");

        }
        if (code.equals("99")) {
            load.loadUrl("file:///android_asset/condirtion/c4.htm");

        }
        if (code.equals("100")) {
            load.loadUrl("file:///android_asset/condirtion/c5.htm");

        }
        if (code.equals("81")) {
            load.loadUrl("file:///android_asset/dictionary/d1.htm");

        }
        if (code.equals("82")) {
            load.loadUrl("file:///android_asset/dictionary/d2.htm");

        }

        if (code.equals("83")) {
            load.loadUrl("file:///android_asset/dictionary/d3.htm");

        }

        if (code.equals("84")) {
            load.loadUrl("file:///android_asset/dictionary/d4.htm");

        }

        if (code.equals("85")) {
            load.loadUrl("file:///android_asset/dictionary/d5.htm");

        }

        if (code.equals("86")) {
            load.loadUrl("file:///android_asset/list/li1.htm");

        }

        if (code.equals("87")) {
            load.loadUrl("file:///android_asset/list/li2.htm");

        }

        if (code.equals("88")) {
            load.loadUrl("file:///android_asset/list/li3.htm");

        }

        if (code.equals("89")) {
            load.loadUrl("file:///android_asset/list/li4.htm");

        }

        if (code.equals("90")) {
            load.loadUrl("file:///android_asset/list/li5.htm");

        }
        if (code.equals("71")) {
            load.loadUrl("file:///android_asset/looping/l1.htm");

        }

        if (code.equals("72")) {
            load.loadUrl("file:///android_asset/looping/l2.htm");

        }

        if (code.equals("73")) {
            load.loadUrl("file:///android_asset/looping/l3.htm");

        }

        if (code.equals("74")) {
            load.loadUrl("file:///android_asset/looping/l4.htm");

        }

        if (code.equals("75")) {
            load.loadUrl("file:///android_asset/looping/l5.htm");

        }

        if (code.equals("61")) {
            load.loadUrl("file:///android_asset/pattern/p1.htm");

        }

        if (code.equals("62")) {
            load.loadUrl("file:///android_asset/pattern/p2.htm");

        }
        if (code.equals("63")) {
            load.loadUrl("file:///android_asset/pattern/p3.htm");

        }
        if (code.equals("64")) {
            load.loadUrl("file:///android_asset/pattern/p4.htm");

        }
        if (code.equals("65")) {
            load.loadUrl("file:///android_asset/pattern/p5.htm");

        }
        if (code.equals("66")) {
            load.loadUrl("file:///android_asset/pattern/p6.htm");

        }
        if (code.equals("67")) {
            load.loadUrl("file:///android_asset/pattern/p7.htm");

        }
        if (code.equals("68")) {
            load.loadUrl("file:///android_asset/pattern/p8.htm");

        }

        if (code.equals("56")) {
            load.loadUrl("file:///android_asset/sorting/s1.htm");

        }
        if (code.equals("57")) {
            load.loadUrl("file:///android_asset/sorting/s2.htm");

        }
        if (code.equals("58")) {
            load.loadUrl("file:///android_asset/sorting/s3.htm");

        }
        if (code.equals("59")) {
            load.loadUrl("file:///android_asset/sorting/s4.htm");

        }

        if (code.equals("41")) {
            load.loadUrl("file:///android_asset/string/s1.htm");

        }

        if (code.equals("42")) {
            load.loadUrl("file:///android_asset/string/s2.htm");

        }

        if (code.equals("43")) {
            load.loadUrl("file:///android_asset/string/s3.htm");

        }
        if (code.equals("44")) {
            load.loadUrl("file:///android_asset/string/s4.htm");

        }

        if (code.equals("45")) {
            load.loadUrl("file:///android_asset/string/s5.htm");

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.code_interpreter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.rateus) {
            startActivity(new Intent(loadprogram.this,CodeTerminal.class));

        }





        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            mInterstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    startActivity(new Intent(loadprogram.this, moreprograms.class));
                }
            });

        } else {
            super.onBackPressed();
        }

    }

}
