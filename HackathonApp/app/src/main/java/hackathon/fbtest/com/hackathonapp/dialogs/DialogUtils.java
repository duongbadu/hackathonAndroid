package hackathon.fbtest.com.hackathonapp.dialogs;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import hackathon.fbtest.com.hackathonapp.R;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by mr.icetea on 7/31/16.
 */
public class DialogUtils {

    public static ProgressDialog showProgressDialog(Context context){
        return ProgressDialog.show(context,
                context.getString(R.string.loading), context.getString(R.string.please_wait), false);
    }

    public static <T> void showErrorDialog(Context context, final Call<T> call, final Callback<T> callback){
        new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.error))
                .setMessage(context.getString(R.string.retry))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        call.enqueue(callback);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
