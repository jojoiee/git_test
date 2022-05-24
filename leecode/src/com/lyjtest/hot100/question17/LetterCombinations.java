package com.lyjtest.hot100.question17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NoobProgrammer
 * @title: LetterCombinations
 * @projectName leecode
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 答案可以按 任意顺序 返回。
 * @date 2021/12/79:38
 */

/**
 * 给定一串长度可变的数字，
 */
public class LetterCombinations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);

    }
}


class Solution {
    public List<String> letterCombinations(String digits) {
        //哈希表存储数字与字母的映射关系
        Map<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        //新建一个ArrayList存放结果
        List<String> resList = new ArrayList<>();
        if (digits.equals("")) {
            return resList;
        }
        StringBuffer builder = new StringBuffer();
        letterCombination(resList, hashMap, digits, 0, builder);
        return resList;

    }

    /**
     * @param resList     表示存放结果的集合
     * @param hashMap     存放映射关系的map
     * @param digits      带解析的数字
     * @param index       遍历到第几个数字
     * @param combination 连接字符串
     */
    private void letterCombination(List<String> resList, Map<Character, String> hashMap,
                                   String digits, int index, StringBuffer combination) {
        //如果递归进行到最后一个数字，将之前StringBuffer内拼接的字符串加入resList
        if (index == digits.length()) {

            resList.add(combination.toString());
//            combination.delete(0,combination.length());
        } else {
            //取出当前索引的数字
            char c = digits.charAt(index);
            //取出当前数字映射的字母
            String letters = hashMap.get(c);
            //对每一个字母递归，index+1；
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                //先遍历完每一个数字，在回溯：
                //“23”
                letterCombination(resList, hashMap, digits, index + 1, combination);
                //将最后一个字符删除，下个循环继续添加
                combination.deleteCharAt(index);
            }
        }

    }


}