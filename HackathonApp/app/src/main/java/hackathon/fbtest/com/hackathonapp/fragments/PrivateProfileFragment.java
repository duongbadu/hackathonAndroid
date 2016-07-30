package hackathon.fbtest.com.hackathonapp.fragments;

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

import hackathon.fbtest.com.hackathonapp.R;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class PrivateProfileFragment extends MainFragment {

    public static PrivateProfileFragment newInstance(){
        return new PrivateProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CallbackManager callbackManager = CallbackManager.Factory.create();

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
                Log.d("duPro", "fb token: " + token.toString());
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        return rootView;
    }

}
