package com.example.investingmonitor.project.splash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.example.investingmonitor.R;
import com.example.investingmonitor.project.feed.FeedActivity;
import com.example.investingmonitor.project.utils.Delay;

public class SplashActivity extends AppCompatActivity {

    private final int splashScreenVisibilityDurationSeconds = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this.getApplicationContext(),R.color.grey_dark));
        }

        //ApiServiceGenerator.getInstance().generate();
        Delay.delay(splashScreenVisibilityDurationSeconds, new Delay.DelayCallback() {
            @Override
            public void afterDelay() {
                showFeedScreen();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void showFeedScreen() {
        Intent intent = new Intent(this, FeedActivity.class);
        this.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
        this.startActivity(intent);
        this.finish();
    }
}
