/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: StringConstant
 * Author:   lixuanfeng
 * Date:     2019/8/1 上午10:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.schedul;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/8/1
 * @since 1.0.0
 */
public class StringConstant {
    public static final String urlBase = "https://blog.csdn.net/qq_33029793/article/details/";

    public static List str() {
        RandomAccessFile randomAccessFile;
        List<String> artNum = new LinkedList();
        try {
            randomAccessFile = new RandomAccessFile("CSDNArt.txt", "r");
            String constant;
            while ((constant = randomAccessFile.readLine()) != null) {
                artNum.add(constant);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artNum;
    }


    public static void main(String[] args) {
        str();
    }
}