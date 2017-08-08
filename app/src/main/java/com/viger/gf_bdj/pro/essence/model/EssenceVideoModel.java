package com.viger.gf_bdj.pro.essence.model;

import android.content.Context;
import com.viger.gf_bdj.http.impl.RequestParam;
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

    public void getEssenceList() {
        RequestParam requestParam = new RequestParam();
        requestParam.put("a", "list");
        requestParam.put("c", "data");
    }

}
