
package com.hyperchain.base;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Ps {
    private static final Log logger = LogFactory.getLog(Ps.class);
    private List<Object> paramsList = new ArrayList();

    public Ps() {
    }

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
                logger.error("日期转换异常，原因：", var4);
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
