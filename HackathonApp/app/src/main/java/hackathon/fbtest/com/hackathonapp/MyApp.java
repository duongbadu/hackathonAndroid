package hackathon.fbtest.com.hackathonapp;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by mr.icetea on 7/31/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
