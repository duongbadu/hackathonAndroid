package hackathon.fbtest.com.hackathonapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hackathon.fbtest.com.hackathonapp.R;
import hackathon.fbtest.com.hackathonapp.models.ArticleItem;

/**
 * Created by mr.icetea on 7/30/16.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleItemViewHolder> {

    public interface OnArticleItemSelectedListener {
        void onArticleItemSelected(ArticleItem article);
    }

    private List<ArticleItem> articles;
    private LayoutInflater inflater;
    private OnArticleItemSelectedListener listener;

    public ArticleAdapter(Context context, List<ArticleItem> articles) {
        this.articles = articles;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleItemViewHolder(inflater.inflate(R.layout.article_grid_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public void onBindViewHolder(ArticleItemViewHolder holder, int position) {
        final ArticleItem article = articles.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onArticleItemSelected(article);
            }
        });
//        holder.tvName.setText(article.getName());
    }

    public class ArticleItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public ArticleItemViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public void setListener(OnArticleItemSelectedListener listener) {
        this.listener = listener;
    }
}
