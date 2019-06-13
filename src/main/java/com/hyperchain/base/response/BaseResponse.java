/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: BaseResponse
 * Author:   lixuanfeng
 * Date:     2019/6/13 上午10:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.base.response;

import java.io.Closeable;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/13
 * @since 1.0.0
 */
public class BaseResponse<T> implements Closeable {
    private String code;
    private String message;
    private T data;


    private BaseResponse() {
    }

    public static BaseResponse success(ResponseCode code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code.getCode());
        baseResponse.setMessage(code.getMsg());
        return baseResponse;

    }

    public static <T> BaseResponse success(ResponseCode code, T data) {
        BaseResponse baseResponse = success(code);
        baseResponse.setData(data);
        return baseResponse;
    }


    public static <T> BaseResponse success(String code, String msg, T data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMessage(msg);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static BaseResponse fail(ResponseCode code) {
        return success(code);
    }

    public static BaseResponse fail(String code, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMessage(msg);
        baseResponse.setData(null);
        return baseResponse;
    }

    @Override
    public void close() throws IOException {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}