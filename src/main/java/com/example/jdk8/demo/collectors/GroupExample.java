package com.example.jdk8.demo.collectors;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 17:55
 */
@Slf4j
public class GroupExample {

    @Test
    public void testGroup(){
        //groupingBy(Function) 和断言分组类似  这种非并发 效率低
        Map<Boolean,List<User>> map = userList.stream().collect(Collectors.groupingBy(a-> a.getAge()>20));
        log.info("根据年龄分组map：{}",map);
        //groupingByConcurrent(Function) 并发
        Map<Boolean,List<User>> concurrentMap = userList.stream().collect(Collectors.groupingByConcurrent(a-> a.getAge()>20));
        log.info("并发根据年龄分组concurrentMap：{}",concurrentMap);

        // groupingByConcurrent(Function, Collector) 并发
        Map<Boolean,Long> concurrentMap2 = userList.stream().collect(
                Collectors.groupingByConcurrent(a-> a.getAge()>20,Collectors.counting()));
        log.info("并发根据年龄分组计数concurrentMap2：{}",concurrentMap2);

        // groupingBy(Function, Supplier, Collector)  非并发
        // 由ConcurrentMap生产的ConcurrentMap由提供的工厂功能创建。
        Map<Boolean,Long> concurrentMap3 =userList.stream().collect(Collectors.groupingByConcurrent(a-> a.getAge()>20,ConcurrentHashMap::new,Collectors.counting()));
        log.info("并发根据年龄分组计数concurrentMap3：{}",concurrentMap3);

        // groupingByConcurrent(Function, Supplier, Collector)并发
        // 这里的工厂直接使用 ConcurrentHashMap::new 和 groupingByConcurrent(Function, Collector) 等同
        //多个工厂参数 可以便于自定义map工厂，如果无需自定义，则直接使用 groupingByConcurrent(Function, Collector)即可
        Map<Boolean,Long> concurrentMap4 =userList.stream().collect(Collectors.groupingByConcurrent(a-> a.getAge()>20,ConcurrentHashMap::new,Collectors.counting()));
        log.info("并发根据年龄分组计数concurrentMap3：{}",concurrentMap4);
    }



    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",16),
            new User("Jay",25),
            new User("Jack",25)
    );
}
