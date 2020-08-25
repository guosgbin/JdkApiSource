package com.gsgb.introduce.useful;

import java.util.function.Predicate;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 17:41
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo07Predicate {
    public static void main(String[] args) {
        boolean adult = isAdult(23, age -> age >= 18);
        System.out.println("是否是成年人：" + adult);
    }

    public static boolean isAdult(Integer age, Predicate<Integer> p) {
        return p.test(age);
    }
}
