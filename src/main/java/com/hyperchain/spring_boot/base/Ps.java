/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Ps
 * Author:   lixuanfeng
 * Date:     2018/8/9 上午10:28
 * Description: 参数类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.base;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈参数类〉
 *
 * @author lixuanfeng
 * @create 2018/8/9
 * @since 1.0.0
 */
@Slf4j
@NoArgsConstructor
public class Ps {
    private List<Object> paramsList = new ArrayList<>();

    public void addString(String param) {
        this.paramsList.add(param);
    }

    public void addTimeStamp(String param) {
        this.paramsList.add(Timestamp.valueOf(param));
    }

    public void addTimeStamp(Date date) {
        this.paramsList.add(date);
    }

    public void addDate(Date date) {
        this.paramsList.add(date);
    }

    public void addDate(String date) {
        if (date != null && !"".equals(date)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                this.paramsList.add(format.parse(date));
            } catch (ParseException var4) {
                log.error("日期转换异常，原因：", var4);
            }
        } else {
            this.paramsList.add("");
        }

    }

    public List<Object> getParamsList() {
        return this.paramsList;
    }

    public void addFile(File file) {
        this.paramsList.add(file == null ? "" : file);
    }


}