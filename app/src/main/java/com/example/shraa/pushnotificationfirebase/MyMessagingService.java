package com.example.shraa.pushnotificationfirebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService extends FirebaseMessagingService {
    private String TAG = "MyMessagingService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size()>0){
            String title,message,img_url;

            title = remoteMessage.getData().get("title");
            message = remoteMessage.getData().get("message");
            img_url = remoteMessage.getData().get("img_url");


            Log.i(TAG, "onMessageReceived: ................. "+remoteMessage.getNotification().getBody());
            Log.i(TAG, "onMessageReceived: ................."+message);
            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
            notification.setContentTitle("Firebase Messaging");
            notification.setContentText(remoteMessage.getNotification().getBody());
            notification.setAutoCancel(true);
            notification.setSmallIcon(R.mipmap.ic_launcher);
            notification.setContentIntent(pendingIntent);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0,notification.build());
//            ImageRequest imageRequest = new ImageRequest(img_url, new Response.Listener<Bitmap>() {
//                @Override
//                public void onResponse(Bitmap response) {
//                    notification.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(response));
//                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                    manager.notify(0,notification.build());
//                }
//            },0, 0,null,Bitmap.Config.RGB_565, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                }
//            });
//            MySingleton.getmInstance(this).addToRequestQueue(imageRequest);
        }
    }
}
