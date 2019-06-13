/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: BusinessException
 * Author:   lixuanfeng
 * Date:     2019/6/13 上午10:31
 * Description: 业务异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.base.exception;

import com.hyperchain.base.response.ResponseCode;

/**
 * 〈一句话功能简述〉<br>
 * 〈业务异常〉
 *
 * @author lixuanfeng
 * @create 2019/6/13
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String msg;


    public BusinessException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.errorCode = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}