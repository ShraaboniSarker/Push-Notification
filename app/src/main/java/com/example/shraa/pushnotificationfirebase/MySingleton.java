package com.example.shraa.pushnotificationfirebase;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton mInstance;
    private  static Context context;
    private RequestQueue requestQueue;

    public MySingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        return requestQueue;
    }

    public static synchronized MySingleton getmInstance(Context context){
        if(mInstance == null)
            mInstance = new MySingleton(context);
        return mInstance;
    }
    public <T>void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }
}
