package com.gsgb.introduce.functional;

import java.util.function.Predicate;

/**
 * @author: Kwok Dylan GSGB
 * @date: 2020/8/19 23:48
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
@FunctionalInterface
public interface WorkInterface {
    /**
     * 抽象方法
     */
    void work();

    /**
     * 默认方法
     */
    default void study() {
        System.out.println("studying...");
    }


    /**
     * 静态方法
     */
    static void sleep(){
        System.out.println("sleeping...");
    }

    /**
     * 重写Object类的toString方法
     */
    String toString();
}
