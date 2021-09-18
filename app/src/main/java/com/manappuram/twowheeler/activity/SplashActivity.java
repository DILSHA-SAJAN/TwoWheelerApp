package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_LENGTH = 3000;
    private Handler mHandler;
    private Runnable mRunnable;
    private ActivitySplashBinding binding;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        runnable.run();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,
                        LoginActivity.class);
                startActivity(i);
                finish();
                handler.removeCallbacks(runnable);

            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    private Runnable runnable = new Runnable() {
        public void run() {
            String text = binding.tvLoading.getText().toString();
            text += ".";

            int count = 0;
            for(int i=0; i < text.length(); i++)
            {
                if(text.charAt(i) == '.')
                    count++;
            }
            if(count>3)
                text = text.replaceAll(".","");

            binding.tvLoading.setText(text);

            handler.postDelayed(this, 200);
        }
    };

}