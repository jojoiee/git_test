package com.lyjtest.searchAndTraceback.offer13;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author NoobProgrammer
 * @title: Offer13
 * @projectName leecode
 * @description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外）
 * ，也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @date 2021/12/916:36
 */
public class Offer13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.bfs(1, 2, 1);
//        int i = solution.movingCount(1, 2, 1);
        System.out.println(i);

    }
}

//
class Solution {

    private int m;
    private int n;
    private int k;
    boolean[][] isVisited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        isVisited = new boolean[m][n];
        return dfs(0, 0, 0, 0);


    }

    //深度优先遍历：
    //由于从 (0,0) 开始走，因此只需要考虑向下和向右的情况

    /**
     * @param x    当前位置x坐标
     * @param y    当前位置y坐标
     * @param sumX x坐标的数位和
     * @param sumY y坐标的数位和
     * @return 可以到达的格子个数
     */
    private int dfs(int x, int y, int sumX, int sumY) {
        //如果位置越界，数位和大于k或者该位置已经走过 返回0
        if (x >= m || y >= n || sumX + sumY > k || isVisited[x][y]) {
            return 0;
        } else {

            //设置当前位置为已访问

            isVisited[x][y] = true;

            //当前位置可以到达(向右和向下)，并且满足要求的格子的个数为：
            return 1 + dfs(x + 1, y, sum(x + 1), sum(y)) + dfs(x, y + 1, sum(x), sum(y + 1));
        }

    }

    //计算一个数字的数位和
    private int sum(int n) {
        int s = 0;
        while (n != 0) {
            s += n % 10;
            n = n / 10;
        }
        return s;
    }

    //队列+广度优先遍历

    int bfs(int m, int n, int k) {

        boolean[][] isVisited1 = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 0, 0});

        int res = 0;

        while (queue.size() > 0) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x >= m || y >= n || poll[2] + poll[3] > k || isVisited1[x][y]) {
                continue;
            }
            //当前位置满足要求:标记为已访问，并将结果 +1
            isVisited1[x][y] = true;
            res++;
            //将下方和右方的坐标及其数位和加入队列
            queue.add(new int[]{x + 1, y, sum(x + 1), sum(y)});
            queue.add(new int[]{x, y + 1, sum(x), sum(y + 1)});
        }
        return res;

    }

}