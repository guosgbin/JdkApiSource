package com.gsgb.introduce.functional;

import java.util.Collection;
import java.util.List;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 15:01
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
@FunctionalInterface
public interface CalcMax {
    Integer getMax(List<Integer> coll);
}
