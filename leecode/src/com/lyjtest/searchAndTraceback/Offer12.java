package com.lyjtest.searchAndTraceback;

/**
 * @author NoobProgrammer
 * @title: Offer12
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/914:46
 */
public class Offer12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        System.out.println(solution.exist(chars, word));
    }
}

class Solution {

    //可以将方法中需要用到的变量定义为属性,就不用给方法传递过多参数
    //位置偏移量
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int row;
    private int col;
    private int len; //字符串长度
    private boolean[][] isVisited;//位置是否访问过
    private char[][] board;
    private char[] wordCharArray;

    //回溯+DFS
    public boolean exist(char[][] board, String word) {
        //设定属性值
        row = board.length;
        col = board[0].length;
        len = word.length();
        //初始化isVisited数组
        isVisited = new boolean[row][col];
        wordCharArray = word.toCharArray();
        this.board = board;

        //遍历第一个位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * @param x     当前遍历到的x坐标
     * @param y     当前遍历到的x坐标
     * @param index 遍历到第几个字母
     * @return 匹配到给定字母，返回true，反之false
     */
    private boolean dfs(int x, int y, int index) {
        //如果遍历到最后一个字母
        if (index == len - 1) {
            //看最后一个字母是否匹配
            return board[x][y] == wordCharArray[index];
        }
        //如果匹配到:
        if (board[x][y] == wordCharArray[index]) {
            //将该位置设定为已访问，向上下左右遍历
            isVisited[x][y] = true;
            //使用位置偏移数组，得到要遍历的坐标
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                //如果下一个位置不超出边界,没有被访问过，则访问
                if (inArea(newX, newY) && !isVisited[newX][newY]) {
                    if (dfs(newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            //重置当前位置
            isVisited[x][y] = false;


        }
        return false;

    }

    //坐标是否越界
    private boolean inArea(int x, int y) {
        return x < row && y < col && x >= 0 && y >= 0;
    }

    //我写的也不知道哪里不对
//    boolean[][] isVisited;
//
//    public boolean exist(char[][] board, String word) {
//
//        isVisited = new boolean[board[0].length][board.length];
//        //遍历board的每个位置
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (traceBack(board, word.toCharArray(), 0, i, j, isVisited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//
//    private boolean traceBack(char[][] board, char[] word, int index, int x, int y, boolean[][] isVisited) {
//        //如果遍历到所给单词的最后，说明匹配成功
//
//        if (index >= word.length) {
//            return true;
//            //如果当前位置的字符匹配
//        } else {
//            //把当前位置设置为已访问
//            if (board[x][y] == word[index] && !isVisited[x][y]) {
//                isVisited[x][y] = true;
//                //寻路规则：右，下，左，上
//                if (y + 1 < board[0].length && traceBack(board, word, index + 1, x, y + 1, isVisited) && !isVisited[x][y + 1]) {
//                    return true;
//                }
//                if (x + 1 < board.length && traceBack(board, word, index + 1, x + 1, y, isVisited) && !isVisited[x + 1][y]) {
//                    return true;
//                }
//                if (y - 1 > 0 && traceBack(board, word, index + 1, x, y - 1, isVisited) && !isVisited[x][y - 1]) {
//                    return true;
//                }
//                if (x - 1 > 0 && traceBack(board, word, index + 1, x - 1, y, isVisited) && !isVisited[x - 1][y]) {
//                    return true;
//                } else {
//                    return false;
//                }
//
//
//            } else {
//                return false;
//            }
//        }
//
//    }
}