package com.gsgb.introduce.omit;

import com.gsgb.introduce.functional.DoubleParamNoReturn;
import com.gsgb.introduce.functional.DoubleParamReturn;
import com.gsgb.introduce.functional.OneParamNoReturn;
import org.junit.jupiter.api.Test;

/**
 * @author: Kwok Dylan GSGB
 * @date: 2020/8/24 14:15
 * <p>
 * 古之立大事者，不惟有超世之才，亦必有坚忍不拔之志——苏轼
 */
public class OmitDemo {
    @Test
    public void OmitType() {
        // 完整格式
        DoubleParamNoReturn fun1 = (Integer age, String name) -> {
            System.out.println("年龄：" + age + ",名称：" + name);
        };

        // 省略参数类型
        DoubleParamNoReturn fun2 = (age, name) -> {
            System.out.println("年龄：" + age + ",名称：" + name);
        };


        fun1.function(21,"陈树生"); // 年龄：21,名称：陈树生
        fun2.function(40,"张译"); // 年龄：40,名称：张译
    }

    @Test
    public void OmitTypeAndBrackets() {
        // 完整格式
        OneParamNoReturn fun1 = (Integer age) -> {
            System.out.println("年龄：" + age);
        };

        // 省略参数类型和括号
        OneParamNoReturn fun2 =  age -> {
            System.out.println("年龄：" + age);
        };

        fun1.function(21); // 年龄：21
        fun2.function(40); // 年龄：40
    }

    @Test
    public void OmitOthers() {
        // 完整格式
        DoubleParamReturn fun1 = (Integer age, String name) -> {
            return age > 18 && name.length() > 3;
        };

        // 省略格式
        DoubleParamReturn fun2 = (age, name) ->
             age > 18 && name.length() > 3
        ;

        System.out.println(fun1.function(21, "陈树生")); // false
        System.out.println(fun2.function(29, "第五佩佩")); // true
    }
}
