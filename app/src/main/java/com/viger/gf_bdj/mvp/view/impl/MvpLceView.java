package com.viger.gf_bdj.mvp.view.impl;

import com.viger.gf_bdj.mvp.view.MvpView;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface MvpLceView<M> extends MvpView {

    public void showLoading(boolean pullToRefresh);
    public void showContent();
    public void showError(Exception e, boolean pullToRefresh);
    public void showData(M data);

}
