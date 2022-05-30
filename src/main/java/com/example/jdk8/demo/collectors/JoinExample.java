package com.example.jdk8.demo.collectors;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description join拼接
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 17:07
 */
@Slf4j
public class JoinExample {

    private String a ="aaa";
    private String b ="bbb";
    @Test
    public void joinTest(){
        //将输入元素连接到一个 String ，按照顺序
        log.info("直接拼接:{}", Stream.of(a,b).collect(Collectors.joining()));
        log.info("参数为连接符:{}", Stream.of(a,b).collect(Collectors.joining(",")));
        log.info("参数为连接符，前缀，后缀:{}",
                Stream.of(a,b).collect(Collectors.joining(",","{","}")));
    }



}
