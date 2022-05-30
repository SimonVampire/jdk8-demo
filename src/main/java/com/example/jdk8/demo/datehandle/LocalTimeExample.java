package com.example.jdk8.demo.datehandle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.Temporal;

/**
 * @description LocalTime 不含日期的时间
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 19:03
 */
@Slf4j
public class LocalTimeExample {
    @Test
    public void test(){
        LocalTime localTime =LocalTime.now();
        log.info("localTime-1:{}",localTime);
        log.info("getHour：{}",localTime.getHour());
        log.info("getMinute：{}",localTime.getMinute());
        log.info("getSecond：{}",localTime.getSecond());
        //纳秒
        log.info("getNano：{}",localTime.getNano());

        LocalTime localTime2 =LocalTime.parse("17:00:01");
        log.info("localTime2-1={}",localTime2);


        Temporal temporal = localTime2.adjustInto(LocalTime.now());
        log.info("localTime2={}",localTime2);
        log.info("temporal={}",temporal);
        temporal = temporal.with(localTime2);
        log.info("localTime2={}",localTime2);
        log.info("temporal={}",temporal);
    }
}
