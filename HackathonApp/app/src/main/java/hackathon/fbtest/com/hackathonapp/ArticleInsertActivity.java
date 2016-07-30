package hackathon.fbtest.com.hackathonapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import hackathon.fbtest.com.hackathonapp.fragments.ClassDialogFragment;
import hackathon.fbtest.com.hackathonapp.fragments.RegionDialogFragment;
import hackathon.fbtest.com.hackathonapp.fragments.SubjectDialogFragment;

/**
 * Created by mr.icetea on 7/31/16.
 */
public class ArticleInsertActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText etName;
    TextInputEditText etRegion;
    TextInputEditText etClass;
    TextInputEditText etSubject;
    TextInputEditText etTime;
    TextInputEditText etPeople;
    TextInputEditText etPrice;
    TextInputEditText etDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_insert);
        etName = (TextInputEditText) findViewById(R.id.et_article_name);
        etRegion = (TextInputEditText) findViewById(R.id.et_region);
        etClass = (TextInputEditText) findViewById(R.id.et_class);
        etSubject = (TextInputEditText) findViewById(R.id.et_subject);
        etTime = (TextInputEditText) findViewById(R.id.et_time);
        etPeople = (TextInputEditText) findViewById(R.id.et_people);
        etPrice = (TextInputEditText) findViewById(R.id.et_price);
        etDescription = (TextInputEditText) findViewById(R.id.et_description);

        etRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegionDialogFragment rd = new RegionDialogFragment();
                rd.show(getFragmentManager(), "regionTag");
            }
        });

        etSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubjectDialogFragment rd = new SubjectDialogFragment();
                rd.show(getFragmentManager(), "classTag");
            }
        });

        etClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassDialogFragment rd = new ClassDialogFragment();
                rd.show(getFragmentManager(), "classTag");
            }
        });

//        etSubject.setOnClickListener(this);
//        etClass.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.d("duPro", "onClick");

        if (v.getId() == R.id.et_region ) {
            Log.d("duPro", "region");


        }
        else if (v.getId() == R.id.et_subject) {
            Log.d("duPro", "subjet");
        }
        else if (v.getId() == R.id.et_class) {
            Log.d("duPro", "class");
        }
    }
}
