package com.viger.gf_bdj.pro.mine.view.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Administrator on 2017/8/16.
 */

public class LoginNavigationBuilder extends NavigationBuilderAdapter {

    private View.OnClickListener titleOnClickListener;

    public LoginNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_login_layout;
    }

    public LoginNavigationBuilder setTitleOnClickListener(View.OnClickListener titleOnClickListener) {
        this.titleOnClickListener = titleOnClickListener;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left, getLeftIconRes(),getLeftIconOnClickListener());
        setTitleTextView(R.id.tv_title, getTitle(), titleOnClickListener);
    }
}
