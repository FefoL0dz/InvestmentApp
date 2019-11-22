package com.example.investingmonitor.project.main;

public interface MainContract {

    interface View {
        void showLoginScreen();
        void showFeedScreen();
        void showSplashScreen();
    }

    interface Actions {
        void subscribe();
        void unsubscribe();
    }
}
