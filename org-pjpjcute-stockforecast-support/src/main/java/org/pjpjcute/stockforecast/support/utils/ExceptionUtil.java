package org.pjpjcute.stockforecast.support.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author zhoulei
 * @create 2023/4/11
 * @description:
 */
public class ExceptionUtil {
    private static final String DEFAULT_MESSAGE = "错误原因为:%s,入参:%s,堆栈:%s";
    /**
     * 获得打印堆栈信息
     * @param e
     * @param message
     * @param param
     * @return
     */
    public static String printException(Exception e,String message,String param) {
        String exceptionMessage = e == null ? "" : getStackTraceAsString(e);
        String paramMessage = param == null ? "" : param;
        String tip = message == null ? "" : message;
        return String.format(DEFAULT_MESSAGE,tip,paramMessage,exceptionMessage);
    }

    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}
