# JDK8新特性 研究学习使用

Java 8 是目前最常用的 JDK 版本，在增强代码可读性、简化代码方面，做了很多优化，
如 Lambda、Stream 、ParallelStream、Optional、新日期时间类型等。

## 我整理的思维导图

https://blog.csdn.net/zx03070723/article/details/115735117

## Lambda表达式

其实本质就是简化匿名类的语法糖

## 函数式接口

使用 @FunctionalInterface 来描述，只有单一抽象方法的接口。也称为SAM接口，即Single Abstract Method interfaces。

*其实未使用 @FunctionalInterfaces注解的接口未必就不是函数式接口，一个接口是不是函数式接口的条件只有一条，即接口中只有一个抽象方法的接口（Object类中的方法不算，如hashcode方法）。*

- 使用lambda表达式来实现函数式接口 

  JDK8中内置函数式接口包括:  

| 接口名       | 类                | 方法               | 方法描述             |
| ------------ | ----------------- | ------------------ | -------------------- |
| 单参函数接口 | Function<T,R>     | R apply(T t);      | 有入参 有返回值      |
| 双参函数接口 | BiFunction<T,U,R> | R apply(T t, U u); | 有2个入参 有返回值   |
| 供给接口     | Supplier<T>       | T get();           | 无入参 有返回值      |
| 消费接口     | Consumer<T>       | void accept(T t);  | 有入参，无返回值     |
| 断言接口     | Predicate<T>      | boolean test(T t); | 有入参，返回布尔类型 |

- 函数式编程还可以使用双冒号:: 方法引用的方式  
  结合Lambda表达式让编写的代码变得更加精简

| 种类          | 语法                  | lambda表达式                     |
| ------------- | --------------------- | -------------------------------- |
| 静态方法引入  | ClassName::methodName | (args)->类名.static_method(args) |
| 对象方法引入  | Class::method         | (instance)->instance.method()    |
| 实例方法引入  | Instance::methodName  | (args)->对象实例.method(args)    |
| 构造函数yinru | Class::new            | (args)->new 类名(args)           |

## Steam 流

通过将集合（如List 、Set、Map等）转换为一种叫做流的元素队列，通过声明性方式，能够对集合中的每个元素进行一系列并行或串行的流水线操作。

按照功能可以划分八大类型    

### 筛选

| 方法     | 语法                                             | 描述                                |
| -------- | ------------------------------------------------ | ----------------------------------- |
| filter   | Stream<T> filter(Predicate<? super T> predicate) | 通过条件过滤元素                    |
| distinct | Stream<T> distinct()                             | 去重                                |
| limit    | Stream<T> limit(long maxSize)                    | 截取流，自取maxSize条数据           |
| skip     | Stream<T> skip(long n)                           | 跳过操作，跳过n条数据，取后面的数据 |

### 转换  

| 方法    | 语法                                                         | 描述                                         |
| ------- | ------------------------------------------------------------ | -------------------------------------------- |
| map     | Stream map(Function<? super T, ? extends R> mapper)          | 转化操作，将流中每一个元素T转化为R           |
| flatMap | Stream  flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) | 转化操作，将参数T 转化为R，返回多个R类型的流 |

