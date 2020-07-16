package com.gsgb.local;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;


/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/7/15 13:19
 * 行百里者半九十--《战国策》
 * <p>
 * 测试不带时区的时间日期类
 * LocalDateTime,LocalTime,LocalDate
 */
public class LocalTest {

    /**
     * 1.now()方法获取当前时间
     */
    @Test
    public void testNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Instant instant = Instant.now(); // 时间戳
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); // 带时区的类

        System.out.println("localDateTime的时间是:" + localDateTime);
        System.out.println("localDate的时间是:" + localDate);
        System.out.println("localTime的时间是:" + localTime);
        System.out.println("instant的时间是:" + instant);
        System.out.println("zonedDateTime的时间是:" + zonedDateTime);
    }

    /**
     * 2.now()方法,其他类的now方法
     */
    @Test
    public void testNow02() {
        // 代表年份的Year类
        Year year = Year.now();
        // 代表一年中的某月的YearMonth类
        YearMonth yearMonth = YearMonth.now();
        // 代表一月中的某天的MonthDay类
        MonthDay monthDay = MonthDay.now();

        System.out.println("当前的年份为: " + year);
        System.out.println("当前的年份和月份为: " + yearMonth);
        System.out.println("当前的月份和天数为: " + monthDay);

    }

    /**
     * 3.获取一些常量
     * 测试时间日期类的一些常量
     * 主要看{@link LocalTime}的一些
     */
    @Test
    public void testConstant() {
        /*System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.MIN);

        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);*/

        System.out.println("某一天的结束时间是: " + LocalTime.MAX);
        System.out.println("某一天的开始时间是: " + LocalTime.MIN);
        System.out.println("某一天的半夜时间是: " + LocalTime.MIDNIGHT);
        System.out.println("某一天的正中午时间是: " + LocalTime.NOON);
    }

    /**
     * 4.of()方法获取指定时间
     * 测试不带时区的时间日期类的of方法，获取指定时间
     */
    @Test
    public void testOf() {
        // 1.LocalDate
        LocalDate date1 = LocalDate.of(1997, 8, 8); // 设置1997-08-08
        // Mouth是一个代表月份枚举类
        LocalDate date2 = LocalDate.of(2000, Month.JUNE, 23); // 设置2000-06-23
        System.out.println("date1时间为: " + date1);
        System.out.println("date2时间为: " + date2);

        // 2.LocalTime
        LocalTime time1 = LocalTime.of(8, 10);
        System.out.println("time1时间为: " + time1);

        // 3.LocalDateTime
        // 设置2015-09-05 8:30
        LocalDateTime dateTime1 = LocalDateTime.of(2015, 9, 5, 8, 30);
        // 设置2019-06-25 12:00
        LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.JUNE, 25, 12, 0);
        System.out.println("dateTime1时间为: " + dateTime1);
        System.out.println("dateTime2时间为: " + dateTime2);

        // LocalDateTime有个特殊的of方法
        // LocalDateTime of(LocalDate date, LocalTime time)
        LocalDateTime dateTime3 = LocalDateTime.of(date1, time1);
        System.out.println("特殊of方法的dateTime3的时间为: " + dateTime3);

        // 4.ZonedDateTime的of方法需要带上ZoneId，也就是指定时区，后面再说
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime3, ZoneId.systemDefault());
        System.out.println("zonedDateTime的时间为: " + zonedDateTime);
    }

    /**
     * 5.Month枚举类
     */
    @Test
    public void testMonth() {
        // 1.of方法创建对象
        Month month = Month.of(7);

        // 2.获取某月的最长天数和最短天数
        int maxLength = Month.FEBRUARY.maxLength();
        int minLength = Month.FEBRUARY.minLength();

        // 3.获取某个月的 在/不在 闰年的长度
        int julyLength = Month.JULY.length(true);

        // 4.获取当前月份所在的季度的 第一个月份
        // DECEMBER是12月，所以返回OCTOBER 9月
        Month month2 = Month.DECEMBER.firstMonthOfQuarter();

        // 5.获取某个月 在/不在 闰年的第一天在该年的天数
        int monthValue = Month.JULY.firstDayOfYear(false);

        // 6.顺便说下如何判断某年是否是闰年,Year类
        boolean leap = Year.isLeap(Year.now().getValue());

        System.out.println("Mouth的of方法: " + month);
        System.out.println("某月的最长天数: " + maxLength);
        System.out.println("某月的最短天数: " + minLength);
        System.out.println("七月在闰年一个月的长度为: " + julyLength);
        System.out.println("获取12月所在的季度的第一个月份: " + month2);
        System.out.println("获取7月不在闰年的第一天在该年的天数: " + monthValue);

        System.out.println("今年是否是闰年: " + (leap ? "是的" : "不是"));

    }

    /**
     * 4.get方法
     * 测试不带时区的时间日期类的get方法，获取日期时间对象的各个字段值
     * 以LocalDateTime为例，其他两个是一样的
     */
    @Test
    public void testGet() {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("获取年份:" + dateTime.getYear());
        System.out.println("获取月份枚举:" + dateTime.getMonth());
        System.out.println("获取月份:" + dateTime.getMonthValue());
        System.out.println("获取月的第几天:" + dateTime.getDayOfMonth());
        System.out.println("获取小时:" + dateTime.getHour());
    }

    /**
     * 5.日期类的特殊的Get方法
     * 以LocalDateTime为例，其他两个是差不多的
     * 在{@link ChronoField}类中定义了一些具有特殊含义的枚举
     *
     * @see ChronoField
     */
    @Test
    public void testGet02() {
        LocalDateTime dateTime = LocalDateTime.now();
        // AMPM_OF_DAY 表示时间是上午还是下午，0-上午，1-下午
        int amPmOfDay = dateTime.get(ChronoField.AMPM_OF_DAY);
        System.out.println("现在时间在当天是:" + (amPmOfDay == 0 ? "上午" : "下午"));

        // MINUTE_OF_HOUR 表示时间的分钟数
        int clockHourOfDay = dateTime.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println("现在时间的分钟是第" + clockHourOfDay + "分");
    }

    /**
     * 6.日期类的比较方法
     * isAfter
     * isBefore
     * isEqual
     */
    @Test
    public void testCompare() {

    }

    /**
     * 6.with方法
     */
    @Test
    public void testWith() {

    }

    /**
     * minus
     */
    @Test
    public void testPlusAndMinus() {

    }
}