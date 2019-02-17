package com.cmcm.study.java8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用：如果lambda体中的内容已经实现好了，可以直接使用“方法引用”，可以理解为lambda表达式的另外一种实现
 * 主要有三种格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 构造器引用
 * ClassName::new
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致。
 *
 * 数组引用
 * Type::new
 */
//@FunctionalInterface
public class TestMethodRef {

    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println(x);

        Consumer<String> con = System.out::println;
        con.accept("abcd");

        Comparator<Integer> com = Integer::compare;
        BiPredicate<String, String> orinBp = (x, y) -> x.equals(y);
        //能使用类::实例方法名的情况是，若lambda参数列表中当第一个参数是实例方法的调用者，
        // 第二个参数是实例方法的参数的时候，可以使用类::实例方法名。
        BiPredicate<String, String> bp = String::equals;


//        TestMethodRef tmr = TestMethodRef::new;
        //数组引用
        Function<Integer, String[]> fun = String[]::new;
    }
}