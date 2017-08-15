package com.viger.gf_bdj.pro.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.bean.UserBean;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.pro.base.presenter.BasePresenter;
import com.viger.gf_bdj.pro.base.view.BaseActivity;
import com.viger.gf_bdj.pro.mine.presenter.LoginPresenter;
import com.viger.gf_bdj.utils.ToastUtil;

/**
 * Created by Administrator on 2017/8/14.
 */

public class LoginActivity extends BaseActivity {

    private Button bt_login;
    private LoginPresenter loginPresenter;
    private EditText et_phone, et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToastUtil.showToast(LoginActivity.this, "登录");
                String phone = et_phone.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if(TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
                    ToastUtil.showToast(LoginActivity.this, "手机号或密码为空");
                    return;
                }
                ToastUtil.showToast(LoginActivity.this, "开始登录---");
                loginPresenter.login(phone, password, new BasePresenter.OnUiThreadListener<UserBean>() {
                    @Override
                    public void onResult(UserBean result) {
                        ToastUtil.showToast(LoginActivity.this, result.getUsername()+",欢迎登陆!");
                        finish();
                    }
                });
            }
        });
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }


}
