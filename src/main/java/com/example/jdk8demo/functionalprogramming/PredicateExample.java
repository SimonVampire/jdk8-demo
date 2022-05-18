package com.example.jdk8demo.functionalprogramming;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @description Predicate<T>
 * 有入参，返回布尔类型
 * boolean test(T t);
 * @AUTHOR zhangxue9
 * @DATE 2022/5/18 18:53
 */
@Slf4j
public class PredicateExample {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 大于10
     *
     * @param
     * @return void
     * @author zhangxue9
     * @date 2022/5/18 21:23
     */
    private static void test1() {
        Predicate<Integer> predicate = s -> s > 10;
        log.info(" test1 -> {}", predicate.test(11));
    }

    /**
     * 10的倍数 and 大于10
     *
     * @param
     * @return void
     * @author zhangxue9
     * @date 2022/5/18 21:22
     */
    private static void test2() {
        Predicate<Integer> biggerPredicate = s -> s > 1;
        Predicate<Integer> evenNumber = s -> s % 10 == 0;
        log.info(" test2-> {}", biggerPredicate.and(evenNumber).test(12));
    }

    /**
     * 10的倍数 or 大于10
     *
     * @param
     * @return void
     * @author zhangxue9
     * @date 2022/5/18 21:22
     */
    private static void test3() {
        Predicate<Integer> biggerPredicate = s -> s > 1;
        Predicate<Integer> evenNumber = s -> s % 10 == 0;
        log.info(" test3-> {}", biggerPredicate.or(evenNumber).test(12));
    }

    /**
     * isEqual的使用
     *
     * @param
     * @return void
     * @author zhangxue9
     * @date 2022/5/18 21:22
     */
    private static void test4() {
        Predicate<Integer> predicate = Predicate.isEqual(12);
        log.info("一共有{}个12", Stream.of(12, 12, 1, 3, 5).filter(predicate).filter(predicate).count());
    }


}
