package com.example.jdk8.demo.functionalprogramming;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 比较函数
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 14:31
 */
@Slf4j
public class ComparatorExample {
   static Comparator<Integer>  myCompartor =  (a,b)-> a-b;
    public static void main(String[] args) {
       List<Integer> list = Arrays.asList(
               1,3,9,8,5
       );
       log.info("按照从小到大排序{}",list.stream().sorted(myCompartor).collect(Collectors.toList()));
    }
}
