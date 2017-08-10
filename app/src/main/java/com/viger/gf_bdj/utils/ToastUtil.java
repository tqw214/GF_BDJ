package com.viger.gf_bdj.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/10.
 */

public class ToastUtil {

    public static void showToast(Context ctx,String message) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
    }

}
