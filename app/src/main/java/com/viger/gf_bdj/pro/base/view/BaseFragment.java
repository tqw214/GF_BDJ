package com.viger.gf_bdj.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.mvp.view.impl.MvpFragment;

/**
 * Created by Administrator on 2017/8/1.
 */

public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment<P> {
    //我们自己的fragment需要缓存视图
    private View viewContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(viewContent == null) {
            viewContent = inflater.inflate(getContentView(), container, false);
            initContentView(viewContent);
        }
        //判断fragment对应的activity是否存在这个视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if(parent != null) {
            //如果存在就移除，重新添加,这样的方式就可以缓存视图
            parent.removeView(viewContent);
        }
        return viewContent;
    }

    @Override
    public P bindPresenter() {
        return null;
    }

    protected abstract int getContentView();
    protected abstract void initContentView(View viewContent);

}
