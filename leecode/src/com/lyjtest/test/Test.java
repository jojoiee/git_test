package com.lyjtest.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Test
 * @projectName leecode
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);

        list.add(2);


        foo1(list);

        System.out.println(list);     /// ---- 3


        foo2(list);

        System.out.println(list);     /// ---- 4


    }
    public static void foo1(List<Integer> list) {

        list.add(3);

    }


    public static void foo2(List<Integer> list) {

        list = new ArrayList<>();

        list.add(4);

    }
}
