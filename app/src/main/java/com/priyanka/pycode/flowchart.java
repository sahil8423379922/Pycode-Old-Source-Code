package com.priyanka.pycode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.priyanka.pycode.R;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class flowchart extends AppCompatActivity {
    private WebView wb;
    private View decodeview;
    private AdView mAdView;
    private ProgressBar progressBar;
    Bookmark mydatabase;
    int count = 0;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowchart);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.topics, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.run)
        {

        }
        if(id == R.id.video)
        {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(flowchart.this,startcourse.class));
    }
}
