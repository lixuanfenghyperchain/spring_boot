/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: FDFSUtil
 * Author:   lixuanfeng
 * Date:     2018/10/4 上午10:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.fdfs;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/10/4
 * @since 1.0.0
 */
public class FDFSUtil {


    //  public static String local_filename = FDFSUtil.class.getResource("avatar.png").toString();
    // public static String conf_filename = FDFSUtil.class.getResource("fdfs_client.conf").toString();

    public static void testUpload() {
        try {

            String conf_filename = System.getProperty("user.dir") + "/src/main/resources/fdfs_client.conf";
            String local_filename = System.getProperty("user.dir") + "/src/main/resources/avatar.png";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//          NameValuePair nvp = new NameValuePair("age", "18");
            NameValuePair nvp[] = new NameValuePair[]{
                    new NameValuePair("age", "18"),
                    new NameValuePair("sex", "male")
            };
            String fileIds[] = storageClient.upload_file(local_filename, "png", nvp);

            System.out.println(fileIds.length);
            System.out.println("组名：" + fileIds[0]);
            System.out.println("路径: " + fileIds[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void testDownload() {
        try {
            String conf_filename = System.getProperty("user.dir") + "/src/main/resources/fdfs_client.conf";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            byte[] b = storageClient.download_file("group1", "M00/00/00/wKjhj1u6y-KAXY1rAAALpjFX2pM663.png");
            System.out.println(b);
            IOUtils.write(b, new FileOutputStream("/Users/lixuanfeng/Desktop/hyperfaq/fdfs/" + UUID.randomUUID().toString() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testGetFileInfo() {
        try {
            String conf_filename = System.getProperty("user.dir") + "/src/main/resources/fdfs_client.conf";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            FileInfo fi = storageClient.get_file_info("group1", "M00/00/00/wKjhj1u6y-KAXY1rAAALpjFX2pM663.png");
            System.out.println(fi.getSourceIpAddr());
            System.out.println(fi.getFileSize());
            System.out.println(fi.getCreateTimestamp());
            System.out.println(fi.getCrc32());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void testGetFileMate() {
        try {
            String conf_filename = System.getProperty("user.dir") + "/src/main/resources/fdfs_client.conf";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);
            NameValuePair nvps[] = storageClient.get_metadata("group1", "M00/00/00/wKjhj1u6y-KAXY1rAAALpjFX2pM663.png");
            for (NameValuePair nvp : nvps) {
                System.out.println(nvp.getName() + ":" + nvp.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testDelete() {
        try {
            String conf_filename = System.getProperty("user.dir") + "/src/main/resources/fdfs_client.conf";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);
            int i = storageClient.delete_file("group1", "M00/00/00/wKjhj1u6y-KAXY1rAAALpjFX2pM663.png");
            System.out.println(i == 0 ? "删除成功" : "删除失败:" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
          testUpload();
        //  testDownload();
//        testGetFileInfo();
//        testGetFileMate();
    }
}