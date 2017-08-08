package com.viger.gf_bdj.http.impl;

import com.viger.gf_bdj.http.IHttpCommand;
import com.viger.gf_bdj.http.IRequestParam;
import com.viger.gf_bdj.http.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/7.
 */

public class SystemHttpCommand implements IHttpCommand<HashMap<String, Object>> {

    @Override
    public String execute(String url, IRequestParam<HashMap<String, Object>> requestParam) {
        try {
            return HttpUtils.post(url, requestParam.getRequestParam());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
