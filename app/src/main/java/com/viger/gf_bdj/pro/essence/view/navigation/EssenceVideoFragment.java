package com.viger.gf_bdj.pro.essence.view.navigation;

import android.view.View;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.BaseFragment;

/**
 * Created by Administrator on 2017/8/3.
 */

public class EssenceVideoFragment extends BaseFragment {

    private int mType = 0;

    public void setmType(int mType) {
        this.mType = mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    private String mTitle;

    @Override
    protected int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    protected void initContentView(View viewContent) {

    }
}
