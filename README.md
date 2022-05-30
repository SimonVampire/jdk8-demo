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

## Steam/ParallelStream  串/并行流

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

### 匹配

| 方法      | 语法                                              | 描述                                         |
| --------- | ------------------------------------------------- | -------------------------------------------- |
| allMatch  | boolean allMatch(Predicate<? super T> predicate)  | 转化操作，将参数T 转化为R，返回多个R类型的流 |
| anyMatch  | boolean anyMatch(Predicate<? super T> predicate)  | 判断是否有一条匹配                           |
| noneMatch | boolean noneMatch(Predicate<? super T> predicate) | 判断是否都不匹配                             |

### 查找

| 方法      | 语法                    | 描述                                     |
| --------- | ----------------------- | ---------------------------------------- |
| findAny   | Optional<T> findAny()   | 查找操作，查询流中任意元素并返回Optional |
| findFirst | Optional<T> findFirst() | 查找操作，查询流中的第一个元素           |

### 最大/小值

| 方法 | 语法                                              | 描述                         |
| ---- | ------------------------------------------------- | ---------------------------- |
| min  | Optional<T> min(Comparator<? super T> comparator) | 求最小值，根据Comparator计算 |
| max  | Optional<T> max(Comparator<? super T> comparator) | 求最大值，根据Comparator计算 |

### 聚合

| 方法    | 语法                                                   | 描述                              |
| ------- | ------------------------------------------------------ | --------------------------------- |
| collect | <R, A> R collect(Collector<? super T, A, R> collector) | 汇总操作                          |
| count   | long count()                                           | 数量统计                          |
| reduce  | Optional<T> reduce(BinaryOperator<T> accumulator)      | 通过计算返回唯一值                |
| reduce  | T reduce(T identity, BinaryOperator<T> accumulator)    | 提供初始值T，再通过计算返回唯一值 |

### 遍历

| 方法    | 语法                                     | 描述                                                  |
| ------- | ---------------------------------------- | ----------------------------------------------------- |
| foreach | void forEach(Consumer<? super T> action) | 不能使用break、return、continue等关键字结束或跳出循环 |

### 排序

| 方法 | 语法                                               | 描述                       |
| ---- | -------------------------------------------------- | -------------------------- |
| sort | Stream<T> sorted()                                 | T 实现Comparable           |
| sort | Stream<T> sorted(Comparator<? super T> comparator) | 按照自己的比较函数进行排序 |

## Optional 容器对象

| 方法                                                 | 描述                                                         |
| ---------------------------------------------------- | ------------------------------------------------------------ |
| empty()                                              | 返回一个空的 Optional实例                                    |
| equals(Object obj)                                   | 指示某个其他对象是否等于此可选项                             |
| filter(Predicate<? super T> predicate)               | 如果一个值存在，并且该值给定的谓词相匹配时，返回一个 Optional描述的值，否则返回一个空的 Optional 。 |
| flatMap(Function<? super T,Optional<U>> mapper)      | 如果一个值存在，应用提供的 Optional映射函数给它，返回该结果，否则返回一个空的 Optional 。 |
| map(Function<? super T,? extends U> mapper)          | 如果存在一个值，则应用提供的映射函数，如果结果不为空，则返回一个 Optional结果的 Optional |
| get()                                                | 返回包含值                                                   |
| ifPresent(Consumer<? super T> consumer)              | 如果存在值，则使用该值调用指定的消费者，否则不执行任何操作。 |
| isPresent()                                          | 如果存在值返回 true，否则为 false 。                         |
| of(T value)                                          | 返回具有 Optional的当前非空值的Optional。                    |
| ofNullable(T value)                                  | 返回一个 Optional指定值的Optional，如果空，则返回一个空的 Optional |
| orElse(T other)                                      | 返回值如果存在，否则返回 other 。                            |
| orElseGet(Supplier<? extends T> other)               | 返回值（如果存在），否则调用 other并返回该调用的结果         |
| orElseThrow(Supplier<? extends X> exceptionSupplier) | 返回包含的值（如果存在），否则抛出由提供的供应商创建的异常   |

## 收集器工具类Collectors

| 功能             | 语法                                                         |
| ---------------- | ------------------------------------------------------------ |
| 拼接             | Collector<CharSequence, ?, String> joining()                 |
|                  | Collector<CharSequence, ?, String> joining(CharSequence delimiter) |
|                  | Collector<CharSequence, ?, String> joining(CharSequence delimiter,  CharSequence prefix,CharSequence suffix) |
| 断言分组         | Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T> predicate) |
|                  | Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream) |
| 分组             | groupingBy(Function)                                         |
|                  | groupingBy(Function, Supplier, Collector)                    |
|                  | groupingByConcurrent(Function) 并发                          |
|                  | groupingByConcurrent(Function, Collector) 并发               |
|                  | groupingByConcurrent(Function, Supplier, Collector)并发      |
| 统计数量         | <T> Collector<T, ?, Long>   counting()                       |
| 统计信息         | summarizingLong(ToLongFunction）                             |
|                  | summarizingDouble(ToDoubleFunction)                          |
|                  | summarizingInt(ToIntFunction)                                |
| 直接获取统计信息 | averagingDouble                                              |
|                  | summingDouble                                                |

