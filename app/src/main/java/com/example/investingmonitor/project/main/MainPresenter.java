package com.example.investingmonitor.project.main;

public class MainPresenter implements MainContract.Actions {
    MainActivity view;
    @Override
    public void subscribe() {
        view.showFeedScreen();
    }

    @Override
    public void unsubscribe() {

    }
}
