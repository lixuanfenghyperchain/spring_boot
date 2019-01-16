/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: FileController
 * Author:   lixuanfeng
 * Date:     2018/8/31 下午4:44
 * Description: 文件上传下载controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import com.hyperchain.spring_boot.service.FileService;
import com.hyperchain.spring_boot.vo.BaseResult;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈文件上传下载controller〉
 *
 * @author lixuanfeng
 * @create 2018/8/31
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileController {
    //文件上传路径
    @Value("${file.uploadUrl}")
    private String uploadUrl;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    BaseResult fileUpload(@ApiParam("文件") @RequestParam(required = false) MultipartFile multipartFile,
                          HttpServletRequest request) {
        BaseResult baseResult = new BaseResult();
//        String originalFilename = multipartFile.getOriginalFilename();
////文件名加上时间戳，然后用md5算法，哈希成字符串
//        String newFileName = DigestUtils.md5Hex(originalFilename.substring(0, originalFilename.lastIndexOf(".")) + CommonUtil.getToDayStrAsFileName());
//        String fileFormat = originalFilename.substring(originalFilename.lastIndexOf("."));
//        File file = new File(uploadUrl + File.separator + newFileName + fileFormat);
//        if (!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//        try {
//            multipartFile.transferTo(file);
//        } catch (IOException e) {
//            log.error("文件上传失败");
//        }

        String filePath = fileService.uploadFile(multipartFile, request);

        baseResult.setMessage("文件上传成功！");
        baseResult.setCode(0);
        Map map=new HashMap();
        map.put("filePath", filePath);
        baseResult.setData(map);
        System.out.println("OK");
        return baseResult;
    }

    @RequestMapping(value = "/getString", method = RequestMethod.POST)
    BaseResult getString() {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(1);
        baseResult.setMessage("ok");
        Map map = new HashMap();
        map.put("name", "fda");
        return baseResult;
    }

    @PostMapping("/uploadFiles")
    @ResponseBody
    public String uploadFiles(HttpServletRequest request) throws IOException {
        File savePath = new File(request.getSession().getServletContext().getRealPath("/upload/"));
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File saveFile = new File(savePath, file.getOriginalFilename());
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    if (stream != null) {
                        stream.close();
                        stream = null;
                    }
                    return "第 " + i + " 个文件上传有错误" + e.getMessage();
                }
            } else {
                return "第 " + i + " 个文件为空";
            }
        }
        return "所有文件上传成功";
    }
}