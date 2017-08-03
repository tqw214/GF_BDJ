package com.viger.gf_bdj.pro.essence.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.base.view.BaseFragment;
import com.viger.gf_bdj.pro.essence.view.navigation.EssenceNavigationBuilder;

/**
 * Created by Administrator on 2017/8/1.
 */

public class EssenceFragment extends BaseFragment {

    @Override
    protected int getContentView() {
        return R.layout.fragment_essence;
    }

    @Override
    protected void initContentView(View viewContent) {
        initToolBar(viewContent);
    }

    @Override
    protected void initData() {

    }

    private void initToolBar(View view) {
        EssenceNavigationBuilder builder = new EssenceNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_essence_btn_selector)
                .setRightIcon(R.drawable.main_essence_btn_more_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "EssenceLeftIconOnClick", Toast.LENGTH_SHORT).show();
                    }
                })
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "EssenceRightIconOnClick", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.createAndBind((ViewGroup)view);
        builder.setImageViewStyle(R.id.iv_left, R.drawable.main_essence_btn_selector,
                builder.getLeftIconOnClickListener());
        builder.setImageViewStyle(R.id.iv_right, R.drawable.main_essence_btn_more_selector,
                builder.getRightIconOnClickListener());
    }



}
