package com.lyjtest.searchAndTraceback.offer38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author NoobProgrammer
 * @title: Offer38
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1417:27
 */
public class Offer38 {
}

class Solution {
    List<String> resList = new ArrayList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);

        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;

    }

    //x表示当前深度(位置的索引)
    private void dfs(int x){
        //如果深度达到 数组长度-1 ，将当前char数组加入结果集合
        if(x == c.length-1){
            resList.add(new String(c));
            return;
        }
        //创建一个hashSet防止同一个字母处于相同深度
        Set<Character> set = new HashSet<>();
        //考虑字符数组每个元素位于该深度的情况
        for (int i = x; i < c.length; i++) {
            //如果set中有该字符，跳过这个字符，遍历下一个
            if(set.contains(c[i])){
                continue;
            }
            //将这个未重复的字符加入set
            set.add(c[i]);
            //将当前深度的字符与遍历到的字符相交换
            swap(x,i);
            //向下一层遍历
            dfs(x+1);
            //回溯
            swap(x,i);
        }

    }

    //交换x,y索引对应的字母
    private void swap(int x , int y){
        char temp = this.c[x];
        c[x] = c[y];
        c[y] = temp;
    }

}