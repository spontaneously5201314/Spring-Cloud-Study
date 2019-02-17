package com.cmcm.study.java8.stream;

import java.util.Objects;

public class Employee {

    private String name;

    private int age;

    private double money;

    private Status status;

    public Employee(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Employee(String name, int age, double money, Status status) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.money, money) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, money);
    }

    public enum Status {
        /**
         * 休闲
         */
        FREE,
        /**
         * 忙碌
         */
        BUSY,
        /**
         * 休假
         */
        VOCATION;
    }

}
