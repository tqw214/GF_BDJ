package com.viger.gf_bdj.pro.base.view.navigation;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/8/2.
 * 构建ToolBar----Builder设计模式
 */

public interface NavigationBuilder {

    public NavigationBuilder setTitle(String title);

    public NavigationBuilder setTitle(int title);

    public NavigationBuilder setTitleIcon(int iconRes);

    public NavigationBuilder setLeftIcon(int iconRes);

    public NavigationBuilder setRightIcon(int iconRes);

    public NavigationBuilder setLeftIconOnClickListener(View.OnClickListener listener);

    public NavigationBuilder setRightIconOnClickListener(View.OnClickListener listener);

    public void createAndBind(ViewGroup parent);

}
