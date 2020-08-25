package com.gsgb.introduce.useful;

import java.util.function.Predicate;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 18:37
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo08PredicateLogic {
    public static void main(String[] args) {
        boolean ageRange1 = judgeAnd(18,
                age -> age >= 18,
                age -> age <= 40);

        boolean ageRange2 = judgeOr(18,
                age -> age >= 18,
                age -> age <= 40);

        boolean ageRange3 = judgeNegate(25,
                age -> age >= 18);

        System.out.println("是否在年龄范围内：" + ageRange1); // true
        System.out.println("是否在年龄范围内：" + ageRange2); // true
        System.out.println("是否在年龄范围内：" + ageRange3); // false
    }

    public static boolean judgeAnd(Integer age, Predicate<Integer> p1, Predicate<Integer> p2) {
        return p1.and(p2).test(age);
    }

    public static boolean judgeOr(Integer age, Predicate<Integer> p1, Predicate<Integer> p2) {
        return p1.or(p2).test(age);
    }

    public static boolean judgeNegate(Integer age, Predicate<Integer> p) {
        return p.negate().test(age);
    }
}
