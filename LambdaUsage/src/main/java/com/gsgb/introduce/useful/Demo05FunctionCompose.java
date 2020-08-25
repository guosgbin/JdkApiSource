package com.gsgb.introduce.useful;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 17:11
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo05FunctionCompose {
    public static void main(String[] args) {
        Integer timesLength = getTenTimesLength("令狐毕玉",
                length -> length *= 10,
                name -> name.length());

        System.out.println("名字的十倍长度是：" + timesLength);

    }

    public static Integer getTenTimesLength(String name,
                                            Function<Integer, Integer> f1, Function<String, Integer> f2) {
        return f1.compose(f2).apply(name);
    }
}
