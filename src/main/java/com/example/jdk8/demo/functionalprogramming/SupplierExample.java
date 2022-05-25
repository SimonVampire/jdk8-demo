package com.example.jdk8.demo.functionalprogramming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * @description Supplier<T> 供给型接口
 * 无入参 有返回值 不要被上面的泛型骗了，这个泛型是返回类型 和断言接口不一样（断言的泛型是入参）
 * 方法：T get();
 * @AUTHOR zhangxue9
 * @DATE 2022/5/18 19:01
 */
@Slf4j
public class SupplierExample {
    public static void main(String[] args) {
        //定义随机数供给接口
        Supplier<Integer> random = ()-> ThreadLocalRandom.current().nextInt();

        //获取随机数
        log.info("get random->{}",random.get());
    }


}
