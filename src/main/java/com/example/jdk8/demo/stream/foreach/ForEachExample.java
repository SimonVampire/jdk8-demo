package com.example.jdk8.demo.stream.foreach;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description 遍历
 * @AUTHOR zhangxue9
 * @DATE 2022/5/25 21:22
 */
@Slf4j
public class ForEachExample {

    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",20)
    );

    public static void main(String[] args) {
        AtomicInteger a= new AtomicInteger(10);

        AtomicReference<String> b= new AtomicReference<String>(Strings.EMPTY);
        //不要修改外部变量，多线程不安全
        //不能使用break、return、continue等关键字结束或跳出循环
        userList.stream().forEach(t->t.setAge(t.getAge()+1));
        userList.stream().forEach(System.out::println);

        userList.stream().forEach(t->{
            t.setAge(t.getAge()+ a.get());
        });
        userList.stream().forEach(System.out::println);


        userList.stream().forEach(t->{
            if("simon".equals(t.getName())){
                a.set(t.getAge());
            }

        });
       log.info("给外部变量赋值a={}",a.get());

    }
}
