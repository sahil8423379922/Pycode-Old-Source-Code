package com.priyanka.pycode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.priyanka.pycode.R;

public class pythonHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_home);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(pythonHome.this,startcourse.class));
    }
}
