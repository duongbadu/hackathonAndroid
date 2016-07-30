package hackathon.fbtest.com.hackathonapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hackathon.fbtest.com.hackathonapp.ArticleDetailActivity;
import hackathon.fbtest.com.hackathonapp.R;
import hackathon.fbtest.com.hackathonapp.adapters.ArticleAdapter;
import hackathon.fbtest.com.hackathonapp.models.ArticleItem;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class ArticleListFragment extends MainFragment {

    public static ArticleListFragment newInstance(){
        return new ArticleListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_list_fragment, container, false);
        RecyclerView rvArticle = (RecyclerView) rootView.findViewById(R.id.rv_article);
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvArticle.setLayoutManager(layoutManager);
        List<ArticleItem> articleItems = new ArrayList<>();
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        articleItems.add(new ArticleItem("Nhu Dang", "PhD Computer sience", "1000.000đ", "Toán học cơ bản, lớp 3"));
        ArticleAdapter articleAdapter = new ArticleAdapter(getActivity(), articleItems);
        articleAdapter.setListener(new ArticleAdapter.OnArticleItemSelectedListener() {
            @Override
            public void onArticleItemSelected(ArticleItem article) {
                goToArticleDetail();
            }
        });
        rvArticle.setAdapter(articleAdapter);
        return rootView;
    }

    private void goToArticleDetail(){
        if(isAdded()) {
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            startActivity(intent);
        }
    }
}
