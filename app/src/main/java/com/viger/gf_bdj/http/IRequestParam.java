package com.viger.gf_bdj.http;

/**
 * Created by Administrator on 2017/8/7.
 */

public interface IRequestParam<T> {

    public void put(String key, Object value);

    public Object get(String key);

    public int size();

    public T getRequestParam();

}
