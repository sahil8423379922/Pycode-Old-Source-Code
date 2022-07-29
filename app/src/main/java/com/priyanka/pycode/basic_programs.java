package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
// android.priyanka.pycode.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class basic_programs extends AppCompatActivity {
    private UnifiedNativeAd nativeAd;

    Bundle b;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_programs);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        refreshAd();

        i = new Intent(basic_programs.this, loadprogram.class);
        b = new Bundle();
        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(basic_programs.this, loadprogram.class));
                String p1 = "91";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(basic_programs.this, loadprogram.class));
                String p1 = "92";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });

        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(basic_programs.this, loadprogram.class));
                String p1 = "93";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });


        findViewById(R.id.b4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(basic_programs.this, loadprogram.class));
                String p1 = "94";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });


        findViewById(R.id.b5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(basic_programs.this, loadprogram.class));
                String p1 = "95";
                b.putString("program1", p1);
                i.putExtras(b);
                startActivity(i);

            }
        });


    }

    private void refreshAd() {


        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.native_advanced_app_unit_id));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                if (nativeAd != null) {
                    nativeAd = unifiedNativeAd;
                }
                CardView cardView = findViewById(R.id.ad_container);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater().inflate(R.layout.native_ad_layout1, null);
                prepareNativeAd(unifiedNativeAd, adView);
                cardView.removeAllViews();
                cardView.addView(adView);


            }
        });

        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {

                //Toast.makeText(basic_programs.this, "Eror in Loading Ad", Toast.LENGTH_SHORT).show();
                super.onAdFailedToLoad(i);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

    private void prepareNativeAd(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        adView.setBodyView(adView.findViewById(R.id.ad_body_text));
        adView.setMediaView((MediaView) adView.findViewById(R.id.media_view));
        adView.setIconView(adView.findViewById(R.id.adv_icon));
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
            adView.getBodyView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }


        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }


        adView.setNativeAd(nativeAd);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(basic_programs.this,moreprograms.class));
        super.onBackPressed();
    }
}
