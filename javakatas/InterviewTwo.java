package ru.bykov.javakatas;

import java.util.*;

/**
 * Created by g.bykov on 02/02/2017.
 */
public class InterviewTwo {

    public static void main(String[] args) {
//        Set<Number> set = new TreeSet<>();
//        set.add(1);
//        set.add(1L);
//        set.add(1.0);

        String s = Arrays.toString("".split("\\."));
        System.out.println(s);

    }

    void add(List<Number> list) {
        list.add(5);
    }

//    void add1(List<? extends Number> list) {
//        list.add(5);
//    }

    void add2(List<? super Number> list) {
        list.add(5);
    }

}
