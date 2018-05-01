package com.rasmus.newsapi.presenter;

import com.rasmus.newsapi.model.Article;
import com.rasmus.newsapi.model.Source;

/**
 * Created by rasmus on 01/05/18.
 */
public interface DetailArticlesPresenter {

    void processdata(Article article, Source source);
}
