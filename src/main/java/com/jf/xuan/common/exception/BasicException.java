package com.jf.xuan.common.exception;

import com.jf.xuan.common.util.I18nUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BasicException
 *
 * @author Junfeng
 */
public class BasicException extends Exception {

    private static final Logger log = LoggerFactory.getLogger(BasicException.class);
    /**
     * 异常信息国际化KEY
     */
    protected String key;


    public BasicException(String key, Object... args) {
        super(getMessage(key, args));
        this.key = key;
    }

    public BasicException(String key, Throwable cause, Object... args) {
        super(getMessage(key, args), cause);
        this.key = key;
    }


    /**
     * 根据国际化KEY获取具体消息
     *
     * @param propKey 国际化KEY
     * @param args    参数变量
     * @return String
     */
    private static String getMessage(String propKey, Object... args) {
        try {
            return I18nUtils.getMessage(propKey, args);
        } catch (Exception ex) {
            log.error("Error occurred: i18n get " + propKey + " failure!", ex);
            return "";
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
