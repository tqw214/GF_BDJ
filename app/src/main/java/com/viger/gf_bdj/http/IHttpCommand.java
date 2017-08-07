package com.viger.gf_bdj.http;

/**
 * Created by Administrator on 2017/8/7.
 */

public interface IHttpCommand<T> {

    public String execute(String url, IRequestParam<T> requestParam);

}
