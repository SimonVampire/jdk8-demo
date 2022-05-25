package com.example.jdk8.demo.functionalprogramming;

import com.example.jdk8.demo.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * @description 函数式编程-方法引用 JSK8新特性之一
 * 方法引入可以结合Lambda表达式让编写的代码变得更加精简
 * 方法引用的4种写法,分别为 构造函数引入、静态方法引入、实例方法引入,对象方法引入
 * @AUTHOR zhangxue9
 * @DATE 2022/5/19 11:08
 */
@Slf4j
public class MethodReferenceExample {
    public static void main(String[] args) {
        //User::new  构造函数引用
        Supplier<User> userSupplier = User::new;
        User user = userSupplier.get();
        user.setName("Simon");
        log.info("构造函数引用 name={} ",user.getName());
        //实例方法引入
        Supplier<String>  nameSupplier = user::getName;
        log.info("实例方法引入 name={}",nameSupplier.get());
        //静态方法引入
        Supplier<Integer> getRandomNum =MethodReferenceExample::getRandomNum;
        log.info("静态方法引入 random={}",getRandomNum.get());
        //对象方法引入
        MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
        Supplier<Integer>  integerSupplier= methodReferenceExample::getRandom;
        log.info("非静态方法引入 random={}",integerSupplier.get());
    }

    public int getRandom(){
        return ThreadLocalRandom.current().nextInt(100);
    }

    static int getRandomNum(){
        return ThreadLocalRandom.current().nextInt(100);
    }


}
