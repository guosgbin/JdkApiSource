package com.gsgb.introduce.useful;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 16:27
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo04Function {
    public static void main(String[] args) {
        // 计算雨果名字的长度,apply方法输入字符串类型,输出Integer类型
        Integer lenth = getStrLenth("Victor Hugo",
                name -> name.length());

        System.out.println("雨果名字的长度为：" + lenth);
    }

    public static Integer getStrLenth(String name, Function<String, Integer> f) {
        return f.apply(name);
    }
}
