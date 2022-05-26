package com.example.jdk8.demo.stream.find;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 查找
 * @author zhangxue9
 * @date 2022/5/25 20:28
 */
@Slf4j
public class FindStreamExample {

    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",20)
    );

    public static void main(String[] args) {
        //查找操作，查询流中任意元素并返回Optional
        Optional<User> anyUser =userList.stream().findAny();
        Optional<User> anyUser2 =userList.parallelStream().findAny();
        //查找操作，查询流中的第一个元素
        Optional<User> firstUser = userList.stream().findFirst();
        //并行的情况下anyUser并不一定是第一个
        log.info("anyUser:{}", anyUser.isPresent()?anyUser.get():null);
        log.info("anyUser2:{}", anyUser2.isPresent()?anyUser2.get():null);
        log.info("判断是否任意一个匹配:{}", firstUser.isPresent()?firstUser.get():null);
    }

}
