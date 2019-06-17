/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: MD5Util
 * Author:   lixuanfeng
 * Date:     2019/6/16 上午10:32
 * Description: MD5加密工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 〈一句话功能简述〉<br>
 * 〈MD5加密工具〉
 *
 * @author lixuanfeng
 * @create 2019/6/16
 * @since 1.0.0
 */
public class MD5Util {

    private MD5Util() {
    }

    public static String md5(String sourceStr) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(sourceStr.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("异常！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);//
        //
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}