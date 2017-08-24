package com.viger.gitdemo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/8/24.
 */

public class StreamTool {

    /**
     * 从输入流中读取数据
     */
    public static byte[] readInputStream(InputStream inputStream) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,len);
        }
        byte[] data = outputStream.toByteArray();
        outputStream.close();
        inputStream.close();
        return data;
    }

}
