package com.example.jdk8.demo.datehandle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description LocalDateTime 包含了日期及时间
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 19:04
 */
@Slf4j
public class LocalDateTimeExample {

    @Test
    public void test(){

        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("获取年份 返回int getYear ={}",localDateTime.getYear());
        log.info("获取当前日期的月份对象，返回Month getMonth ={}",localDateTime.getMonth());
        log.info("获取当前日期是第几月，返回int ={}",localDateTime.getMonthValue());
        log.info("表示星期几 返回 DayOfWeek,getDayOfWeek()={}",localDateTime.getDayOfWeek());
        log.info("表示这个月的第几天 返回 int,getDayOfMonth()  ={}",localDateTime.getDayOfMonth());
        log.info("表示年份的第几天 返回int getDayOfYear() ={}",localDateTime.getDayOfYear() );
        log.info(" 修改当前对象的年份返回LocalDate={}",localDateTime.withYear(2000));
        log.info("修改当前对象的月份。返回LocalDate , withMonth(int month) ={}",localDateTime.withMonth(1));
        log.info(" 修改对象的月份的日期 withDayOfMonth(int dayOfMonth) ={}",localDateTime.withDayOfMonth(1));
        log.info(" 增加指定年数 返回LocalDate，注意返回值赋给原对象,plusYears(long yearsToAdd) ={}",localDateTime.plusYears(1));
        log.info("增加指定月数,plusMonths(long monthsToAdd)  ={}",localDateTime.plusMonths(1));
        log.info("增加指定周数,plusWeeks(long weeksToAdd)  ={}",localDateTime.plusWeeks(1));
        log.info("增加天数,plusDays(long daysToAdd)  ={}",localDateTime.plusDays(2));
        log.info("减少年数,minusYears(long yearsToSubtract) ={}",localDateTime.minusYears(1));
        log.info("减少月数 minusMonths(long monthsToSubtract)  ={}",localDateTime.minusMonths(1));
        log.info("减少星期数 minusWeeks(long weeksToSubtract) ={}",localDateTime.minusWeeks(1));
        log.info(" 比较日期，当前对象比other晚，则返回正数 int,compareTo(ChronoLocalDate other)  ={}"
                ,localDateTime.compareTo(LocalDateTime.now().withYear(1)));
        log.info("判断对象日期是否在other之前 isBefore(ChronoLocalDate other) ={}",localDateTime.isBefore(LocalDateTime.now().minusDays(1)));
        log.info("判断对象日期是否在other之后 isAfter(ChronoLocalDate other) ={}",localDateTime.isAfter(LocalDateTime.now().minusDays(1)));
        log.info(" 判断对象日期是否相等 isEqual(ChronoLocalDate other)={}",LocalDateTime.now().isEqual(LocalDateTime.now()));
        log.info("此时使用指定的格式化程序格式化。 format(DateTimeFormatter）={}",localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
