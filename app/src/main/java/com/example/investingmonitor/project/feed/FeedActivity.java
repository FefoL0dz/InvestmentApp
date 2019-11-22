package com.example.investingmonitor.project.feed;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.example.investingmonitor.R;
import com.example.investingmonitor.project.models.Stock;
import com.example.investingmonitor.project.webService.ApiServiceGenerator;

import retrofit2.Response;

public class FeedActivity extends AppCompatActivity implements FeedContract.View {

    private static final String TAG = "INVESTING_MONITOR_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Response<Stock> results = ApiServiceGenerator.getInstance(this).generate();
    }

    @Override
    public void showErrorMessage(String message) {
        
    }
}
