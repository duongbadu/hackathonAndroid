package hackathon.fbtest.com.hackathonapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by mr.icetea on 7/31/16.
 */
public class ArticleInsertActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_insert);
        TextInputEditText etName = (TextInputEditText) findViewById(R.id.et_article_name);
        TextInputEditText etRegion = (TextInputEditText) findViewById(R.id.et_region);
        TextInputEditText etClass = (TextInputEditText) findViewById(R.id.et_class);
        TextInputEditText etSubject = (TextInputEditText) findViewById(R.id.et_subject);
        TextInputEditText etTime = (TextInputEditText) findViewById(R.id.et_time);
        TextInputEditText etPeople = (TextInputEditText) findViewById(R.id.et_people);
        TextInputEditText etPrice = (TextInputEditText) findViewById(R.id.et_price);
        TextInputEditText etDescription = (TextInputEditText) findViewById(R.id.et_description);
        etRegion.setOnClickListener(this);
        etSubject.setOnClickListener(this);
        etClass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
