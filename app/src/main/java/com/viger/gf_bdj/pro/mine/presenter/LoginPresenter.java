package com.viger.gf_bdj.pro.mine.presenter;

import android.content.Context;

import com.viger.gf_bdj.bean.UserBean;
import com.viger.gf_bdj.http.utils.HttpUtils;
import com.viger.gf_bdj.pro.base.presenter.BasePresenter;
import com.viger.gf_bdj.pro.mine.model.LoginModel;

/**
 * Created by Administrator on 2017/8/15.
 */

public class LoginPresenter extends BasePresenter<LoginModel> {

    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginModel bindModel() {
        return new LoginModel(getContext());
    }

    public void login(String username, String password, final OnUiThreadListener<UserBean> onUiThreadListener) {
        getModel().login(username, password, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if(result == null) {
                    onUiThreadListener.onResult(null);
                }else {
                    UserBean userBean = getGson().fromJson(result, UserBean.class);
                    onUiThreadListener.onResult(userBean);
                }

            }
        });
    }


}
