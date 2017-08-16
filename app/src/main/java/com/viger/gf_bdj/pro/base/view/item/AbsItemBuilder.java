package com.viger.gf_bdj.pro.base.view.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/8/16.
 */

public abstract class AbsItemBuilder implements ItemBuilder {

    private Context context;

    public AbsItemBuilder(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public abstract int getContentView();

    @Override
    public View buildAndBind(ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(getContentView(), parent, false);
        ViewGroup viewGroup = (ViewGroup) parent.getParent();
        if(viewGroup != null) {
            viewGroup.removeView(parent);
        }
        parent.addView(view);
        return view;
    }

}
