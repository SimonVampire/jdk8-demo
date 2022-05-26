package com.example.jdk8.demo.stream.filter;

import com.example.jdk8.demo.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description Stream之筛选功能
 * @AUTHOR zhangxue9
 * @DATE 2022/5/19 17:20
 */
@Slf4j
public class FiltrateStreamExample {
    
    public static final String SIMON_KEY="Simon";
    
    private static List<User> list =Arrays.asList(
            new User(1,SIMON_KEY,18),
            //增加一套重复的，用来测试去重
            new User(1,SIMON_KEY,18),
            new User(2,"Hank",30),
            new User(3,"Jay",15),
            new User(4,"Eric",28),
            new User(5,SIMON_KEY,40)
    );

    public static void main(String[] args) {
        filtrate();
    }


    /**
     * 筛选
     * @return void
     * @author zhangxue9
     * @date 2022/5/19 17:45
     */
    public static void filtrate(){

        // filter 通过条件过滤元素   过滤年级小于20的小鲜肉
        List<User> filterList = list.stream().filter(t->t.getAge()<20).collect(Collectors.toList());
        // 打印验证下
        filterList.forEach(t->log.info("filterList:{}",t.toString()));

        //distinct 去重
        List<User> distinctList = list.stream().filter(t-> StringUtils.equals(SIMON_KEY,t.getName())).distinct().collect(Collectors.toList());
        // 打印验证下,这里使用前面讲到的对象方法引入
        distinctList.forEach(t->log.info("distinctList:{}",t.toString()));

        //limit 截取 ,这里限制取4条
        List<User> limitList = list.stream().limit(4).collect(Collectors.toList());
        // 打印验证下,这里使用前面讲到的对象方法引入
        limitList.forEach(t->log.info("limitList:{}",t.toString()));

        //skip 跳过，取后面的数据
        List<User> skipList = list.stream().skip(5).collect(Collectors.toList());
        // 打印验证下,这里使用前面讲到的对象方法引入
        skipList.forEach(t->log.info("skipList:{}",t.toString()));


    }

}
