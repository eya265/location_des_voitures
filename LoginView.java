package com.example.locationdesvoitures;

import android.view.accessibility.AccessibilityNodeInfo;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setPasswordError(String message);
    void navigateToHome();
    void showLoginError(String message);
    public default void setEmailError(String message) {
        AccessibilityNodeInfo emailEditText = null;
        emailEditText.setError(message);}
}

