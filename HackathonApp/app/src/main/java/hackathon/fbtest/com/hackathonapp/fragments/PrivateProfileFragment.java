package hackathon.fbtest.com.hackathonapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import hackathon.fbtest.com.hackathonapp.MainActivity;
import hackathon.fbtest.com.hackathonapp.R;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class PrivateProfileFragment extends MainFragment {

    private static final String TAG = "profile fragment";
    private CallbackManager callbackManager;

    public static PrivateProfileFragment newInstance(){
        return new PrivateProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        callbackManager = ((MainActivity)getActivity()).getCallbackManager();

        View rootView = inflater.inflate(R.layout.private_profile_fragment, container, false);

        //set fb login btn
        View view = inflater.inflate(R.layout.private_profile_fragment, container, false);

        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                AccessToken token = loginResult.getAccessToken();
                Log.d(TAG, "fb token: " + token.getToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "Cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.e(TAG, "error", exception);
            }

        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(callbackManager != null)
            callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
