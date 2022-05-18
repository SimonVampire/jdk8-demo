package com.example.jdk8demo.functionalprogramming;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * @description Consumer<T> 消费型接口
 *  有入参，无返回值
 * 方法：void accept(T t);
 * @AUTHOR zhangxue9
 * @DATE 2022/5/18 19:08
 */
@Slf4j
public class ConsumerExample {
    public static void main(String[] args) {
        String str ="aaa";
        log.info("origin:{}",str);
        Consumer<String> consumer = t->{
            t=t.replace('a','b');
            log.info("consumer:{}",t);
        };
        Consumer<String> after1 = t->{
            t=t.replace('b','c');
            log.info("after1:{}",t);
        };
        after1.accept(str);
        consumer.accept(str);
        Consumer<String> after2 = t->{
            log.info("after2:{}",t);
        };
        //andThen的使用很有意思
        consumer.andThen(after1).andThen(after2).accept(str);

    }
}
