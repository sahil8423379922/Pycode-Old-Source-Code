package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//import android.priyanka.pycode.R;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class CodeTerminal extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;
    private int progress = 0;
    private TextView textView;
    private Handler handler = new Handler();
    private RelativeLayout layout;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_terminal);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        layout = findViewById(R.id.relative);
        webView = findViewById(R.id.codeterminalhost);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setSupportMultipleWindows(true);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressrelative);
        webView.setWebChromeClient(new WebChromeClient());
        /*webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });*/

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, final int newProgress) {

                new Thread(new Runnable() {
                    public void run() {
                        progress = newProgress;
                        handler.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(progress);
                                textView.setText(String.valueOf(progress));
                            }
                        });
                        try {
                            // Sleep for 200 milliseconds.
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    layout.setVisibility(View.GONE);
                }
            }
        });


        //webView.loadUrl("https://pycode-ebbac.firebaseapp.com");
        webView.loadUrl("https://pycode-ebbac.firebaseapp.com/");


        // Start long running operation in a background thread


    }

    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            mInterstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    startActivity(new Intent(CodeTerminal.this,taskscreen.class));
                }
            });

        } else {
            super.onBackPressed();
        }

    }

}
