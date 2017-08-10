package com.viger.gf_bdj.pro.essence.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.viger.gf_bdj.bean.PostsListBean;
import com.viger.gf_bdj.http.utils.HttpUtils;
import com.viger.gf_bdj.pro.base.presenter.BasePresenter;
import com.viger.gf_bdj.pro.essence.model.EssenceVideoModel;

import java.util.List;

/**MVP中的p层，处理数据返回后的业务逻辑
 * l例如数据解析等
 * Created by Administrator on 2017/8/10.
 */

public class EssenceVideoPresenter extends BasePresenter {

    private EssenceVideoModel essenceVideoModel;
    private int page = 0;
    private String maxtime = null;

    public EssenceVideoPresenter(Context context) {
        super(context);
        essenceVideoModel = new EssenceVideoModel(context);
    }

    public void getEssenceList(int type, final boolean isDownRefresh,
                               final OnUiThreadListener<List<PostsListBean.PostList>> onUiThreadListener) {
        if(isDownRefresh) {
            //如果是下拉刷新，就清空数据
            maxtime = null;
        }
        essenceVideoModel.getEssenceList(type, page, maxtime, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if(TextUtils.isEmpty(result)) {
                    onUiThreadListener.onResult(null);
                }else {
                    final PostsListBean postListBean = getGson().fromJson(result, PostsListBean.class);
                    if(postListBean != null && postListBean.getInfo() != null) {
                        //保存状态，为了下拉加载
                        maxtime = postListBean.getInfo().getMaxtime();
                    }
                    if(isDownRefresh) {
                        page = 0;
                    }else {
                        page++;
                    }
                    onUiThreadListener.onResult(postListBean.getList());
                }
            }
        });
    }


}
