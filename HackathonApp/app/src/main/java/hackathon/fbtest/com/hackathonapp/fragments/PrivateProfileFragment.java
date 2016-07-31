package hackathon.fbtest.com.hackathonapp.fragments;

import android.app.ProgressDialog;
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
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;

import org.json.JSONObject;

import hackathon.fbtest.com.hackathonapp.MainActivity;
import hackathon.fbtest.com.hackathonapp.MyApp;
import hackathon.fbtest.com.hackathonapp.R;
import hackathon.fbtest.com.hackathonapp.dialogs.DialogUtils;
import hackathon.fbtest.com.hackathonapp.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class PrivateProfileFragment extends MainFragment {

    private static final String TAG = "profile fragment";
    private CallbackManager callbackManager;
    private Gson gson;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
    }

    public static PrivateProfileFragment newInstance() {
        return new PrivateProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        callbackManager = ((MainActivity) getActivity()).getCallbackManager();

        View rootView = inflater.inflate(R.layout.private_profile_fragment, container, false);

        //set fb login btn
        View view = inflater.inflate(R.layout.private_profile_fragment, container, false);

        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
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
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                User user =
                                        gson.fromJson(response.getRawResponse(), User.class);
                                User.setInstance(user);
                                loadUIProfile();
                                createNewUser();
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,picture.width(320).height(320)");
                request.setHttpMethod(HttpMethod.GET);
                request.setParameters(parameters);
                request.executeAsync();
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
        if (callbackManager != null)
            callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void loadUIProfile() {

    }

    private Callback<User> createUserCallback = new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            if(progressDialog != null) {
                progressDialog.dismiss();
            }
            if(response.code() == 200) {

            } else {
                DialogUtils.showErrorDialog(getActivity(), call.clone(), this);
            }
        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {
            Log.e(TAG, "error", t);
            if(progressDialog != null) progressDialog.dismiss();
            DialogUtils.showErrorDialog(getActivity(), call.clone(), this);
        }
    };

    private void createNewUser() {
        if(progressDialog != null) progressDialog.dismiss();
        progressDialog = DialogUtils.showProgressDialog(getActivity());
        Call<User> call = MyApp.getInstance().getNetworkService().createUser(User.getInstance());
        call.enqueue(createUserCallback);
    }

}
