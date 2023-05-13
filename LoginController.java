package com.example.locationdesvoitures.Controleur;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.example.locationdesvoitures.LoginCallback;
import com.example.locationdesvoitures.Model.UserModel;

public class LoginController<LoginView> {
    private LoginView view;
    private UserModel model;
    private LoginCallback callback;

    public LoginController(LoginView view, LoginCallback callback) {
        this.view = view;
        this.callback = callback;
    }

    public void login(String email, String password) {
        model = new UserModel(email, password);
        boolean isValid = validate();
        if (isValid) {
            // Connexion à la base de données
            // Vérifier les informations d'identification dans la base de données
            boolean success = checkCredentials();
            if (success) {
                callback.onLoginSuccess();
            } else {
                callback.onLoginError("Email ou mot de passe incorrect");
            }
        }
    }

    private boolean validate() {
        // Vérification des champs email et password
        String email = model.getEmail();
        String password = model.getPassword();

        if (TextUtils.isEmpty(email)) {
            view.setEmailError("L'adresse email ne peut pas être vide");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.setEmailError("L'adresse email est invalide");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            View.setEmailError("Le mot de passe ne peut pas être vide");
            return false;
        }

        return true;
    }

    private boolean checkCredentials() {
        // Connexion à la base de données
        // Exécution de la requête SELECT pour vérifier les informations d'identification
        return true;
    }
}

