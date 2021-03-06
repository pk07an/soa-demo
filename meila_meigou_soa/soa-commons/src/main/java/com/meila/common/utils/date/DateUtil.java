package com.meila.common.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;

import org.apache.commons.lang.time.DateFormatUtils;

import com.meila.common.exceptions.UtilException;
import com.meila.common.utils.DateTime;
import com.meila.common.utils.StringUtils;

/**
 * 时间工具类
 * 
 * @author xiaoleilu
 */
public class DateUtil {
    /** 毫秒 */
    public final static long MS = 1;
    /** 每秒钟的毫秒数 */
    public final static long SECOND_MS = MS * 1000;
    /** 每分钟的毫秒数 */
    public final static long MINUTE_MS = SECOND_MS * 60;
    /** 每小时的毫秒数 */
    public final static long HOUR_MS = MINUTE_MS * 60;
    /** 每天的毫秒数 */
    public final static long DAY_MS = HOUR_MS * 24;

    /** 标准日期格式 */
    public final static String NORM_DATE_PATTERN = "yyyy-MM-dd";
    /** 标准时间格式 */
    public final static String NORM_TIME_PATTERN = "HH:mm:ss";
    /** 标准日期时间格式，精确到分 */
    public final static String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    /** 标准日期时间格式，精确到秒 */
    public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /** 标准日期时间格式，精确到毫秒 */
    public final static String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    /** HTTP头中日期时间格式 */
    public final static String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";

    /** 标准日期（不含时间）格式化器 */
    // private final static SimpleDateFormat NORM_DATE_FORMAT = new SimpleDateFormat(NORM_DATE_PATTERN);
    private static ThreadLocal<SimpleDateFormat> NORM_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATE_PATTERN);
        };
    };
    /** 标准时间格式化器 */
    // private final static SimpleDateFormat NORM_TIME_FORMAT = new SimpleDateFormat(NORM_TIME_PATTERN);
    private static ThreadLocal<SimpleDateFormat> NORM_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_TIME_PATTERN);
        };
    };
    /** 标准日期时间格式化器 */
    // private final static SimpleDateFormat NORM_DATETIME_FORMAT = new SimpleDateFormat(NORM_DATETIME_PATTERN);
    private static ThreadLocal<SimpleDateFormat> NORM_DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATETIME_PATTERN);
        };
    };
    /** HTTP日期时间格式化器 */
    // private final static SimpleDateFormat HTTP_DATETIME_FORMAT = new SimpleDateFormat(HTTP_DATETIME_PATTERN,
    // Locale.US);
    private static ThreadLocal<SimpleDateFormat> HTTP_DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(HTTP_DATETIME_PATTERN, Locale.US);
        };
    };

    /**
     * 当前时间，格式 yyyy-MM-dd HH:mm:ss
     * 
     * @return 当前时间的标准形式字符串
     */
    public static String now() {
        return formatDateTime(new DateTime());
    }

    /**
     * 当前日期，格式 yyyy-MM-dd
     * 
     * @return 当前日期的标准形式字符串
     */
    public static String today() {
        return formatDate(new DateTime());
    }

    /**
     * @return 当前时间
     */
    public static DateTime date() {
        return new DateTime();
    }

    /**
     * Long类型时间转为Date
     * 
     * @param date Long类型Date（Unix时间戳）
     * @return 时间对象
     */
    public static DateTime date(long date) {
        return new DateTime(date);
    }

    /**
     * 获得指定日期年份和季节<br>
     * 格式：[20131]表示2013年第一季度
     * 
     * @param date 日期
     * @return Season ，类似于 20132
     */
    public static String yearAndSeason(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return yearAndSeason(cal);
    }

    /**
     * 获得指定日期区间内的年份和季节<br>
     * 
     * @param startDate 其实日期（包含）
     * @param endDate 结束日期（包含）
     * @return Season列表 ，元素类似于 20132
     */
    public static LinkedHashSet<String> yearAndSeasons(Date startDate, Date endDate) {
        final LinkedHashSet<String> seasons = new LinkedHashSet<String>();
        if (startDate == null || endDate == null) {
            return seasons;
        }

        final Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        while (true) {
            // 如果开始时间超出结束时间，让结束时间为开始时间，处理完后结束循环
            if (startDate.after(endDate)) {
                startDate = endDate;
            }

            seasons.add(yearAndSeason(cal));

            if (startDate.equals(endDate)) {
                break;
            }

            cal.add(Calendar.MONTH, 3);
            startDate = cal.getTime();
        }

        return seasons;
    }

    // ------------------------------------ Format start ----------------------------------------------
    /**
     * 根据特定格式格式化日期
     * 
     * @param date 被格式化的日期
     * @param format 格式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 格式 yyyy-MM-dd HH:mm:ss
     * 
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDateTime(Date date) {
        return NORM_DATETIME_FORMAT.get().format(date);
    }

    /**
     * 格式 yyyy-MM-dd
     * 
     * @param date 被格式化的日期
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date) {
        return NORM_DATE_FORMAT.get().format(date);
    }

    /**
     * 格式化为Http的标准日期格式
     * 
     * @param date 被格式化的日期
     * @return HTTP标准形式日期字符串
     */
    public static String formatHttpDate(Date date) {
        return HTTP_DATETIME_FORMAT.get().format(date);
    }
    // ------------------------------------ Format end ----------------------------------------------

    // ------------------------------------ Parse start ----------------------------------------------

    /**
     * 构建DateTime对象
     * 
     * @param dateStr Date字符串
     * @param simpleDateFormat 格式化器
     * @return DateTime对象
     */
    public static DateTime parse(String dateStr, SimpleDateFormat simpleDateFormat) {
        try {
            return new DateTime(simpleDateFormat.parse(dateStr));
        } catch (Exception e) {
            throw new UtilException(StringUtils.format("Parse [{}] with format [{}] error!", dateStr, simpleDateFormat.toPattern()), e);
        }
    }

    /**
     * 将特定格式的日期转换为Date对象
     * 
     * @param dateString 特定格式的日期
     * @param format 格式，例如yyyy-MM-dd
     * @return 日期对象
     */
    public static DateTime parse(String dateString, String format) {
        return parse(dateString, new SimpleDateFormat(format));
    }

    /**
     * 格式yyyy-MM-dd HH:mm:ss
     * 
     * @param dateString 标准形式的时间字符串
     * @return 日期对象
     */
    public static DateTime parseDateTime(String dateString) {
        return parse(dateString, NORM_DATETIME_FORMAT.get());
    }

    /**
     * 格式yyyy-MM-dd
     * 
     * @param dateString 标准形式的日期字符串
     * @return 日期对象
     */
    public static DateTime parseDate(String dateString) {
        return parse(dateString, NORM_DATE_FORMAT.get());
    }

    /**
     * 格式HH:mm:ss
     * 
     * @param timeString 标准形式的日期字符串
     * @return 日期对象
     */
    public static DateTime parseTime(String timeString) {
        return parse(timeString, NORM_TIME_FORMAT.get());
    }

    /**
     * 格式：<br>
     * 1、yyyy-MM-dd HH:mm:ss<br>
     * 2、yyyy-MM-dd<br>
     * 3、HH:mm:ss<br>
     * 4、yyyy-MM-dd HH:mm 5、yyyy-MM-dd HH:mm:ss.SSS
     * 
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static DateTime parse(String dateStr) {
        if (null == dateStr) {
            return null;
        }
        dateStr = dateStr.trim();
        int length = dateStr.length();
        try {
            if (length == NORM_DATETIME_PATTERN.length()) {
                return parseDateTime(dateStr);
            } else if (length == NORM_DATE_PATTERN.length()) {
                return parseDate(dateStr);
            } else if (length == NORM_TIME_PATTERN.length()) {
                return parseTime(dateStr);
            } else if (length == NORM_DATETIME_MINUTE_PATTERN.length()) {
                return parse(dateStr, NORM_DATETIME_MINUTE_PATTERN);
            } else if (length >= NORM_DATETIME_MS_PATTERN.length() - 2) {
                return parse(dateStr, NORM_DATETIME_MS_PATTERN);
            }
        } catch (Exception e) {
            throw new UtilException(StringUtils.format("Parse [{}] with format normal error!", dateStr));
        }

        // 没有更多匹配的时间格式
        throw new UtilException(StringUtils.format(" [{}] format is not fit for date pattern!", dateStr));
    }
    // ------------------------------------ Parse end ----------------------------------------------

    // ------------------------------------ Offset start ----------------------------------------------
    /**
     * 获取某天的开始时间
     * 
     * @param date 日期
     * @return 某天的开始时间
     */
    public static DateTime getBeginTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new DateTime(calendar.getTime());
    }

    /**
     * 获取某天的结束时间
     * 
     * @param date 日期
     * @return 某天的结束时间
     */
    public static DateTime getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new DateTime(calendar.getTime());
    }

    /**
     * 昨天
     * 
     * @return 昨天
     */
    public static DateTime yesterday() {
        return offsiteDay(new DateTime(), -1);
    }

    /**
     * 上周
     * 
     * @return 上周
     */
    public static DateTime lastWeek() {
        return offsiteWeek(new DateTime(), -1);
    }

    /**
     * 上个月
     * 
     * @return 上个月
     */
    public static DateTime lastMouth() {
        return offsiteMonth(new DateTime(), -1);
    }

    /**
     * 偏移天
     * 
     * @param date 日期
     * @param offsite 偏移天数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static DateTime offsiteDay(Date date, int offsite) {
        return offsiteDate(date, Calendar.DAY_OF_YEAR, offsite);
    }

    /**
     * 偏移周
     * 
     * @param date 日期
     * @param offsite 偏移周数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static DateTime offsiteWeek(Date date, int offsite) {
        return offsiteDate(date, Calendar.WEEK_OF_YEAR, offsite);
    }

    /**
     * 偏移月
     * 
     * @param date 日期
     * @param offsite 偏移月数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public static DateTime offsiteMonth(Date date, int offsite) {
        return offsiteDate(date, Calendar.MONTH, offsite);
    }

    /**
     * 获取指定日期偏移指定时间后的时间
     * 
     * @param date 基准日期
     * @param calendarField 偏移的粒度大小（小时、天、月等）使用Calendar中的常数
     * @param offsite 偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public static DateTime offsiteDate(Date date, int calendarField, int offsite) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendarField, offsite);
        return new DateTime(cal.getTime());
    }
    // ------------------------------------ Offset end ----------------------------------------------

    /**
     * 判断两个日期相差的时长<br/>
     * 返回 minuend - subtrahend 的差
     * 
     * @param subtrahend 减数日期
     * @param minuend 被减数日期
     * @param diffField 相差的选项：相差的天、小时
     * @return 日期差
     */
    public static long diff(Date subtrahend, Date minuend, long diffField) {
        long diff = minuend.getTime() - subtrahend.getTime();
        return diff / diffField;
    }

    /**
     * 计时，常用于记录某段代码的执行时间，单位：纳秒
     * 
     * @param preTime 之前记录的时间
     * @return 时间差，纳秒
     */
    public static long spendNt(long preTime) {
        return System.nanoTime() - preTime;
    }

    /**
     * 计时，常用于记录某段代码的执行时间，单位：毫秒
     * 
     * @param preTime 之前记录的时间
     * @return 时间差，毫秒
     */
    public static long spendMs(long preTime) {
        return System.currentTimeMillis() - preTime;
    }

    /**
     * 格式化成yyMMddHHmm后转换为int型
     * 
     * @param date 日期
     * @return int
     */
    public static int toIntSecond(Date date) {
        return Integer.parseInt(DateUtil.format(date, "yyMMddHHmm"));
    }

    /**
     * 计算指定指定时间区间内的周数
     * 
     * @param start 开始时间
     * @param end 结束时间
     * @return 周数
     */
    public static int weekCount(Date start, Date end) {
        final Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        final Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);

        final int startWeekofYear = startCalendar.get(Calendar.WEEK_OF_YEAR);
        final int endWeekofYear = endCalendar.get(Calendar.WEEK_OF_YEAR);

        int count = endWeekofYear - startWeekofYear + 1;

        if (Calendar.SUNDAY != startCalendar.get(Calendar.DAY_OF_WEEK)) {
            count--;
        }

        return count;
    }

    // ------------------------------------------------------------------------ Private method start
    /**
     * 获得指定日期年份和季节<br>
     * 格式：[20131]表示2013年第一季度
     * 
     * @param cal 日期
     */
    private static String yearAndSeason(Calendar cal) {
        return new StringBuilder().append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH) / 3 + 1).toString();
    }
    // ------------------------------------------------------------------------ Private method end

    // private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd
    // HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
    // "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
    // "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
    // "yyyy.MM.dd HH:mm", "yyyy.MM" };

    public static String dateAdd(String pattern, String days) {
        try {
            if (StringUtils.isNull(days)) {
                return null;
            } else if (days.endsWith("d")) {
                Long daysValue = Long.valueOf(days.substring(0, days.length() - 1));
                return DateFormatUtils.format(new Date(System.currentTimeMillis() + (daysValue * 86400000)), pattern);

            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 获取过去的天数
     * 
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     * 
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     * 
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * 
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     * 
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        // System.out.println(formatDate(parseDate("2010/3/6")));
        // System.out.println(getDate("yyyy年MM月dd日 E"));
        // long time = new Date().getTime()-parseDate("2012-11-19").getTime();
        // System.out.println(time/(24*60*60*1000));
    }
}
