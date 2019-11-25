package com.example.investingmonitor.project.feed;

import com.example.investingmonitor.project.models.Stock;

public interface FeedContract {
    
    interface View extends FeedContract {

        void showErrorMessage(String message);
        void showUnsucessMessage(String code);
        void showStockResults(Stock body);
    }

    interface Action extends FeedContract {

    }
}
