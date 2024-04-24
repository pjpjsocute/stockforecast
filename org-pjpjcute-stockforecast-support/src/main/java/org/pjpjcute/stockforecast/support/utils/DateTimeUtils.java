package org.pjpjcute.stockforecast.support.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhoulei
 */
public final class DateTimeUtils {

    private DateTimeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static final String  DEFAULT_TIME_FORM = "yyyy-MM-dd HH:mm:ss";

    private static final Integer MAX_MONTH         = 12;

    /**
     * 两个时间对比，获取最新的时间
     *
     * @param firstTimestamp
     * @param secondTimestamp
     * @return
     */
    public static String getLastTimestamp(String firstTimestamp, final String secondTimestamp) {
        int compareValue = StringUtils.compare(firstTimestamp, secondTimestamp);
        // 说明相等
        if (compareValue == 0) {
            return firstTimestamp;
        }
        // 说明后面时间大
        else if (compareValue < 0) {
            return secondTimestamp;
        } else { // 说明前面时间大
            return firstTimestamp;
        }
    }

    public static Date toDate(String dateString) {
        return toDate(dateString, DEFAULT_TIME_FORM);
    }

    public static Date toDate(String dateString, String format) {
        if (StringUtils.isBlank(dateString)) {
            return new Date();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(ExceptionUtil.printException(e, "时间转换失败", dateString + "[]" + format));
        }
    }

    /**
     * 计算两个日期之间的时间差（毫秒）
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 时间差（毫秒）
     */
    public static long timeDiff(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }

    /**
     * 计算两个日期之间的时间差（毫秒）
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 时间差（毫秒）
     */
    public static long timeDiff(String date1, String date2) {
        return toDate(date2).getTime() - toDate(date1).getTime();
    }

    public static long getFirstDayMillis(int year, int month) {
        Calendar calendar = Calendar.getInstance();

        month = month - 1;
        // 设置当前月份的第一天
        calendar.set(year, month, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long currentMonthFirstDayMillis = calendar.getTimeInMillis();

        return currentMonthFirstDayMillis;
    }

    public static long getLastDayMillis(int year, int month) {
        Calendar calendar = Calendar.getInstance();

        // 检查月份是否超过MAX_MONTH，如果是，增加年份并重新计算月份
        if (month >= MAX_MONTH) {
            year += month / MAX_MONTH;
            month %= MAX_MONTH;
        }

        // 设置下个月的第一天
        calendar.set(year, month, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 减去1毫秒，获取当前月最后一天的23时59分59秒59毫秒
        calendar.add(Calendar.MILLISECOND, -1);

        return calendar.getTimeInMillis();
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        // 获取当前时间
        Date currentDate = new Date();

        // 格式化当前时间为字符串
        return sdf.format(currentDate);
    }

    public static String getStartOfDayAsString(long millis) {
        LocalDateTime startOfDay =
            Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORM);
        return startOfDay.format(formatter);
    }

    public static String getEndOfDayAsString(long millis) {
        LocalDateTime endOfDay =
            Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate().atTime(23, 59, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORM);
        return endOfDay.format(formatter);
    }
}
