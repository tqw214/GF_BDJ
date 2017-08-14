package com.viger.gf_bdj.pro.essence.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.viger.gf_bdj.R;
import com.viger.gf_bdj.bean.PostsListBean;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.pro.base.presenter.BasePresenter;
import com.viger.gf_bdj.pro.base.view.BaseFragment;
import com.viger.gf_bdj.pro.essence.presenter.EssenceVideoPresenter;
import com.viger.gf_bdj.pro.essence.view.adapter.EssenceVideoAdapter;
import com.viger.gf_bdj.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class EssenceVideoFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;
    private EssenceVideoPresenter presenter;
    private XRefreshView xRefreshView;
    private RecyclerView recyclerView;
    private EssenceVideoAdapter essenceVideoAdapter;
    public List<PostsListBean.PostList> postLists;

    public void setType(int mType) {
        this.mType = mType;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        presenter = new EssenceVideoPresenter(getContext());
        return presenter;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    protected void initContentView(View viewContent) {
        postLists = new ArrayList<PostsListBean.PostList>();

        //设置下拉刷新控件
        xRefreshView = viewContent.findViewById(R.id.xrefreshview);
        xRefreshView.setPullRefreshEnable(true);// 设置是否可以下拉刷新
        xRefreshView.setPullLoadEnable(true);// 设置是否可以上拉加载
        xRefreshView.setPinnedTime(500);// 设置刷新完成以后，headerview固定的时间
        xRefreshView.setAutoLoadMore(true);// 设置支持自动刷新
        //xRefreshView.setPreLoadCount(2); //设置静默加载时提前加载的item个数

        recyclerView = viewContent.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        essenceVideoAdapter = new EssenceVideoAdapter(postLists, getContext());
        recyclerView.setAdapter(essenceVideoAdapter);
        essenceVideoAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getContext()));

        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                loadData(true);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                loadData(false);
            }
        });
    }

    @Override
    protected void initData() {
        loadData(true);
    }

    private void loadData(final boolean isDownRefresh) {
        presenter.getEssenceList(mType, isDownRefresh, new BasePresenter.OnUiThreadListener<List<PostsListBean.PostList>>() {
            @Override
            public void onResult(List<PostsListBean.PostList> result) {
                if(isDownRefresh) {
                    xRefreshView.stopRefresh();
                }else {
                    xRefreshView.stopLoadMore();
                }
                if(result == null) {
                    ToastUtil.showToast(getContext(), "类型："+mType+" 加载失败");
                }else {
                    ToastUtil.showToast(getContext(), "类型："+mType+" 加载成功");
                    //刷新ui
                    if(isDownRefresh) {
                        postLists.clear();
                    }
                    postLists.addAll(result);
                    essenceVideoAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
