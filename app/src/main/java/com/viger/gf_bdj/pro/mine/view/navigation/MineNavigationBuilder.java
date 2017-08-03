package com.viger.gf_bdj.pro.mine.view.navigation;

import android.content.Context;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * Created by Administrator on 2017/8/2.
 */

public class MineNavigationBuilder extends NavigationBuilderAdapter {

    public MineNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_mine_layout;
    }
}
