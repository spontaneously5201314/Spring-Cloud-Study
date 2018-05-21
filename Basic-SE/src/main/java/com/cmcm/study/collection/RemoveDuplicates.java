package com.cmcm.study.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * @author hongfei
 * @create 2018-05-18 上午11:13
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(new ArrayList<>(new LinkedHashSet<>(list)));

        ArrayList<Person> people = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                people.add(new Person("person" + (i - 1), (i - 1)));
            } else {
                people.add(new Person("person" + i, i));
            }
        }
        System.out.println("生成的list元素是" + people.size());
        System.out.println("去重之后的list是" + new ArrayList<>(new LinkedHashSet<>(people)).size());
    }

    static class Person {
        private String name;

        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            if (getAge() != person.getAge()) return false;
            return getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            int result = getName().hashCode();
            result = 31 * result + getAge();
            return result;
        }
    }
}
