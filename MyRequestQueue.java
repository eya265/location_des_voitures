package com.example.locationdesvoitures.View;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.Volley;

public class MyRequestQueue {
    private static MyRequestQueue mInstance;
    private Object mRequestQueue;
    private static Context mCtx;

    private MyRequestQueue(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized MyRequestQueue getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyRequestQueue(context);
        }
        return mInstance;
    }

    public <RequestQueue> RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // Création de la RequestQueue avec la méthode Volley.newRequestQueue()
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return (RequestQueue) mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        Request<T> req1 = req;
        Request<T> req2 = req;
    }
}

