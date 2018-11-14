package com.cmcm.study.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author Spontaneously
 * @time 2018-10-11 下午9:06
 */
public class PrecidateDemo {

    private static final List<Apple> LIST = new ArrayList<Apple>(5);

    public static void main(String[] args) {
        Supplier<Apple> noParamAppleSupplier = Apple::new;
        Apple apple1 = noParamAppleSupplier.get();
        System.out.println(apple1.toString());
        BiFunction<String, Integer, Apple> twoParamAppleSupplier = Apple::new;
        Apple apple2 = twoParamAppleSupplier.apply("green", 20);
        System.out.println(apple2.toString());
        LIST.add(new Apple("red", 10));
        LIST.add(new Apple("yellow", 101));
        LIST.add(new Apple("blue", 120));
        LIST.add(new Apple("pink", 20));
        LIST.add(new Apple("red", 30));

        List<Apple> result = filter(LIST, new ColorPrecidate());
        System.out.println(result.toString());

        System.out.println(filter(LIST, (Apple apple) -> "red".equalsIgnoreCase(apple.getColor())));

        LIST.forEach((Apple apple) -> System.out.println(apple.toString()));
    }

    private static List<Apple> filter(List<Apple> list, MyPrecidate<Apple> precidate) {
        List<Apple> result = new ArrayList<>(list.size());
        for (Apple apple : list) {
            if (!precidate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

interface MyPrecidate<T> {

    /**
     * 比较
     * @param t 参数
     * @return 返回true或者false
     */
    boolean test(T t);
}

class ColorPrecidate implements MyPrecidate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return "red".equalsIgnoreCase(apple.getColor());
    }
}

class PricePrecidate implements MyPrecidate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.getPrice() > 100;
    }
}

class Apple {
    private String color;

    private int price;

    public Apple(){
        new Apple(null, 0);
    }

    public Apple(String color, int price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}