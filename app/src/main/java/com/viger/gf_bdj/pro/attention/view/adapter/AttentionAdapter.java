package com.viger.gf_bdj.pro.attention.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.viger.gf_bdj.pro.essence.view.EssenceVideoFragment;

import java.util.List;


/**
 * Created by Dream on 16/5/27.
 * FragmengPagerAdapter 每个生成Fragment都保存在内存中，适用于数量较少时
 * FragmentStatePagerAdapter 适用于fragment数量较多，数据动态性较大
 */
public class AttentionAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;

    public AttentionAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        mTitles = titles;
    }

    /**
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        EssenceVideoFragment fragment = new EssenceVideoFragment();
        String[] title = mTitles.get(position).split(TAB_TAG);
        fragment.setType(Integer.parseInt(title[1]));
        fragment.setTitle(title[0]);
        return fragment;
    }


    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }
}
