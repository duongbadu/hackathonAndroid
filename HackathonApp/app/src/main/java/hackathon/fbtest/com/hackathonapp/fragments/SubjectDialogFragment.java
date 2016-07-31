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
import hackathon.fbtest.com.hackathonapp.models.SubjectName;

/**
 * Created by vinhc on 7/31/2016.
 */
public class SubjectDialogFragment extends DialogFragment {

    List<SubjectName> subNames = new ArrayList<>();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        subNames.add(new SubjectName("Toán", 0));
        subNames.add(new SubjectName("Vật lý", 1));
        subNames.add(new SubjectName("Hóa Học", 2));
        subNames.add(new SubjectName("Kèn và các loại nhạc cụ thổi khác", 2));

        CharSequence[] subs = new CharSequence[subNames.size()];

        for (int i = 0; i < subNames.size(); ++i) {
            subs[i] = subNames.get(i).getName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Môn")
                .setItems(subs , new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });
        return builder.create();
    }

}
