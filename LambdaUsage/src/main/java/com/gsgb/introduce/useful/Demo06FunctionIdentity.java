package com.gsgb.introduce.useful;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 17:30
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Demo06FunctionIdentity {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("司马懿", "夏侯惇", "张辽", "夏侯子臧");
//        Map<String, Integer> map =
//                names.stream().collect(Collectors.toMap(Function.identity(), name -> name.length()));
        Map<String, Integer> map =
                names.stream().collect(Collectors.toMap(name -> name, name -> name.length()));
        map.forEach((k, v) -> System.out.println(k + "==" + v)); // 遍历
    }
}
