/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: QiniuService
 * Author:   lixuanfeng
 * Date:     2019/6/17 下午2:05
 * Description: 七牛云文件上传
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.service;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 〈一句话功能简述〉<br>
 * 〈七牛云文件上传〉
 *
 * @author lixuanfeng
 * @create 2019/6/17
 * @since 1.0.0
 */
@Component
@Slf4j
public class QiniuService {


    @Value("${qiniu.cloud.access.Key}")
    private String accessKey;

    @Value("${qiniu.cloud.secret.Key}")
    private String secretKey;

    @Value("${qiniu.cloud.bucket}")
    private String bucket;

    @Value("${qiniu.cloud.domain}")
    private String domain;


    private String getUpToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }

    //base64方式上传
    public String put64image(byte[] base64, String fileName) throws Exception {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String upToken = getUpToken();
        uploadManager.put(base64, fileName, upToken);
        //如果不需要添加图片样式，使用以下方式
        //return DOMAIN + key;
        return domain + fileName;
    }

    public String downLoadFile(String url) throws URISyntaxException {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        URI ur = new URI(url);
        File file = new File(url);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            String fileName = url.substring(url.lastIndexOf("/")+1);
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}