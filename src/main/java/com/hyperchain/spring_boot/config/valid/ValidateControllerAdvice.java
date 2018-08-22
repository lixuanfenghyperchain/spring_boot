///**
// * Copyright (C), 2016-2018, 趣链科技有限有限公司
// * FileName: ValidateControllerAdvice
// * Author:   lixuanfeng
// * Date:     2018/7/24 下午5:21
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.hyperchain.spring_boot.config.valid;
//
//
//import com.hyperchain.spring_boot.vo.BaseResult;
//import com.hyperchain.spring_boot.vo.Code;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 统一处理验证失败异常
// * 使用此切片后@Valid注解验证的参数后不用再加Errors或Bindingesult
// */
//@ControllerAdvice
//@Slf4j
//public class ValidateControllerAdvice {
//
//
//    //    @ExceptionHandler(BindException.class)
////    public String validExceptionHandler(BindException e, WebRequest request, HttpServletResponse response) {
////
////        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
////        for (FieldError error : fieldErrors) {
////            log.error(error.getField() + ":" + error.getDefaultMessage());
////        }
////        request.setAttribute("fieldErrors", fieldErrors, WebRequest.SCOPE_REQUEST);
////        if (AjaxUtils.isAjaxRequest(request)) {
////            Map<String, Object> attrMap = new HashMap<String, Object>();
////            String[] atrrNames = request.getAttributeNames(WebRequest.SCOPE_REQUEST);
////            for (String attr : atrrNames) {
////                Object value = request.getAttribute(attr, WebRequest.SCOPE_REQUEST);
////                if (value instanceof Serializable) {
////                    attrMap.put(attr, value);
////                }
////
////            }
////            AjaxUtils.writeJson(attrMap, response);
////            return null;
////        }
////
////        return "/validError";
////    }
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
//}
//
