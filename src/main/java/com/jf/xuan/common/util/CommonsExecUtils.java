package com.jf.xuan.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 执行本地命令工具类
 *
 * @author Junfeng
 */
@Slf4j
public class CommonsExecUtils {

    public static int exec(String cmd) throws IOException {
        return exec(cmd, 0);
    }

    public static int exec(String cmd, String... args) throws IOException {
        return exec(cmd, 0, new int[0], args);
    }

    public static int exec(String cmd, long timeout) throws IOException {
        return exec(cmd, timeout, new int[0]);
    }

    public static int exec(String cmd, int... exitValues) throws IOException {
        return exec(cmd, 0, exitValues);
    }

    public static int exec(String cmd, long timeout, int[] exitValues, String... args) throws IOException {
        final CommandLine commandLine = CommandLine.parse(cmd);
        for (String arg : args) {
            commandLine.addArgument(arg);
        }
        DefaultExecutor executor = new DefaultExecutor();
        if (0 < timeout) {
            ExecuteWatchdog watchdog = new ExecuteWatchdog(timeout);
            executor.setWatchdog(watchdog);
        }
        if (exitValues.length > 0) {
            executor.setExitValues(exitValues);
        }
        if (log.isDebugEnabled()) {
            log.debug("-[DEBUG]- Exec cmd: " + commandLine.toString());
        }
        return executor.execute(commandLine);
    }

    public static DefaultExecuteResultHandler asyncExec(String cmd, long timeout, int[] exitValues, String... args) throws IOException {
        final CommandLine commandLine = CommandLine.parse(cmd);
        for (String arg : args) {
            commandLine.addArgument(arg);
        }
        DefaultExecutor executor = new DefaultExecutor();
        if (0 < timeout) {
            ExecuteWatchdog watchdog = new ExecuteWatchdog(timeout);
            executor.setWatchdog(watchdog);
        }
        if (exitValues.length > 0) {
            executor.setExitValues(exitValues);
        }

        final DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        if (log.isDebugEnabled()) {
            log.debug("-[DEBUG]- Exec cmd: " + commandLine.toString());
        }
        executor.execute(commandLine, resultHandler);
        return resultHandler;
    }


    public static Map<String, Object> execOutString(String cmd, long timeout, int[] exitValues, String... args) throws IOException {
        final CommandLine commandLine = CommandLine.parse(cmd);
        for (String arg : args) {
            commandLine.addArgument(arg);
        }
        DefaultExecutor executor = new DefaultExecutor();
        if (0 < timeout) {
            ExecuteWatchdog watchdog = new ExecuteWatchdog(timeout);
            executor.setWatchdog(watchdog);
        }
        if (exitValues.length > 0) {
            executor.setExitValues(exitValues);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        executor.setStreamHandler(new PumpStreamHandler(baos, baos));
        if (log.isDebugEnabled()) {
            log.debug("-[DEBUG]- Exec cmd: " + commandLine.toString());
        }
        int exitValue = executor.execute(commandLine);
        String result = baos.toString("gbk").trim();
        Map<String, Object> res = new HashMap<>(4);
        res.put("exitValue", exitValue);
        res.put("msg", result);
        return res;
    }

    public static int execOutFile(String cmd, String logFile, long timeout, int[] exitValues, String... args) throws IOException {
        final CommandLine commandLine = CommandLine.parse(cmd);
        for (String arg : args) {
            commandLine.addArgument(arg);
        }
        DefaultExecutor executor = new DefaultExecutor();
        if (0 < timeout) {
            ExecuteWatchdog watchdog = new ExecuteWatchdog(timeout);
            executor.setWatchdog(watchdog);
        }
        if (exitValues.length > 0) {
            executor.setExitValues(exitValues);
        }
        FileOutputStream out = new FileOutputStream(logFile);
        executor.setStreamHandler(new PumpStreamHandler(out, out));
        if (log.isDebugEnabled()) {
            log.debug("-[DEBUG]- Exec cmd: " + commandLine.toString());
        }
        return executor.execute(commandLine);
    }
}
