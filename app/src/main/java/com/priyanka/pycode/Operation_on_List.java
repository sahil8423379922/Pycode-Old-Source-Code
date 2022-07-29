package com.priyanka.pycode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
//import android.priyanka.pycode.BuildConfig;
///import android.priyanka.pycode.R;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Operation_on_List extends AppCompatActivity {
    private WebView wb;
    private View decodeview;
    private ProgressBar progressBar;
    private AdView mAdView;
    Bookmark mydatabase;
    int count = 0;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_on__list);
        progressBar = findViewById(R.id.progress);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3774908939242242/2077460977");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        Toolbar toolbar = findViewById(R.id.toolbar_operation_in_list);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Lists.class));
            }
        });
        wb= findViewById(R.id.accesing_element_webview);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("https://sites.google.com/view/operationlistpython/home");
        loadprogress();
        decodeview = getWindow().getDecorView();
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3774908939242242/5917946717");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mydatabase = new Bookmark(this);
        BottomNavigationCall();


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
        {
            decodeview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }


    }

    private void BottomNavigationCall() {
        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Operation_on_List.this,startcourse.class));
            }
        });


        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Operation_on_List.this);
                alertDialogBuilder.setTitle("Exit Application?");
                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                    }
                                })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        findViewById(R.id.run).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Operation_on_List.this,CodeTerminal.class));
            }
        });

        findViewById(R.id.video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Operation_on_List.this,Video.class ));
            }
        });


        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pycode");
                    String shareMessage = "\nA Smart way for Learn Python Programming Language\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.subtopics, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.bookmark) {

            Cursor cursor = mydatabase.getAlldata();

            while (cursor.moveToNext()) {
                String value = cursor.getString(1);
                if (value.equals("Operation on List")) {
                    count = count + 1;

                }

            }

            if (count != 0) {
                Toast.makeText(this, "Already Bookmarked", Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_bookmark_black_24dp);
            } else {

                boolean check = mydatabase.insertdata("Operation on List");
                if (check == true) {
                    item.setIcon(R.drawable.ic_bookmark_black_24dp);
                }
                Toast.makeText(this, "Bookmarked", Toast.LENGTH_SHORT).show();

            }
        }

        if(id == R.id.download)
        {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "IIT Preparation");
                String shareMessage = "\nA Smart way for the preparation of JEE Main and JEE Advanced\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }
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
                    startActivity(new Intent(Operation_on_List.this, Lists.class));
                }
            });

        } else {
            super.onBackPressed();
        }

    }
    private void loadprogress() {
        wb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress == 100)
                {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
