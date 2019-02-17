package com.cmcm.study.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 尝试使用Stream API
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上出发终止操作，否则中间操作不会执行任何的处理，而在终止操作时一次性全部处理，成为惰性求值。
 */
public class StreamAPI {

    private static final String LINE = "------------------------------------";

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 15, 15.15, Employee.Status.FREE),
            new Employee("李四", 26, 26.26, Employee.Status.VOCATION),
            new Employee("王五", 37, 37.37, Employee.Status.BUSY),
            new Employee("赵六", 24, 24.24, Employee.Status.BUSY),
            new Employee("赵六", 24, 24.24, Employee.Status.VOCATION),
            new Employee("钱七", 30, 30.30, Employee.Status.FREE)
    );

    /**
     * 收集
     * collect--将流转换为其他形式，接收一个Collector接口的实现，用于给stream中元素做汇总的方法
     */
    @Test
    public void test6(){
        System.out.println(employees.stream().map(Employee::getName).collect(Collectors.toList()));
        System.out.println(LINE);
        System.out.println(employees.stream().map(Employee::getName).collect(Collectors.toSet()));
        System.out.println(LINE);
        //收集到特定的集合中
        employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
        System.out.println(LINE);
        //分组，返回值类型是Map<Status, List<Employee>>
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getStatus)));
        System.out.println(LINE);
        //多级分组， 调用Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)可以进行无限分组
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getAge))));
        System.out.println(LINE);
        //分区
        System.out.println(employees.stream().collect(Collectors.partitioningBy(e -> e.getMoney() > 20)));
        System.out.println(LINE);
        //统计值
        DoubleSummaryStatistics collect = employees.stream().collect(Collectors.summarizingDouble(Employee::getMoney));
        System.out.println(collect.getAverage());
        System.out.println(collect.getMax());
        System.out.println(collect.getCount());
        System.out.println(LINE);
        //连接
        System.out.println(employees.stream().map(Employee::getName).collect(Collectors.joining(",")));
    }

    /**
     * 规约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) --可以将流中元素反复结合起来，得到一个流
     */
    @Test
    public void test5() {
        System.out.println(employees.stream().map(Employee::getMoney).reduce(0.0, (x, y) -> x + y));
        System.out.println(LINE);
        //上面的因为起始值为0.0，所以计算结果是不可能为空，但是下面的employee可能为空，所以下面返回的是Optional
        System.out.println(employees.stream().map(Employee::getMoney).reduce(Double::sum));
    }

    /**
     * 查找与匹配
     * allMatch--检查是否匹配所有元素
     * anyMatch--检查是否至少匹配一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAny--返回当前流中的任意元素
     * count--返回流中元素的总个数
     * max--返回流中最大值
     * min--返回流中最小值
     */
    @Test
    public void test4() {
        System.out.println(employees.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY)));
        System.out.println(LINE);
        System.out.println(employees.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.VOCATION)));
        System.out.println(LINE);
        System.out.println(employees.stream().sorted(Comparator.comparingDouble(Employee::getMoney)).findFirst());
        System.out.println(LINE);
        System.out.println(employees.stream().findAny());
        System.out.println(LINE);
        System.out.println(employees.stream().count());
        System.out.println(LINE);
        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::getMoney)));
    }

    /**
     * sorted()--自然排序(Comparable)
     * sorted(Comparator comparator)--定制排序(Comparator)
     */
    @Test
    public void test3() {
        employees.stream().map(Employee::getAge).sorted().forEach(System.out::println);
        System.out.println(LINE);
        employees.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return x.getAge() - y.getAge();
            }
        }).forEach(System.out::println);
    }

    /**
     * 映射
     * map(Function mapper)--接收lambda，将元素转关成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap(Function mapper)--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 两者的区别就类似于list.add()和list.addAll的区别，一个是把集合加入，一个是把集合中的元素加入，相对应，map是把流加入，flatMap是把流中元素加入
     */
    @Test
    public void test2() {
        employees.stream().map(employee -> employee.getName()).forEach(System.out::println);
        System.out.println(LINE);
        employees.stream().map(Employee::getAge).forEach(System.out::println);
        System.out.println(LINE);
        employees.stream().map(Employee::getName).flatMap(StreamAPI::getCharacter).forEach(System.out::println);
    }

    private static Stream<Character> getCharacter(String name) {
        List<Character> list = new ArrayList<>();
        char[] chars = name.toCharArray();
        for (char aChar : chars) {
            list.add(aChar);
        }
        return list.stream();
    }

    /**
     * 筛选和切片
     * filter(Predicate p)--接收lambda，从流中排出某些元素
     * limit(long maxSize)--截断流，时期元素不超过给定数量
     * skip(long n)--跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
     * distinct()--筛选，通过流所生成元素的hashCode()和equals()去除重复元素，去重操作依赖于hashCode()和equals()方法
     */
    @Test
    public void test1() {
        employees.stream().filter(employee -> employee.getAge() > 20).forEach(System.out::println);
        System.out.println(LINE);
        employees.stream().limit(2).forEach(System.out::println);
        System.out.println(LINE);
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println(LINE);
        employees.stream().distinct().forEach(System.out::println);
    }
}
