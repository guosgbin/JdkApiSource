package demo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/7/14 22:49
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo {

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
