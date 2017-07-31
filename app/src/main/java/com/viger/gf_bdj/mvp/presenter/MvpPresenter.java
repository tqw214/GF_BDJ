package com.viger.gf_bdj.mvp.presenter;

import com.viger.gf_bdj.mvp.view.MvpView;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface MvpPresenter<V extends MvpView> {

    public void attachView(V view);
    public void detachView();

}
