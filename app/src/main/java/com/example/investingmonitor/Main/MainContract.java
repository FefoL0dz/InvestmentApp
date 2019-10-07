package com.example.investingmonitor.Main;

public interface MainContract {

    interface View {
        void showLoginScreen();
        void showFeedScreen();
    }

    interface Actions {
        void subscribe();
        void unsubscribe();
    }
}
