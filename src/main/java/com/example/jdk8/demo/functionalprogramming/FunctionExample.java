package com.example.jdk8.demo.functionalprogramming;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @description 函数型接口Function<T, R>
 *     有入参 有返回值
 *     方法 R apply(T t);
 * @AUTHOR zhangxue9
 * @DATE 2022/5/18 18:14
 */
@Slf4j
public class FunctionExample {

    public static void main(String[] args) {
        //定义了一个自己的函数 myFunction，从MAP中取key为simon的value值
        Function<ConcurrentHashMap<String,String>,String> myFunction = t-> t.get("simon");
        //组装map
        ConcurrentHashMap<String,String> localMap = new ConcurrentHashMap<>();
        localMap.computeIfAbsent("simon",p->"I'm Simon!");
        localMap.computeIfAbsent("hank",p->"I'm Hank!");
        //调用myFunction 获取map中的value值
        log.info("simon->{}",myFunction.apply(localMap));
    }

}
