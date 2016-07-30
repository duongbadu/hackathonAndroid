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
public class TeacherListFragment extends MainFragment {


    public static TeacherListFragment newInstance(){
        return new TeacherListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.teacher_list_fragment, container, false);

        return rootView;
    }
}
