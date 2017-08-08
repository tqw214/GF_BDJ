package com.viger.gf_bdj.pro.base.model;

import android.content.Context;

import com.viger.gf_bdj.mvp.model.MvpModel;

/**
 * Created by Administrator on 2017/8/8.
 */

public abstract class BaseModel implements MvpModel {

    private Context context;

    public BaseModel(Context context) {
        this.context = context;
    }

    public String getServerUrl(){
        return "http://api.budejie.com";
    }


}
