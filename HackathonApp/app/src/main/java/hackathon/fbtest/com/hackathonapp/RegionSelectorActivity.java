package hackathon.fbtest.com.hackathonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hackathon.fbtest.com.hackathonapp.adapters.RegionAdapter;
import hackathon.fbtest.com.hackathonapp.models.Region;

public class RegionSelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_selector_activiy);
        List<Region> regions = new ArrayList<>();
        regions.add(new Region("Ha Noi", 0));
        regions.add(new Region("Da Nang", 1));
        regions.add(new Region("TP HCM", 2));

        RecyclerView rvRegion = (RecyclerView) findViewById(R.id.rv_region);
        RegionAdapter regionAdapter = new RegionAdapter(this, regions);
        regionAdapter.setListener(new RegionAdapter.OnRegionSelectedListener() {
            @Override
            public void onRegionSelected(Region region) {
                goToMainScreen(region);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvRegion.setLayoutManager(linearLayoutManager);
        rvRegion.setAdapter(regionAdapter);
    }

    private void goToMainScreen(Region region){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_REGION_NAME, region.getName());
        intent.putExtra(MainActivity.EXTRA_REGION_ID, region.getId());
        startActivity(intent);
    }
}
