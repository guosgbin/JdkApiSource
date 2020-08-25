package com.gsgb.introduce.useful;

import java.security.SecureRandom;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 16:14
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo03Supplier {
    public static void main(String[] args) {
        // 生成一个随机数字字符串
        Integer numString = randomNumString(() -> {
            SecureRandom random = new SecureRandom();
            return random.nextInt(10000);
        });

        System.out.println(numString);
    }

    public static Integer randomNumString(Supplier<Integer> s){
        return s.get();
    }
}
