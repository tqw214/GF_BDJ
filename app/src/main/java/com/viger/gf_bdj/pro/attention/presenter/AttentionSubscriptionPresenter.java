package com.viger.gf_bdj.pro.attention.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.viger.gf_bdj.bean.AttentionSubscriptionBean;
import com.viger.gf_bdj.http.utils.HttpUtils;
import com.viger.gf_bdj.pro.attention.model.AttentionSubscriptionModel;
import com.viger.gf_bdj.pro.base.model.BaseModel;
import com.viger.gf_bdj.pro.base.presenter.BasePresenter;
import com.viger.gf_bdj.utils.GsonUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class AttentionSubscriptionPresenter extends BasePresenter {

    private AttentionSubscriptionModel model = null;

    public AttentionSubscriptionPresenter(Context context) {
        super(context);
        model = new AttentionSubscriptionModel(context);
    }

    @Override
    public BaseModel bindModel() {
        return new AttentionSubscriptionModel(getContext());
    }

    public void getAttentionSubscriptionList(int type, final OnUiThreadListener<List<AttentionSubscriptionBean>> onUIThreadListener) {
        model.getAttentionSubscriptionList(type, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)){
                    onUIThreadListener.onResult(null);
                }else {
                    List<AttentionSubscriptionBean> list = GsonUtils.getList(result,AttentionSubscriptionBean.class);
                    onUIThreadListener.onResult(list);
                }
            }
        });

    }

}
