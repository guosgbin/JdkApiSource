package com.gsgb.introduce.reference;

import java.util.function.Supplier;

/**
 * @author: Dylan Kwok GSGB
 * @date: 2020/8/24 23:10
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class ThisDemo {
    public static void main(String[] args) {
        ThisDemo process = new ThisDemo();
        process.goHome();
    }

    /**
     * 创建一辆车
     */
    public String buyCar() {
        return "奥拓";
    }

    /**
     * 回家需要的交通工具
     */
    public void newVehicle(Supplier<String> s) {
        String carBrand = s.get();
        System.out.println("我开" + carBrand + "回家，很有面子");
    }

    /**
     * 回家过年
     */
    public void goHome() {
//        newVehicle(() -> this.buyCar()); // Lambda表达式方式
        newVehicle(this::buyCar); // this方法引用
    }
}
