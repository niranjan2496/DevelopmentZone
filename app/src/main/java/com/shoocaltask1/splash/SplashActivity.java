package com.shoocaltask1.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

import com.shoocaltask1.R;
import com.shoocaltask1.home.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // hide title bar
        getSupportActionBar().hide();
        // Hide status bar
        Window window=getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.getInsetsController().hide(WindowInsets.Type.statusBars());
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}