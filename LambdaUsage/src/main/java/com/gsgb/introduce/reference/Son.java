package com.gsgb.introduce.reference;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 23:29
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class Son extends Father {
    public void goFishing(){
//        function(()-> super.goFishing());
        // 方法引用方式
        function(super::goFishing);
    }

    public void function(FishingFunction fish){
        fish.fishing();
        System.out.println("小弟弟带了太阳伞...");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.goFishing();
    }

}
