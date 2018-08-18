package com.example.shraa.pushnotificationfirebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    public final String TAG = "FIREBASE_TOKEN";

    @Override
    public void onTokenRefresh() {
        String refreshed_token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh:.................................... "+refreshed_token);
    }
}
