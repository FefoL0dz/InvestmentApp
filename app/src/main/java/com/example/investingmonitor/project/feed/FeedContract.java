package com.example.investingmonitor.project.feed;

public interface FeedContract {
    
    interface View extends FeedContract {

        void showErrorMessage(String message);
    }

    interface Action extends FeedContract {

    }
}
