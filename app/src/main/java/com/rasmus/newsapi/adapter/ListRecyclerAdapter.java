package com.rasmus.newsapi.adapter;

/**
 * Created by rasmus on 01/05/18.
 */
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rasmus.newsapi.R;
import com.rasmus.newsapi.Utils.UtilsDate;
import com.rasmus.newsapi.model.Article;
import com.rasmus.newsapi.view.DetailArticles;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {

    private List<Article> data;
    private Context context;

    public ListRecyclerAdapter(List<Article> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.list_item_cardview_tvsource)
        public TextView tvSource;

        @BindView(R.id.list_item_cardview_tvtitle)
        public TextView tvTitlearticle;

        @BindView(R.id.list_item_cardview_ivthumbnail)
        public ImageView ivIcon;

        @BindView(R.id.list_item_cardview)
        public CardView cvItem;

        @BindView(R.id.list_item_cardview_tvpublish)
        public TextView tvPublish;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }

    @Override
    public ListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item_articles_cardview,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ListRecyclerAdapter.ViewHolder holder, final int position) {

        holder.tvTitlearticle.setText(data.get(position).getTitle());
        holder.tvSource.setText(data.get(position).getSource().getName());

        holder.tvPublish.setText(UtilsDate.formateDateFromstring("yyyy-MM-dd'T'HH:mm:ss'Z'","d MMM yy",data.get(position).getPublishedAt()));
        Glide.with(context).load(data.get(position).getUrlToImage())
                .thumbnail(0.5f)
                .apply(new RequestOptions().placeholder(R.drawable.androidimage).fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).override(450,200))
                .into(holder.ivIcon);

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent todetail = new Intent(context, DetailArticles.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    ActivityOptions activityOptions = ActivityOptions.makeCustomAnimation(context,R.anim.fade_in,R.anim.fade_out);
                    Article article = data.get(position);
                    todetail.putExtra(DetailArticles.EXTRA_DATA,article);
                    todetail.putExtra(DetailArticles.EXTRA_DATA_SOURCE,article.getSource());
                    context.startActivity(todetail,activityOptions.toBundle());
                } else context.startActivity(todetail);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
