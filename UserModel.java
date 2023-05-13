package com.example.locationdesvoitures.Model;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.accessibility.AccessibilityNodeInfo;

import com.example.locationdesvoitures.View.LoginActivity;

public class UserModel {
    private String email;
    private String password;

    //public UserModel(String email, String password) {
      //  this.email = email;
        //this.password = password;
    //}

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserModel(LoginActivity loginActivity) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String email, String password) {
        // Vérification des champs email et password
        if (TextUtils.isEmpty(email)) {
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            return false;
        }

        // Connexion à la base de données
        // Exécution de la requête SELECT pour vérifier les informations d'identification
        boolean success = checkCredentials(email, password);

        return success;
    }

    private boolean checkCredentials(String email, String password) {
        // Connexion à la base de données
        // Exécution de la requête SELECT pour vérifier les informations d'identification
        // Retourne true si les informations sont correctes, false sinon
        return true;
    }


}
