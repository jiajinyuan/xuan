package com.jf.xuan.common.util;

import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * 字符串工具类
 *
 * @author Junfeng
 */
public class StringUtil {

    /**
     * 验证是否是double
     */
    public static final Pattern IS_DOUBLE = Pattern.compile("^[-\\+]?[.\\d]*$");

    /**
     * 取指定长度的前面字符串
     *
     * @param src        字符串
     * @param byteLength 安字节算, 中文算两个字节
     * @param tail       跟在后面的字符串
     * @return 处理后的字符串
     */
    public static String ellipsis(String src, int byteLength, String tail) {
        if (src == null) {
            return src;
        }

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < src.length() && byteLength > 0; i++) {
            char c = src.charAt(i);
            s.append(c);
            byteLength -= String.valueOf(c).getBytes().length;
        }
        if (tail != null && byteLength <= 0) {
            byteLength = tail.getBytes().length;
            for (int i = s.length() - 1; i >= 0 && byteLength > 0; i--) {
                char c = s.charAt(i);
                s.deleteCharAt(i);
                byteLength -= String.valueOf(c).getBytes().length;
            }
            return s.append(tail).toString();
        } else {
            return s.toString();
        }
    }

    /**
     * 只显示字符串的前面几个字符方法
     *
     * @param src        字符串
     * @param byteLength 需要保留的长度
     * @param tail       跟在后面的字符串
     * @return 处理后的字符串
     */
    public static String[] ellipse(String[] src, int byteLength, String tail) {
        String[] returnSrc = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            returnSrc[i] = ellipsis(src[i], byteLength, tail);
        }
        return returnSrc;
    }


    /**
     * 格式化路径
     *
     * @param path 路径
     * @return 格式化后的路径
     */
    public static String cleanPath(String path) {
        return org.springframework.util.StringUtils.cleanPath(path);
    }

    /**
     * 字符串变成数组
     *
     * @param str        字符串
     * @param delimiters 间隔
     * @return 字符串数组
     */
    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return org.springframework.util.StringUtils.tokenizeToStringArray(str, delimiters);
    }

    /**
     * 判断是否是浮点型
     *
     * @param str 字符串
     * @return 是 否
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return IS_DOUBLE.matcher(str).matches();
    }

    /**
     * 判断是否是整数
     *
     * @param str 字符串
     * @return 是 否
     */
    public static boolean isInteger(String str) {
        int begin = 0;
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        str = str.trim();
        if (str.startsWith("+") || str.startsWith("-")) {
            if (str.length() == 1) {
                // "+" "-"
                return false;
            }
            begin = 1;
        }
        for (int i = begin; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为数字
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 处理目录结束符.
     *
     * @param str str
     * @return String
     **/
    public static String evalFileSeparator(String str) {
        str = str.replace("\\", "/");
        if (!str.endsWith("/")) {
            str += "/";
        } else if (str.endsWith("//")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * 删除末尾的字符.
     *
     * @param sb     StringBuilder
     * @param remove String
     * @return StringBuilder
     **/
    public static StringBuilder removeEnd(StringBuilder sb, String remove) {
        if (isEmpty(sb.toString()) || isEmpty(remove)) {
            return new StringBuilder();
        }
        if (sb.toString().endsWith(remove)) {
            return sb.delete(sb.length() - remove.length(), sb.length());
        }
        return sb;
    }

    /**
     * 验证字符串是否已后缀结束
     *
     * @param str    验证的字符串
     * @param suffix 后缀
     * @return 是否匹配
     */
    public static boolean endsWith(String str, String suffix) {
        return endsWith(str, suffix, false);
    }

    /**
     * 验证字符串是否已后缀结束
     *
     * @param str        验证的字符串
     * @param suffix     后缀
     * @param ignoreCase 忽略大小写
     * @return 是否匹配
     */
    private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        if (str == null || suffix == null) {
            return (str == null && suffix == null);
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
    }

    /**
     * 验证字符串是否已前缀开始
     *
     * @param str    验证的字符串
     * @param prefix 前缀
     * @return 是否匹配
     */
    public static boolean startsWith(String str, String prefix) {
        return startsWith(str, prefix, false);
    }

    /**
     * 验证字符串是否已前缀开始
     *
     * @param str        验证的字符串
     * @param prefix     前缀
     * @param ignoreCase 忽略大小写
     * @return 是否匹配
     */
    private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
    }
}
