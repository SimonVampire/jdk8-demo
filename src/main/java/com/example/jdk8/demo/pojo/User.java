package com.example.jdk8.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;


/**
 * @author zhangxue9
 * @date 2022/5/25 20:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) //allSuper默认是false ，设置true对象比较才会同时比较父类ID;
public class User extends Base implements Comparable<User> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(User o) {
        return o.getAge();
    }

}
