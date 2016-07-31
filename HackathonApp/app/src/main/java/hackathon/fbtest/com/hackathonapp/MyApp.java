package hackathon.fbtest.com.hackathonapp;

import android.app.Application;

import com.facebook.FacebookSdk;

import hackathon.fbtest.com.hackathonapp.network.NetworkService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mr.icetea on 7/31/16.
 */
public class MyApp extends Application {

    private NetworkService networkService;
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.247.224.172:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
        instance = this;
    }

    public NetworkService getNetworkService() {
        return networkService;
    }

    public static MyApp getInstance() {
        return instance;
    }
}
