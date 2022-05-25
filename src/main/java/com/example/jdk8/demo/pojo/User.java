package com.example.jdk8.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author zhangxue9
 * @date 2022/5/25 20:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {
    private Integer id;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(User o) {
        return o.getAge();
    }
}
