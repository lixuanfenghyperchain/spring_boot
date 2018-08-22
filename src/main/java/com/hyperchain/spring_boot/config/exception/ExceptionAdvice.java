/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: ExceptionAdvice
 * Author:   lixuanfeng
 * Date:     2018/7/24 下午6:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.exception;

import com.hyperchain.spring_boot.vo.BaseResult;
import com.hyperchain.spring_boot.vo.Code;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * 统一校验异常处理
 *
 * @author lixuanfeng
 * @create 2018/7/24
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionAdvice {
    /**
     * 拦截捕捉自定义异常 ConstraintViolationException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Map constraintViolationExceptionHandler(ConstraintViolationException ex) {
        Map map = new HashMap();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }
        map.put("status", 1);
        map.put("msg", msgList);
        return map;
    }

    //    @ResponseBody
//    @ExceptionHandler(BindException.class)
//    public BaseResult validExceptionHandler(BindException e) {
//        BaseResult baseResult = new BaseResult();
//        BindingResult result = e.getBindingResult();
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            Map<String, String> errMap = new LinkedHashMap();
//            for (FieldError fieldError : fieldErrors) {
//                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            baseResult.setData(errMap);
//            baseResult.setCode(Code.RETURN_FALSE.getCode());
//            baseResult.setMessage(Code.RETURN_FALSE.getMsg());
//        }
//        return baseResult;
//    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult MethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request, HttpServletResponse response) {
        BaseResult baseResult = new BaseResult();
        BindingResult result = ex.getBindingResult();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String, String> errMap = new LinkedHashMap();
            for (FieldError fieldError : fieldErrors) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//                System.out.println();
            }
            baseResult.setData(errMap);
            baseResult.setCode(Code.RETURN_FALSE.getCode());
            baseResult.setMessage(Code.RETURN_FALSE.getMsg());
        }
        return baseResult;
    }

}
