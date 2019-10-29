package com.jf.xuan.common.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * I18nUtils
 *
 * @author Junfeng
 */
public abstract class I18nUtils {

    /**
     * MessageSource
     */
    private static MessageSource MS;

    public static String getMessage(String code) {
        return getMessage(code, "", null);
    }

    public static String getMessage(String code, Object[] args) {
        return getMessage(code, "", args);
    }

    public static String getMessage(String code, String defaultMessage) {
        return getMessage(code, defaultMessage, null);
    }

    public static String getMessage(String code, String defaultMessage, Object[] args) {
        return MS.getMessage(code, args, defaultMessage, getLocale());
    }

    public static Locale getLocale() {
        //这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getLanguage().contains("zh")) {
            locale = Locale.SIMPLIFIED_CHINESE;
        }
        return locale;
    }

    /**
     * Resolver
     */
    @Configuration
    public static class Resolver implements BeanFactoryAware {
        /**
         * beanFactory
         *
         * @param beanFactory bean工厂
         */
        @Override
        public void setBeanFactory(BeanFactory beanFactory) {
            MS = beanFactory.getBean("messageSource", MessageSource.class);
        }
    }
}
