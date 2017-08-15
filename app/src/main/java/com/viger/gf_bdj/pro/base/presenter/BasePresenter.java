package com.viger.gf_bdj.pro.base.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.pro.base.model.BaseModel;

/**
 * Created by Administrator on 2017/8/10.
 */

public abstract class BasePresenter<M extends BaseModel> extends MvpBasePresenter {

    private Context context;
    private Gson gson;
    private M model;

    public BasePresenter(Context context) {
        this.context = context;
        this.gson = new Gson();
        this.model = bindModel();
    }

    public Context getContext() {
        return context;
    }
    public Gson getGson() {
        return gson;
    }
    public M getModel() {
        return model;
    }

    public abstract M bindModel();

    public interface OnUiThreadListener<T> {
        public void onResult(T result);
    }



}
