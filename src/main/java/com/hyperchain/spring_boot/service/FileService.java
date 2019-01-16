package com.hyperchain.spring_boot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
    //文件上传
    String uploadFile(MultipartFile multipartFile, HttpServletRequest request);

}
