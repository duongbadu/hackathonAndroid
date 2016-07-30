package hackathon.fbtest.com.hackathonapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.article_info));
        setContentView(R.layout.activity_article_detail);
    }
}
