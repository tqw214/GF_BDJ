package com.viger.gf_bdj.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.mvp.view.MvpView;

/**
 * Created by Administrator on 2017/8/1.
 */

public abstract class MvpFragment<P extends MvpBasePresenter> extends Fragment implements MvpView {

    protected P presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = bindPresenter();
        if(presenter != null) {
            presenter.attachView(this);
        }
    }

    protected P getPresenter() {
        return presenter;
    }

    //交给别人实现
    public abstract P bindPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter != null) {
            presenter.detachView();
        }
    }
}
