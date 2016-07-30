package hackathon.fbtest.com.hackathonapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View rootView = inflater.inflate(R.layout.private_profile_fragment, container, false);

        return rootView;
    }
}
