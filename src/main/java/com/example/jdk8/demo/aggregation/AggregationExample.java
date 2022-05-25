package com.example.jdk8.demo.aggregation;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 聚合 前面其实用了很多collect() ,就是聚合的一种
 * @AUTHOR zhangxue9
 * @DATE 2022/5/25 20:57
 */
@Slf4j
public class AggregationExample {

    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",20)
    );
    public static void main(String[] args) {
        //collect 汇总操作
        List<Integer> list =userList.stream().map(User::getAge).collect(Collectors.toList());
        log.info("list={}",list);
        //count  数量统计
        log.info("list.size={}",userList.stream().count());
        //reduce 计算返回唯一值
        // 1. Optional<T> reduce(BinaryOperator<T> accumulator)  如下面那就是一个累加器
        log.info("1.年龄的和：{}",list.stream().reduce((a,b)->a+b).get());
        // 2. T reduce(T identity,BinaryOperator<T> accumulator) 比上面多了一个初始值
        log.info("2.年龄的和：{}",list.stream().reduce(10,(a,b)->a+b));
        //3. <U> U reduce(U identity,
        //             BiFunction<U,? super T,U> accumulator,
        //             BinaryOperator<U> combiner)
        // 加了第3个参数，主要作用是处理并发操作，合并每个线程的result
        log.info("3.年龄的和：{}",list.stream().reduce(10,(a,b)->a+b, (a,b)-> 0));
    }
}
