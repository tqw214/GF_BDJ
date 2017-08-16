package com.viger.gf_bdj.pro.attention.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.attention.view.adapter.AttentionAdapter;
import com.viger.gf_bdj.pro.attention.view.navigation.AttentionNavigationBuilder;
import com.viger.gf_bdj.pro.base.view.BaseFragment;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/1.
 * attention
 */

public class AttentionFragment extends BaseFragment {

    @Override
    protected int getContentView() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void initContentView(View viewContent) {
        ViewPager vp_attention = (ViewPager) viewContent.findViewById(R.id.vp_attention);
        String[] titles = getResources().getStringArray(R.array.attention_video_tab);
        AttentionAdapter adapter =
                new AttentionAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_attention.setAdapter(adapter);
        initToolBar(viewContent,vp_attention);
    }

    @Override
    protected void initData() {

    }

    private void initToolBar(View contentView, ViewPager viewPager){
        AttentionNavigationBuilder builder = new AttentionNavigationBuilder(getContext());
        builder.setUpWithViewPager(viewPager)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        ViewGroup parentView = (ViewGroup) contentView;
        builder.createAndBind(parentView);
    }


}
