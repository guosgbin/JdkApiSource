package com.gsgb.introduce;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Kwok Dylan GSGB
 * @date: 2020/8/12 23:50
 *
 * 前事之不忘，后事之师——《战国策》
 */
public class TraditionEmpty {

    /**
     * 传统判空
     */
    @Test
    public void traditionEmpty01(){
//        String username = "蔡瑁,张允";
        String username = null;
        // 按逗号切割
        if(username != null){
            String[] split = username.split(",");
            System.out.println(Arrays.toString(split));
        }else{
            System.out.println("username is null");
        }

    }

    /**
     * 传统遍历集合 判空
     */
    @Test
    public void traditionEmpty02(){
        List<String> names = Arrays.asList("曹仁", "文丑", "陆逊");
        // 遍历集合前需要我们进行集合的判空，需要写一个if 比较麻烦
        if(names != null || !names.isEmpty()){
            for (String name : names) {
                System.out.println(name);
            }
        }
    }

}
