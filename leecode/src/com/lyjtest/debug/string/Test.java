package com.lyjtest.debug.string;

/**
 * @author NoobProgrammer
 * @title: Test
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/1318:51
 */
public class Test {
    public static void main(String[] args) {
        String str = "ab";
        Test test = new Test();
        String change = test.change(str);
        System.out.println(str == change);
    }

    public String change(String str) {
        str = "cd";
        return str;
    }
}
