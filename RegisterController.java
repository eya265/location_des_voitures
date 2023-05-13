package com.example.locationdesvoitures.Controleur;

import static android.app.DownloadManager.*;
import static android.app.DownloadManager.Request.*;
import static android.provider.SyncStateContract.*;

import static androidx.privacysandbox.tools.core.model.Method.*;

import static com.android.volley.Request.Method.POST;

import android.app.DownloadManager;
import android.provider.SyncStateContract;

import androidx.privacysandbox.tools.core.model.Method;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.locationdesvoitures.Model.UserModel1;
import com.example.locationdesvoitures.View.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterController<StringRequest extends Request<T>, T> {
    private static final String URL_REGISTER = "http://exemple.com/register";


    private RegisterActivity registerActivity;

    public RegisterController(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }

    public void registerUser(UserModel1 userModel1) {
        registerActivity.showProgressDialog();

        //StringRequest stringRequest = new StringRequest(URL_REGISTER, POST,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        registerActivity.hideProgressDialog();

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String message = jsonObject.getString("message");
                            if (!jsonObject.getBoolean("error")) {
                                registerActivity.goToLoginActivity();
                            }
                            registerActivity.showErrorMessage(message);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        registerActivity.hideProgressDialog();
                        registerActivity.showErrorMessage(error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", UserModel1.getName());
                params.put("email", UserModel1.getEmail());
                params.put("password", UserModel1.getPassword());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(registerActivity);
        requestQueue.add(stringRequest);
    }
}
