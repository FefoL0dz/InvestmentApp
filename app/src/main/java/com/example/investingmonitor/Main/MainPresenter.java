package com.example.investingmonitor.Main;

public class MainPresenter implements MainContract.Actions{
    MainActivity view;
    @Override
    public void subscribe() {
        view.showFeedScreen();
    }

    @Override
    public void unsubscribe() {

    }
}
