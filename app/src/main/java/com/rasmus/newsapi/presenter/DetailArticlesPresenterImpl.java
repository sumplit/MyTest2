package com.rasmus.newsapi.presenter;

import android.text.TextUtils;

import com.rasmus.newsapi.Utils.UtilsDate;
import com.rasmus.newsapi.model.Article;
import com.rasmus.newsapi.model.Source;

/**
 * Created by rasmus on 01/05/18.
 */
public class DetailArticlesPresenterImpl implements DetailArticlesPresenter{

    private DetailArticlesScene detailArticlesScene;

    public DetailArticlesPresenterImpl(DetailArticlesScene detailArticlesScene) {
        this.detailArticlesScene = detailArticlesScene;
    }

    @Override
    public void processdata(Article article, Source source) {

        String author = article.getAuthor();
        if (TextUtils.isEmpty(author))
            author = "No Name";

        String title = article.getTitle();
        String publish = UtilsDate.formateDateFromstring("yyyy-MM-dd'T'HH:mm:ss'Z'","EEE, d MMM yyyy",article.getPublishedAt());
        String desc = article.getDescription();
        String sourc = source.getName();
        String urlimg = article.getUrlToImage();

        detailArticlesScene.processdone(author,title,publish,desc,sourc,urlimg);

    }

}
