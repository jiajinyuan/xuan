package com.jf.xuan.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Junfeng
 */
public class DateUtils {
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd
     */
    public static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";
    /**
     * yyyyMMdd
     */
    public static final String PATTERN_YYYYMMDD2 = "yyyyMMdd";
    /**
     * yyyyMMddhhmmss
     */
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 字符串转时间对象
     *
     * @param source  字符串
     * @param pattern 格式
     * @return Date
     */
    public static Date parse(String source, String pattern) {
        if (null == source || "".equals(source)) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("can not parse " + source + " pattern " + pattern, e);
        }
    }

    /**
     * 时间对象转字符串
     *
     * @param source  时间对象
     * @param pattern 格式
     * @return String
     */
    public static String format(Date source, String pattern) {
        if (source == null) {
            return null;
        }
        return new SimpleDateFormat(pattern).format(source);
    }

    /**
     * 获取当前时间的字符串
     *
     * @param pattern 时间格式
     * @return String
     */
    public static String currentTime(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 获取时间的前后多少天
     *
     * @param pattern 时间格式
     * @param source  时间
     * @param num     前后多少天
     * @return Date
     */
    public static Date getDateForNum(String pattern, String source, int num) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            if (null != source && !"".equals(source)) {
                date = new SimpleDateFormat(pattern).parse(source);
            } else {
                date = new Date();
            }
        } catch (ParseException e) {
            throw new RuntimeException("can not parse " + source + " pattern " + pattern, e);
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + num);

        return c.getTime();
    }

    /**
     * 获取时间的前后多少天
     *
     * @param pattern 时间格式
     * @param source  时间
     * @param num     前后多少天
     * @return String
     */
    public static String getDateStringForNum(String pattern, String source, int num) {
        return new SimpleDateFormat(pattern).format(getDateForNum(pattern, source, num));
    }

    /**
     * 判段字符串是否是时间
     *
     * @param source  时间字符串
     * @param pattern 格式
     * @return boolean
     */
    public static boolean isDate(String source, String pattern) {
        if (null == source || "".equals(source)) {
            return false;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(source);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 判段时间1是否大于时间2
     *
     * @param date1   时间字符串1
     * @param date2   时间字符串2
     * @param pattern 格式
     * @return boolean
     */
    public static boolean compareDate(String date1, String date2, String pattern) {
        try {
            Date dt1 = parse(pattern, date1);
            Date dt2 = parse(pattern, date2);
            assert dt1 != null;
            assert dt2 != null;
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
