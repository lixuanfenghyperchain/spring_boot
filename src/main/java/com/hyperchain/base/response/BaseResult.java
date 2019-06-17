/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: BaseResult
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
public class BaseResult<T> implements Closeable {
    private Boolean isSuccess;
    private String code;
    private String message;
    private T data;


    private BaseResult() {
    }

    public static BaseResult success(ResultCode code) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(code.getSuccess());
        baseResult.setCode(code.getCode());
        baseResult.setMessage(code.getMsg());
        return baseResult;

    }

    public static <T> BaseResult success(ResultCode code, T data) {
        BaseResult baseResult = success(code);
        baseResult.setData(data);
        return baseResult;
    }


    public static <T> BaseResult success(Boolean isSuccess, String code, String msg, T data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(isSuccess);
        baseResult.setCode(code);
        baseResult.setMessage(msg);
        baseResult.setData(data);
        return baseResult;
    }

    public static BaseResult fail(ResultCode code) {
        return success(code);
    }

    public static BaseResult fail(Boolean isSuccess, String code, String msg) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(isSuccess);
        baseResult.setCode(code);
        baseResult.setMessage(msg);
        baseResult.setData(null);
        return baseResult;
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

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}