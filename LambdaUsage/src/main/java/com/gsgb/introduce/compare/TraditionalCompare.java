package com.gsgb.introduce.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Kwok Dylan GSGB
 * @date: 2020/8/20 0:30
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class TraditionalCompare {
    public static void main(String[] args) {

        // 匿名内部类开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类...");
            }
        }).start();

        // lambda表达式开启线程
        new Thread(()-> System.out.println("lambda表达式...")).start();
    }
}
