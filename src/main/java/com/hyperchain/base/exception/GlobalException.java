/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: GlobalException
 * Author:   lixuanfeng
 * Date:     2019/6/13 上午11:03
 * Description: 全局异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.base.exception;

import com.hyperchain.base.response.BaseResponse;
import com.hyperchain.base.response.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 〈一句话功能简述〉<br>
 * 〈全局异常〉
 *
 * @author lixuanfeng
 * @create 2019/6/13
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalException {
    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public BaseResponse handleBusinessException(BusinessException be) {
        logger.warn(be.getMsg());
        BaseResponse fail = BaseResponse.fail(be.getErrorCode(), be.getMsg());
        return fail;
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponse Exception(Exception e) {
        logger.error("系统异常", e);
        BaseResponse fail = BaseResponse.fail(ResponseCode.DEFAULT_FAIL);
        return fail;
    }
}