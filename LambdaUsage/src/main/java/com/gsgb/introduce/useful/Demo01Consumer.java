package com.gsgb.introduce.useful;

import java.util.function.Consumer;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 15:32
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo01Consumer {
    public static void main(String[] args) {
        // 需要将字符串全部变成小写
        printStrToLower("Hello Consumer",str ->
            System.out.println(str.toLowerCase())
        ); // hello consumer
    }

    public static void printStrToLower(String str,Consumer<String> c){
        c.accept(str);
    }
}
