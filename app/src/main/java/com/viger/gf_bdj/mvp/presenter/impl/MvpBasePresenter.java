package com.viger.gf_bdj.mvp.presenter.impl;

import com.viger.gf_bdj.mvp.presenter.MvpPresenter;
import com.viger.gf_bdj.mvp.view.MvpView;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if(view != null) {
            view = null;
        }
    }
}
