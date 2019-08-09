package com.jf.xuan.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 将异常信息printStackTrace输出到字符串
 *
 * @author Junfeng
 */
public class ExceptionMsgUtils {

    /**
     * 将异常信息printStackTrace输出到字符串
     *
     * @param ex 异常
     * @return 异常字符串
     */
    public static String get(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }

}
