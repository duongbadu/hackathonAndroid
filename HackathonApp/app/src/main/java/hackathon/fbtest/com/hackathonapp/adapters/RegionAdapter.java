package hackathon.fbtest.com.hackathonapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hackathon.fbtest.com.hackathonapp.R;
import hackathon.fbtest.com.hackathonapp.models.Region;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> {

    public interface OnRegionSelectedListener {
        void onRegionSelected(Region region);
    }

    private List<Region> regions;
    private LayoutInflater inflater;
    private OnRegionSelectedListener listener;

    public RegionAdapter(Context context, List<Region> regions) {
        this.regions = regions;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RegionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RegionViewHolder(inflater.inflate(R.layout.region_item_view, parent, false));
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }

    @Override
    public void onBindViewHolder(RegionViewHolder holder, int position) {
        final Region region = regions.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onRegionSelected(region);
            }
        });
        holder.tvName.setText(region.getName());
    }

    public class RegionViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public RegionViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public void setListener(OnRegionSelectedListener listener) {
        this.listener = listener;
    }
}
