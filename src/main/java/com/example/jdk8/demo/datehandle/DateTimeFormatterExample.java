package com.example.jdk8.demo.datehandle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description DateTimeFormatter 日期格式化
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 19:05
 */
@Slf4j
public class DateTimeFormatterExample {
    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.info("日期字符串{}",LocalDateTime.now().format(formatter));

        String text = "2022-05-30 20:10:05";
        LocalDateTime localDateTime = LocalDateTime.parse(text,formatter);

        log.info("localDateTime={}",localDateTime);
    }
}
