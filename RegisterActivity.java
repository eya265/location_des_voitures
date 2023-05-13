package com.example.locationdesvoitures.View;

import static android.app.DownloadManager.*;
import static android.app.DownloadManager.Request.*;
import static android.provider.SyncStateContract.*;

import static com.android.volley.toolbox.Volley.newRequestQueue;
import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.example.locationdesvoitures.R;
import com.google.android.material.color.utilities.DynamicColor;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response;


@SuppressLint("RestrictedApi")
public class RegisterActivity<RequestQueue, StringRequest> extends AppCompatActivity  {


        private EditText editTextName, editTextEmail, editTextPassword;
        private Button buttonRegister;

        private ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            editTextName = findViewById(R.id.edit_text_name);
            editTextEmail = findViewById(R.id.edit_text_email);
            editTextPassword = findViewById(R.id.edit_text_password);
            buttonRegister = findViewById(R.id.button_register);

            buttonRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registerUser();
                }
            });
        }

        private void registerUser() {
            final String name = editTextName.getText().toString().trim();
            final String email = editTextEmail.getText().toString().trim();
            final String password = editTextPassword.getText().toString().trim();

            progressDialog = new ProgressDialog(RegisterActivity.this);
            progressDialog.setMessage("Enregistrement en cours...");
            progressDialog.show();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                Toast.makeText(RegisterActivity.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                                if (!jsonObject.getBoolean("error")) {
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }


                        public <VolleyError> void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {

                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", name);
                    params.put("email", email);
                    params.put("password", password);
                    return params;
                }
            };

            Object Volley = null;
            RequestQueue requestQueue = com.example.locationdesvoitures.View.Volley
            .newRequestQueue(RegisterActivity.this);
            requestQueue.add(stringRequest);
        }

    public void showProgressDialog() {
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    public void goToLoginActivity() {

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();



    }

    public void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle("Error")
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void showErrorMessage(VolleyError error) {
        String message = "";
        if (error instanceof NetworkError) {
            message = "Impossible de se connecter au serveur, veuillez vérifier votre connexion Internet";
        } else if (error instanceof ServerError) {
            message = "Le serveur a renvoyé une erreur, veuillez réessayer plus tard";
        } else if (error instanceof AuthFailureError) {
            message = "Erreur d'authentification, veuillez réessayer";
        } else if (error instanceof ParseError) {
            message = "Erreur de parsing de la réponse du serveur, veuillez réessayer";
        } else if (error instanceof NoConnectionError) {
            message = "Pas de connexion disponible, veuillez vérifier votre connexion Internet";
        } else if (error instanceof TimeoutError) {
            message = "Temps d'attente dépassé, veuillez réessayer";
        }
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG).show();
    }
    new Response.ErrorListener() {

        Object onErrorResponse;
        Object onErrorResponse1 = onErrorResponse;
        assert progressDialog != null;
        (VolleyError ) {
            progressDialog.dismiss();};
        Object error2;
        if (error2 instanceof NetworkError) {
                Toast.makeText(RegisterActivity.this, "Erreur de réseau", Toast.LENGTH_LONG).show();
            } else if (error2 instanceof ServerError) {
                Toast.makeText(RegisterActivity.this, "Erreur du serveur", Toast.LENGTH_LONG).show();
            } else if (error2 instanceof AuthFailureError) {
                Toast.makeText(RegisterActivity.this, "Erreur d'authentification", Toast.LENGTH_LONG).show();
            } else if (error2 instanceof ParseError) {
                Toast.makeText(RegisterActivity.this, "Erreur de parsing", Toast.LENGTH_LONG).show();
            } else if (error2 instanceof NoConnectionError) {
                Toast.makeText(RegisterActivity.this, "Pas de connexion", Toast.LENGTH_LONG).show();
            } else if (error2 instanceof TimeoutError) {
                Toast.makeText(RegisterActivity.this, "Temps d'attente dépassé", Toast.LENGTH_LONG).show();
            }
        }
    }


