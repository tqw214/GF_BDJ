package com.viger.gf_bdj.pro.mine.model;

import android.content.Context;

import com.viger.gf_bdj.http.utils.HttpUtils;
import com.viger.gf_bdj.pro.base.model.BaseModel;

/**
 * Created by Administrator on 2017/8/15.
 */

public class LoginModel extends BaseModel {

    public LoginModel(Context context) {
        super(context);
    }

    public void login(String username, String password, HttpUtils.OnHttpResultListener onHttpResultListener) {
//        RequestParam requestParam = new RequestParam();
//        requestParam.put("username", username);
//        requestParam.put("password", password);
//        HttpTask httpTask = new HttpTask("url", requestParam, new SystemHttpCommand(), onHttpResultListener);
//        httpTask.execute();
        if("111".equals(username) && "123".equals(password)) {
            String json = "{\"username\":\"aaa\",\"password\":\"aaa\",\"sex\":\"男\",\"content\":\"内容\"}";
            onHttpResultListener.onResult(json);
        }
    }

}
