/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: FileServiceImpl
 * Author:   lixuanfeng
 * Date:     2018/8/31 下午8:06
 * Description: 文件上传实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.service.impl;

import com.hyperchain.spring_boot.business.constant.BaseConstant;
import com.hyperchain.spring_boot.service.FileService;
import com.hyperchain.spring_boot.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈文件上传实现类〉
 *
 * @author lixuanfeng
 * @create 2018/8/31
 * @since 1.0.0
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${file.uploadUrl}")
    private String file_uploadUrl;

    @Override
    public String uploadFile(MultipartFile multipartFile, HttpServletRequest request) {

        if (multipartFile == null) {
            return "";
        }
        StringBuffer pic_path = new StringBuffer(file_uploadUrl + File.separator + BaseConstant.FOLDER_UPLOAD + File.separator);
        File fileDir = new File(pic_path.toString());
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //图片的原始名称
        String originFileName = multipartFile.getOriginalFilename();
        //新的图片名称
        String newFileName = null;
        String fileFormat = null;

        if (multipartFile != null && originFileName != null && originFileName.length() > 0) {
            //文件名加上时间戳  然后再用md5算法 哈希成字符串
            newFileName = DigestUtils.md5Hex(originFileName.substring(0, originFileName.lastIndexOf('.')).toString() + CommonUtil.getToDayStrAsFileName());
            //文件格式
            fileFormat = originFileName.substring(originFileName.lastIndexOf('.'));
            File file = new File(pic_path.append(newFileName).append(fileFormat).toString());
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                log.error("文件上传失败！");
            }
            //这里返回映射路径即可
            return file.getPath().substring(file.getPath().lastIndexOf(BaseConstant.FOLDER_UPLOAD));
        } else {
            return "";
        }

    }
}