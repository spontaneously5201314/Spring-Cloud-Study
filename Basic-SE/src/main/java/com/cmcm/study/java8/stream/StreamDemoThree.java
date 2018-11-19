package com.cmcm.study.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @author Spontaneously
 * @time 2018-11-06 下午5:01
 */
public class StreamDemoThree {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年发生的所有交易，并按交易额从低到高排序
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //交易员都在哪些不同的城市工作过？
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //查找所有来自剑桥的交易员，并按照姓名排序
        transactions.stream().filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
                .sorted(comparing(transaction -> transaction.getTrader().getName()))
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //返回所有交易员姓名的字符串，按照字母顺序排序
        transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //有没有交易员实在米兰工作过？
        System.out.println(transactions.stream().anyMatch(transaction -> "Milan".equalsIgnoreCase(transaction.getTrader().getCity())));
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
                .map(Transaction::getValue).reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //找到最高的交易额
        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        //找到最小的交易额
        transactions.stream().map(Transaction::getValue).reduce(Integer::min).ifPresent(System.out::println);
        transactions.stream().min(comparing(Transaction::getValue)).ifPresent(System.out::println);
    }
}

class Trader {

    private String name;

    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Transaction {

    private Trader trader;

    private int year;

    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}