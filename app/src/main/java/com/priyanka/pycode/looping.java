package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
//import android.priyanka.pycode.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class looping extends AppCompatActivity {
    private UnifiedNativeAd nativeAd;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looping);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        refreshAd();

        Toolbar toolbar = findViewById(R.id.toolbar_looping);
        setSupportActionBar(toolbar);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
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
                            startActivity(new Intent(looping.this, looping_middle.class));
                        }
                    });

                } else {
                    startActivity(new Intent(looping.this, looping_middle.class));
                }
            }
        });


        findViewById(R.id.while_loop_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(looping.this, whileLoop.class));
            }
        });

        findViewById(R.id.for_loop_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(looping.this, ForLoop.class));
            }
        });

        findViewById(R.id.nested_loop_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(looping.this, NestedLoop.class));
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
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            mInterstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    startActivity(new Intent(looping.this, looping_middle.class));
                }
            });

        } else {
            startActivity(new Intent(looping.this, looping_middle.class));
        }
    }
}
