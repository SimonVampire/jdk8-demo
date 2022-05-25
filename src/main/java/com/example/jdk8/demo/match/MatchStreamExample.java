package com.example.jdk8.demo.match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 匹配
 * @author zhangxue9
 * @date 2022/5/25 20:10
 */
@Slf4j
public class MatchStreamExample {
    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",20)
    );


    public static void main(String[] args) {
        log.info("判断是否全部匹配:{}", userList.stream().allMatch(t->t.getAge()<25));
        log.info("判断是否都不匹配:{}", userList.stream().noneMatch(t->t.getAge()<25));
        log.info("判断是否任意一个匹配:{}", userList.stream().anyMatch(t->t.getAge()<25));

    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        private Integer id;
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
