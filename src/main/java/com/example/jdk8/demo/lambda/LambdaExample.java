package com.example.jdk8.demo.lambda;

/**
 * @description Lambda表达式 样例
 * @AUTHOR zhangxue9
 * @DATE 2022/5/18 18:16
 */
public class LambdaExample {
    public static void main(String[] args) {
        //匿名类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }).start();

        //转换为Lambda表达式，代码更加简洁、易读
        new Thread(() -> System.out.println("hello2")).start();
    }
}
