package com.example.jdk8.demo.stream;

import com.example.jdk8.demo.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description Stream之转换
 * @AUTHOR zhangxue9
 * @DATE 2022/5/19 17:20
 */
@Slf4j
public class TransformStreamExample {
    
    public static final String SIMON_KEY="Simon";
    public static void main(String[] args) {
        transform();
        transform2();
    }


    /**
     * 转换map
     * Stream map(Function<? super T, ? extends R> mapper)
     * 转化操作，将流中每一个元素T转化为R
     * 使用场景 stream()返回的是一个对象或一个值时，去转换使用
     * 比如这里这里将User 转成 String
     *
     */
    public static void transform(){
        List<User> list =Arrays.asList(
                new User(1,SIMON_KEY,18),
                //增加一套重复的，用来测试去重
                new User(1,SIMON_KEY,18),
                new User(2,"Hank",30),
                new User(3,"Jay",15),
                new User(4,"Eric",28),
                new User(5,SIMON_KEY,40)
        );
        // map  转换获取所有去重的name
        Object[] mapArr = list.stream().map(User::getName).distinct().toArray(String[]::new);
        log.info("--------------------打印mapArr条数{}---------------------",mapArr.length);
        Arrays.stream(mapArr).forEach(t->{
          log.info("mapArr-t:{}",t);
        });


    }

    /**
     * flatMap
     * Stream  flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
     * 转化操作，将参数T 转化为R，返回多个R类型的流
     * 使用场景：当stream返回的是数组或集合的时候使用 ，
     * 比如下面这个list.stream() 返回的是String[]
     */
    public static void transform2(){
        List<String[]> list = Arrays.asList(
                new String[]{"a", "b"},
                new String[]{"c", "d"},
                new String[]{"e","f"}
        );
       Object[] mapArr2=  list.stream().flatMap(t->Arrays.stream(t)).toArray();
        log.info("--------------------打印mapArr2条数{}---------------------",mapArr2.length);
        Arrays.stream(mapArr2).forEach(t->{
            log.info("mapArr2-t:{}",t);
        });
    }


}
