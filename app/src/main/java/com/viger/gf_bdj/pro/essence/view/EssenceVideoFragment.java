package com.viger.gf_bdj.pro.essence.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andview.refreshview.XRefreshView;
import com.viger.gf_bdj.R;
import com.viger.gf_bdj.bean.PostsListBean;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.pro.base.presenter.BasePresenter;
import com.viger.gf_bdj.pro.base.view.BaseFragment;
import com.viger.gf_bdj.pro.essence.presenter.EssenceVideoPresenter;
import com.viger.gf_bdj.utils.ToastUtil;

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
        //初始化
        xRefreshView = viewContent.findViewById(R.id.xrefreshview);
        recyclerView = viewContent.findViewById(R.id.recyclerview);


    }

    @Override
    protected void initData() {
        loadData(true);
    }

    private void loadData(boolean isDownRefresh) {
        presenter.getEssenceList(mType, isDownRefresh, new BasePresenter.OnUiThreadListener<List<PostsListBean.PostList>>() {
            @Override
            public void onResult(List<PostsListBean.PostList> result) {
                if(result == null) {
                    ToastUtil.showToast(getContext(), "类型："+mType+" 加载失败");
                }else {
                    ToastUtil.showToast(getContext(), "类型："+mType+" 加载成功");
                }
            }
        });
    }
}
