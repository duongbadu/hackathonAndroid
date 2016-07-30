package hackathon.fbtest.com.hackathonapp.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

import hackathon.fbtest.com.hackathonapp.R;
import hackathon.fbtest.com.hackathonapp.models.Region;

/**
 * Created by vinhc on 7/31/2016.
 */
public class RegionDialogFragment extends DialogFragment {

    List<Region> regions = new ArrayList<>();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        regions.add(new Region("Ha Noi", 0));
        regions.add(new Region("Da Nang", 1));
        regions.add(new Region("TP HCM", 2));

        CharSequence[] regionSeq = new CharSequence[regions.size()];

        for (int i = 0; i < regions.size(); ++i) {
            regionSeq[i] = regions.get(i).getName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn vùng")
                .setItems(regionSeq , new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });
        return builder.create();
    }

}
