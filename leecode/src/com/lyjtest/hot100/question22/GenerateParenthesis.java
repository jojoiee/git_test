package com.lyjtest.hot100.question22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: GenerateParenthesis
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/810:00
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<int[]> ints = solution.generateParenthesis(3);
//        for (int i = 0; i < ints.size(); i++) {
//            System.out.println(Arrays.toString(ints.get(i)));
//        }
        List<String> strings = solution.generateParenthesisMethod2(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}

//class Solution {
//    public List<int[]> generateParenthesis(int n) {
//        //第一个位置必定是左括号
//        List<int[]> resList = new ArrayList<>();
//        //int数组存储左括号可能的位置
//        int[] left = new int[n];
//        generate(resList, left, 0, n);
//        return resList;
//
//    }
//
//    /**
//     * @param resList 最后需要返回的结果集合
//     * @param index   放置第几个括号
//     * @param n       一共要放几个括号
//     */
//    private void generate(List<int[]> resList, int[] position, int index, int n) {
//        //深度
//        if (index == n) {
//            System.out.println(Arrays.toString(position));
//        } else {
//            if (index == 0) {
//                position[index] = 0;
//                generate(resList, position, index + 1, n);
//            } else {
//                //每个括号可能的位置与其是第多少个括号有关
//                for (int i = index; i < n + index; i++) {
//                    position[index] = i;
//                    generate(resList, position, index + 1, n);
//                }
//            }
//        }
//    }
//
//
//}
//回溯法
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        turnBack(resList, sb, 0, 0, n);
        return resList;
    }

    /**
     * @param resList 结果集
     * @param sb      拼接字符串
     * @param left    左括号使用了几个
     * @param right   右括号
     * @param n       总数
     */
    private void turnBack(List<String> resList, StringBuffer sb, int left, int right, int n) {
        //如果左括号和右括号都用完,加入结果集
        if (left == n && right == n) {
            resList.add(sb.toString());
        } else {
            //如果左括号个数小于n加入左括号
            if (left < n) {
                sb.append('(');
                turnBack(resList, sb, left + 1, right, n);
                //将添加的左括号删除
                sb.deleteCharAt(sb.length() - 1);
            }
            //右括号的个数如果小于左括号则，可以加入
            if (right < left) {
                sb.append(')');
                turnBack(resList, sb, left, right + 1, n);
                //将添加的右括号删除
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    //广度优先遍历+剪枝
    public List<String> generateParenthesisMethod2(int n) {
        List<String> resList = new ArrayList<>();
        if (n == 0) {
            return null;
        }
        dfs("", n, n, resList);
        return resList;

    }

    private void dfs(String curString, int left, int right, List<String> resList) {
        //如果左右括号都用完，将当前拼接的字符串加入结果集
        if (left == 0 && right == 0) {
            resList.add(curString);
            return;
        }

        //剪枝：左括号剩余的多就剪枝
        if (left > right) {
            return;
        }
        //添加左括号
        if (left > 0) {
            dfs(curString + "(", left - 1, right, resList);
        }
        //添加右括号
        if (right > 0) {
            dfs(curString + ")", left, right - 1, resList);
        }
    }
}

