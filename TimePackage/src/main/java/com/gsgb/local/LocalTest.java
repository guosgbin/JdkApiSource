package com.gsgb.local;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/7/15 13:19
 * 行百里者半九十--《战国策》
 *
 * 测试不带时区的时间日期类
 */
public class LocalTest {

    /**
     * 测试空参的now方法，获取当前时间
     */
    @Test
    public void testNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println("localDateTime的时间是："+localDateTime);
        System.out.println("localDate的时间是："+localDate);
        System.out.println("localTime的时间是："+localTime);
    }
}
