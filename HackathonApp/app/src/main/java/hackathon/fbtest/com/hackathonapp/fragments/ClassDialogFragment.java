package hackathon.fbtest.com.hackathonapp.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

import hackathon.fbtest.com.hackathonapp.ArticleInsertActivity;
import hackathon.fbtest.com.hackathonapp.R;
import hackathon.fbtest.com.hackathonapp.models.ClassName;
import hackathon.fbtest.com.hackathonapp.models.Region;

/**
 * Created by vinhc on 7/31/2016.
 */
public class ClassDialogFragment extends DialogFragment {

    List<ClassName> classes = new ArrayList<>();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        classes.add(new ClassName("Lớp 1", 0));
        classes.add(new ClassName("Lớp 2", 1));
        classes.add(new ClassName("Lớp 3", 2));
        classes.add(new ClassName("Lớp 4", 3));
        classes.add(new ClassName("Lớp 5", 4));
        classes.add(new ClassName("Lớp 6", 5));
        classes.add(new ClassName("Lớp 7", 6));
        classes.add(new ClassName("Lớp 8", 7));
        classes.add(new ClassName("Lớp 9", 8));
        classes.add(new ClassName("Lớp 10", 9));
        classes.add(new ClassName("Lớp 11", 10));
        classes.add(new ClassName("Lớp 12", 11));
        classes.add(new ClassName("Lớp khác", 12));

        CharSequence[] regionSeq = new CharSequence[classes.size()];

        for (int i = 0; i < classes.size(); ++i) {
            regionSeq[i] = classes.get(i).getName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Lớp")
                .setItems(regionSeq , new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });
        return builder.create();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        item.getTitle();

        return super.onOptionsItemSelected(item);
    }
}
