package com.hyperchain.spring_boot.utils;


import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 日期,判空工具类
 */
public final class CommonUtil {

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }


    public static boolean checkEmail(String str) {
         String rule_email = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
      //  String rule_email = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(rule_email);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    //TODO
    public static boolean checkPhone(String str) {
        String rule_phone = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        if (str.startsWith("+86")) {
            str = str.substring(3);
        }
        //TODO 港澳台等国际号码
//        if (str.startsWith("")){
//            rule_phone="";
//        }

        Pattern p = Pattern.compile(rule_phone);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 数据格式化.
     *
     * @param pattern the pattern
     * @param
     * @return the string
     */
    public static String codeFormat(String pattern, Object value) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(value);
    }

    /**
     * 格式化时间.
     *
     * @param date the date
     * @return the string
     */
    public static String fomatDate(String date) {
        if (isEmpty(date)) return null;
        return date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
                + date.substring(6, 8);
    }


    /**
     * 将double数值格式化成指定格式的字串
     *
     * @param value
     * @param format
     * @return
     */
    public static Double formatCurrency2Double(Double value, String format) {
        if (isEmpty(format)) {
            format = "0.00";
        }
        DecimalFormat df = new DecimalFormat(format);
        String temp = df.format(value);
        ;
        return Double.valueOf(temp);
    }

    /**
     * 格式化时间.
     *
     * @param date the date
     * @return the string
     */
    public static String fomatLongDate(String date) {
        if (isEmpty(date)) return null;
        return date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
                + date.substring(6, 8) + " " + date.substring(8, 10) + ":"
                + date.substring(10, 12) + ":" + date.substring(12, 14);

    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getTodayString() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return f.format(c.getTime());
    }

    /**
     * 格式化时间.
     *
     * @param date the date
     * @return the string
     */
    public static String fomatDateTime2String(String date) {
        if (isEmpty(date)) return null;
        return date.replace("-", "").replace("T", "").replace(":", "")
                .replace(" ", "");
    }

    /**
     * 将时间字符串格式化成一个日期(java.util.Date)
     *
     * @param dateStr   要格式化的日期字符串，如"2014-06-15 12:30:12"
     * @param formatStr 格式化模板，如"yyyy-MM-dd HH:mm:ss"
     * @return the string
     */
    public static Date formatDateString2Date(String dateStr, String formatStr) {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    public static String getNowTimeStr() {
        Long temp = new Date().getTime();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(temp);
        return sf.format(date);
    }

    /**
     * 将时间字符串格式化成一个日期(java.util.Date)
     *
     * @param "2014-06-15 12:30:12"
     * @param formatStr   格式化模板，如"yyyy-MM-dd HH:mm:ss"
     * @return the string
     */
    public static String formatDate2String(Date date, String formatStr) {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        String result = null;
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将一个毫秒数时间转换为相应的时间格式
     *
     * @param longSecond
     * @return
     */
    public static String formateDateLongToString(long longSecond) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(longSecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(gc.getTime());
    }

    public static String formateDateLongToString(long longSecond, String formatPatten) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(longSecond);
        if (CommonUtil.isEmpty(formatPatten)) {
            formatPatten = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatPatten);
        return format.format(gc.getTime());
    }

    /**
     * 格式化金额.
     *
     * @param value the value
     * @return the string
     */
    public static String formatCurrency2String(Long value) {
        if (value == null || "0".equals(String.valueOf(value))) {
            return "0.00";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value / 100.00);
    }

    /**
     * 格式化金额.
     *
     * @param priceFormat the price format
     * @return the long
     */
    public static Long formatCurrency2Long(String priceFormat) {
        BigDecimal bg = new BigDecimal(priceFormat);
        Long price = bg.multiply(new BigDecimal(100)).longValue();
        return price;
    }

    /**
     * 获取当前时间.
     *
     * @param
     * @return
     * @throws
     */
    public static String getToDayStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间当作文件名称
     *
     * @return
     */
    public static String getToDayStrAsFileName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    public static Date getToDay() throws ParseException {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Date date = sdf.parse(String.valueOf(System.currentTimeMillis()));
        return new Date();
    }

    /**
     * 获取下一天.
     *
     * @param currentDate the current date
     * @return the next date str
     * @throws ParseException the parse exception
     */
    public static String getNextDateStr(String currentDate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        String nextDate = sdf.format(calendar.getTime());
        return nextDate;
    }

    public static String getNextNday(String currentDate, Integer n) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(currentDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, n);
            return sdf.format(calendar.getTime());

        } catch (Exception e) {
            return null;
        }


    }

    /**
     * 获取上一天.
     *
     * @param currentDate the current date
     * @return the next date str
     * @throws ParseException the parse exception
     */
    public static String getYesterdayStr(String currentDate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        String nextDate = sdf.format(calendar.getTime());
        return nextDate;
    }

    /**
     * 根据日期获取星期
     *
     * @param strdate
     * @return
     */
    public static String getWeekDayByDate(String strdate) {
        final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
                "星期六"};
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = sdfInput.parse(strdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0)
            dayOfWeek = 0;
        return dayNames[dayOfWeek];
    }


    /**
     * 判断两个时间是否相差指定分钟
     *
     * @param _time1 时间戳1
     * @param _time2 时间戳2
     * @param minute 指定分钟
     * @return 超过指定分钟:false;未超过:true
     */
    public static boolean isTwoTimeDeltaMinute(long _time1, long _time2, int minute) {
        long deltaSecond = Math.abs(_time1 - _time2);
        long deltaMinute = deltaSecond / (1000 * 60);
        int curMinute = new Long(deltaMinute).intValue();
        return curMinute < minute;
    }


    /**
     * 判断一个long类型时间加上一定的月份后是否到达另一个时间
     *
     * @param last  相对较大的时间
     * @param curr  相对较小的时间
     * @param delta 相隔的月份
     * @return 是否到达
     */
    public static boolean isTwoTimeDeltaMonthDiff(long last, long curr, int delta) {

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTimeInMillis(last > curr ? last : curr); // 设置c1为相对大的日期
        c2.setTimeInMillis(last > curr ? curr : last); // 设置c2为相对小的日期

        c2.add(Calendar.MONTH, delta);

        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DATE) == c2.get(Calendar.DATE);
    }

    /**
     * 获取请求ip地址
     *
     * @param request 请求对象
     * @return
     */
    public static String getReqAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static void main(String[] args) {
        System.out.println(checkPhone("15557006867"));
    }

}