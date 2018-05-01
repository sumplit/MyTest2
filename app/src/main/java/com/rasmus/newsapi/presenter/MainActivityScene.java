package com.rasmus.newsapi.presenter;


import com.rasmus.newsapi.model.Article;

import java.util.List;

/**
 * Created by rasmus on 30/04/18.
 */
public interface MainActivityScene {

    void responselistsuccess(List<Article> articles);

    void responselisterror();
}
