package com.example.jdk8.demo.maxormin;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @description 最大 最小
 * @AUTHOR zhangxue9
 * @DATE 2022/5/25 20:47
 */
@Slf4j
public class MaxOrMinStreamExample {

    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",20)
    );

    public static void main(String[] args) {

        log.info("年龄最小的:{}",userList.stream().min((a, b)->a.getAge()-b.getAge()));
        log.info("年龄最大的:{}",userList.stream().max((a, b)->a.getAge()-b.getAge()));
    }
}
