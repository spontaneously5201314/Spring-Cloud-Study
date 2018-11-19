package com.cmcm.study.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Spontaneously
 * @time 2018-11-06 上午11:15
 */
public class StreamDemoOne {

    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(10, "10"));
        USERS.add(new User(20, "20"));
        USERS.add(new User(30, "30"));
        USERS.add(new User(40, "40"));
        USERS.add(new User(50, "50"));
        USERS.add(new User(60, "60"));
        USERS.add(new User(70, "70"));
    }

    public static void main(String[] args) {
//        List<String> list = USERS.stream().filter(
//                user -> {
//                    System.out.println("filter" + user.getName());
//                    return user.getCalories() > 10;
//                }
//        ).map(
//                user -> {
//                    System.out.println("mapping" + user.getCalories());
//                    return user.getName();
//                }
//        ).collect(Collectors.toList());
//        list.forEach(System.out::println);
        boolean allMatch = USERS.stream().allMatch(user -> user.getCalories() < 100);
        System.out.println(allMatch);
    }
}

class User {
    private int calories;

    private String name;

    public User(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}