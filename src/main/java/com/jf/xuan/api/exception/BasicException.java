package com.jf.xuan.api.exception;

import com.jf.xuan.common.I18nUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Description: BasicException .</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 * @author Junfeng
 */
public class BasicException extends Exception {
    private static final Logger log = LoggerFactory.getLogger(BasicException.class);


    private String key;
    private String msg;


    public BasicException(String key, Throwable cause, Object... args) {
        super("BasicException", cause);
        this.msg = getMessage(key, args);
        this.key = key;
    }


    private static String getMessage(String propKey, Object... args) {
        String errorMessage = "";
        try {
            return I18nUtils.getMessage(propKey, args);
        } catch (Exception ex) {
            log.error("Error occurred: i18n get " + propKey + " failure!", ex);
        }
        return errorMessage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
