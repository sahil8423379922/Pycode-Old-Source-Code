package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//import android.priyanka.pycode.R;
import android.view.View;

public class splash extends AppCompatActivity {


    private static int SPLASH = 4000;
    private View decodeview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        decodeview = getWindow().getDecorView();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeInten = new Intent(splash.this,MainActivity.class);
                startActivity(homeInten);
                finish();
            }
        },SPLASH);

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

}
