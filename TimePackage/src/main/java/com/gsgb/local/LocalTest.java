package com.gsgb.local;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
     * 测试不带时区的时间日期类的空参的now方法，获取当前时间
     */
    @Test
    public void testNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println("localDateTime的时间是:" + localDateTime);
        System.out.println("localDate的时间是:" + localDate);
        System.out.println("localTime的时间是:" + localTime);
    }

    /**
     * 2.获取一些常量
     * 测试时间日期类的一些常量
     * 主要看{@link LocalTime}的一些
     */
    @Test
    public void testConstant() {
        /*System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.MIN);

        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);*/

        System.out.println("某一天的结束时间是:"+LocalTime.MAX);
        System.out.println("某一天的开始时间是:"+LocalTime.MIN);
        System.out.println("某一天的半夜时间是:"+LocalTime.MIDNIGHT);
        System.out.println("某一天的正中午时间是:"+LocalTime.NOON);
    }

    /**
     * 3.of()方法获取指定时间
     * 测试不带时区的时间日期类的of方法，获取指定时间
     */
    @Test
    public void testOf() {
        // 1.LocalDate
        LocalDate date1 = LocalDate.of(1997, 8, 8); // 设置1997-08-08
        // Mouth是一个代表月份枚举类
        LocalDate date2 = LocalDate.of(2000, Month.JUNE, 23); // 设置2000-06-23
        System.out.println("date1时间为:" + date1);
        System.out.println("date2时间为:" + date2);

        // 2.LocalTime
        LocalTime time1 = LocalTime.of(8, 10);
        System.out.println("time1时间为:" + time1);

        // 3.LocalDateTime
        LocalDateTime dateTime1 = LocalDateTime.of(2015, 9, 5, 8, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.JUNE, 25, 12, 0);
        System.out.println("dateTime1时间为:" + dateTime1);
        System.out.println("dateTime2时间为:" + dateTime2);

        // LocalDateTime有个特殊的of方法
        // LocalDateTime of(LocalDate date, LocalTime time)
        LocalDateTime dateTime3 = LocalDateTime.of(date1, time1);
        System.out.println("特殊of方法的dateTime3的时间为:" + dateTime3);
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
    public void testCompare(){

    }

    /**
     * 6.with方法
     */
    @Test
    public void testWith(){

    }

    /**
     * minus
     */
    @Test
    public void testPlusAndMinus(){

    }
}