package hackathon.fbtest.com.hackathonapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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
    private Context context;

    public ArticleAdapter(Context context, List<ArticleItem> articles) {
        this.articles = articles;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
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
        holder.tvArticleName.setText(article.getSubject());
        holder.tvTeacherName.setText(Html.fromHtml(String.format(context.getResources().getString(R.string.teacher_name),
                article.getTeacherName())));
        holder.tvTeacherDegree.setText(Html.fromHtml(String.format(context.getResources().getString(R.string.teacher_degree),
                article.getDegree())));
        holder.tvPrice.setText(article.getPrice());
    }

    public class ArticleItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvArticleName;
        TextView tvTeacherName;
        TextView tvTeacherDegree;
        TextView tvPrice;

        public ArticleItemViewHolder(View itemView) {
            super(itemView);
            tvArticleName = (TextView) itemView.findViewById(R.id.tv_article_name);
            tvTeacherName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTeacherDegree = (TextView) itemView.findViewById(R.id.tv_degree);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }

    public void setListener(OnArticleItemSelectedListener listener) {
        this.listener = listener;
    }

}
