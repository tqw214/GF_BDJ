package com.viger.gf_bdj.pro.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.mvp.presenter.impl.MvpBasePresenter;
import com.viger.gf_bdj.pro.base.view.BaseActivity;
import com.viger.gf_bdj.utils.ToastUtil;

/**
 * Created by Administrator on 2017/8/14.
 */

public class LoginActivity extends BaseActivity {

    private Button bt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast(LoginActivity.this, "登录");

            }
        });
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        return null;
    }


}
