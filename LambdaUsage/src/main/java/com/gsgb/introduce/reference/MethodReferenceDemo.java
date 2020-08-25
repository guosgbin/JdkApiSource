package com.gsgb.introduce.reference;

import com.gsgb.introduce.functional.CalcMax;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 14:34
 * <p>
 * 读书欲睡，引锥自剌其股，血流至足——《战国策》
 * <p>
 * 方法引用
 */
public class MethodReferenceDemo {

    /**
     * 冗余,求出数组的最大值
     */
    @Test
    public void redundance() {
        // 冗余情况
        CalcMax calcMaxRedundance = list -> {
            int max = list.get(0);
            for (Integer ele : list) {
                if (ele > max) {
                    max = ele;
                }
            }
            return max;
        };

        // Collections类有个静态方法计算集合的最大值
        CalcMax calcMax2 = list -> Collections.max(list);

        // 使用方法引用
        CalcMax calcMax3 = Collections::max;

        List<Integer> asList = Arrays.asList(1, 2, 4, 7, 3, 2);
        System.out.println("集合的最大值：" + calcMaxRedundance.getMax(asList)); // 7
        System.out.println("集合的最大值：" + calcMax2.getMax(asList)); // 7
        System.out.println("集合的最大值：" + calcMax3.getMax(asList)); // 7
    }

    /**
     * 对象::成员方法
     */
    @Test
    public void objectReferenceMethod() {
        Date now = new Date();

        Supplier supplier1 = () -> now.getTime();
        // 方法引用
        Supplier supplier2 = now::getTime;

        System.out.println("当前时间戳:" + supplier1.get());
        System.out.println("当前时间戳:" + supplier2.get());
    }

    /**
     * 类名::静态方法
     */
    @Test
    public void classReferenceStaticMethod() {
        Supplier supplier1 = () -> LocalDateTime.now();
        // 方法引用
        Supplier supplier2 = LocalDateTime::now;

        System.out.println("当前日期:" + supplier1.get());
        System.out.println("当前日期:" + supplier2.get());
    }

    /**
     * 类名::成员方法
     */
    @Test
    public void classReferenceMemberMethod() {
        Function<String, Integer> function1 = name -> name.length();
        // 类名::成员方法
        Function<String, Integer> function2 = String::length;

        System.out.println("获得名字的长度：" + function1.apply("第五佩佩")); // 4
        System.out.println("获得名字的长度：" + function2.apply("肖珏")); // 2
    }

    /**
     * 类名::new
     */
    @Test
    public void classReferenceConstruction() throws Exception {
        // 创建一个长度默认的ArrayList
        Supplier supplier1 = () -> new ArrayList<>();
        Supplier supplier2 = ArrayList::new;

        // 创建一个长度为32的ArrayList
        Function<Integer, ArrayList> function1 = size -> new ArrayList<>(size);
        Function<Integer, ArrayList> function2 = ArrayList::new;

        // 获得集合对象
        ArrayList list = function2.apply(32);
        // 反射获得集合容量
        Field elementDataField = ArrayList.class.getDeclaredField("elementData");
        elementDataField.setAccessible(true);
        Object[] elementDate = (Object[]) elementDataField.get(list);
        System.out.println("集合容量为：" + elementDate.length); // 32
    }

    /**
     * 类名[]::构造器
     */
    @Test
    public void classArrayReferenceConstruction() {
        // 创建一个指定长度的int数组
        Function<Integer, int[]> function1 = length -> new int[length];
        // 方法引用创建数组
        Function<Integer, int[]> function2 = int[]::new;

        System.out.println("数组长度：" + function1.apply(5).length); // 5
        System.out.println("数组长度：" + function2.apply(6).length); // 6
    }

    /**
     * lambda 需要注意的问题
     */
    @Test
    public void tips01() {
        int count = 5;

        Function<Integer, Integer> f1 = num -> {
//            count = count + 5;
            return num + 5;
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
//                count = count + 5;
            }
        }).start();
    }
}
