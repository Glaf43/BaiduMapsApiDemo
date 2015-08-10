package baidumapsdk.demo.sparkDemo;

import com.firebase.client.Firebase;

/**
 * Created by Hoang on 7/31/2015.
 */
public class ChatApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}