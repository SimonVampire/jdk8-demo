package com.example.jdk8.demo.datehandle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description 时间差Duration
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 19:04
 */
@Slf4j
public class DurationExample {

    @Test
    public void test(){
        LocalDateTime localDateTime = LocalDateTime.parse(
                "2022-05-29 22:10:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        LocalDateTime now = LocalDateTime.now();

        log.info("Duration.between={}",Duration.between(localDateTime,now));
        //注意不满24小时 不算一天 现在是20220530 20:00:00 不够24小时，返回0
        log.info("Duration.toDays={}",Duration.between(localDateTime,now).toDays());
        log.info("Duration.toHours={}",Duration.between(localDateTime,now).toHours());
        log.info("Duration.toMinutes={}",Duration.between(localDateTime,now).toMinutes());
        log.info("Duration.toNanos={}",Duration.between(localDateTime,now).toNanos());
    }
}
