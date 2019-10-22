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
     * @param throwable 异常
     * @return String
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
