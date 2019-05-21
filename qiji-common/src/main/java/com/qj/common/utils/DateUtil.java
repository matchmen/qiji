package com.qj.common.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/****
 *
 * author:lqm
 * 2019-05-08
 **/
public class DateUtil {

    public static final Date FIRST_DATE = new Date(0);

    public static final int SECONDS_OF_ONE_MINUTE = 60;

    public static final int SECONDS_OF_ONE_HOUR = 1 * 60 * 60;

    public static final int SECONDS_OF_ONE_DAY = SECONDS_OF_ONE_HOUR * 24;

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    public static final String STANDARD_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * count days between start date and end date, both day included
     *
     * @param start
     * @param end
     * @return
     */
    public static int countDays(Date start, Date end) {
        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        String begin = format(start, DEFAULT_PATTERN);
        String endDate = format(end, DEFAULT_PATTERN);
        int result =  (int) ChronoUnit.DAYS.between(java.time.LocalDate.parse(begin, fmt),
                java.time.LocalDate.parse(endDate, fmt));
        result = result + 1 >= 1 ? result + 1 : 0;
        return result;
    }

    /**
     * 通用的日期转换
     *
     * @param date 日期
     * @return
     */
    public static String commonFormat(final Date date) {
        String format = format(date, "yyyy-MM-dd HH:mm:ss");
        return format;
    }

    public static String defaultFormat(final Date date) {
        String format = format(date, DEFAULT_PATTERN);
        return format;
    }

    public static String format(final Date date, final String pattern) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取某天的最后一秒对应的时间:当天的23:59.000
     *
     * @param day
     * @return
     */
    public static Date dayEnd(Date day) {
        if (day == null) {
            return null;
        }
        long theDay = dayStart(day).getTime();
        final long ONE_DAY_MILLIS = 1 * 24 * 60 * 60 * 1000;

        return new Date(theDay + ONE_DAY_MILLIS - 1);
    }

    /**
     * 获取某天的第一秒对应的时间:当天的00:00.000
     *
     * @param date
     * @return
     */
    public static Date dayStart(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return Date.from(localDateTime
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)
                .atZone(zoneId)
                .toInstant());
    }

    /**
     * 从当前时间增加秒 seconds 得到另外一个时间
     *
     * @param day
     * @param seconds 可以为负数
     * @return
     */
    public static Date offsetSeconds(Date day, int seconds) {
        long nowMillis = day.getTime();
        final long OFFSET_MILLIS = seconds * 1000L;

        return new Date(nowMillis + OFFSET_MILLIS);
    }

    /**
     * 从当前时间增加天数 days 得到另外一个时间
     *
     * @param day
     * @param days 可以为负数
     * @return
     */
    public static Date offsetDays(Date day, int days) {
        return offsetSeconds(day, days * SECONDS_OF_ONE_DAY);
    }

    public static Date offsetHours(Date day, int hours) {
        return offsetSeconds(day, hours * SECONDS_OF_ONE_HOUR);
    }

    public static Date yesterday(Date day) {
        return offsetSeconds(day, -SECONDS_OF_ONE_DAY);
    }

    public static Date tomorrow(Date day) {
        return offsetSeconds(day, SECONDS_OF_ONE_DAY);
    }

    /**
     * 时间格式化为字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String toString(Date date, String format) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat(format);
            String ctime = formatter.format(date);

            return ctime;
        } catch (Exception e) {
            return "";
        }
    }

    public static String yyyymmdd(Date date) {
        return toString(date, "yyyyMMdd");
    }

    public static String hhmmss(Date date) {
        return toString(date, "HHmmss");
    }

    /**
     * 判断是否为同一天（a或b有一个为空即返回false）
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean sameDay(Date a, Date b) {

        if (null == a || null == b) {
            return false;
        }

        return yyyymmdd(a).equals(yyyymmdd(b));
    }


    /***
     * 日期格式化 yyyy-MM
     * @param date
     * @return
     */
    public static String yyyyMm(Date date) {
        return toString(date, "yyyy-MM");
    }

    /**
     * 将Date 转换 LocalDate对象
     *
     * @param date
     * @return
     */
    public static java.time.LocalDate getDateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 将LocalDate  转换 Date对象
     *
     * @param localDate
     * @return
     */
    public static Date getLocalDateToDate(java.time.LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt =  localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date getFirstDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,1);
        return cal.getTime();
    }

    public static Date getLastDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH,lastDay);
        return cal.getTime();
    }

    /**
     * 列出两个日期之间的天数
     *
     * @param dBegin 开始日期
     * @param dEnd   结束日期
     * @return
     */
    public static List<String> betweenDate(Date dBegin, Date dEnd) {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        dates.add(sf.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);

        while (dEnd.after(calBegin.getTime())) {
            //根据日历的规则,为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(sf.format(calBegin.getTime()));
        }
        return dates;
    }

    /**
     * 获取两个日期之间的的月份
     *
     * @param minDate 最小时间  2015-01
     * @param maxDate 最大时间 2015-10
     * @return 日期集合 格式为 年-月
     * @throws Exception
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }




}
