package com.gsgb.introduce.useful;

import java.util.function.Consumer;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 15:42
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo02ConsumerAndThen {
    public static void main(String[] args) {
        secretLowB("Dylan Kwok",
                name -> {
                    System.out.println(name.toLowerCase());
                },
                name -> {
                    System.out.println(name.toUpperCase());
                });

        secret("Dylan Kwok",
                name -> {
                    System.out.println(name.toLowerCase());
                },
                name -> {
                    System.out.println(name.toUpperCase());
                });
    }

    public static void secretLowB(String name, Consumer<String> c1, Consumer<String> c2) {
        c1.accept(name);
        c2.accept(name);
    }

    public static void secret(String name, Consumer<String> c1, Consumer<String> c2) {
        c1.andThen(c2).accept(name);
    }
}
