package com.example.jdk8.demo.collectors;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description 断言分组
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 17:17
 */
@Slf4j
public class PartitionExample {

    @Test
    public void partitionTest(){
        //返回一个 Collector ，根据Predicate对输入元素进行 Predicate ，并将它们组织成 Map<Boolean, List<T>> 。
        Map<Boolean,List<User>> partionMap =  userList.stream().collect(Collectors.partitioningBy(u->u.getAge()>20));
        log.info("大于20的用户{}",partionMap.get(Boolean.TRUE));
        log.info("不大于20的用户{}",partionMap.get(Boolean.FALSE));

        //返回一个Collector ，它根据Predicate对输入元素进行Predicate ，
        // 根据另一个Collector减少每个分区中的值，并将其组织成Map<Boolean, D> ，
        // 其值是下游缩减的结果
        //如下先断言分组（>20 和<=20）分为了2组，然后根据下游的Collector计数 最终得到>20 和<=20各多少人
        Map<Boolean,Long> partionMap2= userList.stream().collect(
                Collectors.partitioningBy(u->u.getAge()>20,Collectors.counting()));
        log.info("大于20的用户{}",partionMap2);
    }

    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",16),
            new User("Jay",25)
    );

}
