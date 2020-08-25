package com.gsgb.introduce.useful;

import java.util.function.Predicate;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 18:48
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo09PredicateEqual {
    public static void main(String[] args) {
        boolean equals = isEquals("曹仁", Predicate.isEqual("曹爽"));
        System.out.println("是否相等：" + equals); // false
    }

    public static boolean isEquals(String name, Predicate<String> p) {
        return p.test(name);
    }
}
