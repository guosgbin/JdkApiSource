package com.dylan.local;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.MinguoDate;
import java.time.chrono.MinguoEra;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/7/15 13:19
 *
 * 行百里者半九十--《战国策》
 */
public class LocalTest {

    /**
     * 测试旧版本的SimpleDateFormat的线程不安全问题
     */
    @Test
    public void testOldFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    Date date = dateFormat.parse("2020-08-05 23:13:54");
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    /**
     * now()方法获取当前时间
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
     * now()方法,其他类的now方法
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
     * 获取一些常量
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
     * of()方法获取指定时间
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
     * get方法
     * 测试不带时区的时间日期类的get方法，获取日期时间对象的各个字段值
     * 以LocalDateTime为例，其他两个是一样的
     */
    @Test
    public void testGet() {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("当前时间:" + dateTime);
        System.out.println("获取年份:" + dateTime.getYear());
        System.out.println("获取月份枚举:" + dateTime.getMonth());
        System.out.println("获取月份:" + dateTime.getMonthValue());
        System.out.println("获取月的第几天:" + dateTime.getDayOfMonth());
        System.out.println("获取小时:" + dateTime.getHour());
    }

    /**
     * 日期类的特殊的Get方法
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
        System.out.println("现在时间在当天是:" + (amPmOfDay == 0 ? "AM" : "PM"));

        // MINUTE_OF_HOUR 表示时间的分钟数
        int clockHourOfDay = dateTime.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println("现在时间的分钟是第" + clockHourOfDay + "分");
    }

    /**
     * 日期类的比较方法，以LocalDateTime为例
     * isAfter
     * isBefore
     * isEqual
     */
    @Test
    public void testCompare() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(2020, 7, 30, 12, 0);
        // 调用比较方法
        boolean before = now.isBefore(dateTime);
        boolean equal = now.isEqual(dateTime);
        boolean after = now.isAfter(dateTime);

        System.out.println("当前时间是否在指定时间之前: " + before);
        System.out.println("当前时间是否和指定时间相等: " + equal);
        System.out.println("当前时间是否在指定时间之后: " + after);
    }

    /**
     * with方法，直接修改日期
     */
    @Test
    public void testWith() {
        LocalDateTime now = LocalDateTime.now();
        // 1.修改年份为2022年
        LocalDateTime dateTime1 = now.withYear(2022);
        // 2.修改分钟为10分
        LocalDateTime dateTime2 = now.withMinute(10);
        System.out.println("修改年份为2022后的时间为: " + dateTime1);
        System.out.println("修改分钟为10分后的时间为: " + dateTime2);
        System.out.println("修改前后是否是同一个对象：" + (now == dateTime1));
    }

    /**
     * with方法，根据TemporalField类型修改日期
     */
    @Test
    public void testWith02() {
        LocalDateTime now = LocalDateTime.now();
        // 1.将日期中的星期修改为星期一
        LocalDateTime dateTime1 = now.with(ChronoField.DAY_OF_WEEK, 1);
        // 2.将日期中的小时数修改为22时
        LocalDateTime dateTime2 = now.with(ChronoField.HOUR_OF_DAY, 22);

        System.out.println("将日期中的星期修改为星期一：" + dateTime1);
        System.out.println("将日期中的小时数修改为21时：" + dateTime2);
    }

    /**
     * with方法，TemporalAdjuster接口和TemporalAdjusters类
     */
    @Test
    public void testWith03() {
        // 将日期转换为下个月的第一天的日期
        LocalDate now = LocalDate.now();
        LocalDate dateTime = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("将日期转换为下个月的第一天的日期:" + dateTime);
    }

    /**
     * with方法，重写TemporalAdjuster接口，自定义操作
     */
    @Test
    public void testWith04() {
        // 计算距离当前时间100天的日期
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.with(temporal -> {
            LocalDate date = (LocalDate) temporal;
            return date.plusDays(100);
        });

        System.out.println("计算距离当前时间100天的日期：" + localDate);
    }

    /**
     * minus和plus方法
     */
    @Test
    public void testPlusAndMinus01() {
        LocalDateTime now = LocalDateTime.now();
        // 1.当前日期增加一个星期
        LocalDateTime plusWeeks = now.plusWeeks(1);
        // 2.当前日期增加20天
        LocalDateTime plusDays = now.plusDays(20);

        System.out.println("当前日期增加一个星期：" + plusWeeks);
        System.out.println("当前日期增加20天：" + plusDays);
    }

    /**
     * minus和plus方法，ChronoUnit
     */
    @Test
    public void testPlusAndMinus02() {
        LocalDateTime now = LocalDateTime.now();
        // 1.当前日期增加两年
        LocalDateTime plusY = now.plus(2, ChronoUnit.YEARS);
        // 2.下一个世纪
        LocalDateTime plusC = now.plus(1, ChronoUnit.CENTURIES);

        System.out.println("当前日期增加两年：" + plusY);
        System.out.println("下一个世纪：" + plusC);
    }

    /**
     * minus和plus方法，ChronoUnit
     */
    @Test
    public void testPlusAndMinus03() {
        LocalDateTime now = LocalDateTime.now();
        // 1.当前时间增加1年1月1日
        LocalDateTime plusP = now.plus(Period.of(1, 1, 1));
        // 2.当前时间增加10分钟
        LocalDateTime plusD = now.plus(Duration.ofMinutes(10));

        System.out.println("当前时间增加1年1月1日：" + plusP);
        System.out.println("当前时间增加10分钟：" + plusD);
    }


    /**
     * query查询方法
     */
    @Test
    public void testQuery() {
        // 计算下一个国庆节还有多少天
        LocalDate now = LocalDate.now();
        long betweenDays = (long) now.query(temporal -> {
            LocalDate date = (LocalDate) temporal;
            int year = date.getYear();
            int monthValue = date.getMonthValue();
            int dayOfMonth = date.getDayOfMonth();
            // 获取当年国庆节的日期
            LocalDate nationalDay = LocalDate.of(year, 10, 1);
            if (date.isAfter(nationalDay)) {
                // 今年的国庆节已过，计算距离下一年国庆节的时间
                nationalDay = nationalDay.plusYears(1);
            }
            // 今年国庆节未过
            return ChronoUnit.DAYS.between(date, nationalDay);
        });

        System.out.println("下一个国庆节还有" + betweenDays + "天");
    }

    /**
     * 测试时间戳类
     */
    @Test
    public void testInstant() {
        // 获取当前时间戳
        Instant now = Instant.now();
        long epochMilli = now.toEpochMilli();
        System.out.println("当前时间：" + now);
        System.out.println("当前时间戳：" + epochMilli);
    }

    /**
     * - Year类
     * - YearMonth类
     * - MonthDay类
     */
    @Test
    public void testYear() {
        // Year类判断某年是否是闰年
        boolean leap1 = Year.isLeap(1997);
        System.out.println("1997年是否是闰年：" + leap1);
        // Year类判断Year对象封装的年份是否是闰年
        boolean leap2 = Year.now().isLeap();
        System.out.println("今年是否是闰年：" + leap2);
        // YearMonth判断其封装的年份是否是闰年
        boolean leapYear = YearMonth.now().isLeapYear();
        System.out.println("今年是否是闰年：" + leapYear);
    }

    /**
     * Month枚举类
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

    /********************** day02 ********************/

    /**
     * ZoneID 世界时区类
     */
    @Test
    public void testZoneId() {
        // 1.获取ZoneId封装的所有地区时区信息
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        zoneIds.forEach(System.out::println); // 很多类型
        System.out.println("地区时区信息个数：" + zoneIds.size()); // 600
        // 2.获取当前时区
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); // 默认当前时区
        System.out.println("当前时区：" + zoneId);
        System.out.println("当前时区时间：" + zonedDateTime);

        // 3.获得指定时区的时间
        LocalDateTime japanTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("当前日本时间为：" + japanTime);
        // 4.获得指定时区的时间
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime huZhiMingTime = now.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("当前胡志明市时间为：" + huZhiMingTime);
        // 5.根据偏移量获得时间
        LocalDateTime utc2Time = LocalDateTime.now(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(2)));
        System.out.println("标准UTC偏移2个时区的时间为：" + utc2Time);
    }

    /**
     * 带时区的时间类
     */
    @Test
    public void testZoneDateTime() {
        // 1.获取当前时间
        ZonedDateTime now = ZonedDateTime.now();
        // 2.当前时间增加2天
        ZonedDateTime zonedDateTime = now.plusDays(2);
        // 3.获得当前时间是星期几
        DayOfWeek dayOfWeek = now.getDayOfWeek();
    }

    /**
     * ZonedDateTime和LocalDateTime等转换
     */
    @Test
    public void testZoneTurnLocal() {
        // 1.LocalDateTime -> ZonedDateTime
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(ZoneId.systemDefault());

        // 2.LocalDate -> ZonedDateTime
        LocalDate localDate1 = LocalDate.now();
        ZonedDateTime zonedDateTime2 = localDate1.atStartOfDay(ZoneId.systemDefault());

        // 3.LocalTime -> ZonedDateTime
        LocalTime localTime1 = LocalTime.now();
        ZonedDateTime zonedDateTime3 = localTime1.atDate(LocalDate.now()).atZone(ZoneId.systemDefault());

        // 4.ZonedDateTime -> LocalDateTime
        LocalDateTime localDateTime2 = zonedDateTime1.toLocalDateTime();

        // 5.ZonedDateTime -> LocalDate
        LocalDate localDate2 = zonedDateTime2.toLocalDate();

        // 6.ZonedDateTime -> LocalTime
        LocalTime localTime = zonedDateTime3.toLocalDateTime().toLocalTime();
    }


    /**
     * 计算两个时间之间的差值，主要精确到秒、毫秒、纳秒这些
     */
    @Test
    public void testDuration() {
        LocalDateTime now = LocalDateTime.now(); // 2020-07-27 00:05:32.009
        LocalDateTime dateTime = LocalDateTime.of(2020, 8, 31, 1, 0); // 1时0分0秒
        Duration duration = Duration.between(now, dateTime);

        long days = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long millis = duration.toMillis();
        long nanos = duration.toNanos();

        System.out.println("当前时间：" + now);
        System.out.println("两个时间间隔" + days + "天");
        System.out.println("两个时间间隔" + hours + "小时");
        System.out.println("两个时间间隔" + minutes + "分钟");
        System.out.println("两个时间间隔" + millis + "毫秒");
        System.out.println("两个时间间隔" + nanos + "纳秒");
    }

    /**
     * 计算两个日期之间的差值，和上面的Duration有区别
     */
    @Test
    public void testPeroid() {
        LocalDate now = LocalDate.now(); // 2020-07-27
        LocalDate date = LocalDate.of(2020, 10, 1); // 1时0分0秒
        Period period = Period.between(now, date);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("当前时间：" + now);
        System.out.println("两个时间间隔：" + years + "年" + months + "月" + days + "日"); // 0年1月22日
    }

    @Test
    public void testChronoUnit() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = LocalDateTime.of(2020, 10, 1, 0, 0); // 1时0分0秒

        long nanos = ChronoUnit.NANOS.between(now, date);
        long micros = ChronoUnit.MICROS.between(now, date);
        long days = ChronoUnit.DAYS.between(now, date);
        long centuries = ChronoUnit.CENTURIES.between(now, date);

        System.out.println("两个时间相隔纳秒：" + nanos);
        System.out.println("两个时间相隔微秒：" + micros);
        System.out.println("两个时间相隔天数：" + days);
        System.out.println("两个时间相隔世纪数：" + centuries);
    }

    /**
     * 日期的解析和格式化 DateTimeFormatter
     * 格式化
     */
    @Test
    public void testDateFormat() {
        // LocalDate格式化
    /*    LocalDate now = LocalDate.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("格式化之后:" + format);*/
        // 1.自定义格式
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH::mm::ss"));
        System.out.println("格式化之前：" + now);
        System.out.println("格式化之后：" + format);
        // 2.使用自带的格式，有很多内置格式
        String format2 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("自带的格式：" + format2);
        // 3.使用带时区的of
        String format3 = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
        System.out.println("带时区的格式：" + format3);
        // 4.将时间对象作为参数
        String format4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH::mm::ss").format(now);
        System.out.println("将时间对象作为参数传入：" + format4);
    }

    @Test
    public void testFormatStyle(){
        LocalDate now = LocalDate.now();
        String format1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(now);
        String format2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(now);
        String format3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(now);
        String format4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(now);

        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
        System.out.println(format4);
    }

    @Test
    public void testDateParse() {
        String dateStr = "2020年08月10日 23:25:52";
//        String dateStr = "2020-08-10 23:25:52";

//        LocalDateTime now = LocalDateTime.now();
//        String format = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
//        System.out.println("格式化之前：" + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+8"));
        LocalDateTime dateTime = LocalDateTime.parse(dateStr,formatter);

        System.out.println(dateTime);

        System.out.println("=========");
        TemporalAccessor temporal = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss").parse(dateStr);

    }

    /**
     * 转换为Date
     */
    @Test
    public void testTurnOff() {
        // LocalDateTime -> Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant1 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date1 = Date.from(instant1);
        System.out.println("localDateTime:" + localDateTime);
        System.out.println("date:" + date1);
        System.out.println("===============");

        // LocalDate -> Date
        LocalDate localDate = LocalDate.now();
        Instant instant2 = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date2 = Date.from(instant2);
        System.out.println("localDate:" + localDate);
        System.out.println("date:" + date2);
        System.out.println("===============");

        // LocalTime -> Date
        LocalTime localTime = LocalTime.now();
        Instant instant3 = localTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant();
        Date date3 = Date.from(instant3);
        System.out.println("localTime:" + localTime);
        System.out.println("date:" + date3);
        System.out.println("===============");
    }

    /**
     * Date转换
     */
    @Test
    public void testTurnDown() {
        // Date -> LocalDateTime
        Date date1 = new Date();
        LocalDateTime localDateTime = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("date:" + date1);
        System.out.println("localDateTime:" + localDateTime);
        System.out.println("===============");

        // Date -> LocalDate
        Date date2 = new Date();
        LocalDate localDate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("date:" + date2);
        System.out.println("localDate:" + localDate);
        System.out.println("===============");

        // Date -> LocalTime
        Date date3 = new Date();
        LocalTime localTime = date3.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        System.out.println("date:" + date3);
        System.out.println("localTime:" + localTime);
        System.out.println("===============");
    }



    @Test
    public void testDateTurnNew(){
        // 1.LocalDateTime -> Date

        Date date1 = Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)));
        System.out.println(date1);

        // 2.LocalDate -> Date
        Date date2 = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date2);

        // 3.LocalTime -> Date

        Date date3 = Date.from(LocalTime.now().atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date3);

        // 4.Date -> LocalDateTime
        Date date4 = new Date();
        LocalDateTime localDateTime1= LocalDateTime.ofInstant(date4.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime2 = date4.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        // 5.Date -> LocalDate
        Date date5 = new Date();
        LocalDate localDate = date5.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 6.Date -> LocalTime
        Date date6 = new Date();
        LocalTime localTime = date6.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        // Calendar -> ZoneDateTime
        ZonedDateTime zonedDateTime = Calendar.getInstance().toInstant().atZone(ZoneId.systemDefault());
    }

    /**
     * 测试民国历
     */
    @Test
    public void testMinguo() {
        MinguoDate now = MinguoDate.now();
        System.out.println("民国历：" + now); // Minguo ROC 109-08-12

        // LocalDate -> MinguoDate
        LocalDate localDate = LocalDate.of(1912, 1, 1);
        MinguoDate minguo = MinguoDate.from(localDate);
        System.out.println("MinguoDate : " + minguo);   // Minguo ROC 1-01-01
        System.out.println("LocalDate : " + localDate); // 1912-01-01

        // MinguoDate -> LocalDate
        MinguoDate minguo2 = MinguoDate.of(109, 8, 24);
        //LocalDate localDate = LocalDate.ofEpochDay(minguo2.toEpochDay());
        LocalDate localDate2 = LocalDate.from(minguo2);
        System.out.println("MinguoDate : " + minguo2);   // Minguo ROC 109-08-24
        System.out.println("LocalDate : " + localDate2); // 2020-08-24
    }
}