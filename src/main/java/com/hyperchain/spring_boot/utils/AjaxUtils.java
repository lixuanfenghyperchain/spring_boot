/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: AjaxUtils
 * Author:   lixuanfeng
 * Date:     2018/7/24 下午5:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.utils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AjaxUtils {
    private static ObjectMapper mapper = new ObjectMapper();


    /**
     * 验证是否是ajax请求
     *
     * @param webRequest
     * @return
     */
    public static boolean isAjaxRequest(WebRequest webRequest) {
        String requestedWith = webRequest.getHeader("X-Requested-With");
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }

    public static boolean isAjaxUploadRequest(WebRequest webRequest) {
        return webRequest.getParameter("ajaxUpload") != null;
    }

    public static void writeJson(Object value, HttpServletResponse response) {
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = mapper.getFactory().createGenerator(response.getOutputStream(), JsonEncoding.UTF8);
            if (jsonGenerator != null) {
                jsonGenerator.writeObject(value);
            }
        } catch (IOException e) {
            log.error("dfa");
        }


    }

    private AjaxUtils() {
    }

}
