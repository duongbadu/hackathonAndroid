package hackathon.fbtest.com.hackathonapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import hackathon.fbtest.com.hackathonapp.adapters.MainPagerAdapter;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_REGION_NAME = "extra_region_name";
    public static final String EXTRA_REGION_ID = "extra_region_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
