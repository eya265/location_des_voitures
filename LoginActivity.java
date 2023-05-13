package com.example.locationdesvoitures.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.locationdesvoitures.LoginCallback;
import com.example.locationdesvoitures.Model.UserModel;
import com.example.locationdesvoitures.R;


        public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginCallback, onSuccess {
            private EditText editTextEmail;
            private EditText editTextPassword;
            private Button buttonLogin;
            private ProgressBar progressBar;
            private UserModel userModel;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login2);

                // Initialise les vues
                editTextEmail = findViewById(R.id.et_email);
                editTextPassword = findViewById(R.id.et_password);
                buttonLogin = findViewById(R.id.btn_login);
                progressBar = findViewById(R.id.progress_bar);
                View Button = findViewById(R.id.register_button);


                // Initialise le modèle
                UserModel UserModel = new UserModel(this);

                // Attache un écouteur de clic au bouton de connexion
                buttonLogin.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (v == buttonLogin) {
                    // Récupère les informations de connexion
                    String email = editTextEmail.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();

                    // Vérifie si les champs sont valides
                    if (TextUtils.isEmpty(email)) {
                        editTextEmail.setError("Veuillez entrer votre adresse e-mail");
                        editTextEmail.requestFocus();
                        return;
                    }

                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        editTextEmail.setError("Veuillez entrer une adresse e-mail valide");
                        editTextEmail.requestFocus();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        editTextPassword.setError("Veuillez entrer votre mot de passe");
                        editTextPassword.requestFocus();
                        return;
                    }

                    // Commence la tentative de connexion
                    progressBar.setVisibility(View.VISIBLE);
                    userModel.login(email, password);
                }
            }

            @Override
            public void onSuccess() {
                // La connexion est réussie, affiche un message et redirige vers l'écran d'accueil
                Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String message) {
                // La connexion a échoué, affiche un message d'erreur
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
            @Override
            public void setEmailError(String errorMsg) {
                AccessibilityNodeInfo emailEditText = null;
                emailEditText.setError(errorMsg);
            }

            @Override
            public void onLoginSuccess() {

            }

            @Override
            public void onLoginError(String errorMessage) {

            }

        }
