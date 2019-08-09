package com.jf.xuan.config;

import com.jf.xuan.common.model.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLTimeoutException;

/**
 * 全局异常处理
 *
 * @author Junfeng
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLTimeoutException.class)
    @ResponseBody
    public ResponseResult sqlTimeoutExceptionHandler(HttpServletRequest request, SQLTimeoutException exception) {
        log.error(" --[ERROR]-- Database execution timeout ", exception);
        return new ResponseResult(ResponseResult.FALSE, "Database execution timeout", exception.getMessage());
    }

    @ExceptionHandler(QueryTimeoutException.class)
    @ResponseBody
    public ResponseResult queryTimeoutExceptionHandler(HttpServletRequest request, QueryTimeoutException exception) {
        log.error(" --[ERROR]-- Database execution timeout ", exception);
        return new ResponseResult(ResponseResult.FALSE, "Database execution timeout", exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest request, Exception exception) {
        log.error(" --[ERROR]-- System exception ", exception);
        return new ResponseResult(ResponseResult.FALSE, "System exception", exception.getMessage());
    }
}
