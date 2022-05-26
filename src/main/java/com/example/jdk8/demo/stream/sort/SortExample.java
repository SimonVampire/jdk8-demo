package com.example.jdk8.demo.stream.sort;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 排序
 * @AUTHOR zhangxue9
 * @DATE 2022/5/25 21:00
 */
@Slf4j
public class SortExample {

    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",20)
    );
    public static void main(String[] args) {
        //比较器排序
        log.info("sort(Comparator):{}",userList.stream().sorted((a,b)->a.getAge()-b.getAge()).collect(Collectors.toList()));
        log.info("sort(Comparator)方式二:{}",userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList()));
        //USER对象需要实现Comparable
        // 否则会报错 com.example.jdk8.demo.pojo.User cannot be cast to java.lang.Comparable
        log.info("sort():{}",userList.stream().sorted().collect(Collectors.toList()));

        log.info("sort(Comparator) 倒序:{}",userList.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList()));
        //自己实现Comparable，这样写倒序是无用的
        log.info("逆序无效:{}",userList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
