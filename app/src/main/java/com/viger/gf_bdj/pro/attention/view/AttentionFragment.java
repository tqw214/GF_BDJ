package com.viger.gf_bdj.pro.attention.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.pro.attention.view.adapter.AttentionAdapter;
import com.viger.gf_bdj.pro.base.view.BaseFragment;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/1.
 */

public class AttentionFragment extends BaseFragment {

    private TabLayout tab_layout;
    private ViewPager view_pager;

    @Override
    protected int getContentView() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void initContentView(View viewContent) {
        tab_layout = getContentLayout().findViewById(R.id.tab_layout);
        view_pager = getContentLayout().findViewById(R.id.view_pager);
    }

    @Override
    protected void initData() {
        String[] titles = getResources().getStringArray(R.array.attention_video_tab);
        AttentionAdapter adapter = new AttentionAdapter(getFragmentManager(), Arrays.asList(titles));
        view_pager.setAdapter(adapter);
        tab_layout.setupWithViewPager(view_pager);
    }


}
