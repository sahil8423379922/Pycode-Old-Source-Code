package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
//import android.priyanka.pycode.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class moreprograms extends AppCompatActivity {
    Bundle b;
    Intent i;
    private UnifiedNativeAd nativeAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreprograms);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest1);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        refreshAd();

        i = new Intent(moreprograms.this, loadprogram.class);
        b = new Bundle();

        findViewById(R.id.p1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));
                String p1 = "1";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

        findViewById(R.id.p2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));
                String p1 = "2";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));
                String p1 = "3";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "4";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

        findViewById(R.id.p5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));
                String p1 = "5";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });


        findViewById(R.id.p6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));
                String p1 = "6";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "7";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

        findViewById(R.id.p8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "8";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

        findViewById(R.id.p9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "9";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

        findViewById(R.id.p10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "10";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "11";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "12";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "13";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));


                String p1 = "14";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

        findViewById(R.id.p15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));


                String p1 = "15";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });


        findViewById(R.id.p16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "16";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "17";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "18";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));
                String p1 = "19";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });


        findViewById(R.id.p20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "20";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.p21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this, loadprogram.class));

                String p1 = "21";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);
            }
        });

       findViewById(R.id.basic_programs).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(moreprograms.this,basic_programs.class));
           }
       });

        findViewById(R.id.conditional_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,condition_programs.class));
            }
        });

        findViewById(R.id.looping_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,looping_programs.class));
            }
        });
        findViewById(R.id.list_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,list_programs.class));
            }
        });

        findViewById(R.id.string_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,string_programs.class));
            }
        });

        findViewById(R.id.dictionary_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,dictionary_programs.class));
            }
        });

        findViewById(R.id.sorting_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,sorting_programs.class));
            }
        });

        findViewById(R.id.pattern_programs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(moreprograms.this,patern_programs.class));
            }
        });


    }

    private void refreshAd()
    {


        AdLoader.Builder builder = new AdLoader.Builder(this,getString(R.string.native_advanced_app_unit_id));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if(nativeAd != null)
                {
                    nativeAd = unifiedNativeAd;
                }
                CardView cardView = findViewById(R.id.ad_container);
                UnifiedNativeAdView adView =(UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.native_ad_layout1,null);
                prepareNativeAd(unifiedNativeAd,adView);
                cardView.removeAllViews();
                cardView.addView(adView);


            }
        });

        AdLoader adLoader = builder.withAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(int i) {

               // Toast.makeText(moreprograms.this, "Eror in Loading Ad", Toast.LENGTH_SHORT).show();
                super.onAdFailedToLoad(i);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

    private void prepareNativeAd(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView){
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        adView.setBodyView(adView.findViewById(R.id.ad_body_text));
        adView.setMediaView((MediaView) adView.findViewById(R.id.media_view));
        adView.setIconView(adView.findViewById(R.id.adv_icon));
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        ((TextView)adView.getHeadlineView()).setText(nativeAd.getHeadline());

        if(nativeAd.getBody() == null)
        {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        }
        else
        {
            ((TextView)adView.getBodyView()).setText(nativeAd.getBody());
            adView.getBodyView().setVisibility(View.VISIBLE);
        }

        if(nativeAd.getAdvertiser() == null)
        {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        }
        else
        {
            ((TextView)adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }



        if(nativeAd.getIcon() == null)
        {
            adView.getIconView().setVisibility(View.INVISIBLE);
        }
        else
        {
            ((ImageView)adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }


        adView.setNativeAd(nativeAd);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(moreprograms.this,startcourse.class));
        super.onBackPressed();
    }
}
