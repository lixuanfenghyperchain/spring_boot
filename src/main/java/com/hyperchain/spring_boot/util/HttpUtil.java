/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: HttpUtil
 * Author:   lixuanfeng
 * Date:     2019/8/1 上午10:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/8/1
 * @since 1.0.0
 */
public class HttpUtil {


    public static void doGet(String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            String s = EntityUtils.toString(entity, Consts.UTF_8);
            System.out.println(s);
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "https://blog.csdn.net/qq_33029793/article/details/89945847";
        doGet(url);
    }

}