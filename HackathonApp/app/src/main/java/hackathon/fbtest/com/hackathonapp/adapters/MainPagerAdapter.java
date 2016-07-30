package hackathon.fbtest.com.hackathonapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import hackathon.fbtest.com.hackathonapp.fragments.ArticleListFragment;
import hackathon.fbtest.com.hackathonapp.fragments.PrivateProfileFragment;
import hackathon.fbtest.com.hackathonapp.fragments.TeacherListFragment;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class MainPagerAdapter extends SmartPagerAdapter {

    private final String[] titles = new String[] {
            "List",
            "Gv",
            "Profile"
    };

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ArticleListFragment.newInstance();
            case 1:
                return TeacherListFragment.newInstance();
            default:
                return PrivateProfileFragment.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return 3;
    }

}
