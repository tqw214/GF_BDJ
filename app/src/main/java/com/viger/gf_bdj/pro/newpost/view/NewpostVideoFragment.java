package com.viger.gf_bdj.pro.newpost.view;

import android.view.View;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.BaseFragment;

/**
 * Created by Administrator on 2017/8/1.
 */

public class NewpostVideoFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;

    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }



    @Override
    protected int getContentView() {
        return R.layout.fragment_newpost_video;
    }

    @Override
    protected void initContentView(View viewContent) {

    }

    @Override
    protected void initData() {

    }
}
