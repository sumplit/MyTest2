package com.rasmus.newsapi.presenter;

import com.rasmus.newsapi.model.ApiInterfaceGetList;
import com.rasmus.newsapi.model.DataList;
import com.rasmus.newsapi.network.ApiService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rasmus on 30/04/18.
 */
public class MainActivityPresenterImpl implements MainActivityPresenter{

    private static final String TAG_APIKEY ="87055553233f4db98aad6a760859d8b8";

    private MainActivityScene mainActivityScene;

    public MainActivityPresenterImpl(MainActivityScene mainActivityScene) {
        this.mainActivityScene = mainActivityScene;
    }

    @Override
    public void getListfromApi(String category) {

        Map<String, String> data = new HashMap<>();
        data.put("category", category);
        data.put("apiKey", TAG_APIKEY);

        ApiInterfaceGetList apiInterfaceGetList = ApiService.createService().create(ApiInterfaceGetList.class);
        Call<DataList> dataListCall = apiInterfaceGetList.getListArticles(data);

        dataListCall.enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {

                mainActivityScene.responselistsuccess(response.body().getArticles());

            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
                mainActivityScene.responselisterror();
            }
        });

    }
}
