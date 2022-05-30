package com.example.jdk8.demo.optional;

import com.example.jdk8.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description 容器对象Optional
 * @AUTHOR zhangxue9
 * @DATE 2022/5/30 15:00
 */
@Slf4j
public class OptionalExample {

    /**
     * Map方法可以用于过滤
     * @param
     * @return void
     * @author zhangxue9
     * @date 2022/5/30 16:53
     */
    @Test
    public void testMap(){
        Optional<User> result =mockUser();
        //如果存在一个值，则应用提供的映射函数，如果结果不为空，则返回一个 Optional结果的 Optional
        Optional<String> name =  result.map(User::getName);
        log.info("map获取姓名：{}",name.isPresent()?name.get(): Strings.EMPTY);

        Function<User,Optional<String>> function = t->Optional.of(t.getName());
        Optional<String> name2= result.flatMap(function);
        log.info("flatMap获取姓名：{}",name2.isPresent()?name2.get(): Strings.EMPTY);

        Optional<User> filterUser = result.filter(t->t.getAge()>10);
        log.info("filterUser：{}",filterUser.isPresent()?filterUser.get(): null);

        //对象是否等于此可选项
        boolean equalFlag = result.equals(Optional.of(new User("simon",18)));
        log.info("equals方法{}",equalFlag);
        User user1 =new User("simon",18);
        user1.setId(1);
        User user2=new User("simon",18);
        user2.setId(2);

        log.info("对象equals比较：{}",user1.equals(user2));
        log.info("对象==比较：{}",user1==user2);
    }

    @Test
    public void testEmpty() throws Exception {
        //声明一个空Optional
        Optional<User> result = Optional.empty();
        //如果存在值返回 true，否则为 false
        log.info("没值时，result.isPresent()={}",result.isPresent());
//        log.info("没值时直接调用会异常-result.get()-{}",result.get());
        //返回值如果存在，否则返回 other 。
        log.info("没值时，获取默认值，result.orElse={}",result.orElse(new User("defaultUser",22)));
         result = mockUser();
        //如果存在值返回 true，否则为 false
        log.info("赋值后-result.isPresent={}",result.isPresent());
        //如果存在值，则使用该值调用指定的消费者，否则不执行任何操作
        Consumer myConsumer = t->log.info("调用了myConsumer");
        result.ifPresent(myConsumer);


        //返回包含值
        log.info("赋值后result.get()={}",result.get());
        log.info("赋值后，返回值，result.orElse={}",result.orElse(new User("defaultUser",18)));
        //返回一个 Optional指定值的Optional
        log.info("返回指定值的Optional，result.ofNullable={}",result.ofNullable(new User("defaultUser",22)));
        log.info("如果空，则返回一个空的Optional,result.ofNullable={}",result.ofNullable(null).isPresent());
        result = Optional.empty();
        Supplier<User> mySupplier = ()->new User("defaultUser",22);
        log.info("返回值（如果存在），否则调用 other并返回该调用的结果,result.orElseGet={}",result.orElseGet(mySupplier));
        result =result.of(new User("SIMON",18));
        log.info("返回值（如果存在），否则调用 other并返回该调用的结果,result.orElseGet={}",result.orElseGet(mySupplier));
        result = Optional.empty();
        Supplier<Exception> myExceptionSupplier = ()->new Exception("我出异常了");
        //返回包含的值（如果存在），否则抛出由提供的供应商创建的异常
//        result.orElseThrow(myExceptionSupplier);

    }


    /**
     * 模拟查到一个USER
     * @param
     * @return java.util.Optional<com.example.jdk8.demo.pojo.User>
     * @author zhangxue9
     * @date 2022/5/30 15:08
     */
    private Optional<User> mockUser(){
        // 返回具有 Optional的当前非空值的Optional。
        return Optional.of(new User("simon",18));
    }
}
