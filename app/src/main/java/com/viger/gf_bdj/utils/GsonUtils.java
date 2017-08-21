package com.viger.gf_bdj.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**a
 * Created by Administrator on 2017/8/16.
 */

public class GsonUtils<T> {

    public ArrayList<T> parseArray(String result, Class<?> clazz) {
        ArrayList<T> list = new ArrayList<T>();
        return null;
    }

    public static <T> List<T> getList(String result, Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(result);
        Iterator it = el.getAsJsonArray().iterator();
        while(it.hasNext()) {
            JsonElement e = (JsonElement) it.next();
            T model = gson.fromJson(e, clazz);
            list.add(model);
        }
        return list;
    }

}
