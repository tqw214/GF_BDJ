package com.viger.gf_bdj.pro.essence.model;

import android.content.Context;
import android.text.TextUtils;

import com.viger.gf_bdj.http.impl.RequestParam;
import com.viger.gf_bdj.http.impl.SystemHttpCommand;
import com.viger.gf_bdj.http.utils.HttpTask;
import com.viger.gf_bdj.http.utils.HttpUtils;
import com.viger.gf_bdj.pro.base.model.BaseModel;

/**
 * Created by Administrator on 2017/8/8.
 */

public class EssenceVideoModel extends BaseModel {

    public EssenceVideoModel(Context context) {
        super(context);
    }

    private String getUrl() {
        return getServerUrl().concat("/api/api_open.php");
    }

    /**
     *
     * @param type 数据类型(例如图片、视频、音频等)
     * @param page 分页
     * @param maxtime 用于加载更多
     * @param listener
     */
    public void getEssenceList(int type, int page, String maxtime, HttpUtils.OnHttpResultListener listener) {
        RequestParam requestParam = new RequestParam();
        requestParam.put("a", "list");
        requestParam.put("c", "data");
        if(!TextUtils.isEmpty(maxtime)) {
            requestParam.put("maxtime", maxtime);
        }
        requestParam.put("type", type);
        requestParam.put("page", page);
        HttpTask httpTask = new HttpTask(
                getUrl(),
                requestParam,
                new SystemHttpCommand(),
                listener);
        httpTask.execute();
    }

}
