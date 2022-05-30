package com.example.jdk8.demo.collectors;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 18:49
 */
@Slf4j
public class SummaryExample {
    private static List<User> userList = Arrays.asList(
            new User("simon",18),
            new User("hank",30),
            new User("lee",16),
            new User("Jay",25)
    );

    @Test
    public void testLongSummary(){
        LongSummaryStatistics summaryStatistics =userList.stream().collect(Collectors.summarizingLong(t->t.getAge()));
        log.info("getAverage：{}",summaryStatistics.getAverage());
        log.info("getCount：{}",summaryStatistics.getCount());
        log.info("getMax：{}",summaryStatistics.getMax());
        log.info("getMin：{}",summaryStatistics.getMin());
        log.info("getSum：{}",summaryStatistics.getSum());
    }


    @Test
    public void testDoubleSummary(){
        DoubleSummaryStatistics summaryStatistics =userList.stream().collect(Collectors.summarizingDouble(t->t.getAge()));
        log.info("getAverage：{}",summaryStatistics.getAverage());
        log.info("getCount：{}",summaryStatistics.getCount());
        log.info("getMax：{}",summaryStatistics.getMax());
        log.info("getMin：{}",summaryStatistics.getMin());
        log.info("getSum：{}",summaryStatistics.getSum());
    }
    @Test
    public void testIntSummary(){
        IntSummaryStatistics summaryStatistics =userList.stream().collect(Collectors.summarizingInt(t->t.getAge()));
        log.info("getAverage：{}",summaryStatistics.getAverage());
        log.info("getCount：{}",summaryStatistics.getCount());
        log.info("getMax：{}",summaryStatistics.getMax());
        log.info("getMin：{}",summaryStatistics.getMin());
        log.info("getSum：{}",summaryStatistics.getSum());
    }
    @Test
    public void testDirectSummary(){
        Double averageAge = userList.stream().collect(Collectors.averagingDouble(t->t.getAge()));
        log.info("直接获取想要的值：{}",averageAge);
        log.info("直接获取想要的值：{}", userList.stream().collect(Collectors.summarizingDouble(t->t.getAge())));
        log.info("直接获取想要的值：{}", userList.stream().collect(Collectors.summarizingLong(t->t.getAge())));
        log.info("直接获取想要的值：{}", userList.stream().collect(Collectors.summarizingInt(t->t.getAge())));
        log.info("直接获取想要的值：{}", userList.stream().collect(Collectors.minBy((a,b)->a.getAge()-b.getAge())));
        log.info("直接获取想要的值：{}", userList.stream().collect(Collectors.maxBy((a,b)->a.getAge()-b.getAge())));
    }

}
