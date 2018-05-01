package com.rasmus.newsapi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rasmus.newsapi.R;
import com.rasmus.newsapi.model.Article;
import com.rasmus.newsapi.model.Source;
import com.rasmus.newsapi.presenter.DetailArticlesPresenter;
import com.rasmus.newsapi.presenter.DetailArticlesPresenterImpl;
import com.rasmus.newsapi.presenter.DetailArticlesScene;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailArticles extends AppCompatActivity implements DetailArticlesScene{

    public static final String EXTRA_DATA = "DetailArticles";
    public static final String EXTRA_DATA_SOURCE = "DetailArticlesSource";

//    @BindView(R.id.detail_item_tvauthor)
//    public TextView tvAuthor;

    @BindView(R.id.detail_item_tvtitle)
    public TextView tvTitlearticle;

    @BindView(R.id.detail_item_tvpublish)
    public TextView tvPublish;

    @BindView(R.id.detail_item_ivthumbnail)
    public ImageView ivThumbnail;

    @BindView(R.id.detail_item_tvsource)
    public TextView tvSource;

    @BindView(R.id.detail_item_tvdescription)
    public TextView tvDescription;

    private DetailArticlesPresenter detailArticlesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail_articles);

        ButterKnife.bind(this);

        detailArticlesPresenter = new DetailArticlesPresenterImpl(this);
        Article article = getIntent().getParcelableExtra(EXTRA_DATA);
        Source source = getIntent().getParcelableExtra(EXTRA_DATA_SOURCE);
        detailArticlesPresenter.processdata(article,source);

    }

    @Override
    public void processdone(String author,String title,String publish,String desc,String source,String urlimage) {

        getSupportActionBar().setTitle(author);
        tvTitlearticle.setText(title);
        tvPublish.setText(publish);
        Glide.with(this).load(urlimage).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.androidimage))
                .thumbnail(0.5f).into(ivThumbnail);
        tvSource.setText(source);
        tvDescription.setText(desc);

    }
}
