package com.gsgb.optional;

import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author: Kwok Dylan GSGB
 * @date: 2020/8/13 0:30
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class OptionalTest {

    /**
     * 使用Optional优化第一个例子的传统判空
     */
    @Test
    public void optimizeTraditionEmpty() {
//        String username = "蔡瑁,张允";
        String username = null;
        Optional.ofNullable(username).ifPresent(name -> {
            String[] split = username.split(",");
            System.out.println(Arrays.toString(split));
        });
    }

    /**
     * 创建Optional对象
     */
    @Test
    public void createOptional(){
        String username = "邢道荣";

        Optional<String> op1 = Optional.of(username);
        Optional<String> op2 = Optional.ofNullable(username);
        Optional<Object> empty = Optional.empty();
    }

    /**
     * 测试get方法
     */
    @Test
    public void getDemo(){
        String username = null;
//        Optional<String> op1 = Optional.of(username);
        Optional<String> op2 = Optional.ofNullable(username);

//        String s = op1.get();
        String s1 = op2.get();
    }

    /**
     * 测试isPresent方法，不推荐使用
     */
    @Test
    public void isPresentDemo(){
//        String username = "lv meng"; // 吕蒙
        String username = null;
        Optional<String> op = Optional.ofNullable(username);
        if(op.isPresent()){
            String upperUsername = op.get().toUpperCase();
            System.out.println(upperUsername);
        }else{
            System.out.println("username is null");
        }
    }

    /**
     * 测试ifPresent方法，推荐使用
     */
    @Test
    public void ifPresentDemo(){
        String username = "lv meng"; // 吕蒙
//        String username = null;
        Optional<String> op = Optional.ofNullable(username);
        op.ifPresent(name ->{
            System.out.println(name.toUpperCase());
        });
    }

    /**
     * 测试过滤
     */
    @Test
    public void filterDemo(){
        // 判断集合的长度是否大于3
        List<String> nameList = Arrays.asList("关平", "徐庶", "诸葛村夫", "王司徒");
        Optional optional = Optional.ofNullable(nameList).filter(names ->
                names.size() > 3
        );

        System.out.println(optional);
    }

    /**
     * 转换方法 map
     */
    @Test
    public void mapDemo(){
        String username = "康帅博蜂蜜柚子";
        Optional<Integer> op = Optional.ofNullable(username).map(name ->
                name.length()
        );
        System.out.println(op);
    }

    /**
     * 转换方法 map
     */
    @Test
    public void flatMapDemo(){
        String username = "康帅博脑残牛肉面";
        Optional<Integer> op = Optional.ofNullable(username).flatMap(name ->
                Optional.ofNullable(name.length())
        );
        System.out.println(op);
    }

    /**
     * orElse
     */
    @Test
    public void orElseDemo(){
//        String username = null;
        String username = "康帅博脑残牛肉面";
        username = Optional.ofNullable(username).orElse("unkown name");
        System.out.println(username);
    }

    /**
     * orElseGet
     */
    @Test
    public void orElseGetDemo(){
        String username = null;
//        String username = "康帅博脑残牛肉面";
        username = Optional.ofNullable(username).orElseGet(()->{
            String name = "東南西北中發";
            return name.substring(4);
        });
        System.out.println(username);
    }

    /**
     * orElseThrow
     */
    @Test
    public void orElseThrowDemo(){
        String username = null;
//        String username = "康帅博脑残牛肉面";
        username = Optional.ofNullable(username).orElseThrow(()->
            new RuntimeException("username is null")
        );
        System.out.println(username);
    }

}
