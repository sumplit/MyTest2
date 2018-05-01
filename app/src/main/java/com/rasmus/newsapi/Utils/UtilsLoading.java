package com.rasmus.newsapi.Utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by AsusI3 on 18-Dec-17.
 */

public class UtilsLoading {

    Context context;
    ProgressDialog progressDialog;

    public UtilsLoading(Context mcontext,String text){
        this.context = mcontext;
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage(text);
        progressDialog.setCancelable(false);
    }

    public void show(){
        progressDialog.show();
    }

    public void dismiss(){
        progressDialog.dismiss();
    }

}
