package com.viger.gf_bdj.pro.base.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;

/**
 * Created by Administrator on 2017/8/10.
 */

public abstract class BasePresenter extends MvpBasePresenter {

    private Context context;
    private Gson gson;

    public BasePresenter(Context context) {
        this.context = context;
        this.gson = new Gson();
    }

    public Context getContext() {
        return context;
    }
    public Gson getGson() {
        return gson;
    }



    public interface OnUiThreadListener<T> {
        public void onResult(T result);
    }



}
