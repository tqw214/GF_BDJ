package com.viger.gf_bdj.pro.attention.model;

import android.content.Context;
import com.viger.gf_bdj.http.impl.RequestParam;
import com.viger.gf_bdj.http.impl.SystemHttpCommand;
import com.viger.gf_bdj.http.utils.HttpTask;
import com.viger.gf_bdj.http.utils.HttpUtils;
import com.viger.gf_bdj.pro.base.model.BaseModel;

/**
 * Created by Administrator on 2017/8/16.
 */

public class AttentionSubscriptionModel extends BaseModel {

    private static final String URL_STR = "/api/api_open.php";

    public AttentionSubscriptionModel(Context context) {
        super(context);
    }

    public void getAttentionSubscriptionList(int type, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        requestParam.put("a","tag_recommend");
        requestParam.put("action","sub");
        requestParam.put("c","topic");
        requestParam.put("type",type);

        HttpTask httpTask = new HttpTask(getServerUrl().concat(URL_STR),requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();

    }

}
