package com.example.jdk8.demo.datehandle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description LocalDate 不含具体时间的日期
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 19:03
 */
@Slf4j
public class LocalDateExample {
    @Test
    public void test(){

        LocalDate localDate = LocalDate.now();
        log.info("获取年份 返回int getYear ={}",localDate.getYear());
        log.info("获取当前日期的月份对象，返回Month getMonth ={}",localDate.getMonth());
        log.info("获取当前日期是第几月，返回int ={}",localDate.getMonthValue());
        log.info("表示星期几 返回 DayOfWeek,getDayOfWeek()={}",localDate.getDayOfWeek());
        log.info("表示这个月的第几天 返回 int,getDayOfMonth()  ={}",localDate.getDayOfMonth());
        log.info("表示年份的第几天 返回int getDayOfYear() ={}",localDate.getDayOfYear() );
        log.info(" 修改当前对象的年份返回LocalDate={}",localDate.withYear(2000));
        log.info("修改当前对象的月份。返回LocalDate , withMonth(int month) ={}",localDate.withMonth(1));
        log.info(" 修改对象的月份的日期 withDayOfMonth(int dayOfMonth) ={}",localDate.withDayOfMonth(1));
        log.info(" 增加指定年数 返回LocalDate，注意返回值赋给原对象,plusYears(long yearsToAdd) ={}",localDate.plusYears(1));
        log.info("增加指定月数,plusMonths(long monthsToAdd)  ={}",localDate.plusMonths(1));
        log.info("增加指定周数,plusWeeks(long weeksToAdd)  ={}",localDate.plusWeeks(1));
        log.info("增加天数,plusDays(long daysToAdd)  ={}",localDate.plusDays(2));
        log.info("减少年数,minusYears(long yearsToSubtract) ={}",localDate.minusYears(1));
        log.info("减少月数 minusMonths(long monthsToSubtract)  ={}",localDate.minusMonths(1));
        log.info("减少星期数 minusWeeks(long weeksToSubtract) ={}",localDate.minusWeeks(1));
        log.info(" 比较日期，当前对象比other晚，则返回正数 int,compareTo(ChronoLocalDate other)  ={}"
                ,localDate.compareTo(LocalDate.now().withYear(2030)));
        log.info("判断对象日期是否在other之前 isBefore(ChronoLocalDate other) ={}",localDate.isBefore(LocalDate.now().minusDays(1)));
        log.info("判断对象日期是否在other之后 isAfter(ChronoLocalDate other) ={}",localDate.isAfter(LocalDate.now().minusDays(1)));
        log.info(" 判断对象日期是否相等 isEqual(ChronoLocalDate other)={}",LocalDate.now().isEqual(LocalDate.now()));
        log.info("返回当前localDate对象的凌晨时刻的LocalDateTime对象 atStartOfDay()={}",localDate.atStartOfDay());
        log.info("此时使用指定的格式化程序格式化。 format(DateTimeFormatter）={}",localDate.format(DateTimeFormatter.ISO_DATE));
    }
}
