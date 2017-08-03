package com.viger.gf_bdj.pro.newpost.view.navigation;

import android.content.Context;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Administrator on 2017/8/2.
 */

public class NewpostNavigationBuilder extends NavigationBuilderAdapter {

    public NewpostNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }
}
