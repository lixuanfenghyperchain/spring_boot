/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: FileService
 * Author:   lixuanfeng
 * Date:     2019/6/17 下午2:38
 * Description: 文件上传下载
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.controller;

import com.hyperchain.base.response.BaseResult;
import com.hyperchain.base.response.ResultCode;
import com.hyperchain.service.QiniuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 〈一句话功能简述〉<br>
 * 〈文件上传下载〉
 *
 * @author lixuanfeng
 * @create 2019/6/17
 * @since 1.0.0
 */

@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileController {


    @Autowired
    private QiniuService qiniuService;

    @RequestMapping(value = "upload.do")
    public BaseResult upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return BaseResult.fail(ResultCode.FILE_EMPTY);
        }
        try {
            //获取文件的字节组数
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名：" + fileName);
            //使用七牛云进行文件的存储
            String fileUrl = qiniuService.put64image(bytes, fileName);
            log.info(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return BaseResult.success(ResultCode.SUCCESS);
    }
}