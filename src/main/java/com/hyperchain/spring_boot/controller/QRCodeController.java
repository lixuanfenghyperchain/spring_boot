/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: QRCodeController
 * Author:   lixuanfeng
 * Date:     2018/8/13 下午3:38
 * Description: 生成二维码controlelr
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.hyperchain.spring_boot.vo.BaseResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈生成二维码controlelr〉
 *
 * @author lixuanfeng
 * @create 2018/8/13
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/v1/QRCodeController")
public class QRCodeController {


    /**
     * 生成二维码方法
     *
     * @param url  访问链接
     * @param resp response对象
     * @throws Exception 抛出异常
     */
    public void getQrcode(String url, HttpServletResponse resp) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = resp.getOutputStream();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bm = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 300, 300);
            MatrixToImageWriter.writeToStream(bm, "png", stream);
        } catch (WriterException e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }

    }

    /**
     * 生成二维码
     *
     * @param url      url
     * @param response response对象
     */
    @RequestMapping(value = "/getEquipmentQrcode", method = RequestMethod.GET)
    public void getEquipmentQrcode(String url, HttpServletResponse response) {
        BaseResult baseResult=new BaseResult();
        if (StringUtils.isEmpty(url)) {
            //生成二维码
            url = "https://www.baidu.com/";
        }
        try {
            getQrcode(url, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}